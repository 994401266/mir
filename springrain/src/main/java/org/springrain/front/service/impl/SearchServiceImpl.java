package org.springrain.front.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springrain.front.dao.SearchDao;
import org.springrain.front.entity.SearchResult;
import org.springrain.front.service.ISearchService;

@Service("searchService")
public class SearchServiceImpl implements ISearchService {
	
	private String DEFAULT_FIELD = "movie_name";
	@Autowired
	private SearchDao searchDao;
	
	@Override
	public SearchResult search(String keyword, int page, int rows) throws Exception {

		SolrQuery query = new SolrQuery();
		query.setQuery(keyword);
		query.set("df", DEFAULT_FIELD);
		query.setHighlight(true);
		query.setHighlightSimplePre("<em style='color:red'>");
		query.setHighlightSimplePost("</em>");
		if(page<0){
			page = 1;
		}
		query.setStart((page-1)*rows);
		query.setRows(rows);
		SearchResult result = searchDao.search(query);
		long recourdCount = result.getRecourdCount();
		int pages = (int) (recourdCount/rows);
		if(recourdCount%rows > 0) pages++;
		result.setTotalPages(pages);
		return result;
	}
	
}
