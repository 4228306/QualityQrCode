package com.ceprei.qualityqrcode.entity;


public class MaterialBatch implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8985045650275345883L;
	private Integer id;
	private MainInfo mainInfo;
	private String batchNum;
	private String material;
	private String type;
	private String company;
	private String piNum;

	// Constructors

	/** default constructor */
	public MaterialBatch() {
	}

	/** minimal constructor */
	public MaterialBatch(Integer id, String batchNum) {
		this.id = id;
		this.batchNum = batchNum;
	}

	/** full constructor */
	public MaterialBatch(Integer id, MainInfo mainInfo, String batchNum,
			String material, String type, String company, String piNum) {
		this.id = id;
		this.mainInfo = mainInfo;
		this.batchNum = batchNum;
		this.material = material;
		this.type = type;
		this.company = company;
		this.piNum = piNum;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MainInfo getMainInfo() {
		return this.mainInfo;
	}

	public void setMainInfo(MainInfo mainInfo) {
		this.mainInfo = mainInfo;
	}

	public String getBatchNum() {
		return this.batchNum;
	}

	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPiNum() {
		return this.piNum;
	}

	public void setPiNum(String piNum) {
		this.piNum = piNum;
	}

}