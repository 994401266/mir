package org.springrain.front.service.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springrain.frame.util.ReturnDatas;
import org.springrain.front.entity.SearchMovie;
import org.springrain.front.service.ISearchMovieService;
import org.springrain.system.service.IMovieService;


@Service("searchMovieService")
public class SearchMovieServiceImpl implements ISearchMovieService{
	
	@Resource
	private IMovieService movieService;
	@Autowired
	private SolrServer solrServer;
	@Override
	public ReturnDatas importAllItems() {
		try {
			//查询数据库获得所有数据
			List<SearchMovie> itemList = movieService.findMovieList();
			//遍历数据
			for (SearchMovie searchItem : itemList) {
				//创建document对象
				SolrInputDocument document = new SolrInputDocument();
				//向document添加
				document.addField("id", searchItem.getId());
				document.addField("movie_name", searchItem.getName());
				document.addField("movie_doubanRating", searchItem.getDoubanRating());
				document.addField("movie_actors", searchItem.getActors());
				document.addField("movie_anotherNames", searchItem.getAnotherNames());
				document.addField("movie_coverLink", searchItem.getCoverLink());
				document.addField("movie_directors", searchItem.getDirectors());
				document.addField("movie_languages", searchItem.getLanguages());
				document.addField("movie_originPlace", searchItem.getOriginPlace());
				document.addField("movie_releaseYear", searchItem.getReleaseYear());
				document.addField("movie_types", searchItem.getTypes());
				//向索引库添加
				solrServer.add(document);
			}
			//提交
			solrServer.commit();
			//返回ok
			return ReturnDatas.getSuccessReturnDatas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ReturnDatas("error", "数据导入时发生异常");
		}
	}

}
