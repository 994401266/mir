package org.springrain.system.service;

import org.springrain.system.entity.Content;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2018-05-10 11:40:08
 * @see org.springrain.system.service.Content
 */
public interface IContentService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Content findContentById(Object id) throws Exception;
	
	
	
}
