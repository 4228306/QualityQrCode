package com.ceprei.qualityqrcode.fragment;

import java.util.ArrayList;
import java.util.List;

import com.ceprei.qualityqrcode.R;
import com.ceprei.qualityqrcode.activity.ActivityCollector;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class LeftMenuFragment extends Fragment implements OnClickListener{
	private View mView;
    private ListView mCategories;
	private List<String> mDatas;
    private ListAdapter mAdapter;
    private Button loginRegist;
    private Button exit;
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState)  
    {  
        if (mView == null)  
        {  
            initView(inflater, container);
            initOnClickListener();
        }  
        return mView;  
    }  

	private void initView(LayoutInflater inflater, ViewGroup container)  
    {  
        mView = inflater.inflate(R.layout.fragment_leftmenu, container, false);
        loginRegist = (Button) mView.findViewById(R.id.login_regist);
        exit = (Button) mView.findViewById(R.id.exit);
        mCategories = (ListView) mView.findViewById(R.id.id_listview_categories);
        mDatas = getData();
        mAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, mDatas);  
        mCategories.setAdapter(mAdapter);
        mCategories.setVerticalScrollBarEnabled(false);
    }
	  
    private void initOnClickListener() {
		// TODO Auto-generated method stub
		loginRegist.setOnClickListener(this);
		exit.setOnClickListener(this);
	}
    private List<String> getData(){
        List<String> data = new ArrayList<String>();
        data.add(getString(R.string.declare_company));
        data.add("  "+getString(R.string.green_printing));
        data.add("  "+getString(R.string.green_lighter));
        data.add("  "+getString(R.string.building_material));
        data.add("  "+getString(R.string.active_speaker));
        data.add(getString(R.string.scan_search));
        data.add(getString(R.string.report_complaints));
        data.add(getString(R.string.advice));
        return data;
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.login_regist:break;
		case R.id.exit:
			ActivityCollector.finishAll();
			break;
		}
	}
}
