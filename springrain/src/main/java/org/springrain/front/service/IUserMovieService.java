package org.springrain.front.service;

import org.springrain.front.entity.UserMovie;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2018-05-21 13:49:50
 * @see org.springrain.front.service.UserMovie
 */
public interface IUserMovieService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	UserMovie findUserMovieById(Object id) throws Exception;
	
	
	
}
