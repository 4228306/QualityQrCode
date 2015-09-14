package com.ceprei.qualityqrcode.activity;


import java.io.File;
import java.io.InputStream;

import com.ceprei.qualityqrcode.R;
import com.ceprei.qualityqrcode.intent.IntentUtil;
import com.ceprei.qualityqrcode.util.FileUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;


public class ProductFilterActivity extends Activity{
	private final static String RES_RAW = "/res/raw/";
	private final static String BASEPATH = android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "ceprei";
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_product_filter);
        ImageView filterReportView=(ImageView) findViewById(R.id.p_filterReport);
        InputStream is = R.class.getResourceAsStream(RES_RAW + "filter_report1.pdf");
		if(is!=null){
			FileUtils.saveFile(is,BASEPATH+File.separator+"filter_report1.pdf");
			filterReportView.setImageResource(R.drawable.pdf);
		}
        filterReportView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent mIntent = IntentUtil.getPdfFileIntent(BASEPATH+File.separator+"filter_report1.pdf");
				startActivity(mIntent);
			}
		});
    }
    
}
