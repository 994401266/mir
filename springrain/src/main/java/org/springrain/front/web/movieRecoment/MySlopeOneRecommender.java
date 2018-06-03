package org.springrain.front.web.movieRecoment;

import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefItemBasedRecommender;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

public class MySlopeOneRecommender {
	public static List<RecommendedItem> mySlopeOneRecommender(long userID,int size){
		List<RecommendedItem> recommendations = null;
		try {
			DataModel model = new FileDataModel(new File("D:/ml-1m/movie_preferences.txt"));//构造数据模型
			ItemSimilarity similarity = null;
			Recommender recommender = new GenericBooleanPrefItemBasedRecommender(model, similarity);//构造推荐引擎  
			recommendations = recommender.recommend(userID, size);//得到推荐的结果，size是推荐接过的数目
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return recommendations;
	}

}
