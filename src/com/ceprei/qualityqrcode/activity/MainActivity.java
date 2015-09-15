package com.ceprei.qualityqrcode.activity;

import com.ceprei.qualityqrcode.R;
import com.ceprei.qualityqrcode.fragment.CollectionFragment;
import com.ceprei.qualityqrcode.fragment.InformationFragment;
import com.ceprei.qualityqrcode.fragment.LeftMenuFragment;
import com.ceprei.qualityqrcode.fragment.PersonalCenterFragment;
import com.ceprei.qualityqrcode.fragment.RightMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends SlidingFragmentActivity implements OnClickListener{
	
	private Fragment[] fragments = new Fragment[3];
	private TextView title;
	private FragmentManager fm;
	private FragmentTransaction ft; 
    
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);   
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		title = (TextView)findViewById(R.id.head_title);
		initFragment();
		initMenu();
		initOnClickListener();
	}

	private void initFragment() {
		fragments[0] = new InformationFragment();
		fm = getSupportFragmentManager();
		fm.beginTransaction()
		.add(R.id.framelayout_main, fragments[0])
		.commit();
	}

	private void initMenu()
	{
		Fragment leftMenuFragment = new LeftMenuFragment();
		setBehindContentView(R.layout.left_menu_frame);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.id_left_menu_frame, leftMenuFragment).commit();
		SlidingMenu menu = getSlidingMenu();
		menu.setMode(SlidingMenu.LEFT_RIGHT);

		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.shadow);

		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		menu.setFadeDegree(0.35f);
		
		menu.addIgnoredView(findViewById(R.id.framelayout_main).getRootView());

		menu.setSecondaryShadowDrawable(R.drawable.shadow);
		menu.setSecondaryMenu(R.layout.right_menu_frame);
		Fragment rightMenuFragment = new RightMenuFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.id_right_menu_frame, rightMenuFragment).commit();
	}

	public void showLeftMenu(View view)
	{
		getSlidingMenu().showMenu();
		Toast.makeText(MainActivity.this, "左侧按钮", Toast.LENGTH_SHORT).show();
	}
	public void showRightMenu(View view)
	{
		getSlidingMenu().showSecondaryMenu();
		Toast.makeText(MainActivity.this, "右侧按钮", Toast.LENGTH_SHORT).show();
	}
	
	private void initOnClickListener() {
		findViewById(R.id.btnInformation).setOnClickListener(this);
		findViewById(R.id.btnCollection).setOnClickListener(this);
		findViewById(R.id.btnPersonalCenter).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		ft = fm.beginTransaction().hide(fragments[0]);
		if(fragments[1]!=null )
			ft.hide(fragments[1]);
		if(fragments[2]!=null)
			ft.hide(fragments[2]);
		switch(v.getId()){
		case R.id.btnInformation:
			title.setText(R.string.information);
			ft.show(fragments[0]).commit();
			break;
		case R.id.btnCollection:
			if(fragments[1] == null){
				fragments[1]= new CollectionFragment();
				ft.add(R.id.framelayout_main, fragments[1]);
			}
			title.setText(R.string.collection);
			ft.show(fragments[1]).commit();
			break;
		case R.id.btnPersonalCenter:
			if(fragments[2] == null){
				fragments[2]= new PersonalCenterFragment();
				ft.add(R.id.framelayout_main, fragments[2]);
			}
			title.setText(R.string.personal_center);
			ft.show(fragments[2]).commit();
			break;
		}
	}
}
