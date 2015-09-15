package com.ceprei.qualityqrcode.fragment;

import java.util.ArrayList;
import java.util.List;

import com.astuetz.PagerSlidingTabStrip;
import com.ceprei.qualityqrcode.R;
import com.ceprei.qualityqrcode.adapter.SimpleFragmentPagerAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InformationFragment extends Fragment{

	private View view;
	private ViewPager mViewPager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> mFragments = new ArrayList<Fragment>();
	private List<String> titles = new ArrayList<String>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		view = inflater.inflate(R.layout.fragment_information, container, false);
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
		titles.add("绿色印刷");
		titles.add("绿色照明");
		titles.add("建筑材料");
		titles.add("有源音箱");
		/** 
		 * SimpleFragmentPagerAdapter
		 */  
		mAdapter = new SimpleFragmentPagerAdapter(getFragmentManager(),mFragments,titles); 
		mViewPager.setAdapter(mAdapter);
		PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
		tabs.setViewPager(mViewPager);
	}

}
