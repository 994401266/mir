package org.springrain.front.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springrain.front.entity.SearchMovie;
import org.springrain.front.entity.SearchResult;


@Repository
public class SearchDao {
	
	@Autowired
	private SolrServer solrServer;
	
	public SearchResult search(SolrQuery query ) throws Exception{
		QueryResponse queryResponse = solrServer.query(query);
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		long numFound = solrDocumentList.getNumFound();
		//取高亮
		Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
		SearchResult result = new SearchResult();
		result.setRecourdCount(numFound);
		List<SearchMovie> movieList = new ArrayList<>();
		for (SolrDocument solrDocument : solrDocumentList) {
			SearchMovie movie = new SearchMovie();
			movie.setId((String) solrDocument.get("id"));
			List<String> list = highlighting.get(solrDocument.get("id")).get("movie_name");
			String name = "";
			if(list != null&&list.size() != 0){
				name = list.get(0);
			}else{
				name = (String) solrDocument.get("movie_name");
			}
			movie.setName(name);
			movie.setActors((String) solrDocument.get("movie_actors"));
			movie.setDoubanRating((String) solrDocument.get("movie_doubanRating"));
			movie.setAnotherNames((String) solrDocument.get("movie_anotherNames"));
			movie.setCoverLink((String) solrDocument.get("movie_coverLink"));
			movie.setDirectors((String) solrDocument.get("movie_directors"));
			movie.setLanguages((String) solrDocument.get("movie_languages"));
			movie.setOriginPlace((String) solrDocument.get("movie_originPlace"));
			movie.setReleaseYear((String) solrDocument.get("movie_releaseYear"));
			movie.setTypes((String) solrDocument.get("movie_types"));
			
			movieList.add(movie);
		}
		result.setMovieList(movieList);
		
		return result;
	}
}
