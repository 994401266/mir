package org.springrain.front.service;

import java.util.List;

import org.springrain.front.entity.RecommendMovie;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2018-06-03 16:54:17
 * @see org.springrain.front.service.RecommendMovie
 */
public interface IRecommendMovieService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	RecommendMovie findRecommendMovieById(Object id) throws Exception;

	/**
	 * 根据ids查找
	*
	* @param ids
	* @return
	* @throws Exception
	* @author 高永强
	* @version 2018年6月3日 下午5:08:37
	 */
	List<RecommendMovie> findListByIds(List<Integer> ids) throws Exception;

	List<RecommendMovie> findByQueryBean(RecommendMovie queryBean, int i) throws Exception;
	
	
	
}
