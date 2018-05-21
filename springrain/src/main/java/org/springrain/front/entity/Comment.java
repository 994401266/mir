package org.springrain.front.entity;

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
 * @version  2018-05-21 13:50:25
 * @see org.springrain.front.entity.Comment
 */
@Table(name="m_comment")
public class Comment  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "电影评论";
	public static final String ALIAS_ID = "自增ID";
	public static final String ALIAS_USERID = "用户ID";
	public static final String ALIAS_MOVIEID = "电影ID";
	public static final String ALIAS_CONTENT = "内容";
	public static final String ALIAS_CREATED = "评论时间";
    */
	//date formats
	//public static final String FORMAT_CREATED = DateUtils.DATETIME_FORMAT;
	
	//columns START
	/**
	 * 自增ID
	 */
	private java.lang.Integer id;
	/**
	 * 用户ID
	 */
	private java.lang.String userId;
	/**
	 * 电影ID
	 */
	private java.lang.String movieId;
	/**
	 * 内容
	 */
	private java.lang.String content;
	/**
	 * 评论时间
	 */
	private java.util.Date created;
	//columns END 数据库字段结束
	
	private java.lang.String userName;
	//concstructor

	public Comment(){
	}

	public Comment(
		java.lang.Integer id
	){
		this.id = id;
	}

	@Transient
	public java.lang.String getUserName() {
		return userName;
	}

	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	// get and set
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
     @WhereSQL(sql="id=:Comment_id")
	public java.lang.Integer getId() {
		return this.id;
	}
		/**
		 * 用户ID
		 */
	public void setUserId(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.userId = value;
	}
	
	
	
	/**
	 * 用户ID
	 */
     @WhereSQL(sql="userId=:Comment_userId")
	public java.lang.String getUserId() {
		return this.userId;
	}
		/**
		 * 电影ID
		 */
	public void setMovieId(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.movieId = value;
	}
	
	
	
	/**
	 * 电影ID
	 */
     @WhereSQL(sql="movieId=:Comment_movieId")
	public java.lang.String getMovieId() {
		return this.movieId;
	}
		/**
		 * 内容
		 */
	public void setContent(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.content = value;
	}
	
	
	
	/**
	 * 内容
	 */
     @WhereSQL(sql="content=:Comment_content")
	public java.lang.String getContent() {
		return this.content;
	}
		/*
	public String getcreatedString() {
		return DateUtils.convertDate2String(FORMAT_CREATED, getcreated());
	}
	public void setcreatedString(String value) throws ParseException{
		setcreated(DateUtils.convertString2Date(FORMAT_CREATED,value));
	}*/
	
		/**
		 * 评论时间
		 */
	public void setCreated(java.util.Date value) {
		this.created = value;
	}
	
	
	
	/**
	 * 评论时间
	 */
     @WhereSQL(sql="created=:Comment_created")
	public java.util.Date getCreated() {
		return this.created;
	}
	@Override
	public String toString() {
		return new StringBuilder()
			.append("自增ID[").append(getId()).append("],")
			.append("用户ID[").append(getUserId()).append("],")
			.append("电影ID[").append(getMovieId()).append("],")
			.append("内容[").append(getContent()).append("],")
			.append("评论时间[").append(getCreated()).append("],")
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
		if(obj instanceof Comment == false){
			return false;
		}
			
		if(this == obj){
			return true;
		}
		
		Comment other = (Comment)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

	
