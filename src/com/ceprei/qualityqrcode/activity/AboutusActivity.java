package com.ceprei.qualityqrcode.activity;

import com.ceprei.qualityqrcode.R;
import android.os.Bundle;
import android.view.Window;

public class AboutusActivity extends BaseActivity {

	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);   
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_us);
		initViews();
		
	}
	private void initViews() {

	}

}
