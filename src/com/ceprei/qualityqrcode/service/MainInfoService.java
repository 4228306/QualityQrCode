package com.ceprei.qualityqrcode.service;

import java.util.ArrayList;
import java.util.List;

import com.ceprei.qualityqrcode.dbhelper.DataBaseHelper;
import com.ceprei.qualityqrcode.entity.CodeCompany;
import com.ceprei.qualityqrcode.entity.MainInfo;
import com.ceprei.qualityqrcode.entity.MaterialBatch;
import com.ceprei.qualityqrcode.entity.ProdParams;
import com.ceprei.qualityqrcode.entity.ProdProcessYield;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MainInfoService {
	private DataBaseHelper dbHelper;
	public MainInfoService(Context context){
		dbHelper=new DataBaseHelper(context);
	}
	

	public MainInfo getPropduct(int compId,String batchNum,String prodDate){
		MainInfo data = null;
		try{
			dbHelper.createDataBase();
			SQLiteDatabase sdb=dbHelper.getReadableDatabase();
			String sql="select ClassCode,Name,Standard,Type,CompanyID,ProdLine,ManufactureQG,Params,photo,ShapeChart,MaterialReport," +
					"FilterCondition,FilterReport,QualityFeature,FinalizingDate,InspectionOrg,InspectionID,InspectionReport,TechChange," +
					"FailureFrequency,QualityIssues,QulityReport,IssueRelevance,Caution,AppGuide,TotalOrder,Supply3Y,UserNum,AppEnvironment " +
					"from Main_Info where CompID=? and exists(select 1 from Prod_ProcessYield where CompID=Main_Info.CompID and BatchNum=? and ProdDate=?)";
			Cursor cursor=sdb.rawQuery(sql, new String[]{String.valueOf(compId),batchNum,prodDate});		
			if(cursor.moveToNext()) {  
				data = new MainInfo();
				data.setCompId(compId);
				data.setClassCode(cursor.getString(cursor.getColumnIndex("ClassCode")));
				data.setName(cursor.getString(cursor.getColumnIndex("Name")));
				data.setStandard(cursor.getString(cursor.getColumnIndex("Standard")));
				data.setType(cursor.getString(cursor.getColumnIndex("Type")));
				data.setCompanyId(cursor.getString(cursor.getColumnIndex("CompanyID")));
				data.setProdLine(cursor.getString(cursor.getColumnIndex("ProdLine")));
				data.setManufactureQg(cursor.getString(cursor.getColumnIndex("ManufactureQG")));
				data.setParams(cursor.getString(cursor.getColumnIndex("Params")));
				data.setPhoto(cursor.getString(cursor.getColumnIndex("photo")));
				data.setShapeChart(cursor.getString(cursor.getColumnIndex("ShapeChart")));
				data.setMaterialReport(cursor.getString(cursor.getColumnIndex("MaterialReport")));
				
				data.setFilterCondition(cursor.getString(cursor.getColumnIndex("FilterCondition")));
				data.setFilterReport(cursor.getString(cursor.getColumnIndex("FilterReport")));
				data.setQualityFeature(cursor.getString(cursor.getColumnIndex("QualityFeature")));
				data.setFinalizingDate(cursor.getString(cursor.getColumnIndex("FinalizingDate")));
				data.setInspectionOrg(cursor.getString(cursor.getColumnIndex("InspectionOrg")));
				data.setInspectionId(cursor.getString(cursor.getColumnIndex("InspectionID")));
				data.setInspectionReport(cursor.getString(cursor.getColumnIndex("InspectionReport")));
				data.setTechChange(cursor.getString(cursor.getColumnIndex("TechChange")));
				
				data.setFailureFrequency(cursor.getString(cursor.getColumnIndex("FailureFrequency")));
				data.setQualityIssues(cursor.getString(cursor.getColumnIndex("QualityIssues")));
				data.setQulityReport(cursor.getString(cursor.getColumnIndex("QulityReport")));
				data.setIssueRelevance(cursor.getString(cursor.getColumnIndex("IssueRelevance")));
				data.setCaution(cursor.getString(cursor.getColumnIndex("Caution")));
				data.setAppGuide(cursor.getString(cursor.getColumnIndex("AppGuide")));
				data.setTotalOrder(cursor.getString(cursor.getColumnIndex("TotalOrder")));
				data.setSupply3y(cursor.getString(cursor.getColumnIndex("Supply3Y")));
				data.setUserNum(cursor.getString(cursor.getColumnIndex("UserNum")));
				data.setAppEnvironment(cursor.getString(cursor.getColumnIndex("AppEnvironment")));
				data.setCompany(getCompany(sdb,data.getCompanyId()));
				data.setMaterialBatchs(getMaterialBatchs(sdb,compId));
				data.setProdProcessYields(getProdProcessYields(sdb,compId));
				data.setProdParamses(getProdParams(sdb,compId));
 
	        }  
		}catch(Exception e){e.printStackTrace();}
		return data;
	}
	
	private CodeCompany getCompany(SQLiteDatabase sdb,String code){
		if(code==null || code.equals("")){return null;}
		CodeCompany data = null;
		try{
			String sql="select ItemEasy,NetAddress,TechPhone,BuyPhone from Code_Company where code=?";
			Cursor cursor=sdb.rawQuery(sql, new String[]{code});		
			if(cursor.moveToNext()) {  
				data = new CodeCompany();
				data.setCode(code);
				data.setItemEasy(cursor.getString(cursor.getColumnIndex("ItemEasy")));
				data.setNetAddress(cursor.getString(cursor.getColumnIndex("NetAddress")));
				data.setTechPhone(cursor.getString(cursor.getColumnIndex("TechPhone")));
				data.setBuyPhone(cursor.getString(cursor.getColumnIndex("BuyPhone"))); 
	        }  
		}catch(Exception e){e.printStackTrace();}
		return data;
	}
	
	private List<MaterialBatch> getMaterialBatchs(SQLiteDatabase sdb,int compId){
		List<MaterialBatch> list = new ArrayList<MaterialBatch>();
		try{
			String sql="select ID,BatchNum,Material,Type,Company,PiNum from MaterialBatch where CompID=?";
			Cursor cursor=sdb.rawQuery(sql, new String[]{String.valueOf(compId)});		
			while(cursor.moveToNext()) {  
				MaterialBatch data = new MaterialBatch();
				data.setId(cursor.getInt(cursor.getColumnIndex("ID")));
				data.setBatchNum(cursor.getString(cursor.getColumnIndex("BatchNum")));
				data.setMaterial(cursor.getString(cursor.getColumnIndex("Material")));
				data.setType(cursor.getString(cursor.getColumnIndex("Type")));
				data.setCompany(cursor.getString(cursor.getColumnIndex("Company"))); 
				data.setPiNum(cursor.getString(cursor.getColumnIndex("PiNum"))); 
				list.add(data);
	        }  
		}catch(Exception e){e.printStackTrace();}
		return list;
	}
	
	private List<ProdProcessYield> getProdProcessYields(SQLiteDatabase sdb,int compId){
		List<ProdProcessYield> list = new ArrayList<ProdProcessYield>();
		try{
			String sql="select ID,BatchNum,ProcessName,Yield,ProdDate from Prod_ProcessYield where CompID=?";
			Cursor cursor=sdb.rawQuery(sql, new String[]{String.valueOf(compId)});		
			while(cursor.moveToNext()) {  
				ProdProcessYield data = new ProdProcessYield();
				data.setId(cursor.getInt(cursor.getColumnIndex("ID")));
				data.setBatchNum(cursor.getString(cursor.getColumnIndex("BatchNum")));
				data.setProcessName(cursor.getString(cursor.getColumnIndex("ProcessName")));
				data.setYield(cursor.getString(cursor.getColumnIndex("Yield")));
				data.setProdDate(cursor.getString(cursor.getColumnIndex("ProdDate"))); 
				list.add(data);
	        }  
		}catch(Exception e){e.printStackTrace();}
		return list;
	}
	
	private List<ProdParams> getProdParams(SQLiteDatabase sdb,int compId){
		List<ProdParams> list = new ArrayList<ProdParams>();
		try{
			String sql="select ID,BatchNum,Param,Average,StdDeviation from Prod_Params where CompID=?";
			Cursor cursor=sdb.rawQuery(sql, new String[]{String.valueOf(compId)});		
			while(cursor.moveToNext()) {  
				ProdParams data = new ProdParams();
				data.setId(cursor.getInt(cursor.getColumnIndex("ID")));
				data.setBatchNum(cursor.getString(cursor.getColumnIndex("BatchNum")));
				data.setParam(cursor.getString(cursor.getColumnIndex("Param")));
				data.setAverage(cursor.getString(cursor.getColumnIndex("Average")));
				data.setStdDeviation(cursor.getString(cursor.getColumnIndex("StdDeviation"))); 
				list.add(data);
	        }  
		}catch(Exception e){e.printStackTrace();}
		return list;
	}

	
}
