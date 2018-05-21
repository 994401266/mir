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
 * @version  2018-05-21 13:50:11
 * @see org.springrain.front.entity.MovieComment
 */
@Table(name="m_movie_comment")
public class MovieComment  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "电影评论关系表";
	public static final String ALIAS_ID = "自增ID";
	public static final String ALIAS_MOVIEID = "电影ID";
	public static final String ALIAS_COMMENTID = "评论ID";
    */
	//date formats
	
	//columns START
	/**
	 * 自增ID
	 */
	private java.lang.Long id;
	/**
	 * 电影ID
	 */
	private java.lang.String movieId;
	/**
	 * 评论ID
	 */
	private java.lang.String commentId;
	//columns END 数据库字段结束
	
	//concstructor

	public MovieComment(){
	}

	public MovieComment(
		java.lang.Long id
	){
		this.id = id;
	}

	//get and set
		/**
		 * 自增ID
		 */
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	
	
	/**
	 * 自增ID
	 */
	@Id
     @WhereSQL(sql="id=:MovieComment_id")
	public java.lang.Long getId() {
		return this.id;
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
     @WhereSQL(sql="movieId=:MovieComment_movieId")
	public java.lang.String getMovieId() {
		return this.movieId;
	}
		/**
		 * 评论ID
		 */
	public void setCommentId(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.commentId = value;
	}
	
	
	
	/**
	 * 评论ID
	 */
     @WhereSQL(sql="commentId=:MovieComment_commentId")
	public java.lang.String getCommentId() {
		return this.commentId;
	}
	@Override
	public String toString() {
		return new StringBuilder()
			.append("自增ID[").append(getId()).append("],")
			.append("电影ID[").append(getMovieId()).append("],")
			.append("评论ID[").append(getCommentId()).append("],")
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
		if(obj instanceof MovieComment == false){
			return false;
		}
			
		if(this == obj){
			return true;
		}
		
		MovieComment other = (MovieComment)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

	
