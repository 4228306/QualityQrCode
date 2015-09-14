package com.ceprei.qualityqrcode.entity;

import java.util.ArrayList;
import java.util.List;


public class MainInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2415837247653329394L;
	private Integer compId;
	private String classCode;
	private String name;
	private String standard;
	private String type;
	private String companyId;
	private String prodLine;
	private String manufactureQg;
	private String params;
	private String photo;
	private String shapeChart;
	private String materialReport;
	private String filterCondition;
	private String filterReport;
	private String qualityFeature;
	private String finalizingDate;
	private String inspectionOrg;
	private String inspectionId;
	private String inspectionReport;
	private String techChange;
	private String failureFrequency;
	private String qualityIssues;
	private String qulityReport;
	private String issueRelevance;
	private String caution;
	private String appGuide;
	private String totalOrder;
	private String supply3y;
	private String userNum;
	private String appEnvironment;
	private CodeCompany company;
	private List<MaterialBatch> materialBatchs = new ArrayList<MaterialBatch>(0);
	private List<ProdProcessYield> prodProcessYields = new ArrayList<ProdProcessYield>(0);
	private List<ProdParams> prodParamses = new ArrayList<ProdParams>(0);


	// Constructors

	/** default constructor */
	public MainInfo() {
	}

	/** minimal constructor */
	public MainInfo(Integer compId) {
		this.compId = compId;
	}

	// Property accessors

	public Integer getCompId() {
		return this.compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getClassCode() {
		return this.classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStandard() {
		return this.standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getProdLine() {
		return this.prodLine;
	}

	public void setProdLine(String prodLine) {
		this.prodLine = prodLine;
	}

	public String getManufactureQg() {
		return this.manufactureQg;
	}

	public void setManufactureQg(String manufactureQg) {
		this.manufactureQg = manufactureQg;
	}

	public String getParams() {
		return this.params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getShapeChart() {
		return this.shapeChart;
	}

	public void setShapeChart(String shapeChart) {
		this.shapeChart = shapeChart;
	}

	public String getMaterialReport() {
		return this.materialReport;
	}

	public void setMaterialReport(String materialReport) {
		this.materialReport = materialReport;
	}

	public String getFilterCondition() {
		return this.filterCondition;
	}

	public void setFilterCondition(String filterCondition) {
		this.filterCondition = filterCondition;
	}

	public String getFilterReport() {
		return this.filterReport;
	}

	public void setFilterReport(String filterReport) {
		this.filterReport = filterReport;
	}

	public String getQualityFeature() {
		return this.qualityFeature;
	}

	public void setQualityFeature(String qualityFeature) {
		this.qualityFeature = qualityFeature;
	}

	public String getFinalizingDate() {
		return this.finalizingDate;
	}

	public void setFinalizingDate(String finalizingDate) {
		this.finalizingDate = finalizingDate;
	}

	public String getInspectionOrg() {
		return this.inspectionOrg;
	}

	public void setInspectionOrg(String inspectionOrg) {
		this.inspectionOrg = inspectionOrg;
	}

	public String getInspectionId() {
		return this.inspectionId;
	}

	public void setInspectionId(String inspectionId) {
		this.inspectionId = inspectionId;
	}

	public String getInspectionReport() {
		return this.inspectionReport;
	}

	public void setInspectionReport(String inspectionReport) {
		this.inspectionReport = inspectionReport;
	}

	public String getTechChange() {
		return this.techChange;
	}

	public void setTechChange(String techChange) {
		this.techChange = techChange;
	}

	public String getFailureFrequency() {
		return this.failureFrequency;
	}

	public void setFailureFrequency(String failureFrequency) {
		this.failureFrequency = failureFrequency;
	}

	public String getQualityIssues() {
		return this.qualityIssues;
	}

	public void setQualityIssues(String qualityIssues) {
		this.qualityIssues = qualityIssues;
	}

	public String getQulityReport() {
		return this.qulityReport;
	}

	public void setQulityReport(String qulityReport) {
		this.qulityReport = qulityReport;
	}

	public String getIssueRelevance() {
		return this.issueRelevance;
	}

	public void setIssueRelevance(String issueRelevance) {
		this.issueRelevance = issueRelevance;
	}

	public String getCaution() {
		return this.caution;
	}

	public void setCaution(String caution) {
		this.caution = caution;
	}

	public String getAppGuide() {
		return this.appGuide;
	}

	public void setAppGuide(String appGuide) {
		this.appGuide = appGuide;
	}

	public String getTotalOrder() {
		return this.totalOrder;
	}

	public void setTotalOrder(String totalOrder) {
		this.totalOrder = totalOrder;
	}

	public String getSupply3y() {
		return this.supply3y;
	}

	public void setSupply3y(String supply3y) {
		this.supply3y = supply3y;
	}

	public String getUserNum() {
		return this.userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getAppEnvironment() {
		return this.appEnvironment;
	}

	public void setAppEnvironment(String appEnvironment) {
		this.appEnvironment = appEnvironment;
	}

	public CodeCompany getCompany() {
		return company;
	}

	public void setCompany(CodeCompany company) {
		this.company = company;
	}

	public List<MaterialBatch> getMaterialBatchs() {
		return this.materialBatchs;
	}

	public void setMaterialBatchs(List<MaterialBatch> materialBatchs) {
		this.materialBatchs = materialBatchs;
	}

	public List<ProdProcessYield> getProdProcessYields() {
		return this.prodProcessYields;
	}

	public void setProdProcessYields(List<ProdProcessYield> prodProcessYields) {
		this.prodProcessYields = prodProcessYields;
	}

	public List<ProdParams> getProdParamses() {
		return this.prodParamses;
	}

	public void setProdParamses(List<ProdParams> prodParamses) {
		this.prodParamses = prodParamses;
	}
	
	public String getProdDate(){
		String s = "";
		if(prodProcessYields!=null && !prodProcessYields.isEmpty()){
			for(ProdProcessYield data:prodProcessYields){
				if(data.getProdDate()!=null && !data.getProdDate().trim().equals("") && (";"+s+";").indexOf(data.getProdDate())==-1){
					s += ((s.equals("")?"":";") + data.getProdDate());
				}
			}
		}
		return s;
	}
	
	public String getBatchNum(){
		String s = "";
		if(prodProcessYields!=null && !prodProcessYields.isEmpty()){
			for(ProdProcessYield data:prodProcessYields){
				if(data.getBatchNum()!=null && !data.getBatchNum().trim().equals("") && (";"+s+";").indexOf(data.getBatchNum())==-1){
					s += ((s.equals("")?"":";") + data.getBatchNum());
				}
			}
		}
		return s;
	}

	
	

}