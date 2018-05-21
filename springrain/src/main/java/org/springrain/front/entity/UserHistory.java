package org.springrain.front.entity;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springrain.frame.annotation.WhereSQL;
import org.springrain.frame.entity.BaseEntity;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2018-05-21 15:57:06
 * @see org.springrain.front.entity.UserHistory
 */
@Table(name="m_user_history")
public class UserHistory  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "观看历史记录表";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USERID = "用户id";
	public static final String ALIAS_MOVIEID = "电影id";
	public static final String ALIAS_CREATETIME = "添加时间";
	public static final String ALIAS_ACTIVE = "是否有效 1是 0否";
	public static final String ALIAS_BAK1 = "备用1";
	public static final String ALIAS_BAK2 = "备用2";
	public static final String ALIAS_BAK3 = "备用3";
	public static final String ALIAS_BAK4 = "备用4";
	public static final String ALIAS_BAK5 = "备用5";
    */
	//date formats
	//public static final String FORMAT_CREATETIME = DateUtils.DATETIME_FORMAT;
	
	//columns START
	/**
	 * id
	 */
	private java.lang.Long id;
	/**
	 * 用户id
	 */
	private java.lang.String userId;
	/**
	 * 电影id
	 */
	private java.lang.String movieId;
	/**
	 * 添加时间
	 */
	private java.util.Date createTime;
	/**
	 * 是否有效 1是 0否
	 */
	private java.lang.Integer active;
	/**
	 * 备用1
	 */
	private java.lang.String bak1;
	/**
	 * 备用2
	 */
	private java.lang.String bak2;
	/**
	 * 备用3
	 */
	private java.lang.String bak3;
	/**
	 * 备用4
	 */
	private java.lang.String bak4;
	/**
	 * 备用5
	 */
	private java.lang.String bak5;
	//columns END 数据库字段结束
	
	private Date startTime;
	private Date endTime;
	//concstructor

	public UserHistory(){
	}

	public UserHistory(
		java.lang.Long id
	){
		this.id = id;
	}

	@Transient
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Transient
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	// get and set
		/**
		 * id
		 */
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	
	
	/**
	 * id
	 */
	@Id
     @WhereSQL(sql="id=:UserHistory_id")
	public java.lang.Long getId() {
		return this.id;
	}
		/**
		 * 用户id
		 */
	public void setUserId(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.userId = value;
	}
	
	
	
	/**
	 * 用户id
	 */
     @WhereSQL(sql="userId=:UserHistory_userId")
	public java.lang.String getUserId() {
		return this.userId;
	}
		/**
		 * 电影id
		 */
	public void setMovieId(java.lang.String value) {
		this.movieId = value;
	}
	
	
	
	/**
	 * 电影id
	 */
     @WhereSQL(sql="movieId=:UserHistory_movieId")
	public java.lang.String getMovieId() {
		return this.movieId;
	}
		/*
	public String getcreateTimeString() {
		return DateUtils.convertDate2String(FORMAT_CREATETIME, getcreateTime());
	}
	public void setcreateTimeString(String value) throws ParseException{
		setcreateTime(DateUtils.convertString2Date(FORMAT_CREATETIME,value));
	}*/
	
		/**
		 * 添加时间
		 */
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	
	
	/**
	 * 添加时间
	 */
     @WhereSQL(sql="createTime=:UserHistory_createTime")
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
		/**
		 * 是否有效 1是 0否
		 */
	public void setActive(java.lang.Integer value) {
		this.active = value;
	}
	
	
	
	/**
	 * 是否有效 1是 0否
	 */
     @WhereSQL(sql="active=:UserHistory_active")
	public java.lang.Integer getActive() {
		return this.active;
	}
		/**
		 * 备用1
		 */
	public void setBak1(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.bak1 = value;
	}
	
	
	
	/**
	 * 备用1
	 */
     @WhereSQL(sql="bak1=:UserHistory_bak1")
	public java.lang.String getBak1() {
		return this.bak1;
	}
		/**
		 * 备用2
		 */
	public void setBak2(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.bak2 = value;
	}
	
	
	
	/**
	 * 备用2
	 */
     @WhereSQL(sql="bak2=:UserHistory_bak2")
	public java.lang.String getBak2() {
		return this.bak2;
	}
		/**
		 * 备用3
		 */
	public void setBak3(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.bak3 = value;
	}
	
	
	
	/**
	 * 备用3
	 */
     @WhereSQL(sql="bak3=:UserHistory_bak3")
	public java.lang.String getBak3() {
		return this.bak3;
	}
		/**
		 * 备用4
		 */
	public void setBak4(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.bak4 = value;
	}
	
	
	
	/**
	 * 备用4
	 */
     @WhereSQL(sql="bak4=:UserHistory_bak4")
	public java.lang.String getBak4() {
		return this.bak4;
	}
		/**
		 * 备用5
		 */
	public void setBak5(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.bak5 = value;
	}
	
	
	
	/**
	 * 备用5
	 */
     @WhereSQL(sql="bak5=:UserHistory_bak5")
	public java.lang.String getBak5() {
		return this.bak5;
	}
	@Override
	public String toString() {
		return new StringBuilder()
			.append("id[").append(getId()).append("],")
			.append("用户id[").append(getUserId()).append("],")
			.append("电影id[").append(getMovieId()).append("],")
			.append("添加时间[").append(getCreateTime()).append("],")
			.append("是否有效 1是 0否[").append(getActive()).append("],")
			.append("备用1[").append(getBak1()).append("],")
			.append("备用2[").append(getBak2()).append("],")
			.append("备用3[").append(getBak3()).append("],")
			.append("备用4[").append(getBak4()).append("],")
			.append("备用5[").append(getBak5()).append("],")
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
		if(obj instanceof UserHistory == false){
			return false;
		}
			
		if(this == obj){
			return true;
		}
		
		UserHistory other = (UserHistory)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

	
