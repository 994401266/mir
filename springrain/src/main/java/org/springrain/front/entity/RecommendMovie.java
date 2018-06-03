package org.springrain.front.entity;

import java.util.ArrayList;
import java.util.List;

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
 * @version  2018-06-03 16:54:17
 * @see org.springrain.front.entity.RecommendMovie
 */
@Table(name="m_recommend_movie")
public class RecommendMovie  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "用来测试推荐的表";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_TITLE = "title";
	public static final String ALIAS_TYPES = "types";
    */
	//date formats
	
	//columns START
	/**
	 * id
	 */
	private java.lang.Integer id;
	/**
	 * title
	 */
	private java.lang.String title;
	/**
	 * types
	 */
	private java.lang.String types;
	//columns END 数据库字段结束
	
	//concstructor

	public RecommendMovie(){
	}

	public RecommendMovie(
		java.lang.Integer id
	){
		this.id = id;
	}
	
	
	public String getReleaseYear(){
		if(StringUtils.isNotBlank(this.title)&&this.title.contains("(")){
			return this.title.substring(this.title.lastIndexOf("(")+1,this.title.lastIndexOf(")"));
		}
		return null;
	}
	
	public List<String> getTypeList() {
		if (StringUtils.isNotBlank(this.types)) {
			List<String> typeList = new ArrayList<>();
			if (this.types.contains("|")) {
				String[] split = this.types.split("\\|");
				for (String string : split) {
					typeList.add(string);
				}
			} else {
				typeList.add(types);
			}
			return typeList;
		} else {
			return null;
		}
	}
	//get and set
	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	@Id
     @WhereSQL(sql="id=:RecommendMovie_id")
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setTitle(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.title = value;
	}
	
     @WhereSQL(sql="title=:RecommendMovie_title")
	public java.lang.String getTitle() {
		return this.title;
	}
	public void setTypes(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.types = value;
	}
	
     @WhereSQL(sql="types=:RecommendMovie_types")
	public java.lang.String getTypes() {
		return this.types;
	}
	
	public String toString() {
		return new StringBuffer()
			.append("id[").append(getId()).append("],")
			.append("title[").append(getTitle()).append("],")
			.append("types[").append(getTypes()).append("],")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof RecommendMovie == false) return false;
		if(this == obj) return true;
		RecommendMovie other = (RecommendMovie)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

	
