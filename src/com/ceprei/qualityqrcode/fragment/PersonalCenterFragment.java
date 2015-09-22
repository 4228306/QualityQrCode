package com.ceprei.qualityqrcode.fragment;

import com.ceprei.qualityqrcode.R;
import com.ceprei.qualityqrcode.activity.LoginActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class PersonalCenterFragment extends Fragment implements OnClickListener{
	
	private View view;
	private TextView myCollection,myReport,myAdvice,myName,modifyPassword,loginOrLogout;
	private boolean isLogin = false;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		if(view == null){
			view = inflater.inflate(R.layout.fragment_personal_center, container, false);
			initView();
		}
		return view;
	}

	private void initView() {
		initTextViews();
		initUser();
		initOnClickListener();
	}


	private void initUser() {
		Bundle bundle = getArguments();
		if(bundle.containsKey("username")){
			myName.setText(bundle.getString("username"));
			loginOrLogout.setText(getString(R.string.logout));
			isLogin = bundle.getBoolean("isLogin");
		}
	}

	private void initTextViews() {
		myName = (TextView) view.findViewById(R.id.my_name);
		myCollection =(TextView) view.findViewById(R.id.my_collection);
		myReport =(TextView) view.findViewById(R.id.my_report);
		myAdvice =(TextView) view.findViewById(R.id.my_advice);
		modifyPassword =(TextView) view.findViewById(R.id.modify_password);
		loginOrLogout =(TextView) view.findViewById(R.id.loginOrLogout);
	}

	private void initOnClickListener() {
		myCollection.setOnClickListener(this);
		myReport.setOnClickListener(this);
		myAdvice.setOnClickListener(this);
		modifyPassword.setOnClickListener(this);
		loginOrLogout.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.my_collection:break;
		case R.id.my_report:break;
		case R.id.my_advice:break;
		case R.id.modify_password:break;
		case R.id.loginOrLogout:
			if(!isLogin){
				Intent intent = new Intent(getActivity(),LoginActivity.class);
				startActivity(intent);
				break;
			}
			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			builder.setTitle("确定注销？");
			builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					isLogin = false;
					loginOrLogout.setText(getString(R.string.login_regist));
					setArguments(null);
				}
			});
			builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					
					
				}
			});
			builder.show();
		}
	}
}
