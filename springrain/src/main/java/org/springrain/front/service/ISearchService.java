package org.springrain.front.service;

import org.springrain.front.entity.SearchResult;

public interface ISearchService {
	SearchResult search(String keyword, int page ,int rows) throws Exception;
}
