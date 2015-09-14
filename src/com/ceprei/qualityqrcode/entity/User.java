package com.ceprei.qualityqrcode.entity;


public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1679754867065262799L;
	// Fields

	private Integer userId;
	private String userName;
	private String name;
	private String password;
	private Boolean sex;
	private String email;
	private String phone;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer userId) {
		this.userId = userId;
	}

	/** full constructor */
	public User(Integer userId, String userName, String name, String password,
			Boolean sex, String email, String phone) {
		this.userId = userId;
		this.userName = userName;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getSex() {
		return this.sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}