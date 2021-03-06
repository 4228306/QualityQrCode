package com.ceprei.qualityqrcode.activity;


import com.ceprei.qualityqrcode.R;
import com.ceprei.qualityqrcode.entity.MainInfo;
import com.ceprei.qualityqrcode.entity.ProdParams;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ProductParamsActivity extends BaseActivity{
	
	private TableLayout tbLayout;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_product_param);
        tbLayout =  (TableLayout) this.findViewById(R.id.params_tb);  
        Intent intent = this.getIntent(); 
        MainInfo mianInfo =(MainInfo)intent.getSerializableExtra("mainInfo");
        if(mianInfo!=null && mianInfo.getProdParamses()!=null && !mianInfo.getProdParamses().isEmpty()){
        	int index = 1;
        	for(ProdParams data:mianInfo.getProdParamses()){
        		addRow(new String[]{String.valueOf(index++),data.getParam(),data.getAverage(),data.getStdDeviation()});
        	}
        }
    }
	
	private void addRow(String[] text)  
    {  
        TableRow tableRow = new TableRow(this); 
        for(int i=0; i<text.length; i++){
        	TextView textView = new TextView(this);  
            textView.setText(text[i]);
            //TableLayout.LayoutParams margin = new TableLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            //margin.setMargins(0, 0, 0, 7); 
            //textView.setLayoutParams(margin);
            textView.setTextSize(14);
            textView.setBackgroundColor(Color.WHITE);
            tableRow.addView(textView);  
        }
        tbLayout.addView(tableRow);  
    }  

}
