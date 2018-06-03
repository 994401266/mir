package org.springrain.front.service.impl;

import java.io.File;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springrain.front.entity.RecommendMovie;
import org.springrain.front.service.IRecommendMovieService;
import org.springrain.system.service.impl.BaseSpringrainServiceImpl;
import org.springrain.frame.entity.IBaseEntity;
import org.springrain.frame.util.Finder;
import org.springrain.frame.util.Page;


/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2018-06-03 16:54:17
 * @see org.springrain.front.service.impl.RecommendMovie
 */
@Service("recommendMovieService")
public class RecommendMovieServiceImpl extends BaseSpringrainServiceImpl implements IRecommendMovieService {

   
    @Override
	public String  save(Object entity ) throws Exception{
	      RecommendMovie recommendMovie=(RecommendMovie) entity;
	       return super.save(recommendMovie).toString();
	}

    @Override
	public String  saveorupdate(Object entity ) throws Exception{
	      RecommendMovie recommendMovie=(RecommendMovie) entity;
		 return super.saveorupdate(recommendMovie).toString();
	}
	
	@Override
    public Integer update(IBaseEntity entity ) throws Exception{
	 RecommendMovie recommendMovie=(RecommendMovie) entity;
	return super.update(recommendMovie);
    }
    @Override
	public RecommendMovie findRecommendMovieById(Object id) throws Exception{
	 return super.findById(id,RecommendMovie.class);
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
	public List<RecommendMovie> findListByIds(List<Integer> ids) throws Exception {
		if(CollectionUtils.isNotEmpty(ids)){
			Finder finder = new Finder(" select * from  ")
					.append(Finder.getTableName(RecommendMovie.class))
					.append(" where id in(:ids) ").setParam("ids", ids);
			return super.queryForList(finder, RecommendMovie.class);
		}
		return null;
	}

	@Override
	public List<RecommendMovie> findByQueryBean(RecommendMovie queryBean, int pageSize) throws Exception {
		Finder finder = new Finder(" select * from  ")
				.append(Finder.getTableName(RecommendMovie.class))
				.append(" where types like:types ").setParam("types", queryBean.getTypes());
		Page page = new Page();
		page.setPageSize(pageSize);
		return super.queryForList(finder, RecommendMovie.class, page);
	}

}
