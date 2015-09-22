package com.ceprei.qualityqrcode.activity;

import com.ceprei.qualityqrcode.R;
import com.ceprei.qualityqrcode.entity.User;
import com.ceprei.qualityqrcode.service.UserService;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class RegisterActivity extends BaseActivity {
	private EditText userName;
	private EditText password;
	private EditText passwordRe;
	private EditText name;
	private RadioGroup sex;	
	private EditText email;
	private EditText phone;
	Button register;
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);   
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		initViews();
		register.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String userName1 = userName.getText().toString().trim();
				String password1 = password.getText().toString().trim();
				String passwordRe1 = passwordRe.getText().toString().trim();
				String name1 = name.getText().toString().trim();
				String email1 = email.getText().toString().trim();
				String phone1 = phone.getText().toString().trim();
				String sex1=((RadioButton)RegisterActivity.this.findViewById(sex.getCheckedRadioButtonId())).getText().toString();
				Log.i("TAG",userName1+"_"+password1+"_"+name1+"_"+sex1);
				if(userName1.equals("")){
					Toast.makeText(RegisterActivity.this, "请输入邮箱", Toast.LENGTH_SHORT).show();
					return;
				}
				if(password1.equals("")){
					Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
					return;
				}
				if(name1.equals("")){
					Toast.makeText(RegisterActivity.this, "请输入姓名", Toast.LENGTH_SHORT).show();
					return;
				}
				if(!password1.equals(passwordRe1)){
					Toast.makeText(RegisterActivity.this, "再次输入密码不一致", Toast.LENGTH_SHORT).show();
					return;
				}
				UserService uService=new UserService(RegisterActivity.this);
				User user=new User();
				user.setUserName(userName1);
				user.setPassword(password1);
				user.setName(name1);
				user.setSex(sex1!=null && sex1.equals(R.string.woman)?false:true);
				user.setEmail(email1);
				user.setPhone(phone1);
				if(uService.existUserName(user.getUserName())){
					Toast.makeText(RegisterActivity.this, "用户已存在", Toast.LENGTH_SHORT).show();
					return;
				}
				if(user.getEmail()!=null && !user.getEmail().equals("") && uService.existUserName(user.getEmail())){
					Toast.makeText(RegisterActivity.this, "邮箱已被注册", Toast.LENGTH_SHORT).show();
					return;
				}
				if(uService.register(user)){
					Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
					RegisterActivity.this.finish();
				}else{
					Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	private void initViews() {
		userName=(EditText) findViewById(R.id.userNameRegister);
		password=(EditText) findViewById(R.id.passwordRegister);
		passwordRe=(EditText) findViewById(R.id.password1Register);
		register=(Button) findViewById(R.id.register_btn1);
	}

}
