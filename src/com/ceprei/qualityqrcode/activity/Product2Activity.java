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
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;


public class Product2Activity extends BaseActivity {
	private final static String BASEPATH = android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "ceprei";
	private final static String RES_RAW = "/res/raw/";
	private final static int MENU_BG_ON = Color.rgb(250,231,153);
	private final static int MENU_BG = Color.rgb(243,242,238);
	
	private ViewFlipper mViewFilpper;
	private float StartX;
    private float StartY;
    private int currentView = 1;
    private LinearLayout menubar;
    private LinearLayout btn1;
    private LinearLayout btn2;
    private LinearLayout btn3;
    private LinearLayout btn4;
    private LinearLayout btn5;
    private LinearLayout btn6;
    private LinearLayout btn7;
    private MainInfo data;
	
	private ImageView photoView;
	private String photoPath;
	private ImageView shapeChartView;
	private String shapeChartPath;
	private ImageView materialReportView;
	private String materialReportPath;
	private ImageView prodProcessView;
	private ImageView prodParamsView;//p_prodParams
	private TextView supplyReportView;//p_supplyReport
	//private TextView materialPisView;
	private TextView cautionView;//p_caution
	private TextView prodLineStaView;//p_prodLineSta
	//private ImageView p3temperture1View;
	private ImageView p3temperture2View;
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);   
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activi);
		mViewFilpper=(ViewFlipper)findViewById(R.id.ViewFlipper);
		initViews();
		int compId = getIntent().getExtras().getInt("compId");
		String batchNum = getIntent().getExtras().getString("batchNum");
		String prodDate = getIntent().getExtras().getString("prodDate");
		MainInfoService mService=new MainInfoService(Product2Activity.this);
		data = mService.getPropduct(compId, batchNum, prodDate);
		if(data!=null){
			((TextView)findViewById(R.id.p_name)).setText(getString(R.string.p_name_value));
			((TextView)findViewById(R.id.p_type)).setText(getString(R.string.p_type_value));
			((TextView)findViewById(R.id.p_specDetial)).setText(getString(R.string.p_specDetial_value));
			((TextView)findViewById(R.id.p_company)).setText(getString(R.string.p_company_value));
			((TextView)findViewById(R.id.p_standard)).setText(getString(R.string.p_standard_value));
			((TextView)findViewById(R.id.p_std)).setText(getString(R.string.p_std_value));
			((TextView)findViewById(R.id.p_stdDetail)).setText(getString(R.string.p_stdDetail_value));
			((TextView)findViewById(R.id.p_reQg)).setText(getString(R.string.p_reQg_value));
			((TextView)findViewById(R.id.p_failQg)).setText(getString(R.string.p_failQg_value));
			((TextView)findViewById(R.id.p_encap)).setText(getString(R.string.p_encap_value));
			((TextView)findViewById(R.id.p_inspectionOrg)).setText(getString(R.string.p_inspectionOrg_value));
			((TextView)findViewById(R.id.p_inspectionTime)).setText(getString(R.string.p_inspectionTime_value));
			((TextView)findViewById(R.id.p_techChangeTimes)).setText(getString(R.string.p_techChangeTimes_value));
			((TextView)findViewById(R.id.p_failNum)).setText(getString(R.string.p_failNum_value));
			
			
			((TextView)findViewById(R.id.p_prodLine)).setText(getString(R.string.p_prodLine_value));			
			((TextView)findViewById(R.id.p_prodDate)).setText(getString(R.string.p_prodDate_value));
			((TextView)findViewById(R.id.p_batchNum)).setText(getString(R.string.p_batchNum_value));
			((TextView)findViewById(R.id.p_manufactureQg)).setText(getString(R.string.p_manufactureQg1_value));
			((TextView)findViewById(R.id.p_manufactureQg1)).setText(getString(R.string.p_manufactureQg1_value));
			((TextView)findViewById(R.id.p_params)).setText(getString(R.string.p_params_value));
			((TextView)findViewById(R.id.p_supply3y)).setText(getString(R.string.p_supply3y_value));//近三年的总供货量
			((TextView)findViewById(R.id.p_supply_f)).setText(getString(R.string.p_supply_f_value));//产品首次定型后的供货量
			((TextView)findViewById(R.id.p_supply_main)).setText(getString(R.string.p_supply_main_value));//主要用户供货量
			((TextView)findViewById(R.id.p_appField)).setText(getString(R.string.p_appField_value));//产品应用领域
			((TextView)findViewById(R.id.p_2filterPass)).setText(getString(R.string.p_2filterPass_value));//二筛平均合格率
			((TextView)findViewById(R.id.p_userFail)).setText(getString(R.string.p_userFail_value));//用户使用过程中的失效次数
			((TextView)findViewById(R.id.p_failMode)).setText(getString(R.string.p_failMode_value));//主要失效模式
			((TextView)findViewById(R.id.p_failReport)).setText(getString(R.string.p_failReport_value));//失效案例和失效分析报告
			((TextView)findViewById(R.id.p_guanbiao)).setText(getString(R.string.p_guanbiao_value));//贯标覆盖情况
			((TextView)findViewById(R.id.p_finalizingDate)).setText(getString(R.string.p_finalizingDate_value));
			((TextView)findViewById(R.id.p_specialIndex)).setText(getString(R.string.p_specialIndex_value));//特殊应用环境适用性指标
			((TextView)findViewById(R.id.p_failRelevance)).setText(getString(R.string.p_failRelevance_value));
			((TextView)findViewById(R.id.p_appMode)).setText(getString(R.string.p_appMode));
			((TextView)findViewById(R.id.p_failure1)).setText(getString(R.string.p_failure1));
			((TextView)findViewById(R.id.p_failure2)).setText(getString(R.string.p_failure2));
			
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
						Bitmap bitmap = BitmapFactory.decodeFile(materialReportPath);
						materialReportView.setImageBitmap(bitmap);
					}
				}catch(Exception e){e.printStackTrace();}
			}
			try{
				InputStream is = R.class.getResourceAsStream(RES_RAW + "process.jpg");
				if(is!=null){
					FileUtils.saveFile(is,BASEPATH+File.separator+"process.jpg");
					Bitmap bitmap = BitmapFactory.decodeFile(BASEPATH+File.separator+"process.jpg");
					prodProcessView.setImageBitmap(bitmap);
				}
			}catch(Exception e){e.printStackTrace();}
			
			try{
				InputStream is = R.class.getResourceAsStream(RES_RAW + "prod_params.jpg");
				if(is!=null){
					FileUtils.saveFile(is,BASEPATH+File.separator+"prod_params.jpg");
					Bitmap bitmap = BitmapFactory.decodeFile(BASEPATH+File.separator+"prod_params.jpg");
					prodParamsView.setImageBitmap(bitmap);
				}
			}catch(Exception e){e.printStackTrace();}
			
			
			try{
				InputStream is = R.class.getResourceAsStream(RES_RAW + "mr.jpg");
				if(is!=null){
					FileUtils.saveFile(is,BASEPATH+File.separator+"mr.jpg");
				}
			}catch(Exception e){e.printStackTrace();}
			
			try{
				InputStream is = R.class.getResourceAsStream(RES_RAW + "renzheng.jpg");
				if(is!=null){
					FileUtils.saveFile(is,BASEPATH+File.separator+"renzheng.jpg");
				}
			}catch(Exception e){e.printStackTrace();}
			
			/*try{
				InputStream is = R.class.getResourceAsStream(RES_RAW + "three_temperture1.jpg");
				if(is!=null){
					FileUtils.saveFile(is,BASEPATH+File.separator+"three_temperture1.jpg");
					Bitmap bitmap = BitmapFactory.decodeFile(BASEPATH+File.separator+"three_temperture1.jpg");
					p3temperture1View.setImageBitmap(bitmap);
				}
			}catch(Exception e){e.printStackTrace();}*/
			
			try{
				InputStream is = R.class.getResourceAsStream(RES_RAW + "three_temperture2.jpg");
				if(is!=null){
					FileUtils.saveFile(is,BASEPATH+File.separator+"three_temperture2.jpg");
					Bitmap bitmap = BitmapFactory.decodeFile(BASEPATH+File.separator+"three_temperture2.jpg");
					p3temperture2View.setImageBitmap(bitmap);
				}
			}catch(Exception e){e.printStackTrace();}
			
		}
	}
	
	private void initViews(){
		menubar = (LinearLayout) findViewById(R.id.class_list);
		btn1 = (LinearLayout) findViewById(R.id.p_view1_btn);
		btn1.setBackgroundColor(MENU_BG_ON);
		btn1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0){
				changeView(1,false);
			}
		});
		
		btn2 = (LinearLayout) findViewById(R.id.p_view2_btn);
		btn2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0){
				changeView(2,false);
			}
		});
		
		btn3 = (LinearLayout) findViewById(R.id.p_view3_btn);
		btn3.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0){
				changeView(3,false);
			}
		});
		
		btn4 = (LinearLayout) findViewById(R.id.p_view4_btn);
		btn4.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0){
				changeView(4,false);
			}
		});
		
		btn5 = (LinearLayout) findViewById(R.id.p_view5_btn);
		btn5.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0){
				changeView(5,false);
			}
		});
		
		btn6 = (LinearLayout) findViewById(R.id.p_view6_btn);
		btn6.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0){
				changeView(6,false);
			}
		});
		
		btn7 = (LinearLayout) findViewById(R.id.p_view7_btn);
		btn7.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0){
				changeView(7,false);
			}
		});
		
		TextView linkView = (TextView) findViewById(R.id.web_link_text);
		CharSequence charSequence = Html.fromHtml("<a HREF=\"" + getString(R.string.p_linkUrl) + "\">" + getString(R.string.p_linkUrl) + "</A>"); 
		linkView.setText(charSequence); 
		linkView.setMovementMethod(LinkMovementMethod.getInstance());
		
		photoView=(ImageView) findViewById(R.id.p_photo);
		photoView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				if(photoPath!=null && !photoPath.equals("")){
					Intent mIntent = IntentUtil.getImageFileIntent(photoPath);
					startActivity(mIntent);
				}
			}
		});
		shapeChartView=(ImageView) findViewById(R.id.p_shapeChart);
		shapeChartView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				if(shapeChartPath!=null && !shapeChartPath.equals("")){
					Intent mIntent = IntentUtil.getImageFileIntent(shapeChartPath);
					startActivity(mIntent);
				}
			}
		});
		/*
		materialPisView=(TextView) findViewById(R.id.p_materialPis);
		materialPisView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
//				Intent intent=new Intent(Product2Activity.this,ProductMaterialActivity.class);
//				Bundle bundle = new Bundle();
//				bundle.putSerializable("mainInfo", data);
//				intent.putExtras(bundle);
//				startActivity(intent);
				Intent mIntent = IntentUtil.getImageFileIntent(BASEPATH+File.separator+"mr.jpg");
				startActivity(mIntent);
			}
		});
		
		materialReportView=(ImageView) findViewById(R.id.p_materialReport);
		materialReportView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				if(materialReportPath!=null && !materialReportPath.equals("")){
					Intent mIntent = IntentUtil.getImageFileIntent(materialReportPath);
					startActivity(mIntent);
				}
			}
		});
		
		prodProcessView=(ImageView) findViewById(R.id.p_prodProcessData);
		prodProcessView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent mIntent = IntentUtil.getImageFileIntent(BASEPATH+File.separator+"process.jpg");
				startActivity(mIntent);
			}
		});
		*/
		prodParamsView=(ImageView) findViewById(R.id.p_prodParams);
		prodParamsView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent mIntent = IntentUtil.getImageFileIntent(BASEPATH+File.separator+"prod_params.jpg");
				startActivity(mIntent);
			}
		});

		supplyReportView=(TextView) findViewById(R.id.p_supplyReport);
		supplyReportView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(Product2Activity.this,ProductFilterActivity.class);
				Bundle bundle = new Bundle();
				bundle.putSerializable("mainInfo", data);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
		
		/*p3temperture1View=(ImageView) findViewById(R.id.p_3temperture1);
		p3temperture1View.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent mIntent = IntentUtil.getImageFileIntent(BASEPATH+File.separator+"three_temperture1.jpg");
				startActivity(mIntent);
			}
		});*/
		
		p3temperture2View=(ImageView) findViewById(R.id.p_3temperture2);
		p3temperture2View.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent mIntent = IntentUtil.getImageFileIntent(BASEPATH+File.separator+"three_temperture2.jpg");
				startActivity(mIntent);
			}
		});
		cautionView=(TextView) findViewById(R.id.p_caution);
		cautionView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(Product2Activity.this,ProductCautionActivity.class);
				Bundle bundle = new Bundle();
				bundle.putSerializable("mainInfo", data);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
		
		prodLineStaView=(TextView) findViewById(R.id.p_prodLineSta);
		prodLineStaView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent mIntent = IntentUtil.getImageFileIntent(BASEPATH+File.separator+"renzheng.jpg");
				startActivity(mIntent);
			}
		});
		
		
		
	}
	
	 @Override
	 public boolean onTouchEvent(MotionEvent event){
	        switch(event.getAction())
	        {
	            case MotionEvent.ACTION_DOWN:
	            	StartX=event.getX();
	            	StartY=event.getY();
	            break;
	            case MotionEvent.ACTION_UP:
	            	if(event.getX()<(StartX-200)){//hide
	            		menubar.setVisibility(View.GONE);
	            	}
	            	if(event.getX()>(StartX+200)){//show
	            		menubar.setVisibility(View.VISIBLE);
	            	}
	                if(event.getY()<(StartY-200) && currentView<7)//向上滑动
	                {
	                	changeView(currentView+1,true);
	                }
	                if(event.getY()>(StartY+200) && currentView>1)//向下滑动
	                {
	                	changeView(currentView-1,true);
	                }
	        }
			return false;
	 }
	 
	 private void changeView(int index,boolean fade){
		 resetMenuBg(index);
		 if(index<currentView){
			 while(currentView>index){
				 if(fade){
					 mViewFilpper.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
	                 mViewFilpper.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
				 }
				 mViewFilpper.showPrevious();
				 currentView--;
			 }
		 }else if(index>currentView){
			 while(currentView<index){
				 if(fade){
					 mViewFilpper.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
	                 mViewFilpper.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
				 }
				 mViewFilpper.showNext();
				 currentView++;
			 }
		 }
	 }
	 
	 private void resetMenuBg(int index){
		 btn1.setBackgroundColor(MENU_BG);
		 btn2.setBackgroundColor(MENU_BG);
		 btn3.setBackgroundColor(MENU_BG);
		 btn4.setBackgroundColor(MENU_BG);
		 btn5.setBackgroundColor(MENU_BG);
		 btn6.setBackgroundColor(MENU_BG);
		 btn7.setBackgroundColor(MENU_BG);
		 switch(index){
		 case 1:btn1.setBackgroundColor(MENU_BG_ON);break;
		 case 2:btn2.setBackgroundColor(MENU_BG_ON);break;
		 case 3:btn3.setBackgroundColor(MENU_BG_ON);break;
		 case 4:btn4.setBackgroundColor(MENU_BG_ON);break;
		 case 5:btn5.setBackgroundColor(MENU_BG_ON);break;
		 case 6:btn6.setBackgroundColor(MENU_BG_ON);break;
		 case 7:btn7.setBackgroundColor(MENU_BG_ON);break;
		 default:break;
		 }
	 }
	 
	 

}
