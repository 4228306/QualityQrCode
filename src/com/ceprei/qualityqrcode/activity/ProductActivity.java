package com.ceprei.qualityqrcode.activity;

import java.io.File;
import java.io.InputStream;
import com.ceprei.qualityqrcode.R;
import com.ceprei.qualityqrcode.entity.MainInfo;
import com.ceprei.qualityqrcode.intent.IntentUtil;
import com.ceprei.qualityqrcode.service.MainInfoService;
import com.ceprei.qualityqrcode.util.FileUtils;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.ImageView;

public class ProductActivity extends BaseActivity {
	private final static String BASEPATH = android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "ceprei";
	private final static String RES_RAW = "/res/raw/";
	private MainInfo data;
	
	private TextView baseInfoView;
	private TableLayout baseInfoTb;
	
	
	private ImageView photoView;
	private String photoPath;
	private ImageView shapeChartView;
	private String shapeChartPath;
	private ImageView materialReportView;
	private String materialReportPath;
	private ImageView filterReportView;
	private String filterReportPath;
	private ImageView inspectReportView;
	private String inspectReportPath;
	private TextView materialPisView;
	private TextView prodParamsView;
	private TextView prodProcessYieldView;
	
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);   
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product1);
		initViews();
		int compId = getIntent().getExtras().getInt("compId");
		String batchNum = getIntent().getExtras().getString("batchNum");
		String prodDate = getIntent().getExtras().getString("prodDate");
		MainInfoService mService=new MainInfoService(ProductActivity.this);
		data = mService.getPropduct(compId, batchNum, prodDate);
		if(data!=null){
			((TextView)findViewById(R.id.p_name)).setText(data.getName());
			((TextView)findViewById(R.id.p_type)).setText(data.getType());
			((TextView)findViewById(R.id.p_company)).setText(data.getCompany()!=null && data.getCompany().getItemEasy()!=null? data.getCompany().getItemEasy():"");
			((TextView)findViewById(R.id.p_standard)).setText(data.getStandard());
			((TextView)findViewById(R.id.p_prodLine)).setText(data.getProdLine());			
			((TextView)findViewById(R.id.p_prodDate)).setText(data.getProdDate());
			((TextView)findViewById(R.id.p_batchNum)).setText(data.getBatchNum());
			((TextView)findViewById(R.id.p_manufactureQg)).setText(data.getManufactureQg());
			((TextView)findViewById(R.id.p_params)).setText(data.getParams());
			((TextView)findViewById(R.id.p_filterCondition)).setText(data.getFilterCondition());
			((TextView)findViewById(R.id.p_qualityFeature)).setText(data.getQualityFeature());
			((TextView)findViewById(R.id.p_finalizingDate)).setText(data.getFinalizingDate());
			((TextView)findViewById(R.id.p_inspectionOrg)).setText(data.getInspectionOrg());
			((TextView)findViewById(R.id.p_inspectionId)).setText(data.getInspectionId());
			((TextView)findViewById(R.id.p_techChange)).setText(data.getTechChange());
			((TextView)findViewById(R.id.p_failureFrequency)).setText(data.getFailureFrequency());
			((TextView)findViewById(R.id.p_qualityIssues)).setText(data.getQualityIssues());
			((TextView)findViewById(R.id.p_qulityReport)).setText(data.getQulityReport());
			((TextView)findViewById(R.id.p_issueRelevance)).setText(data.getIssueRelevance());
			((TextView)findViewById(R.id.p_caution)).setText(data.getCaution());
			((TextView)findViewById(R.id.p_appGuide)).setText(data.getAppGuide());
			((TextView)findViewById(R.id.p_totalOrder)).setText(data.getTotalOrder());
			((TextView)findViewById(R.id.p_supply3y)).setText(data.getSupply3y());
			((TextView)findViewById(R.id.p_userNum)).setText(data.getUserNum());
			((TextView)findViewById(R.id.p_appEnvironment)).setText(data.getAppEnvironment());
			((TextView)findViewById(R.id.p_techPhone)).setText(data.getCompany()!=null && data.getCompany().getTechPhone()!=null?data.getCompany().getTechPhone():"");
			((TextView)findViewById(R.id.p_buyPhone)).setText(data.getCompany()!=null && data.getCompany().getBuyPhone()!=null?data.getCompany().getBuyPhone():"");
			((TextView)findViewById(R.id.p_companySite)).setText(data.getCompany()!=null && data.getCompany().getNetAddress()!=null?data.getCompany().getNetAddress():"");
			
			if(data.getPhoto()!=null && !data.getPhoto().equals("")){
				try{
					InputStream is = R.class.getResourceAsStream(RES_RAW + data.getPhoto());
					if(is!=null){
						photoPath = BASEPATH+File.separator+data.getPhoto();
						FileUtils.saveFile(is,photoPath);
						Bitmap bitmap = BitmapFactory.decodeFile(photoPath);
						photoView.setImageBitmap(bitmap);
					}
				}catch(Exception e){e.printStackTrace();}
			}
			if(data.getShapeChart()!=null && !data.getShapeChart().equals("")){
				try{
					InputStream is = R.class.getResourceAsStream(RES_RAW + data.getShapeChart());
					if(is!=null){
						shapeChartPath = BASEPATH+File.separator+data.getShapeChart();
						FileUtils.saveFile(is,shapeChartPath);
						Bitmap bitmap = BitmapFactory.decodeFile(shapeChartPath);
						shapeChartView.setImageBitmap(bitmap);
					}
				}catch(Exception e){e.printStackTrace();}
			}
			if(data.getMaterialReport()!=null && !data.getMaterialReport().equals("")){
				try{
					InputStream is = R.class.getResourceAsStream(RES_RAW + data.getMaterialReport());
					if(is!=null){
						materialReportPath = BASEPATH+File.separator+data.getMaterialReport();
						FileUtils.saveFile(is,materialReportPath);
						materialReportView.setImageResource(R.drawable.pdf);
					}
				}catch(Exception e){e.printStackTrace();}
			}
			if(data.getFilterReport()!=null && !data.getFilterReport().equals("")){
				try{
					InputStream is = R.class.getResourceAsStream(RES_RAW + data.getFilterReport());
					if(is!=null){
						filterReportPath = BASEPATH+File.separator+data.getFilterReport();
						FileUtils.saveFile(is,filterReportPath);
						filterReportView.setImageResource(R.drawable.pdf);
					}
				}catch(Exception e){e.printStackTrace();}
			}
			if(data.getInspectionReport()!=null && !data.getInspectionReport().equals("")){
				try{
					InputStream is = R.class.getResourceAsStream(RES_RAW + data.getInspectionReport());
					if(is!=null){
						inspectReportPath = BASEPATH+File.separator+data.getInspectionReport();
						FileUtils.saveFile(is,inspectReportPath);
						inspectReportView.setImageResource(R.drawable.pdf);
					}
				}catch(Exception e){e.printStackTrace();}
			}
			//<string name="p_materialPis">主要原材料批号</string>
			//((TextView)findViewById(R.id.p_materialPis)).setText(data);
			//<string name="p_materialName">原材料名称</string>
			//((TextView)findViewById(R.id.p_materialName)).setText(data);
			//<string name="p_materialType">型号规格</string>
			//((TextView)findViewById(R.id.p_materialType)).setText(data);
			//<string name="p_materialCompany">供应厂商</string>
			//((TextView)findViewById(R.id.p_materialCompany)).setText(data);
			//<string name="p_materialPi">批号</string>
			//((TextView)findViewById(R.id.p_materialPi)).setText(data);
			//((TextView)findViewById(R.id.p_prodData)).setText(data);
			//<string name="p_prodParams">批次参数一致性</string>
			//((TextView)findViewById(R.id.p_prodParams)).setText(data);
			//<string name="p_prodParamName">参数</string>
			//((TextView)findViewById(R.id.p_prodParamName)).setText(data);
			//<string name="p_prodParamAverage">均值</string>
			//((TextView)findViewById(R.id.p_prodParamAverage)).setText(data);
			//<string name="p_prodParamStdDeviation">标准差</string>
			//((TextView)findViewById(R.id.p_prodParamStdDeviation)).setText(data);
			//<string name="p_prodProcessYield">关键工序成品率</string>
			//((TextView)findViewById(R.id.p_prodProcessYield)).setText(data);
			//<string name="p_prodProcess">工序名称</string>
			//((TextView)findViewById(R.id.p_prodProcess)).setText(data);
			//<string name="p_prodYield">成品率（%）</string>
			//((TextView)findViewById(R.id.p_prodYield)).setText(data);
			
			//<string name="p_firstFinalizing">首次设计定型</string>
			//((TextView)findViewById(R.id.p_firstFinalizing)).setText(data);
			//<string name="p_finalizingDate">首次定型日期</string>
			//((TextView)findViewById(R.id.p_finalizingDate)).setText(data);
			//<string name="p_inspectionOrg">鉴定检验机构</string>
			//((TextView)findViewById(R.id.p_inspectionOrg)).setText(data);
			//<string name="p_inspectionId">鉴定检验证书号</string>
			//((TextView)findViewById(R.id.p_inspectionId)).setText(data);
			//<string name="p_inspectionReport">鉴定检验报告</string>
			//((TextView)findViewById(R.id.p_inspectionReport)).setText(data);
			//<string name="p_techChange">技术状态更改</string>
			
		}
	}
	
	private void initViews(){
		baseInfoView = (TextView) findViewById(R.id.p_baseInfo_tx);;
		baseInfoTb = (TableLayout) findViewById(R.id.p_baseInfo_tb);;
		
		photoView=(ImageView) findViewById(R.id.p_photo);
		shapeChartView=(ImageView) findViewById(R.id.p_shapeChart);
		materialReportView=(ImageView) findViewById(R.id.p_materialReport);
		filterReportView=(ImageView) findViewById(R.id.p_filterReport);
		inspectReportView=(ImageView) findViewById(R.id.p_inspectReport);
		materialPisView=(TextView) findViewById(R.id.p_materialPis);
		prodParamsView = (TextView) findViewById(R.id.p_prodParams);
		prodProcessYieldView = (TextView) findViewById(R.id.p_prodProcessYield);
		
		baseInfoView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0){
				if(baseInfoView.getText().equals(getResources().getString(R.string.expand))){
					baseInfoTb.setVisibility(View.VISIBLE);
					baseInfoView.setText(R.string.shrink);
				}else{
					baseInfoTb.setVisibility(View.GONE);
					baseInfoView.setText(R.string.expand);
				}
			}
		});
		
		photoView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				if(photoPath!=null && !photoPath.equals("")){
					Intent mIntent = IntentUtil.getImageFileIntent(photoPath);
					startActivity(mIntent);
				}
			}
		});
		shapeChartView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				if(shapeChartPath!=null && !shapeChartPath.equals("")){
					Intent mIntent = IntentUtil.getImageFileIntent(shapeChartPath);
					startActivity(mIntent);
				}
			}
		});
		materialReportView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				if(materialReportPath!=null && !materialReportPath.equals("")){
					Intent mIntent = IntentUtil.getPdfFileIntent(materialReportPath);
					startActivity(mIntent);
				}
			}
		});
		filterReportView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				if(filterReportPath!=null && !filterReportPath.equals("")){
					Intent mIntent = IntentUtil.getPdfFileIntent(filterReportPath);
					startActivity(mIntent);
				}
			}
		});
		inspectReportView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				if(inspectReportPath!=null && !inspectReportPath.equals("")){
					Intent mIntent = IntentUtil.getPdfFileIntent(inspectReportPath);
					startActivity(mIntent);
				}
			}
		});
		materialPisView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(ProductActivity.this,ProductMaterialActivity.class);
				Bundle bundle = new Bundle();
				bundle.putSerializable("mainInfo", data);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
		prodParamsView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(ProductActivity.this,ProductParamsActivity.class);
				Bundle bundle = new Bundle();
				bundle.putSerializable("mainInfo", data);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
		prodProcessYieldView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(ProductActivity.this,ProductProcessActivity.class);
				Bundle bundle = new Bundle();
				bundle.putSerializable("mainInfo", data);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	}


}
