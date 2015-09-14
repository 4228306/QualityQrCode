package com.ceprei.qualityqrcode.activity;

import com.ceprei.qualityqrcode.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class BulletinActivity extends Activity {
	
	//private TextView about_us;

	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);   
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bulletin);
		initViews();
		
	}
	private void initViews() {
		/*about_us = (TextView)findViewById(R.id.about_us);
		about_us.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent=new Intent(BulletinActivity.this,AboutusActivity.class);
				startActivity(intent);
			}
		});*/
	}

}
