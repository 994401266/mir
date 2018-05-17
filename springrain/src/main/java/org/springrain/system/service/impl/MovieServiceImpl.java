package org.springrain.system.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springrain.frame.entity.IBaseEntity;
import org.springrain.frame.util.Finder;
import org.springrain.frame.util.Page;
import org.springrain.system.common.SystemEnum;
import org.springrain.system.entity.DicData;
import org.springrain.system.entity.Movie;
import org.springrain.system.service.IDicDataService;
import org.springrain.system.service.IMovieService;


/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2018-04-26 13:39:26
 * @see org.springrain.cms.base.service.impl.Movie
 */
@Service("movieService")
public class MovieServiceImpl extends BaseSpringrainServiceImpl implements IMovieService {

	@Resource
	private IDicDataService dicDataService;
   
    @Override
	public String  save(Object entity ) throws Exception{
	      Movie movie=(Movie) entity;
	       return super.save(movie).toString();
	}

    @Override
	public String  saveorupdate(Object entity ) throws Exception{
	      Movie movie=(Movie) entity;
		 return super.saveorupdate(movie).toString();
	}
	
	@Override
    public Integer update(IBaseEntity entity ) throws Exception{
	 Movie movie=(Movie) entity;
	return super.update(movie);
    }
    @Override
	public Movie findMovieById(Object id) throws Exception{
	 return super.findById(id,Movie.class);
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
	public List<Map<String, Object>> findByQueryBean(Page page, Movie movie) throws Exception {
		Finder finder = Finder.getSelectFinder(Movie.class);
		finder.append(" where 1=1 ");
		if (movie != null) {
			if (StringUtils.isNotBlank(movie.getName())) {
				finder.append(" AND name like :name ").setParam("name",
						"%" + movie.getName().trim() + "%");
			}
			if (movie.getStatus() != null) {
				finder.append(" AND status=:status ").setParam("status", movie.getStatus());
			}
			if (StringUtils.isNotBlank(movie.getTypes())) {
				String types = movie.getTypes();
				if (types.contains(",")) {
					String[] split = types.split(",");
					String rege = "";
					for (int i = 0; i < split.length; i++) {
						rege += split[i];
						if (i != split.length - 1) {
							rege += "|";
						}
					}
					finder.append(" AND types regexp:rege ").setParam("rege",
							rege.trim());
				} else {
					finder.append(" AND types like:types ").setParam("types",
							"%" + movie.getTypes().trim() + "%");
				}
			}
			if (StringUtils.isNotBlank(movie.getOriginPlace())) {
				String originPlaces = movie.getOriginPlace();
				if (originPlaces.contains(",")) {
					String[] split = originPlaces.split(",");
					String rege = "";
					for (int i = 0; i < split.length; i++) {
						rege += split[i];
						if (i != split.length - 1) {
							rege += "|";
						}
					}
					finder.append(" AND originPlace regexp:rege ").setParam("rege",
							rege.trim());
				} else if (originPlaces.equals("others")) {
					DicData dicData = new DicData();
					dicData.setActive(SystemEnum.Active.可用.getType());
					dicData.setTypekey(SystemEnum.DicDataType.地区.getTypekey());
					List<DicData> list = dicDataService.findListDataByFinder(null, null,
							DicData.class, dicData);
					String rege = "";
					for (int i = 0; i < list.size(); i++) {
						rege += list.get(i).getName();
						if (i != list.size() - 1) {
							rege += "|";
						}
					}
					finder.append(" AND originPlace NOT regexp:rege ").setParam("rege",
							rege.trim());
				} else {
					finder.append(" AND originPlace like:originPlace ").setParam("originPlace",
							"%" + movie.getOriginPlace().trim() + "%");
				}
			}

			if (StringUtils.isNotBlank(movie.getReleaseYear())) {
				String releaseYear = movie.getReleaseYear();
				if (releaseYear.contains(",")) {
					String[] split = releaseYear.split(",");
					String rege = "";
					finder.append(" AND ( 1!=1 ");
					for (int i = 0; i < split.length; i++) {
						if (split[i].contains("-")) {
							String[] split2 = split[i].split("-");
							if (split2[0].equals("0")) {
								finder.append(" OR releaseYear <:releaseYear ")
										.setParam("releaseYear", split2[1]);
							} else {
								for (int j = Integer.parseInt(split2[0]); j < Integer
										.parseInt(split2[1]); j++) {
									rege += j + "|";
								}
							}
						} else {
							rege += split[i] + "|";
						}
					}
					String subString = rege.substring(0, rege.length() - 1);
					finder.append(" OR releaseYear regexp:rege ").setParam("rege",
							subString.trim());
					finder.append(" ) ");
				} else {
					if (releaseYear.contains("-")) {
						String[] split2 = releaseYear.split("-");
						if (split2[0].equals("0")) {
							finder.append(" AND releaseYear <:releaseYear ").setParam("releaseYear",
									split2[1]);
						} else {
							finder.append(" AND releaseYear <=:endReleaseYear ")
									.setParam("endReleaseYear", split2[1]);
							finder.append(" AND releaseYear >=:startReleaseYear ")
									.setParam("startReleaseYear", split2[0]);
						}
					} else {
						finder.append(" AND releaseYear =:releaseYear ").setParam("releaseYear",
								releaseYear);
					}
				}
			}
		}
		return super.queryForList(finder, page);
	}

}
