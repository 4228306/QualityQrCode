package com.ceprei.qualityqrcode.entity;


public class CodeCompany implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4151564193189920165L;
	// Fields

	private String code;
	private String itemEasy;
	private String netAddress;
	private String techPhone;
	private String buyPhone;

	// Constructors

	/** default constructor */
	public CodeCompany() {
	}

	/** minimal constructor */
	public CodeCompany(String code) {
		this.code = code;
	}

	/** full constructor */
	public CodeCompany(String code, String itemEasy, String netAddress,
			String techPhone, String buyPhone) {
		this.code = code;
		this.itemEasy = itemEasy;
		this.netAddress = netAddress;
		this.techPhone = techPhone;
		this.buyPhone = buyPhone;
	}

	// Property accessors

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getItemEasy() {
		return this.itemEasy;
	}

	public void setItemEasy(String itemEasy) {
		this.itemEasy = itemEasy;
	}

	public String getNetAddress() {
		return this.netAddress;
	}

	public void setNetAddress(String netAddress) {
		this.netAddress = netAddress;
	}

	public String getTechPhone() {
		return this.techPhone;
	}

	public void setTechPhone(String techPhone) {
		this.techPhone = techPhone;
	}

	public String getBuyPhone() {
		return this.buyPhone;
	}

	public void setBuyPhone(String buyPhone) {
		this.buyPhone = buyPhone;
	}

}