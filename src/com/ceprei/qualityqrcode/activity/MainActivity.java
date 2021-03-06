package com.ceprei.qualityqrcode.activity;

import com.ceprei.qualityqrcode.R;
import com.ceprei.qualityqrcode.entity.User;
import com.ceprei.qualityqrcode.fragment.CollectionFragment;
import com.ceprei.qualityqrcode.fragment.InformationFragment;
import com.ceprei.qualityqrcode.fragment.LeftMenuFragment;
import com.ceprei.qualityqrcode.fragment.PersonalCenterFragment;
import com.ceprei.qualityqrcode.service.UserService;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends SlidingFragmentActivity implements OnTouchListener{

	private Fragment[] fragments = new Fragment[3];
	private Button[] buttons = new Button[3];
	private ImageButton handSearch,scanSearch;
	private TextView title;
	private FragmentManager fm;
	private FragmentTransaction ft;
	private long exitTime = 0;
	private int position=0;
	private boolean isLogin = false;
	private User user;
	private Bundle bundle;

	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		title = (TextView)findViewById(R.id.head_title);
		ActivityCollector.addActivity(this);
		initUser();
		initFragment();
		initButton();
		initMenu();
		initOnClickListener();
	}
	
	private void initUser() {
		user = new User();
		bundle = getIntent().getExtras();
		if(bundle.containsKey("isLogin")){
			isLogin = bundle.getBoolean("isLogin");
			user.setName(bundle.getString("username"));
			Log.i("Login","isLogin："+String.valueOf(isLogin));
			return;
		}
		SharedPreferences sharedPreferences = getSharedPreferences(LoginActivity.FILE_NAME,Context.MODE_PRIVATE);
		if(sharedPreferences.contains("username")){
			String username = sharedPreferences.getString("username", "");
			String pass = sharedPreferences.getString("password", "");
			user.setName(username);
			user.setPassword(pass);
			boolean isAutoLogin = sharedPreferences.getBoolean("isAutoLogin", true);
			Log.i("Login","isAutoLogin:"+String.valueOf(isLogin));
			if(isAutoLogin){
				UserService uService=new UserService(MainActivity.this);
				isLogin = uService.login(username, pass);
				Log.i("Login","isLogin："+String.valueOf(isLogin));
			}
		}
	}

	private void initFragment() {
		fragments[0] = new InformationFragment();
		fragments[1] = new CollectionFragment();
		fragments[2] = new PersonalCenterFragment();
		fm = getSupportFragmentManager();
		fm.beginTransaction()
			.add(R.id.framelayout_main, fragments[0])
			.add(R.id.framelayout_main, fragments[1])
			.add(R.id.framelayout_main, fragments[2]).commit();
		fm.beginTransaction().hide(fragments[1]).hide(fragments[2]).commit();
	}
	
	private void initButton() {
		buttons[0] = (Button) findViewById(R.id.btnInformation);
		buttons[0].setBackgroundResource(R.color.steelblue);
		buttons[1] = (Button) findViewById(R.id.btnCollection);
		buttons[2] = (Button) findViewById(R.id.btnPersonalCenter);
		handSearch = (ImageButton) findViewById(R.id.hand_search);
		scanSearch = (ImageButton) findViewById(R.id.scan_search);
	}
	private void initMenu()
	{
		Fragment leftMenuFragment = new LeftMenuFragment();
		setBehindContentView(R.layout.left_menu_frame);
		fm.beginTransaction().replace(R.id.id_left_menu_frame, leftMenuFragment).commit();
		SlidingMenu menu = getSlidingMenu();
		menu.setMode(SlidingMenu.LEFT);

		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.shadow);

		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		menu.setFadeDegree(0.35f);

		//menu.setSecondaryShadowDrawable(R.drawable.shadow);
		//menu.setSecondaryMenu(R.layout.right_menu_frame);
		//Fragment rightMenuFragment = new RightMenuFragment();
		//getSupportFragmentManager().beginTransaction()
		//.replace(R.id.id_right_menu_frame, rightMenuFragment).commit();
	}

	public void showLeftMenu(View view)
	{
		if(isLogin){
			Bundle bundle =new Bundle();
			bundle.putString("username", user.getName());
			bundle.putBoolean("isLogin", isLogin);
		}
		getSlidingMenu().showMenu();
		Toast.makeText(MainActivity.this, "左侧按钮", Toast.LENGTH_SHORT).show();
	}

	private void initOnClickListener() {
		for(Button b:buttons)
			b.setOnTouchListener(this);
		handSearch.setOnTouchListener(this);
		scanSearch.setOnTouchListener(this);
	}

	public Fragment getFragment(int id){
		return fragments[id];
	}
	
	private void changeButtonColor(){
		buttons[0].setBackgroundResource(position == 0 ? R.color.steelblue : R.color.peachpuff);
		buttons[1].setBackgroundResource(position == 1 ? R.color.steelblue : R.color.peachpuff);
		buttons[2].setBackgroundResource(position == 2 ? R.color.steelblue : R.color.peachpuff);
	}

	@Override
	public boolean onTouch(View v,MotionEvent event) {
		Intent intent = null;
		AlphaAnimation a = new AlphaAnimation(0.1f,1.0f);
		a.setDuration(600);
		if(event.getAction() == MotionEvent.ACTION_DOWN)
			v.startAnimation(a);
		ft = fm.beginTransaction();
		ft.hide(fragments[0]).hide(fragments[1]).hide(fragments[2]);
		if(event.getAction() == MotionEvent.ACTION_UP){
			switch(v.getId()){
			case R.id.btnInformation:
				position=0;
				title.setText(R.string.information);
				ft.show(fragments[0]).commit();
				break;
			case R.id.btnCollection:
				position=1;
				title.setText(R.string.collection);
				ft.show(fragments[1]).commit();
				break;
			case R.id.btnPersonalCenter:
				position=2;
				title.setText(R.string.personal_center);
				ft.show(fragments[2]).commit();
				break;
			case R.id.hand_search:
				Toast.makeText(this, "手动搜索", Toast.LENGTH_SHORT).show();
				intent = new Intent(MainActivity.this,SearchActivity.class);
				startActivity(intent);
				break;
			case R.id.scan_search:
				Toast.makeText(this, "扫描查询", Toast.LENGTH_SHORT).show();
				intent = new Intent(MainActivity.this,CaptureActivity.class);
				startActivity(intent);
				break;
			case R.id.login_regist:
				if(!isLogin){//没有登陆，跳转登陆
					intent = new Intent(MainActivity.this,LoginActivity.class);
					startActivity(intent);
				}else{//跳转到个人中心
					getSlidingMenu().showContent();
					position=2;
					title.setText(R.string.personal_center);
					ft.show(fragments[2]).commit();
				}
				break;
			case R.id.exit://退出
				position=3;
				onBackPressed();break;
			}
			changeButtonColor();
		}
		return true;
	}

	@Override  
	public void onBackPressed() {
		if ((System.currentTimeMillis() - exitTime) > 2000) {
			// ToastUtil.makeToastInBottom("再按一次退出应用", MainMyselfActivity);
			Toast.makeText(MainActivity.this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
			exitTime = System.currentTimeMillis();
			return;
		}
		Log.v("Exit", "退出应用");
		ActivityCollector.finishAll();
	}

	@Override
	protected void onDestroy(){
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}
	
}
