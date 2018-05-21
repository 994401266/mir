package org.springrain.front.entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springrain.frame.annotation.WhereSQL;
import org.springrain.frame.entity.BaseEntity;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2018-05-21 13:49:50
 * @see org.springrain.front.entity.UserMovie
 */
@Table(name="m_user_movie")
public class UserMovie  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "用户对电影的评分表";
	public static final String ALIAS_ID = "自增ID";
	public static final String ALIAS_UID = "用户ID";
	public static final String ALIAS_MID = "电影ID";
	public static final String ALIAS_SCORE = "用户对电影的评分，暂时定为1-5";
	public static final String ALIAS_UPDATE_TIME = "更新时间";
    */
	//date formats
	//public static final String FORMAT_UPDATE_TIME = DateUtils.DATETIME_FORMAT;
	
	//columns START
	/**
	 * 自增ID
	 */
	private java.lang.Integer id;
	/**
	 * 用户ID
	 */
	private java.lang.String uid;
	/**
	 * 电影ID
	 */
	private java.lang.Integer mid;
	/**
	 * 用户对电影的评分，暂时定为1-5
	 */
	private java.lang.String score;
	/**
	 * 更新时间
	 */
	private java.util.Date update_time;
	//columns END 数据库字段结束
	
	//concstructor

	public UserMovie(){
	}

	public UserMovie(
		java.lang.Integer id
	){
		this.id = id;
	}

	//get and set
		/**
		 * 自增ID
		 */
	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	
	
	/**
	 * 自增ID
	 */
	@Id
     @WhereSQL(sql="id=:UserMovie_id")
	public java.lang.Integer getId() {
		return this.id;
	}
		/**
		 * 用户ID
		 */
	public void setUid(java.lang.String value) {
		this.uid = value;
	}
	
	
	
	/**
	 * 用户ID
	 */
     @WhereSQL(sql="uid=:UserMovie_uid")
	public java.lang.String getUid() {
		return this.uid;
	}
		/**
		 * 电影ID
		 */
	public void setMid(java.lang.Integer value) {
		this.mid = value;
	}
	
	
	
	/**
	 * 电影ID
	 */
     @WhereSQL(sql="mid=:UserMovie_mid")
	public java.lang.Integer getMid() {
		return this.mid;
	}
		/**
		 * 用户对电影的评分，暂时定为1-5
		 */
	public void setScore(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.score = value;
	}
	
	
	
	/**
	 * 用户对电影的评分，暂时定为1-5
	 */
     @WhereSQL(sql="score=:UserMovie_score")
	public java.lang.String getScore() {
		return this.score;
	}
		/*
	public String getupdate_timeString() {
		return DateUtils.convertDate2String(FORMAT_UPDATE_TIME, getupdate_time());
	}
	public void setupdate_timeString(String value) throws ParseException{
		setupdate_time(DateUtils.convertString2Date(FORMAT_UPDATE_TIME,value));
	}*/
	
		/**
		 * 更新时间
		 */
	public void setUpdate_time(java.util.Date value) {
		this.update_time = value;
	}
	
	
	
	/**
	 * 更新时间
	 */
     @WhereSQL(sql="update_time=:UserMovie_update_time")
	public java.util.Date getUpdate_time() {
		return this.update_time;
	}
	@Override
	public String toString() {
		return new StringBuilder()
			.append("自增ID[").append(getId()).append("],")
			.append("用户ID[").append(getUid()).append("],")
			.append("电影ID[").append(getMid()).append("],")
			.append("用户对电影的评分，暂时定为1-5[").append(getScore()).append("],")
			.append("更新时间[").append(getUpdate_time()).append("],")
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
		if(obj instanceof UserMovie == false){
			return false;
		}
			
		if(this == obj){
			return true;
		}
		
		UserMovie other = (UserMovie)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

	
