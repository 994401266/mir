package org.springrain.system.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springrain.frame.entity.IBaseEntity;
import org.springrain.frame.util.Finder;
import org.springrain.frame.util.Page;
import org.springrain.system.entity.ContentCategory;
import org.springrain.system.service.IContentCategoryService;


/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2018-05-10 11:40:28
 * @see org.springrain.system.service.impl.ContentCategory
 */
@Service("contentCategoryService")
public class ContentCategoryServiceImpl extends BaseSpringrainServiceImpl implements IContentCategoryService {

   
    @Override
	public String  save(Object entity ) throws Exception{
	      ContentCategory contentCategory=(ContentCategory) entity;
	       return super.save(contentCategory).toString();
	}

    @Override
	public String  saveorupdate(Object entity ) throws Exception{
	      ContentCategory contentCategory=(ContentCategory) entity;
		 return super.saveorupdate(contentCategory).toString();
	}
	
	@Override
    public Integer update(IBaseEntity entity ) throws Exception{
	 ContentCategory contentCategory=(ContentCategory) entity;
	return super.update(contentCategory);
    }
    @Override
	public ContentCategory findContentCategoryById(Object id) throws Exception{
	 return super.findById(id,ContentCategory.class);
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

}
