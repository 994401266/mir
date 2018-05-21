package org.springrain.front.web;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springrain.frame.common.SessionUser;
import org.springrain.frame.controller.BaseController;
import org.springrain.frame.util.DateUtils;
import org.springrain.frame.util.GlobalStatic;
import org.springrain.frame.util.Page;
import org.springrain.frame.util.ReturnDatas;
import org.springrain.frame.util.property.MessageUtils;
import org.springrain.front.entity.Comment;
import org.springrain.front.entity.UserHistory;
import org.springrain.front.service.ICommentService;
import org.springrain.front.service.IUserHistoryService;
import org.springrain.system.entity.Movie;
import org.springrain.system.service.IMovieService;

/**
 * 前端展示电影数据的controller
 * 
 * @author springrain<Auto generate>
 * @version 2018-04-26 13:39:26
 * @see org.springrain.cms.base.web.Movie
 */
@Controller
@RequestMapping(value = "/front/movie")
public class MovieController  extends BaseController {
	@Resource
	private IMovieService movieService;
	@Resource
	private ICommentService commentService;
	@Resource
	private IUserHistoryService userHistoryService;
	private String listurl = "/system/movie/movieList";
	
	/**
	 * 前台首页
	 *
	 * @param request
	 * @param model
	 * @param movie
	 * @return
	 * @throws Exception
	 * @author 高永强
	 * @version 2018年5月15日 下午4:20:46
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model,Movie movie) 
			throws Exception {
		return "/movie/index";
	}

	/**
	 * 跳转到电影类型分类结果页面
	 * 
	 * @param movieType
	 * @param request
	 * @param model
	 * @param movie
	 * @return
	 * @throws Exception
	 * @author 高永强
	 * @version 2018年5月15日 下午4:21:07
	 */
	@RequestMapping("/types/{movieType}")
	public String type(@PathVariable String movieType, HttpServletRequest request, Model model,
			Movie movie) throws Exception {
		ReturnDatas returnDatas = ReturnDatas.getSuccessReturnDatas();
		Page page = newPage(request);
		page.setPageSize(24);
		if (StringUtils.isNotBlank(movieType)) {
			movie.setTypes(movieType);
		}
		movie.setStatus(1);
		List<Map<String, Object>> datas = null;
		try {

			datas = movieService.findByQueryBean(page, movie);

			for (Map<String, Object> map : datas) {
				String doubanRating = (String) map.get("doubanRating");
				if (StringUtils.isNotBlank(doubanRating)) {
					map.put("doubanRatingDouble", Double.parseDouble(doubanRating));
				} else {
					map.put("doubanRatingDouble", null);
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		returnDatas.setData(datas);
		returnDatas.setQueryBean(movie);
		returnDatas.setPage(page);
		model.addAttribute(GlobalStatic.returnDatas, returnDatas);
		return "/movie/genres";
	}

	/**
	 * 跳转到电影产地结果页面
	 * 
	 * @param movieType
	 * @param request
	 * @param model
	 * @param movie
	 * @return
	 * @throws Exception
	 * @author 高永强
	 * @version 2018年5月15日 下午4:21:07
	 */
	@RequestMapping("/originPlace/{movieOriginPlace}")
	public String originPlace(@PathVariable String movieOriginPlace, HttpServletRequest request,
			Model model, Movie movie) {
		ReturnDatas returnDatas = ReturnDatas.getSuccessReturnDatas();
		Page page = newPage(request);
		page.setPageSize(24);
		if (StringUtils.isNotBlank(movieOriginPlace)) {
			movie.setOriginPlace(movieOriginPlace);
		}
		movie.setStatus(1);
		List<Map<String, Object>> datas = null;
		try {

			datas = movieService.findByQueryBean(page, movie);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		returnDatas.setData(datas);
		returnDatas.setQueryBean(movie);
		returnDatas.setPage(page);
		model.addAttribute(GlobalStatic.returnDatas, returnDatas);
		return "/movie/genres";
	}

	@RequestMapping("/listMovie")
	public String lm(HttpServletRequest request, Model model,Movie movie) 
			throws Exception {
		return "/movie/list";
	}

	@RequestMapping("/history")
	public String history(HttpServletRequest request, Model model,Movie movie) 
	{
		ReturnDatas returnDatas = ReturnDatas.getSuccessReturnDatas();
		Page page = newPage(request);
		page.setPageSize(10);
		String userId = SessionUser.getUserId();
		try {
			// 查询今天的历史记录
			UserHistory userHistory = new UserHistory();
			userHistory.setUserId(userId);
			userHistory.setStartTime(new Date());
			userHistory.setEndTime(new Date());
			List<Map<String, Object>> today = userHistoryService.finderByQueryBean(page,
					userHistory);
			// 一周以内
			userHistory.setStartTime(DateUtils.addDay(-7, new Date()));
			userHistory.setEndTime(DateUtils.addDay(-1, new Date()));
			List<Map<String, Object>> week = userHistoryService.finderByQueryBean(page,
					userHistory);
			// 更早
			userHistory.setStartTime(null);
			userHistory.setEndTime(DateUtils.addDay(-8, new Date()));
			List<Map<String, Object>> longAgo = userHistoryService.finderByQueryBean(page,
					userHistory);
			Map<String, Object> map = new HashMap<>();
			map.put("today", today);
			map.put("week", week);
			map.put("longAgo", longAgo);
			returnDatas.setData(map);
			model.addAttribute(GlobalStatic.returnDatas, returnDatas);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		return "/movie/history";
	}

	@RequestMapping("/single/{movieId}")
	public String single(@PathVariable String movieId, HttpServletRequest request, Model model)
			throws Exception {
		ReturnDatas returnDatas = ReturnDatas.getSuccessReturnDatas();
		// Page page = newPage(request);
		// page.setPageSize(3);
		Movie movie = null;
		if (StringUtils.isNotBlank(movieId)) {

			if (StringUtils.isNotBlank(SessionUser.getUserId())) {
				UserHistory userHistory = new UserHistory();
				userHistory.setMovieId(movieId);
				userHistory.setActive(1);
				userHistory.setUserId(SessionUser.getUserId());
				List<UserHistory> list = userHistoryService.findListDataByFinder(null, null,
						UserHistory.class, userHistory);
				if (CollectionUtils.isNotEmpty(list)) {
					userHistory.setId(list.get(0).getId());
				}
				userHistory.setCreateTime(new Date());
				userHistoryService.saveorupdate(userHistory);
			}

			try {
				movie = movieService.findMovieById(movieId);
				Comment queryBean = new Comment();
				queryBean.setMovieId(movieId);
				List<Comment> commetList = commentService.findByQueryBean(null, queryBean);
				movie.setComments(commetList);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		returnDatas.setData(movie);
		model.addAttribute(GlobalStatic.returnDatas, returnDatas);
		return "/movie/single";
	}

	/**
	 * 列表数据,调用listjson方法,保证和app端数据统一
	 * 
	 * @param request
	 * @param model
	 * @param movie
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model, Movie movie) throws Exception {
		ReturnDatas returnObject = listjson(request, model, movie);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return listurl;
	}

	/**
	 * json数据,为APP提供数据
	 * 
	 * @param request
	 * @param model
	 * @param movie
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list/json")
	public @ResponseBody
	ReturnDatas listjson(HttpServletRequest request, Model model,Movie movie) throws Exception{
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		// ==构造分页请求
		Page page = newPage(request);
		// ==执行分页查询
		// List<Movie>
		// datas=movieService.findListDataByFinder(null,page,Movie.class,movie);
		List<Map<String, Object>> datas = movieService.findByQueryBean(page, movie);
		returnObject.setQueryBean(movie);
		returnObject.setPage(page);
		returnObject.setData(datas);
		return returnObject;
	}
	
	@RequestMapping("/list/export")
	public void listexport(HttpServletRequest request,HttpServletResponse response, Model model,Movie movie) throws Exception{
		// ==构造分页请求
		Page page = newPage(request);
	
		File file = movieService.findDataExportExcel(null,listurl, page,Movie.class,movie);
		String fileName="movie"+GlobalStatic.excelext;
		downFile(response, file, fileName,true);
		return;
	}
	
		/**
	 * 查看操作,调用APP端lookjson方法
	 */
	@RequestMapping(value = "/look")
	public String look(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception {
		ReturnDatas returnObject = lookjson(model, request, response);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return "/system/movie/movieLook";
	}

	
	/**
	 * 查看的Json格式数据,为APP端提供数据
	 */
	@RequestMapping(value = "/look/json")
	public @ResponseBody
	ReturnDatas lookjson(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception {
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		  String  strId=request.getParameter("id");
		  java.lang.Long id=null;
		  if(StringUtils.isNotBlank(strId)){
			 id= java.lang.Long.valueOf(strId.trim());
		  Movie movie = movieService.findMovieById(id);
		   returnObject.setData(movie);
		}else{
		returnObject.setStatus(ReturnDatas.ERROR);
		}
		return returnObject;
		
	}
	
	
	/**
	 * 新增/修改 操作吗,返回json格式数据
	 * 
	 */
	@RequestMapping("/update")
	public @ResponseBody
	ReturnDatas saveorupdate(Model model,Movie movie,HttpServletRequest request,HttpServletResponse response) throws Exception{
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		returnObject.setMessage(MessageUtils.UPDATE_SUCCESS);
		try {
		
			if (movie.getId() == null) {
				movieService.save(movie);
			} else {
				movieService.update(movie, true);
			}
			
		} catch (Exception e) {
			String errorMessage = e.getLocalizedMessage();
			logger.error(errorMessage);
			returnObject.setStatus(ReturnDatas.ERROR);
			returnObject.setMessage(MessageUtils.UPDATE_ERROR);
		}
		return returnObject;
	
	}
	
	/**
	 * 进入修改页面,APP端可以调用 lookjson 获取json格式数据
	 */
	@RequestMapping(value = "/update/pre")
	public String updatepre(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		ReturnDatas returnObject = lookjson(model, request, response);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return "/system/movie/movieCru";
	}
	
	/**
	 * 删除操作
	 */
	@RequestMapping(value="/delete")
	public @ResponseBody ReturnDatas delete(HttpServletRequest request) throws Exception {

			// 执行删除
		try {
		  String  strId=request.getParameter("id");
		  java.lang.Long id=null;
		  if(StringUtils.isNotBlank(strId)){
			 id= java.lang.Long.valueOf(strId.trim());
				movieService.deleteById(id,Movie.class);
				return new ReturnDatas(ReturnDatas.SUCCESS,
						MessageUtils.DELETE_SUCCESS);
			} else {
				return new ReturnDatas(ReturnDatas.WARNING,
						MessageUtils.DELETE_WARNING);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return new ReturnDatas(ReturnDatas.WARNING, MessageUtils.DELETE_WARNING);
	}
	
	/**
	 * 删除多条记录
	 * 
	 */
	@RequestMapping("/delete/more")
	public @ResponseBody
	ReturnDatas deleteMore(HttpServletRequest request, Model model) {
		String records = request.getParameter("records");
		if(StringUtils.isBlank(records)){
			 return new ReturnDatas(ReturnDatas.ERROR,
					MessageUtils.DELETE_ALL_FAIL);
		}
		String[] rs = records.split(",");
		if (rs == null || rs.length < 1) {
			return new ReturnDatas(ReturnDatas.ERROR,
					MessageUtils.DELETE_NULL_FAIL);
		}
		try {
			List<String> ids = Arrays.asList(rs);
			movieService.deleteByIds(ids,Movie.class);
		} catch (Exception e) {
			return new ReturnDatas(ReturnDatas.ERROR,
					MessageUtils.DELETE_ALL_FAIL);
		}
		return new ReturnDatas(ReturnDatas.SUCCESS,
				MessageUtils.DELETE_ALL_SUCCESS);
		
		
	}

}
