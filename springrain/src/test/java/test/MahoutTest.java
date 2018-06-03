package test;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.FastByIDMap;
import org.apache.mahout.cf.taste.impl.model.GenericDataModel;
import org.apache.mahout.cf.taste.impl.model.GenericPreference;
import org.apache.mahout.cf.taste.impl.model.GenericUserPreferenceArray;
import org.apache.mahout.cf.taste.impl.model.MemoryIDMigrator;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.Preference;
import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springrain.frame.util.Finder;
import org.springrain.front.entity.UserMovie;
import org.springrain.front.service.IUserMovieService;

/**
 * TODO 在此加入类描述
 * @copyright {@link www.centforsoft.com}
 * @author 高永强
 * @version 2018年5月31日 上午10:16:39
 * @see test.MahoutTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MahoutTest {
	@Autowired
	private DataSource dataSource;
	private IUserMovieService userMovieService;;
	@Test
	public final void test() {
		// step:1 构建模型 2 计算相似度 3 查找k紧邻 4 构造推荐引擎
		List<RecommendedItem> recommendations = null;
		try {
			DataModel model = new MySQLJDBCDataModel(dataSource,
					Finder.getTableName(UserMovie.class), "uid", "mid", "score", "update_time");// 构造数据模型
			UserSimilarity similarity = new PearsonCorrelationSimilarity(model);// 用PearsonCorrelation
																				// 算法计算用户相似度
			UserNeighborhood neighborhood = new NearestNUserNeighborhood(3, similarity, model);// 计算用户的“邻居”，这里将与该用户最近距离为
																								// 3
																								// 的用户设置为该用户的“邻居”。
			Recommender recommender = new CachingRecommender(
					new GenericUserBasedRecommender(model, neighborhood, similarity));// 采用
			recommendations = recommender
					.recommend(5, 10);// 得到推荐的结果，size是推荐结果的数目
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(recommendations);
	}

	@Test
	public final void test2() {
		// step:1 构建模型 2 计算相似度 3 查找k紧邻 4 构造推荐引擎
		List<RecommendedItem> recommendations = null;
		try {
			DataModel model = new MySQLJDBCDataModel(dataSource,
					Finder.getTableName(UserMovie.class), "uid", "mid", "score", "update_time");// 构造数据模型
			ItemSimilarity itemSimilarity = new PearsonCorrelationSimilarity(model);
			// 构建推荐器，协同过滤推荐有两种，分别是基于用户的和基于物品的，这里使用基于物品的协同过滤推荐
			GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(model,
					itemSimilarity);
			MemoryIDMigrator thing2long = new MemoryIDMigrator();
			// 给用户ID等于5的用户推荐10个与2398相似的商品
			recommendations = recommender.recommendedBecause(
					thing2long.toLongID("36fc06b564b8444481fd1934167dc09f"), 1080, 10);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(recommendations);
	}

	@Test
	public final void test3() {
		List<Preference> userPreferences = new ArrayList<>();
		MemoryIDMigrator thing2long = new MemoryIDMigrator();
		FastByIDMap<PreferenceArray> preferenceMap = new FastByIDMap<>();
		UserMovie userMovie = new UserMovie();
		List<UserMovie> userMovies = null;
		try {
			userMovies = userMovieService.findListDataByFinder(null, null, UserMovie.class,
					userMovie);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (UserMovie userMovie2 : userMovies) {
			long userId = thing2long.toLongID(userMovie2.getUid());
			userPreferences.add(new GenericPreference(userId, userMovie2.getMid(),
					Float.parseFloat(userMovie2.getScore())));
			GenericUserPreferenceArray userArray = new GenericUserPreferenceArray(userPreferences);
			preferenceMap.put(userId, userArray);
		}
		DataModel model = new GenericDataModel(preferenceMap);
		ItemSimilarity itemSimilarity = null;
		try {
			itemSimilarity = new PearsonCorrelationSimilarity(model);
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 构建推荐器，协同过滤推荐有两种，分别是基于用户的和基于物品的，这里使用基于物品的协同过滤推荐
		GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(model,
				itemSimilarity);
		// 给用户ID等于5的用户推荐10个与2398相似的商品
		List<RecommendedItem> list = null;
		try {
			list = recommender.recommendedBecause(
					thing2long.toLongID("36fc06b564b8444481fd1934167dc09f"), 1080, 10);
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
	}

}
