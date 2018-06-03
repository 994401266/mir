package org.springrain.front.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springrain.frame.entity.IBaseEntity;
import org.springrain.frame.util.Finder;
import org.springrain.frame.util.Page;
import org.springrain.front.entity.Comment;
import org.springrain.front.service.ICommentService;
import org.springrain.system.entity.User;
import org.springrain.system.service.impl.BaseSpringrainServiceImpl;


/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2018-05-21 13:50:25
 * @see org.springrain.front.service.impl.Comment
 */
@Service("commentService")
public class CommentServiceImpl extends BaseSpringrainServiceImpl implements ICommentService {

   
    @Override
	public String  save(Object entity ) throws Exception{
	      Comment comment=(Comment) entity;
	       return super.save(comment).toString();
	}

    @Override
	public String  saveorupdate(Object entity ) throws Exception{
	      Comment comment=(Comment) entity;
		 return super.saveorupdate(comment).toString();
	}
	
	@Override
    public Integer update(IBaseEntity entity ) throws Exception{
	 Comment comment=(Comment) entity;
	return super.update(comment);
    }
    @Override
	public Comment findCommentById(Object id) throws Exception{
	 return super.findById(id,Comment.class);
	}
	
/**
 * 列表查询,每个service都会重载,要把sql语句封装到service中,Finder只是最后的方案
 * @param finder
 * @param page
 * @param clazz
 * @param o
 * @return
 * @throws Exception
 */
        @Override
    public <T> List<T> findListDataByFinder(Finder finder, Page page, Class<T> clazz,
			Object o) throws Exception{
			 return super.findListDataByFinder(finder,page,clazz,o);
			}
	/**
	 * 根据查询列表的宏,导出Excel
	 * @param finder 为空则只查询 clazz表
	 * @param ftlurl 类表的模版宏
	 * @param page 分页对象
	 * @param clazz 要查询的对象
	 * @param o  querybean
	 * @return
	 * @throws Exception
	 */
		@Override
	public <T> File findDataExportExcel(Finder finder,String ftlurl, Page page,
			Class<T> clazz, Object o)
			throws Exception {
			 return super.findDataExportExcel(finder,ftlurl,page,clazz,o);
		}

	@Override
	public List<Comment> findByQueryBean(Page page, Comment queryBean) throws Exception {
		Finder finder = new Finder(" SELECT u.name AS userName ,c.* FROM ");
		finder.append(Finder.getTableName(Comment.class)).append(" c INNER JOIN  ")
				.append(Finder.getTableName(User.class)).append(" u ON c.userId=u.id ")
				.append(" where c.movieId =:movieId ").setParam("movieId", queryBean.getMovieId());
		finder.append(" ORDER BY c.created DESC ");
		return super.queryForList(finder, Comment.class, page);
	}

}
