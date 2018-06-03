package org.springrain.front.web.movieRecoment;

import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

/**
 * 基于内容的推荐
 * 
 * @copyright {@link www.centforsoft.com}
 * @author 高永强
 * @version 2018年6月3日 下午3:31:35
 * @see org.springrain.front.web.movieRecoment.MyItemBasedRecommender
 *
 */
public class MyItemBasedRecommender {
	
	public static List<RecommendedItem> myItemBasedRecommender(long userID,long movieId,int size){
		List<RecommendedItem> recommendations = null;
		try {
			//准备数据 这里是电影评分数据
			File file = new File("D:\\ml-latest\\ratings.csv");
	        //将数据加载到内存中，GroupLensDataModel是针对开放电影评论数据的
	        DataModel dataModel = new FileDataModel(file);
	        //计算相似度，相似度算法有很多种，欧几里得、皮尔逊等等。
	        ItemSimilarity itemSimilarity = new PearsonCorrelationSimilarity(dataModel);
	        //构建推荐器，协同过滤推荐有两种，分别是基于用户的和基于物品的，这里使用基于物品的协同过滤推荐
	        GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dataModel, itemSimilarity);
	        //给用户ID等于5的用户推荐10个与2398相似的商品
	        recommendations = recommender.recommendedBecause(userID, movieId, size);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return recommendations;
	}

}
