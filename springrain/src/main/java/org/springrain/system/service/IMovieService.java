package org.springrain.system.service;

import java.util.List;
import java.util.Map;

import org.springrain.frame.util.Page;
import org.springrain.system.entity.Movie;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2018-04-26 13:39:26
 * @see org.springrain.cms.base.service.Movie
 */
public interface IMovieService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Movie findMovieById(Object id) throws Exception;

	/**
	 * 根据条件分页查询
	 *
	 * @param page
	 * @param movie
	 * @return
	 * @author 高永强
	 * @version 2018年4月26日 下午3:41:43
	 */
	List<Map<String, Object>> findByQueryBean(Page page, Movie movie) throws Exception;
	
	
	
}
