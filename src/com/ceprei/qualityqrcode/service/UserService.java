package com.ceprei.qualityqrcode.service;

import com.ceprei.qualityqrcode.dbhelper.DataBaseHelper;
import com.ceprei.qualityqrcode.entity.User;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserService {
	private DataBaseHelper dbHelper;
	public UserService(Context context){
		dbHelper=new DataBaseHelper(context);
	}
	

	public boolean login(String username,String password){
		try{
			dbHelper.createDataBase();
			SQLiteDatabase sdb=dbHelper.getReadableDatabase();
			String sql="select * from User where UserName=? and Password=?";
			Cursor cursor=sdb.rawQuery(sql, new String[]{username,password});		
			if(cursor.moveToFirst()==true){
				cursor.close();
				return true;
			}
		}catch(Exception e){}
		return false;
	}

	public boolean register(User user){
		try{
			dbHelper.createDataBase();
			SQLiteDatabase sdb=dbHelper.getReadableDatabase();
			String sql="insert into User(UserName,Password,Name,Sex,Email,Phone) values(?,?,?,?,?,?)";
			Object obj[]={user.getUserName(),user.getPassword(),user.getName(),user.getSex(),user.getEmail(),user.getPhone()};
			sdb.execSQL(sql, obj);
			return true;
		}catch(Exception e){}
		return false;
	}
	
	public boolean existUserName(String username){
		try{
			dbHelper.createDataBase();
			SQLiteDatabase sdb=dbHelper.getReadableDatabase();
			String sql="select * from User where UserName=?";
			Cursor cursor=sdb.rawQuery(sql, new String[]{username});		
			if(cursor.moveToFirst()==true){
				cursor.close();
				return true;
			}
		}catch(Exception e){}
		return false;
	}
	
	public boolean existEmail(String email){
		try{
			dbHelper.createDataBase();
			SQLiteDatabase sdb=dbHelper.getReadableDatabase();
			String sql="select * from User where Email=?";
			Cursor cursor=sdb.rawQuery(sql, new String[]{email});		
			if(cursor.moveToFirst()==true){
				cursor.close();
				return true;
			}
		}catch(Exception e){}
		return false;
	}
	
	public User getUserById(String id){
		return new User();
	}
}
