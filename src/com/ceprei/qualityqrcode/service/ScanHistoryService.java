package com.ceprei.qualityqrcode.service;

import java.util.ArrayList;
import java.util.List;
import com.ceprei.qualityqrcode.dbhelper.DataBaseHelper;
import com.ceprei.qualityqrcode.entity.ScanHistory;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ScanHistoryService {
	private DataBaseHelper dbHelper;
	public ScanHistoryService(Context context){
		dbHelper=new DataBaseHelper(context);
	}
	

	public List<ScanHistory> getHistory(){
		List<ScanHistory> list = new ArrayList<ScanHistory>();
		try{
			dbHelper.createDataBase();
			SQLiteDatabase sdb=dbHelper.getReadableDatabase();
			String sql="select S.CompID,S.BatchNum,S.ProdDate,M.Type,M.photo " +
					"from Scan_History S left join Main_Info M on S.CompID=M.CompID order by S.ID desc";// where exists(select 1 from Prod_ProcessYield where CompID=S.CompID and BatchNum=S.BatchNum and ProdDate=S.ProdDate)";
			Cursor cursor=sdb.rawQuery(sql, null);		
			while(cursor.moveToNext()) {  
				ScanHistory data = new ScanHistory();
				data.setCompId(cursor.getInt(0));
				data.setBatchNum(cursor.getString(1));
				data.setProdDate(cursor.getString(2));
				data.setType(cursor.getString(3));
				data.setPhoto(cursor.getString(4));
				list.add(data);
 
	        }  
		}catch(Exception e){e.printStackTrace();}
		return list;
	}
	
	public void add(ScanHistory data){
		try{
			dbHelper.createDataBase();
			SQLiteDatabase sdb=dbHelper.getReadableDatabase();
			if(!exist(sdb,data)){
				String sql="insert into Scan_History(CompID,BatchNum,ProdDate) values(?,?,?)";
				Object obj[]={data.getCompId(),data.getBatchNum(),data.getProdDate()};
				sdb.execSQL(sql, obj);
			}
		}catch(Exception e){}
	}
	
	public boolean exist(SQLiteDatabase sdb,ScanHistory data){
		try{
			String sql="select * from ScanHistory where CompID=? and BatchNum=? and ProdDate=?";
			Cursor cursor=sdb.rawQuery(sql, new String[]{String.valueOf(data.getCompId()),data.getBatchNum(),data.getProdDate()});		
			if(cursor.moveToFirst()==true){
				cursor.close();
				return true;
			}
		}catch(Exception e){}
		return false;
	}

	
}
