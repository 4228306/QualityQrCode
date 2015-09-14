package com.ceprei.qualityqrcode.entity;



public class ProdParams implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5959845212554634885L;
	private Integer id;
	private MainInfo mainInfo;
	private String batchNum;
	private String param;
	private String average;
	private String stdDeviation;

	// Constructors

	/** default constructor */
	public ProdParams() {
	}

	/** minimal constructor */
	public ProdParams(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public ProdParams(Integer id, MainInfo mainInfo, String batchNum,
			String param, String average, String stdDeviation) {
		this.id = id;
		this.mainInfo = mainInfo;
		this.batchNum = batchNum;
		this.param = param;
		this.average = average;
		this.stdDeviation = stdDeviation;
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

	public String getParam() {
		return this.param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getAverage() {
		return this.average;
	}

	public void setAverage(String average) {
		this.average = average;
	}

	public String getStdDeviation() {
		return this.stdDeviation;
	}

	public void setStdDeviation(String stdDeviation) {
		this.stdDeviation = stdDeviation;
	}

}