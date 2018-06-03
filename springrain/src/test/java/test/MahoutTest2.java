package test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.cf.taste.similarity.precompute.example.GroupLensDataModel;
import org.junit.Test;

/**
 * TODO 在此加入类描述
 * @copyright {@link www.centforsoft.com}
 * @author 高永强
 * @version 2018年5月31日 下午3:20:09
 * @see test.MahoutTest2
 */
public class MahoutTest2 {

	@Test
	public final void test() {
		// 准备数据 这里是电影评分数据
		File file = new File("D:\\movie_preferences.txt");
		// 将数据加载到内存中，GroupLensDataModel是针对开放电影评论数据的
		DataModel dataModel = null;
		try {
			dataModel = new FileDataModel(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 计算相似度，相似度算法有很多种，欧几里得、皮尔逊等等。
		UserSimilarity similarity = null;
		try {
			similarity = new PearsonCorrelationSimilarity(dataModel);
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 计算最近邻域，邻居有两种算法，基于固定数量的邻居和基于相似度的邻居，这里使用基于固定数量的邻居
		UserNeighborhood userNeighborhood = null;
		try {
			userNeighborhood = new NearestNUserNeighborhood(100, similarity, dataModel);
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 构建推荐器，协同过滤推荐有两种，分别是基于用户的和基于物品的，这里使用基于用户的协同过滤推荐
		Recommender recommender = new GenericUserBasedRecommender(dataModel, userNeighborhood,
				similarity);
		// 推荐10部电影给id为5的用户
		List<RecommendedItem> recommendedItemList = null;
		try {
			recommendedItemList = recommender.recommend(5, 10);
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 打印推荐的结果
		System.out.println("使用基于用户的协同过滤算法");
		System.out.println("为用户5推荐10个商品");
		for (RecommendedItem recommendedItem : recommendedItemList) {
			System.out.println(recommendedItem);
		}
	}

	@Test
	public void test2() throws IOException, TasteException {
		 //准备数据 这里是电影评分数据
        File file = new File("D:\\ml-latest\\ratings.csv");
        //将数据加载到内存中，GroupLensDataModel是针对开放电影评论数据的
        DataModel dataModel = new FileDataModel(file);
        //计算相似度，相似度算法有很多种，欧几里得、皮尔逊等等。
        UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
        //计算最近邻域，邻居有两种算法，基于固定数量的邻居和基于相似度的邻居，这里使用基于固定数量的邻居
        UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(3, similarity, dataModel);
        //构建推荐器，协同过滤推荐有两种，分别是基于用户的和基于物品的，这里使用基于用户的协同过滤推荐
        Recommender recommender = new GenericUserBasedRecommender(dataModel, userNeighborhood, similarity);
        //给用户ID等于5的用户推荐10部电影
        List<RecommendedItem> recommendedItemList = recommender.recommend(5, 10);
        //打印推荐的结果
        System.out.println("使用基于用户的协同过滤算法");
        System.out.println("为用户5推荐10个商品");
        for (RecommendedItem recommendedItem : recommendedItemList) {
            System.out.println(recommendedItem);
        }
	}
	
	@Test
	public void test3() throws Exception{
		//准备数据 这里是电影评分数据
		File file = new File("D:\\ml-latest\\ratings.csv");
        //将数据加载到内存中，GroupLensDataModel是针对开放电影评论数据的
        DataModel dataModel = new FileDataModel(file);
        //计算相似度，相似度算法有很多种，欧几里得、皮尔逊等等。
        ItemSimilarity itemSimilarity = new PearsonCorrelationSimilarity(dataModel);
        //构建推荐器，协同过滤推荐有两种，分别是基于用户的和基于物品的，这里使用基于物品的协同过滤推荐
        GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dataModel, itemSimilarity);
        //给用户ID等于5的用户推荐10个与2398相似的商品
        List<RecommendedItem> recommendedItemList = recommender.recommendedBecause(5, 2398, 10);
        //打印推荐的结果
        System.out.println("使用基于物品的协同过滤算法");
        System.out.println("根据用户5当前浏览的商品2398，推荐10个相似的商品");
        for (RecommendedItem recommendedItem : recommendedItemList) {
            System.out.println(recommendedItem);
        }
        long start = System.currentTimeMillis();
        recommendedItemList = recommender.recommendedBecause(5, 34, 10);
        //打印推荐的结果
        System.out.println("使用基于物品的协同过滤算法");
        System.out.println("根据用户5当前浏览的商品34，推荐10个相似的商品");
        for (RecommendedItem recommendedItem : recommendedItemList) {
            System.out.println(recommendedItem);
        }
        System.out.println(System.currentTimeMillis() -start);
	}
	@Test
	public void test4() throws Exception{
		DataModel model = new FileDataModel(new File("D:/movie_preferences.txt"));//构造数据模型
		ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);//计算内容相似度  
		Recommender recommender = new GenericItemBasedRecommender(model, similarity);//构造推荐引擎  
		//给用户ID等于5的用户推荐10部电影
		List<RecommendedItem> recommendedItemList = recommender.recommend(5, 10);
		//打印推荐的结果
		System.out.println("使用基于内容的协同过滤算法");
		System.out.println("为用户5推荐10个商品");
		for (RecommendedItem recommendedItem : recommendedItemList) {
			System.out.println(recommendedItem);
		}
	}
	@Test
	public void test5() throws Exception{
		DataModel model = new FileDataModel(new File("D:/movie_preferences.txt"));//构造数据模型
		UserSimilarity similarity = new PearsonCorrelationSimilarity(model);//用PearsonCorrelation 算法计算用户相似度
		UserNeighborhood neighborhood = new NearestNUserNeighborhood(3, similarity, model);//计算用户的“邻居”，这里将与该用户最近距离为 3 的用户设置为该用户的“邻居”。
		Recommender recommender = new CachingRecommender(new GenericUserBasedRecommender(model, neighborhood, similarity));//采用 CachingRecommender 为 RecommendationItem 进行缓存
		//给用户ID等于5的用户推荐10部电影
		List<RecommendedItem> recommendedItemList = recommender.recommend(5, 10);
		//打印推荐的结果
		System.out.println("使用基于用户的协同过滤算法");
		System.out.println("为用户5推荐10个商品");
		for (RecommendedItem recommendedItem : recommendedItemList) {
			System.out.println(recommendedItem);
		}
	}
}
