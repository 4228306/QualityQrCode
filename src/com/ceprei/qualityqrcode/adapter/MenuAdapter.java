package com.ceprei.qualityqrcode.adapter;

import java.util.List;
import java.util.Map;

import com.ceprei.qualityqrcode.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAdapter extends BaseAdapter {
	
	private List<Map<String,Object>> data;
	private LayoutInflater inflater;
	private Context context;
	
	public MenuAdapter(Context context,List<Map<String, Object>> data){
		this.setContext(context);  
        this.data=data;  
        this.inflater=LayoutInflater.from(context); 
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int arg0) {
		return data.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}
	
	public final class Zujian{
		public ImageView imageView;
		public TextView textView;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		Zujian zujian = null;
		if(arg1 == null){
			zujian = new Zujian();
			arg1 = inflater.inflate(R.layout.listview_menu, null);
			zujian.imageView = (ImageView)arg1.findViewById(R.id.menuImage);
			zujian.textView = (TextView)arg1.findViewById(R.id.menuTitle);
			arg1.setTag(zujian);
		}else{
			zujian =(Zujian) arg1.getTag();
		}
		zujian.imageView.setBackgroundResource((Integer)data.get(arg0).get("image"));
		zujian.textView.setText((String)data.get(arg0).get("title"));
		
		return arg1;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

}
