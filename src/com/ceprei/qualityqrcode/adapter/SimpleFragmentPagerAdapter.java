package com.ceprei.qualityqrcode.adapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

	private List<Fragment> list = new ArrayList<Fragment>();
	private List<String> titles = new ArrayList<String>();
	
	public SimpleFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
	}
	
	public SimpleFragmentPagerAdapter(FragmentManager fm,List<Fragment> list,List<String> titles){
		super(fm);
		this.list = list;
		this.titles = titles;
	}

	@Override
	public Fragment getItem(int arg0) {
		return list.get(arg0);
	}

	@Override
	public int getCount() {
		return list.size();
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		return titles.get(position);
	}
}
