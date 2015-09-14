package com.ceprei.qualityqrcode.entity;



public class ScanHistory implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2883839946230998398L;
	private Integer id;
	private Integer compId;
	private MainInfo mainInfo;
	private String batchNum;
	private String prodDate;
	private String type;
	private String photo;

	// Constructors

	/** default constructor */
	public ScanHistory() {
	}

	/** minimal constructor */
	public ScanHistory(Integer id) {
		this.id = id;
	}
	
	public ScanHistory(Integer compId,String batchNum,String prodDate) {
		this.compId = compId;
		this.batchNum = batchNum;
		this.prodDate = prodDate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
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

	public String getProdDate() {
		return this.prodDate;
	}

	public void setProdDate(String prodDate) {
		this.prodDate = prodDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}