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
 * @version  2018-05-10 11:40:28
 * @see org.springrain.system.entity.ContentCategory
 */
@Table(name="m_content_category")
public class ContentCategory  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "内容分类";
	public static final String ALIAS_ID = "类目ID";
	public static final String ALIAS_PARENT_ID = "父类目ID=0时，代表的是一级的类目";
	public static final String ALIAS_NAME = "分类名称";
	public static final String ALIAS_STATUS = "状态。可选值:1(正常),2(删除)";
	public static final String ALIAS_SORT_ORDER = "排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数";
	public static final String ALIAS_IS_PARENT = "该类目是否为父类目，1为true，0为false";
	public static final String ALIAS_CREATED = "创建时间";
	public static final String ALIAS_UPDATED = "创建时间";
    */
	//date formats
	//public static final String FORMAT_CREATED = DateUtils.DATETIME_FORMAT;
	//public static final String FORMAT_UPDATED = DateUtils.DATETIME_FORMAT;
	
	//columns START
	/**
	 * 类目ID
	 */
	private java.lang.Long id;
	/**
	 * 父类目ID=0时，代表的是一级的类目
	 */
	private java.lang.Long parent_id;
	/**
	 * 分类名称
	 */
	private java.lang.String name;
	/**
	 * 状态。可选值:1(正常),2(删除)
	 */
	private java.lang.Integer status;
	/**
	 * 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
	 */
	private java.lang.Integer sort_order;
	/**
	 * 该类目是否为父类目，1为true，0为false
	 */
	private java.lang.Boolean is_parent;
	/**
	 * 创建时间
	 */
	private java.util.Date created;
	/**
	 * 创建时间
	 */
	private java.util.Date updated;
	//columns END 数据库字段结束
	
	//concstructor

	public ContentCategory(){
	}

	public ContentCategory(
		java.lang.Long id
	){
		this.id = id;
	}

	//get and set
		/**
		 * 类目ID
		 */
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	
	
	/**
	 * 类目ID
	 */
	@Id
     @WhereSQL(sql="id=:ContentCategory_id")
	public java.lang.Long getId() {
		return this.id;
	}
		/**
		 * 父类目ID=0时，代表的是一级的类目
		 */
	public void setParent_id(java.lang.Long value) {
		this.parent_id = value;
	}
	
	
	
	/**
	 * 父类目ID=0时，代表的是一级的类目
	 */
     @WhereSQL(sql="parent_id=:ContentCategory_parent_id")
	public java.lang.Long getParent_id() {
		return this.parent_id;
	}
		/**
		 * 分类名称
		 */
	public void setName(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.name = value;
	}
	
	
	
	/**
	 * 分类名称
	 */
     @WhereSQL(sql="name=:ContentCategory_name")
	public java.lang.String getName() {
		return this.name;
	}
		/**
		 * 状态。可选值:1(正常),2(删除)
		 */
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	
	
	
	/**
	 * 状态。可选值:1(正常),2(删除)
	 */
     @WhereSQL(sql="status=:ContentCategory_status")
	public java.lang.Integer getStatus() {
		return this.status;
	}
		/**
		 * 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
		 */
	public void setSort_order(java.lang.Integer value) {
		this.sort_order = value;
	}
	
	
	
	/**
	 * 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
	 */
     @WhereSQL(sql="sort_order=:ContentCategory_sort_order")
	public java.lang.Integer getSort_order() {
		return this.sort_order;
	}
		/**
		 * 该类目是否为父类目，1为true，0为false
		 */
	public void setIs_parent(java.lang.Boolean value) {
		this.is_parent = value;
	}
	
	
	
	/**
	 * 该类目是否为父类目，1为true，0为false
	 */
     @WhereSQL(sql="is_parent=:ContentCategory_is_parent")
	public java.lang.Boolean getIs_parent() {
		return this.is_parent;
	}
		/*
	public String getcreatedString() {
		return DateUtils.convertDate2String(FORMAT_CREATED, getcreated());
	}
	public void setcreatedString(String value) throws ParseException{
		setcreated(DateUtils.convertString2Date(FORMAT_CREATED,value));
	}*/
	
		/**
		 * 创建时间
		 */
	public void setCreated(java.util.Date value) {
		this.created = value;
	}
	
	
	
	/**
	 * 创建时间
	 */
     @WhereSQL(sql="created=:ContentCategory_created")
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
		 * 创建时间
		 */
	public void setUpdated(java.util.Date value) {
		this.updated = value;
	}
	
	
	
	/**
	 * 创建时间
	 */
     @WhereSQL(sql="updated=:ContentCategory_updated")
	public java.util.Date getUpdated() {
		return this.updated;
	}
	@Override
	public String toString() {
		return new StringBuilder()
			.append("类目ID[").append(getId()).append("],")
			.append("父类目ID=0时，代表的是一级的类目[").append(getParent_id()).append("],")
			.append("分类名称[").append(getName()).append("],")
			.append("状态。可选值:1(正常),2(删除)[").append(getStatus()).append("],")
			.append("排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数[").append(getSort_order()).append("],")
			.append("该类目是否为父类目，1为true，0为false[").append(getIs_parent()).append("],")
			.append("创建时间[").append(getCreated()).append("],")
			.append("创建时间[").append(getUpdated()).append("],")
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
		if(obj instanceof ContentCategory == false){
			return false;
		}
			
		if(this == obj){
			return true;
		}
		
		ContentCategory other = (ContentCategory)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

	
