package com.ceprei.qualityqrcode.activity;


import com.ceprei.qualityqrcode.R;
import android.os.Bundle;
import android.view.Window;



public class ProductCautionActivity extends BaseActivity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_product_caution);
    }
    
}
