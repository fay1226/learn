package com.mycompany.sql;

import android.app.*;
import android.os.*;
import android.database.sqlite.*;
import android.database.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;

public class MainActivity extends Activity 
{
	TextView text;
	EditText name,salary;
	RadioGroup sex;
	RadioButton sexval;
	Button add,delete;
	ImageButton close;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		MyHepler helper=new MyHepler(MainActivity.this,"test",2);
		SQLiteDatabase db=helper.getWritableDatabase();
		setView();
		//insertDB(db);
		deleteDB(db);
		//updateDB(db);
		selectDB(db);
		db.close();
		close();
    }
	//获取组件
	public void setView(){
		text=(TextView) findViewById(R.id.text);
		name=(EditText) findViewById(R.id.name);
		salary=(EditText) findViewById(R.id.salary);
		sex=(RadioGroup) findViewById(R.id.sex);
		add=(Button) findViewById(R.id.add);
		delete=(Button) findViewById(R.id.del);
		close=(ImageButton) findViewById(R.id.close);
	}
	//插入
	public void insertDB(SQLiteDatabase db){
		String uname=name.getText().toString();
		int usalary=Integer.parseInt(salary.getText().toString());
		String usex="男";
		for(int i=0;i<sex.getChildCount();i++){
			sexval=(RadioButton) sex.getChildAt(i);
			if(sexval.isChecked()){
				usex=sexval.getText().toString();
			}
		}
		db.execSQL("insert into admin(name,salary,sex) values("+uname+","+usalary+","+usex+")");
		Toast.makeText(getApplicationContext(),"成功",Toast.LENGTH_SHORT).show();
	}
	
	//删除
	public void deleteDB(SQLiteDatabase db){
		/*delete.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					db.execSQL("delete admin where id>6");
					db.close();
				}
			});*/
		db.execSQL("delete from admin where id>2 and id<5");
	}
	//修改
	public void updateDB(SQLiteDatabase db){
		db.execSQL("update admin set sex='女',name='雯雯' where id>4");
	}
	//查询
	public void selectDB(SQLiteDatabase db){
		Cursor cursor=db.rawQuery("select * from admin",null);
		StringBuffer sb=new StringBuffer();
		String str=null;
		while(cursor.moveToNext()){
			String name=cursor.getString(1);
			int salary=cursor.getInt(cursor.getColumnIndex("salary"));
			String sex=cursor.getString(cursor.getColumnIndex("sex"));
			str=sb.append(name+"，"+salary+"，"+sex+"\n").toString();
		}
		text.setText(str);
		cursor.close();
	}
	public void operationDB(SQLiteDatabase db){
	}
	//关闭
	public void close(){
		close.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					System.exit(0);
				}
			});
	}
}
