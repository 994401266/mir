package org.springrain.system.service;

import org.springrain.system.entity.ContentCategory;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2018-05-10 11:40:28
 * @see org.springrain.system.service.ContentCategory
 */
public interface IContentCategoryService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	ContentCategory findContentCategoryById(Object id) throws Exception;
	
	
	
}
