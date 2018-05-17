package org.springrain.system.common;

public class SystemEnum {

	
	
	public enum Manager {
		员工(0), 主管(1), 虚拟主管(2), 代理主管(3);

		private Integer manager;

		private Manager(Integer manager) {
			this.manager = manager;
		}

		public Integer getManager() {
			return this.manager;
		}
	}

	/**
	 * 字典typekey枚举
	 * 
	 * @copyright {@link www.centforsoft.com}
	 * @author 高永强
	 * @version 2018年5月17日 下午2:50:38
	 * @see org.springrain.system.common.DicDataType
	 *
	 */
	public enum DicDataType {
		电影类型("movieCat"), 地区("area"), 名族("minzu"), 学历("xueli");

		private String typekey;

		private DicDataType(String typekey) {
			this.typekey = typekey;
		}

		public String getTypekey() {
			return this.typekey;
		}
	}

	/**
	 * 部门类型
	 * 
	 * @author wxp_work
	 *
	 */
	public enum OrgType {
		根(0), 区域(1), 省(11),市(12), 区(13), 学校(21), 校区(22), 年级(22), 班级(23), 部门(24);

		private Integer orgType;

		private OrgType(Integer orgType) {
			this.orgType = orgType;
		}

		public Integer getOrgType() {
			return this.orgType;
		}
	}
	/**
	 * 学校类型
	 * 
	 * @author wxp_work
	 *
	 */
	public enum SchoolType {
		个人(0), 机构(1);
		private Integer schoolType;

		private SchoolType(Integer schoolType) {
			this.schoolType = schoolType;
		}

		public Integer getSchoolType() {
			return this.schoolType;
		}
	}
	/**
	 * 用户类型
	 * 
	 * @author wxp_work
	 *
	 */
	public enum UserType {
		后台管理(0), 前台用户(1);
		private Integer type;

		private UserType(Integer type) {
			this.type = type;
		}

		public Integer getType() {
			return this.type;
		}
	}

	/**
	 * 用户角色id
	 * 
	 * @author wxp_work
	 *
	 */
	public enum Role {
		超级管理员("r_10001"), 学生("65c5edeb7a9b4891a254e6a61dc3de05"), 教师("e197188321b64928a9222016aa375244");
		private String roleId;

		private Role(String roleId) {
			this.roleId = roleId;
		}

		public String getRoleId() {
			return this.roleId;
		}
	}
	
	
	/**
	 * 第三方登录
	 * 
	 * @author wxp_work
	 *
	 */
	public enum UserLoginType {
		微信("WEIXIN"), 新浪微博("SINA"), QQ("QQ");
		private String type;

		private UserLoginType(String type) {
			this.type = type;
		}

		public String getType() {
			return this.type;
		}
	}

	/**
	 * 是否可用
	 * 
	 * @author wxp_work
	 *
	 */
	public enum Active {
		可用(1), 不可用(0);
		private Integer active;

		private Active(Integer active) {
			this.active = active;
		}

		public Integer getType() {
			return this.active;
		}
	}

	/**
	 * 图片:pic,音频:music,视频:video,全景:720,目录:dic
	 * 
	 * @author Z.Q
	 *
	 */
	public enum PictureType {
		图片("PIC"), 音频("MUSIC"), 视频("VIDEO"), 目录("DIC"), 全景("720");
		String pictureType;

		private PictureType(String pictureType) {
			this.pictureType = pictureType;
		}

		public String getPictureType() {
			return this.pictureType;
		}
	}

	/**
	 * 注册账号方式
	 * 
	 * @author wxp_work
	 *
	 */
	public enum RegistType {
		下发(0), 手机注册(1), 微信注册(2);
		private Integer type;

		private RegistType(Integer type) {
			this.type = type;
		}

		public Integer getType() {
			return this.type;
		}
	}
}
