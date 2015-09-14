package com.ceprei.qualityqrcode.fragment;

import java.util.ArrayList;
import java.util.List;

import com.ceprei.qualityqrcode.R;
import com.ceprei.qualityqrcode.adapter.SimpleFragmentPagerAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InformationFragment extends Fragment {
	
	private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments = new ArrayList<Fragment>();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_information, container, false);
		initViewPager(view);
		return view;
	}
	
	private void initViewPager(View view)  
    {  
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mFragments.add(new GreenPrintingFragment());
        mFragments.add(new GreenLighterFragment());
        mFragments.add(new BuildingMaterialFragment());
        mFragments.add(new ActiveSpeakerFragment());
        /** 
         * SimpleFragmentPagerAdapter
         */  
        mAdapter = new SimpleFragmentPagerAdapter(getFragmentManager(),mFragments); 
        mViewPager.setAdapter(mAdapter);  
    }
}
