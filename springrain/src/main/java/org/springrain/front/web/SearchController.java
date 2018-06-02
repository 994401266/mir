package org.springrain.front.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springrain.frame.controller.BaseController;
import org.springrain.frame.util.GlobalStatic;
import org.springrain.frame.util.Page;
import org.springrain.frame.util.ReturnDatas;
import org.springrain.front.entity.SearchResult;
import org.springrain.front.service.ISearchService;


@Controller
@RequestMapping("/front")
public class SearchController extends BaseController{
	
	@Autowired
	private ISearchService searchService;
	
	private Integer SEARCH_RESULT_NUM=24;
	@RequestMapping("/search")
	public String search(String keyword ,HttpServletRequest request,Model model) throws Exception{
		ReturnDatas returnDatas = ReturnDatas.getSuccessReturnDatas();
		Page page = newPage(request);
		page.setPageSize(SEARCH_RESULT_NUM);
		//keyword = new String(keyword.getBytes("ISO8859-1"), "utf-8");
		SearchResult searchResult = searchService.search(keyword, page.getPageIndex(), SEARCH_RESULT_NUM);
		page.setTotalCount((int) searchResult.getRecourdCount());
		page.setPageSize(SEARCH_RESULT_NUM);
		returnDatas.setPage(page);
		returnDatas.setData(searchResult.getMovieList());
		model.addAttribute(GlobalStatic.returnDatas, returnDatas);
		//model.addAttribute("recourdCount", searchResult.getRecourdCount());
		//model.addAttribute("totalPages", searchResult.getTotalPages());
		//model.addAttribute("page", page);
		model.addAttribute("query", keyword);
		//model.addAttribute("movieList", searchResult.getMovieList());
		return "/movie/search";
	}
}
