package org.springrain.front.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springrain.frame.entity.IBaseEntity;
import org.springrain.frame.util.DateUtils;
import org.springrain.frame.util.Finder;
import org.springrain.frame.util.Page;
import org.springrain.front.entity.UserHistory;
import org.springrain.front.service.IUserHistoryService;
import org.springrain.system.entity.Movie;
import org.springrain.system.entity.User;
import org.springrain.system.service.impl.BaseSpringrainServiceImpl;


/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2018-05-21 15:57:06
 * @see org.springrain.front.service.impl.UserHistory
 */
@Service("userHistoryService")
public class UserHistoryServiceImpl extends BaseSpringrainServiceImpl implements IUserHistoryService {

   
    @Override
	public String  save(Object entity ) throws Exception{
	      UserHistory userHistory=(UserHistory) entity;
	       return super.save(userHistory).toString();
	}

    @Override
	public String  saveorupdate(Object entity ) throws Exception{
	      UserHistory userHistory=(UserHistory) entity;
		 return super.saveorupdate(userHistory).toString();
	}
	
	@Override
    public Integer update(IBaseEntity entity ) throws Exception{
	 UserHistory userHistory=(UserHistory) entity;
	return super.update(userHistory);
    }
    @Override
	public UserHistory findUserHistoryById(Object id) throws Exception{
	 return super.findById(id,UserHistory.class);
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
	public List<Map<String, Object>> finderByQueryBean(Page page, UserHistory userHistory)
			throws Exception {
		Finder finder = new Finder(" SELECT  a.createTime,c.* FROM ");
		finder.append(Finder.getTableName(UserHistory.class)).append(" a INNER JOIN  ")
				.append(Finder.getTableName(User.class)).append(" b ON a.userId=b.id INNER JOIN ")
				.append(Finder.getTableName(Movie.class)).append(" c ON a.movieId=c.id ")
				.append(" WHERE 1=1 ").append(" AND a.active=:active ").setParam("active", "1");
		if (StringUtils.isNotBlank(userHistory.getUserId())) {
			finder.append(" AND b.id=:userId ").setParam("userId", userHistory.getUserId());
		}
		if (userHistory.getStartTime() != null) {
			finder.append(" AND a.createTime >=:startTime ").setParam("startTime",
					DateUtils.getMinDateTimeForToDay(userHistory.getStartTime()));
		}
		if (userHistory.getEndTime() != null) {
			finder.append(" AND a.createTime <=:endTime ").setParam("endTime",
					DateUtils.getMaxDateTimeForToDay(userHistory.getEndTime()));
		}
		finder.append(" ORDER BY a.createTime DESC ");
		return super.queryForList(finder, page);
	}

}
