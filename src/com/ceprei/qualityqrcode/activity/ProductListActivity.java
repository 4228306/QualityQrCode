package com.ceprei.qualityqrcode.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.ceprei.qualityqrcode.R;
import com.ceprei.qualityqrcode.entity.ScanHistory;
import com.ceprei.qualityqrcode.service.ScanHistoryService;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ProductListActivity extends BaseActivity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_product_list);
        //绑定Layout里面的ListView
        ListView list = (ListView) findViewById(R.id.product_list);
        ScanHistoryService shService=new ScanHistoryService(ProductListActivity.this);
		List<ScanHistory> lists = shService.getHistory();
        //生成动态数组，加入数据
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
        if(lists!=null && !lists.isEmpty()){
        	for(ScanHistory data:lists){
        		HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("ItemImage", R.raw.picture1);//图像资源的ID
                map.put("ItemTitle", data.getType());
                map.put("ItemText1", data.getBatchNum());
                map.put("ItemText2", data.getProdDate());
                listItem.add(map);
        	}
        }
        if(listItem==null || listItem.isEmpty()){
        	HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", R.raw.picture1);//图像资源的ID
            map.put("ItemTitle", "暂无历史数据");
            map.put("ItemText1", "");
            map.put("ItemText2", "");
            listItem.add(map);
        }
        //生成适配器的Item和动态数组对应的元素
        SimpleAdapter listItemAdapter = new SimpleAdapter(this,listItem,//数据源 
            R.layout.product_listview,//ListItem的XML实现
            //动态数组与ImageItem对应的子项        
            new String[] {"ItemImage","ItemTitle", "ItemText1", "ItemText2"}, 
            //ImageItem的XML文件里面的一个ImageView,两个TextView ID
            new int[] {R.id.ItemImage,R.id.ItemTitle,R.id.ItemText1,R.id.ItemText2}
        );
      
        //添加并且显示
        list.setAdapter(listItemAdapter);
        
        //添加点击
        list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                    long arg3) {
                //setTitle("点击第"+arg2+"个项目");
            	Intent intent=new Intent(ProductListActivity.this,Product2Activity.class);
        		intent.putExtra("compId", 2400745);
        		intent.putExtra("batchNum", "1202BB04331202");
        		intent.putExtra("prodDate", "2013-08-02");
        		startActivity(intent);
            }
        });
        
      //添加长按点击
        list.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {
            
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
                //menu.setHeaderTitle("长按菜单-ContextMenu");  
               // menu.add(0, 0, 0, "弹出长按菜单0");
               // menu.add(0, 1, 0, "弹出长按菜单1");  
            }

        }); 
    }
    
    //长按菜单响应函数
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        setTitle("点击了长按菜单里面的第"+item.getItemId()+"个项目"); 
        return super.onContextItemSelected(item);
    }
}
