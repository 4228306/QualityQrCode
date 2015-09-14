package com.ceprei.qualityqrcode.entity;



public class ProdProcessYield implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2883839946230998398L;
	private Integer id;
	private MainInfo mainInfo;
	private String batchNum;
	private String processName;
	private String yield;
	private String prodDate;

	// Constructors

	/** default constructor */
	public ProdProcessYield() {
	}

	/** minimal constructor */
	public ProdProcessYield(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public ProdProcessYield(Integer id, MainInfo mainInfo, String batchNum,
			String processName, String yield, String prodDate) {
		this.id = id;
		this.mainInfo = mainInfo;
		this.batchNum = batchNum;
		this.processName = processName;
		this.yield = yield;
		this.prodDate = prodDate;
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

	public String getProcessName() {
		return this.processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getYield() {
		return this.yield;
	}

	public void setYield(String yield) {
		this.yield = yield;
	}

	public String getProdDate() {
		return this.prodDate;
	}

	public void setProdDate(String prodDate) {
		this.prodDate = prodDate;
	}

}