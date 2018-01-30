package com.mycompany.sql;
import android.content.*;
import android.database.sqlite.*;

public class MyHepler extends SQLiteOpenHelper
{
	public MyHepler(Context context,String name,int version){
		super(context,name,null,version);
	}
	@Override
	public void onCreate(SQLiteDatabase p1)
	{
		p1.execSQL("create table if not exists admin(id integer primary key autoincrement,name char(8),salary integer,sex char(2))");
		// TODO: Implement this method
	}

	@Override
	public void onUpgrade(SQLiteDatabase p1, int p2, int p3)
	{
		p1.execSQL("create table student(id integer primary key autoincrement,name char(8),salary integer,sex char(2)),age integer");
		// TODO: Implement this method
	}
}
