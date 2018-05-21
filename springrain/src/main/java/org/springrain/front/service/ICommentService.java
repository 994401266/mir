package org.springrain.front.service;

import java.util.List;

import org.springrain.frame.util.Page;
import org.springrain.front.entity.Comment;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2018-05-21 13:50:25
 * @see org.springrain.front.service.Comment
 */
public interface ICommentService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Comment findCommentById(Object id) throws Exception;

	List<Comment> findByQueryBean(Page page, Comment queryBean) throws Exception;
	
	
	
}
