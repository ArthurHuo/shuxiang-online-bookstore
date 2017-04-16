package com.ORM;

/**
 * Admin 管理员
 */

public class Admin implements java.io.Serializable {

	

	private Integer id;

	private Integer adminType;

	private String adminName;

	private String loginName;

	private String loginPwd;

	// Constructors 构造器

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(Integer adminType, String adminName, String loginName,
			String loginPwd) {
		this.adminType = adminType;
		this.adminName = adminName;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAdminType() {
		return this.adminType;
	}

	public void setAdminType(Integer adminType) {
		this.adminType = adminType;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

}