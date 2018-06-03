package org.springrain.system.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springrain.frame.annotation.WhereSQL;
import org.springrain.frame.entity.BaseEntity;
import org.springrain.front.entity.Comment;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2018-05-10 17:16:56
 * @see org.springrain.system.entity.Movie
 */
@Table(name="m_movie")
public class Movie  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	 * public static final String TABLE_ALIAS = "电影基本信息表"; public static final
	 * String ALIAS_ID = "电影ID"; public static final String ALIAS_doubanId =
	 * "豆瓣电影ID"; public static final String ALIAS_NAME = "电影名"; public static
	 * final String ALIAS_DOUBANRATING = "豆瓣评分"; public static final String
	 * ALIAS_IMDBRATING = "IMDb评分"; public static final String ALIAS_RELEASEYEAR
	 * = "电影发行年份"; public static final String ALIAS_DIRECTORS = "电影导演"; public
	 * static final String ALIAS_SCREENWRITERS = "编剧"; public static final
	 * String ALIAS_ACTORS = "相关演员"; public static final String ALIAS_TYPES =
	 * "电影类型"; public static final String ALIAS_STATUS =
	 * "'电影状态，1-正常，2-下架，3-删除'"; public static final String ALIAS_ORIGINPLACE =
	 * "国家"; public static final String ALIAS_RELEASEDATE = "上映时间"; public
	 * static final String ALIAS_LANGUAGES = "语言"; public static final String
	 * ALIAS_RUNTIME = "时长"; public static final String ALIAS_ANOTHERNAMES =
	 * "又名"; public static final String ALIAS_YOUKULINK = "优酷的电影链接"; public
	 * static final String ALIAS_XUNLEIDOWNLOADLINKS = "迅雷下载链接"; public static
	 * final String ALIAS_COVERLINK = "电影封面链接"; public static final String
	 * ALIAS_SYNOPSIS = "剧情概要"; public static final String ALIAS_AWARDS = "获奖";
	 * public static final String ALIAS_ALSOLIKEMOVIES = "喜欢这部电影的人同样喜欢的电影";
	 */
	//date formats
	
	//columns START
	/**
	 * 电影ID
	 */
	private java.lang.Long id;
	/**
	 * 豆瓣电影ID
	 */
	private java.lang.String doubanId;
	/**
	 * 电影名
	 */
	private java.lang.String name;
	/**
	 * 豆瓣评分
	 */
	private java.lang.String doubanRating;
	/**
	 * IMDb评分
	 */
	private java.lang.String imdbRating;
	/**
	 * 电影发行年份
	 */
	private java.lang.String releaseYear;
	/**
	 * 电影导演
	 */
	private java.lang.String directors;
	/**
	 * 编剧
	 */
	private java.lang.String screenwriters;
	/**
	 * 相关演员
	 */
	private java.lang.String actors;
	/**
	 * 电影类型
	 */
	private java.lang.String types;
	/**
	 * '电影状态，1-正常，2-下架，3-删除'
	 */
	private Integer status;
	/**
	 * 国家
	 */
	private java.lang.String originPlace;
	/**
	 * 上映时间
	 */
	private java.lang.String releaseDate;
	/**
	 * 语言
	 */
	private java.lang.String languages;
	/**
	 * 时长
	 */
	private java.lang.String runtime;
	/**
	 * 又名
	 */
	private java.lang.String anotherNames;
	/**
	 * 优酷的电影链接
	 */
	private java.lang.String youkuLink;
	/**
	 * 迅雷下载链接
	 */
	private java.lang.String xunleiDownloadLinks;
	/**
	 * 电影封面链接
	 */
	private java.lang.String coverLink;
	/**
	 * 剧情概要
	 */
	private java.lang.String synopsis;
	/**
	 * 获奖
	 */
	private java.lang.String awards;
	/**
	 * 喜欢这部电影的人同样喜欢的电影
	 */
	private java.lang.String alsoLikeMovies;
	/**
	 * 添加时间
	 */
	private java.util.Date addTime;
	/**
	 * 观看次数
	 */
	private java.lang.Long viewCount;
	//columns END 数据库字段结束
	
	private List<Comment> comments;
	//concstructor

	public Movie(){
	}

	public Movie(
		java.lang.Long id
	){
		this.id = id;
	}

	@Transient
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Transient
	public Double getDoubanRatingDouble() {
		if (StringUtils.isNoneBlank(this.doubanRating)) {
			return Double.parseDouble(this.doubanRating);
		} else {
			return null;
		}
	}

	public List<String> getTypeList() {
		if (StringUtils.isNotBlank(this.types)) {
			List<String> typeList = new ArrayList<>();
			if (this.types.contains(",")) {
				String[] split = this.types.split(",");
				for (String string : split) {
					typeList.add(string.replaceAll("[^\u4E00-\u9FA5]", ""));
				}
			} else {
				typeList.add(types.replaceAll("[^\u4E00-\u9FA5]", ""));
			}
			return typeList;
		} else {
			return null;
		}
	}
	//get and set
		/**
		 * 电影ID
		 */
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	
	
	/**
	 * 电影ID
	 */
	@Id
     @WhereSQL(sql="id=:Movie_id")
	public java.lang.Long getId() {
		return this.id;
	}
		/**
		 * 豆瓣电影ID
		 */
	public void setDoubanId(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.doubanId = value;
	}
	
	
	
	/**
	 * 豆瓣电影ID
	 */
	@WhereSQL(sql = "doubanId=:Movie_doubanId")
	public java.lang.String getDoubanId() {
		return this.doubanId;
	}
		/**
		 * 电影名
		 */
	public void setName(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.name = value;
	}
	
	
	
	/**
	 * 电影名
	 */
     @WhereSQL(sql="name=:Movie_name")
	public java.lang.String getName() {
		return this.name;
	}
		/**
		 * 豆瓣评分
		 */
	public void setDoubanRating(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.doubanRating = value;
	}
	
	
	
	/**
	 * 豆瓣评分
	 */
     @WhereSQL(sql="doubanRating=:Movie_doubanRating")
	public java.lang.String getDoubanRating() {
		return this.doubanRating;
	}
		/**
		 * IMDb评分
		 */
	public void setImdbRating(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.imdbRating = value;
	}
	
	
	
	/**
	 * IMDb评分
	 */
     @WhereSQL(sql="imdbRating=:Movie_imdbRating")
	public java.lang.String getImdbRating() {
		return this.imdbRating;
	}
		/**
		 * 电影发行年份
		 */
	public void setReleaseYear(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.releaseYear = value;
	}
	
	
	
	/**
	 * 电影发行年份
	 */
     @WhereSQL(sql="releaseYear=:Movie_releaseYear")
	public java.lang.String getReleaseYear() {
		return this.releaseYear;
	}
		/**
		 * 电影导演
		 */
	public void setDirectors(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.directors = value;
	}
	
	
	
	/**
	 * 电影导演
	 */
     @WhereSQL(sql="directors=:Movie_directors")
	public java.lang.String getDirectors() {
		return this.directors;
	}
		/**
		 * 编剧
		 */
	public void setScreenwriters(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.screenwriters = value;
	}
	
	
	
	/**
	 * 编剧
	 */
     @WhereSQL(sql="screenwriters=:Movie_screenwriters")
	public java.lang.String getScreenwriters() {
		return this.screenwriters;
	}
		/**
		 * 相关演员
		 */
	public void setActors(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.actors = value;
	}
	
	
	
	/**
	 * 相关演员
	 */
     @WhereSQL(sql="actors=:Movie_actors")
	public java.lang.String getActors() {
		return this.actors;
	}
		/**
		 * 电影类型
		 */
	public void setTypes(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.types = value;
	}
	
	
	
	/**
	 * 电影类型
	 */
     @WhereSQL(sql="types=:Movie_types")
	public java.lang.String getTypes() {
		return this.types;
	}
		/**
		 * '电影状态，1-正常，2-下架，3-删除'
		 */
	public void setStatus(Integer value) {
		this.status = value;
	}
	
	
	
	/**
	 * '电影状态，1-正常，2-下架，3-删除'
	 */
     @WhereSQL(sql="status=:Movie_status")
	public Integer getStatus() {
		return this.status;
	}
		/**
		 * 国家
		 */
	public void setOriginPlace(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.originPlace = value;
	}
	
	
	
	/**
	 * 国家
	 */
     @WhereSQL(sql="originPlace=:Movie_originPlace")
	public java.lang.String getOriginPlace() {
		return this.originPlace;
	}
		/**
		 * 上映时间
		 */
	public void setReleaseDate(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.releaseDate = value;
	}
	
	
	
	/**
	 * 上映时间
	 */
     @WhereSQL(sql="releaseDate=:Movie_releaseDate")
	public java.lang.String getReleaseDate() {
		return this.releaseDate;
	}
		/**
		 * 语言
		 */
	public void setLanguages(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.languages = value;
	}
	
	
	
	/**
	 * 语言
	 */
     @WhereSQL(sql="languages=:Movie_languages")
	public java.lang.String getLanguages() {
		return this.languages;
	}
		/**
		 * 时长
		 */
	public void setRuntime(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.runtime = value;
	}
	
	
	
	/**
	 * 时长
	 */
     @WhereSQL(sql="runtime=:Movie_runtime")
	public java.lang.String getRuntime() {
		return this.runtime;
	}
		/**
		 * 又名
		 */
	public void setAnotherNames(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.anotherNames = value;
	}
	
	
	
	/**
	 * 又名
	 */
     @WhereSQL(sql="anotherNames=:Movie_anotherNames")
	public java.lang.String getAnotherNames() {
		return this.anotherNames;
	}
		/**
		 * 优酷的电影链接
		 */
	public void setYoukuLink(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.youkuLink = value;
	}
	
	
	
	/**
	 * 优酷的电影链接
	 */
     @WhereSQL(sql="youkuLink=:Movie_youkuLink")
	public java.lang.String getYoukuLink() {
		return this.youkuLink;
	}
		/**
		 * 迅雷下载链接
		 */
	public void setXunleiDownloadLinks(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.xunleiDownloadLinks = value;
	}
	
	
	
	/**
	 * 迅雷下载链接
	 */
     @WhereSQL(sql="xunleiDownloadLinks=:Movie_xunleiDownloadLinks")
	public java.lang.String getXunleiDownloadLinks() {
		return this.xunleiDownloadLinks;
	}
		/**
		 * 电影封面链接
		 */
	public void setCoverLink(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.coverLink = value;
	}
	
	
	
	/**
	 * 电影封面链接
	 */
     @WhereSQL(sql="coverLink=:Movie_coverLink")
	public java.lang.String getCoverLink() {
		return this.coverLink;
	}
		/**
		 * 剧情概要
		 */
	public void setSynopsis(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.synopsis = value;
	}
	
	
	
	/**
	 * 剧情概要
	 */
     @WhereSQL(sql="synopsis=:Movie_synopsis")
	public java.lang.String getSynopsis() {
		return this.synopsis;
	}
		/**
		 * 获奖
		 */
	public void setAwards(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.awards = value;
	}
	
	
	
	/**
	 * 获奖
	 */
     @WhereSQL(sql="awards=:Movie_awards")
	public java.lang.String getAwards() {
		return this.awards;
	}
		/**
		 * 喜欢这部电影的人同样喜欢的电影
		 */
	public void setAlsoLikeMovies(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.alsoLikeMovies = value;
	}
	
	
	
	/**
	 * 喜欢这部电影的人同样喜欢的电影
	 */
     @WhereSQL(sql="alsoLikeMovies=:Movie_alsoLikeMovies")
	public java.lang.String getAlsoLikeMovies() {
		return this.alsoLikeMovies;
	}
     
     public void setAddTime(java.util.Date value) {
 		this.addTime = value;
 	}
 	
      @WhereSQL(sql="addTime=:Movie_addTime")
 	public java.util.Date getAddTime() {
 		return this.addTime;
 	}
 	public void setViewCount(java.lang.Long value) {
 		this.viewCount = value;
 	}
 	
      @WhereSQL(sql="viewCount=:Movie_viewCount")
 	public java.lang.Long getViewCount() {
 		return this.viewCount;
 	}
	@Override
	public String toString() {
		return new StringBuilder()
			.append("电影ID[").append(getId()).append("],")
				.append("豆瓣电影ID[").append(getDoubanId()).append("],")
			.append("电影名[").append(getName()).append("],")
			.append("豆瓣评分[").append(getDoubanRating()).append("],")
			.append("IMDb评分[").append(getImdbRating()).append("],")
			.append("电影发行年份[").append(getReleaseYear()).append("],")
			.append("电影导演[").append(getDirectors()).append("],")
			.append("编剧[").append(getScreenwriters()).append("],")
			.append("相关演员[").append(getActors()).append("],")
			.append("电影类型[").append(getTypes()).append("],")
			.append("'电影状态，1-正常，2-下架，3-删除'[").append(getStatus()).append("],")
			.append("国家[").append(getOriginPlace()).append("],")
			.append("上映时间[").append(getReleaseDate()).append("],")
			.append("语言[").append(getLanguages()).append("],")
			.append("时长[").append(getRuntime()).append("],")
			.append("又名[").append(getAnotherNames()).append("],")
			.append("优酷的电影链接[").append(getYoukuLink()).append("],")
			.append("迅雷下载链接[").append(getXunleiDownloadLinks()).append("],")
			.append("电影封面链接[").append(getCoverLink()).append("],")
			.append("剧情概要[").append(getSynopsis()).append("],")
			.append("获奖[").append(getAwards()).append("],")
			.append("喜欢这部电影的人同样喜欢的电影[").append(getAlsoLikeMovies()).append("],")
			.append("添加时间[").append(getAddTime()).append("],")
			.append("观看次数[").append(getViewCount()).append("],")
			.toString();
	}
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Movie == false){
			return false;
		}
			
		if(this == obj){
			return true;
		}
		
		Movie other = (Movie)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

	
