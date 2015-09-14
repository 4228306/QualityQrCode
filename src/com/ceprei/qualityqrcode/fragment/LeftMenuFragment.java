package com.ceprei.qualityqrcode.fragment;

import java.util.ArrayList;
import java.util.List;

import com.ceprei.qualityqrcode.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class LeftMenuFragment extends Fragment {
	private View mView;  
    private ListView mCategories;  
	private List<String> mDatas;
    private ListAdapter mAdapter;  
  
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState)  
    {  
        if (mView == null)  
        {  
            initView(inflater, container);  
        }  
        return mView;  
    }  
  
    private void initView(LayoutInflater inflater, ViewGroup container)  
    {  
        mView = inflater.inflate(R.layout.fragment_leftmenu, container, false);
        mCategories = (ListView) mView.findViewById(R.id.id_listview_categories);
        mDatas = getData();
        mAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, mDatas);  
        mCategories.setAdapter(mAdapter);  
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
}
