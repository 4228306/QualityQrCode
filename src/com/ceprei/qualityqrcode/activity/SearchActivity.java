package com.ceprei.qualityqrcode.activity;

import com.ceprei.qualityqrcode.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class SearchActivity extends Activity {
	private LinearLayout btn_search;

	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);   
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		initViews();
		
	}
	private void initViews() {
		btn_search = (LinearLayout)findViewById(R.id.btn_search);
		btn_search.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent=new Intent(SearchActivity.this,ProductListActivity.class);
				startActivity(intent);
			}
		});
	}

}
