package org.springrain.system.entity;

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
 * @version  2018-05-10 11:40:08
 * @see org.springrain.system.entity.Content
 */
@Table(name="m_content")
public class Content  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "电影首页内容";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CATEGORY_ID = "内容类目ID";
	public static final String ALIAS_TITLE = "内容标题";
	public static final String ALIAS_SUB_TITLE = "子标题";
	public static final String ALIAS_TITLE_DESC = "标题描述";
	public static final String ALIAS_URL = "链接";
	public static final String ALIAS_PIC = "图片绝对路径";
	public static final String ALIAS_PIC2 = "图片2";
	public static final String ALIAS_CONTENT = "内容";
	public static final String ALIAS_CREATED = "created";
	public static final String ALIAS_UPDATED = "updated";
    */
	//date formats
	//public static final String FORMAT_CREATED = DateUtils.DATETIME_FORMAT;
	//public static final String FORMAT_UPDATED = DateUtils.DATETIME_FORMAT;
	
	//columns START
	/**
	 * id
	 */
	private java.lang.Long id;
	/**
	 * 内容类目ID
	 */
	private java.lang.Long category_id;
	/**
	 * 内容标题
	 */
	private java.lang.String title;
	/**
	 * 子标题
	 */
	private java.lang.String sub_title;
	/**
	 * 标题描述
	 */
	private java.lang.String title_desc;
	/**
	 * 链接
	 */
	private java.lang.String url;
	/**
	 * 图片绝对路径
	 */
	private java.lang.String pic;
	/**
	 * 图片2
	 */
	private java.lang.String pic2;
	/**
	 * 内容
	 */
	private java.lang.String content;
	/**
	 * created
	 */
	private java.util.Date created;
	/**
	 * updated
	 */
	private java.util.Date updated;
	//columns END 数据库字段结束
	
	//concstructor

	public Content(){
	}

	public Content(
		java.lang.Long id
	){
		this.id = id;
	}

	//get and set
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
     @WhereSQL(sql="id=:Content_id")
	public java.lang.Long getId() {
		return this.id;
	}
		/**
		 * 内容类目ID
		 */
	public void setCategory_id(java.lang.Long value) {
		this.category_id = value;
	}
	
	
	
	/**
	 * 内容类目ID
	 */
     @WhereSQL(sql="category_id=:Content_category_id")
	public java.lang.Long getCategory_id() {
		return this.category_id;
	}
		/**
		 * 内容标题
		 */
	public void setTitle(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.title = value;
	}
	
	
	
	/**
	 * 内容标题
	 */
     @WhereSQL(sql="title=:Content_title")
	public java.lang.String getTitle() {
		return this.title;
	}
		/**
		 * 子标题
		 */
	public void setSub_title(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.sub_title = value;
	}
	
	
	
	/**
	 * 子标题
	 */
     @WhereSQL(sql="sub_title=:Content_sub_title")
	public java.lang.String getSub_title() {
		return this.sub_title;
	}
		/**
		 * 标题描述
		 */
	public void setTitle_desc(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.title_desc = value;
	}
	
	
	
	/**
	 * 标题描述
	 */
     @WhereSQL(sql="title_desc=:Content_title_desc")
	public java.lang.String getTitle_desc() {
		return this.title_desc;
	}
		/**
		 * 链接
		 */
	public void setUrl(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.url = value;
	}
	
	
	
	/**
	 * 链接
	 */
     @WhereSQL(sql="url=:Content_url")
	public java.lang.String getUrl() {
		return this.url;
	}
		/**
		 * 图片绝对路径
		 */
	public void setPic(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.pic = value;
	}
	
	
	
	/**
	 * 图片绝对路径
	 */
     @WhereSQL(sql="pic=:Content_pic")
	public java.lang.String getPic() {
		return this.pic;
	}
		/**
		 * 图片2
		 */
	public void setPic2(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.pic2 = value;
	}
	
	
	
	/**
	 * 图片2
	 */
     @WhereSQL(sql="pic2=:Content_pic2")
	public java.lang.String getPic2() {
		return this.pic2;
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
     @WhereSQL(sql="content=:Content_content")
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
		 * created
		 */
	public void setCreated(java.util.Date value) {
		this.created = value;
	}
	
	
	
	/**
	 * created
	 */
     @WhereSQL(sql="created=:Content_created")
	public java.util.Date getCreated() {
		return this.created;
	}
		/*
	public String getupdatedString() {
		return DateUtils.convertDate2String(FORMAT_UPDATED, getupdated());
	}
	public void setupdatedString(String value) throws ParseException{
		setupdated(DateUtils.convertString2Date(FORMAT_UPDATED,value));
	}*/
	
		/**
		 * updated
		 */
	public void setUpdated(java.util.Date value) {
		this.updated = value;
	}
	
	
	
	/**
	 * updated
	 */
     @WhereSQL(sql="updated=:Content_updated")
	public java.util.Date getUpdated() {
		return this.updated;
	}
	@Override
	public String toString() {
		return new StringBuilder()
			.append("id[").append(getId()).append("],")
			.append("内容类目ID[").append(getCategory_id()).append("],")
			.append("内容标题[").append(getTitle()).append("],")
			.append("子标题[").append(getSub_title()).append("],")
			.append("标题描述[").append(getTitle_desc()).append("],")
			.append("链接[").append(getUrl()).append("],")
			.append("图片绝对路径[").append(getPic()).append("],")
			.append("图片2[").append(getPic2()).append("],")
			.append("内容[").append(getContent()).append("],")
			.append("created[").append(getCreated()).append("],")
			.append("updated[").append(getUpdated()).append("],")
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
		if(obj instanceof Content == false){
			return false;
		}
			
		if(this == obj){
			return true;
		}
		
		Content other = (Content)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

	
