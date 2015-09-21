package com.ceprei.qualityqrcode.activity;

import com.ceprei.qualityqrcode.R;
import com.ceprei.qualityqrcode.activity.RegisterActivity;
import com.ceprei.qualityqrcode.service.UserService;

import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
	public static final String FILE_NAME="userInfo";
	private String user,pass;
	private boolean isAutoLogin = false;
	private EditText username,password;
	private Button login,register;
	private CheckBox remember,autoLogin;
	private SharedPreferences sharedPreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		getSharedPreferences();
		setContentView(R.layout.activity_login);
		initViews();
	}
	
	private void getSharedPreferences(){
		sharedPreferences = this.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
		if(sharedPreferences.contains("username")){
			user = sharedPreferences.getString("username", "");
			pass = sharedPreferences.getString("password", "");
			isAutoLogin = sharedPreferences.getBoolean("isAutoLogin", true);
			if(isAutoLogin){
				login();
			}
		}
	}
	
	private void initViews() {
		username=(EditText) findViewById(R.id.userName);
		password=(EditText) findViewById(R.id.password);
		login=(Button) findViewById(R.id.login_btn);
		register=(Button) findViewById(R.id.register_btn);
		remember=(CheckBox) findViewById(R.id.ps_ch);
		autoLogin=(CheckBox) findViewById(R.id.cb_auto);
		
		if(user != null && !user.equals("")){
			username.setText(user);
			password.setText(pass);
			remember.setChecked(true);
		}
		if(isAutoLogin){
			autoLogin.setChecked(true);
			login();
		}
		login.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				login();
			}
		});
		register.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
				startActivity(intent);
			}
		});
		remember.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {			
				if(isChecked){
					saveUserInfo();
				}else{
					removeUserInfo();
				}
			}
		});
		autoLogin.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {	
				if(isChecked){
					saveUserInfo();
				}else{
					removeUserInfo();
				}
			}
		});
	}

	private void login(){
		String name=username.getText().toString();
		String pass=password.getText().toString();
		if(name.trim().equals("")){
			Toast.makeText(LoginActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
			return;
		}
		if(pass.trim().equals("")){
			Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
			return;
		}
		Log.i("TAG",name+"_"+pass);
		UserService uService=new UserService(LoginActivity.this);
		boolean flag = uService.login(name, pass);
		if(flag){
			Log.i("TAG","登陆成功");
			Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
			Intent intent=new Intent(LoginActivity.this,MainActivity.class);
			intent.putExtra("isLogin", true);
			intent.putExtra("username", name);
			startActivity(intent);
			LoginActivity.this.finish();
		}else{
			Log.i("TAG","用户名或密码错误");
			Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
		}
	}
	
	private void saveUserInfo(){
		Editor editor=sharedPreferences.edit();
		editor.putString("username", username.getText().toString());
		editor.putString("password", password.getText().toString());
		if(autoLogin.isChecked())
			editor.putBoolean("isAutoLogin", true);
		else
			editor.putBoolean("isAutoLogin", false);
		editor.commit();
	}
	
	private void removeUserInfo(){
		Editor editor=sharedPreferences.edit();
		editor.putString("username", username.getText().toString());
		editor.putString("password", password.getText().toString());
		editor.putBoolean("isAutoLogin", false);
		editor.commit();
	}
}
