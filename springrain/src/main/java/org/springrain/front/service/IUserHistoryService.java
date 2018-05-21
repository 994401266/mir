package org.springrain.front.service;

import java.util.List;
import java.util.Map;

import org.springrain.frame.util.Page;
import org.springrain.front.entity.UserHistory;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2018-05-21 15:57:06
 * @see org.springrain.front.service.UserHistory
 */
public interface IUserHistoryService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	UserHistory findUserHistoryById(Object id) throws Exception;

	List<Map<String, Object>> finderByQueryBean(Page page, UserHistory userHistory)
			throws Exception;
	
	
	
}
