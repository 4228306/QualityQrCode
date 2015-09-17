package com.ceprei.qualityqrcode.fragment;

import java.util.ArrayList;
import java.util.List;

import com.ceprei.qualityqrcode.R;
import com.ceprei.qualityqrcode.activity.ActivityCollector;
import com.ceprei.qualityqrcode.activity.LoginActivity;
import com.ceprei.qualityqrcode.entity.User;
import com.ceprei.qualityqrcode.service.UserService;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class LeftMenuFragment extends Fragment implements OnClickListener{
	private View mView;
	private ListView mCategories;
	private List<String> mDatas;
	private ListAdapter mAdapter;
	private Button loginRegist,exit;
	private ImageView loginImage,exitImage;
	private boolean isLogin = false;
	private String userId;
	private User user;

	@Override  
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){  
		if (mView == null){
			initUser();
			initView(inflater, container);
			initOnClickListener();
		}
		return mView;
	}  

	private void initUser() {
		Intent intent = getActivity().getIntent();
		Bundle bundle = intent.getExtras();
		if(bundle == null || !bundle.containsKey("userId"))
			return;
		userId = bundle.getString("userId");
		isLogin = bundle.getBoolean("isLogin");
		if(isLogin){
			UserService userService = new UserService(getActivity());
			user = userService.getUserById(userId);
		}
		user.setName("123");
	}

	private void initView(LayoutInflater inflater, ViewGroup container)  
	{  
		mView = inflater.inflate(R.layout.fragment_leftmenu, container, false);
		loginRegist = (Button) mView.findViewById(R.id.login_regist);
		exit = (Button) mView.findViewById(R.id.exit);
		loginImage = (ImageView)mView.findViewById(R.id.login_image);
		exitImage = (ImageView)mView.findViewById(R.id.exit_image);
		if(isLogin){
			loginRegist.setText(user.getName());
			loginRegist.setClickable(false);
		}

		mCategories = (ListView) mView.findViewById(R.id.id_listview_categories);
		mDatas = getData();
		mAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, mDatas);  
		mCategories.setAdapter(mAdapter);
		mCategories.setVerticalScrollBarEnabled(false);
	}

	private void initOnClickListener() {
		loginImage.setOnClickListener(this);
		exitImage.setOnClickListener(this);
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
		switch(v.getId()){
		case R.id.login_image:
		case R.id.login_regist:
			Intent intent = new Intent(getActivity(),LoginActivity.class);
			startActivity(intent);
			break;
		case R.id.exit_image:
		case R.id.exit:
			ActivityCollector.finishAll();
			break;
		}
	}
}
