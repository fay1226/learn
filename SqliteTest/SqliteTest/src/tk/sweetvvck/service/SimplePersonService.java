package tk.sweetvvck.service;

import java.util.ArrayList;
import java.util.List;

import tk.sweetvvck.doman.Person;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 使用sqliteDatabase提供的api简单实现数据的增删改查，对于那些不熟悉sql语句的人来用比较方便，但没有直接执行sql语句功能强大
 * 
 * @author 程科
 * 
 */
public class SimplePersonService {
	private DbHelper dbHelper;

	public SimplePersonService(Context context) {
		dbHelper = new DbHelper(context);
	}

	/**
	 * 增加记录
	 * 
	 * @param person
	 */
	public void save(Person person) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();// 对于同一个dbHelper对象通过这个方法打开的多个数据对象是同一个

		ContentValues contentValues = new ContentValues();
		contentValues.put("name", person.getName());
		contentValues.put("phone", person.getPhone());
		db.insert("person", null, contentValues);

		/*
		 * db.execSQL("INSERT INTO person(name, phone) VALUES (?, ?)", new
		 * Object[] { person.getName(), person.getPhone() });
		 */
		db.close();// 当应用中只有一处使用数据库时，不关数据库会提高系统系能，因为不用频繁打开数据库
	}

	/**
	 * 删除记录
	 * 
	 * @param id
	 */
	public void delete(int id) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();// 对于同一个dbHelper对象通过这个方法打开的多个数据对象是同一个
		db.delete("person", "personid=?", new String[]{id + ""});/*
		db.execSQL("DELETE FROM person WHERE personid = ? ",
				new Object[] { id });*/
	}

	/**
	 * 更新纪录
	 * 
	 * @param person
	 */
	public void update(Person person) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();// 对于同一个dbHelper对象通过这个方法打开的多个数据对象是同一个
		ContentValues content = new ContentValues();
		content.put("name", person.getName());
		content.put("phone", person.getPhone());
		db.update("person", content, "personid=?", new String[]{person.getId().toString()});
		/*db.execSQL(
				"UPDATE person SET name = ?, phone = ? WHERE personid = ? ",
				new Object[] { person.getName(), person.getPhone(),
						person.getId() });*/
	}

	/**
	 * 通过id查询
	 * 
	 * @param id
	 *            personid
	 * @return 查询得到的对象
	 */
	public Person findById(Integer id) {
		/*
		 * 如果数据库空间还充足，则会调用getWitableDatabase();
		 * 返回的数据库对象可以执行写操作；如果数据库磁盘空间已满，则会返回一个只读的数据库对象
		 */
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.query("person", null, "personid=?", new String[]{id.toString()}, null, null, null);
		/*Cursor cursor = db.rawQuery("SELECT * FROM person WHERE personid = ?",
				new String[] { id.toString() });*/
		Person person = null;
		if (cursor.moveToFirst()) {
			person = new Person();
			person.setId(cursor.getInt(cursor.getColumnIndex("personid")));
			person.setName(cursor.getString(cursor.getColumnIndex("name")));
			person.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
		}

		return person;
	}

	/**
	 * 分页查询
	 * 
	 * @param offset
	 *            跳过多少条记录
	 * @param maxResult
	 *            获取记录数
	 * @return
	 */
	public List<Person> getScrollAll(Integer offset, Integer maxResult) {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.query("person", null, null, null, null, null, "personid ASC", offset + "," + maxResult);
		/*Cursor cursor = db.rawQuery(
				"SELECT * FROM person ORDER BY personid ASC LIMIT ?, ?",
				new String[] { offset.toString(), maxResult.toString() });*/
		Person person = null;
		List<Person> list = new ArrayList<Person>();
		while (cursor.moveToNext()) {
			person = new Person();
			person.setId(cursor.getInt(cursor.getColumnIndex("personid")));
			person.setName(cursor.getString(cursor.getColumnIndex("name")));
			person.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
			list.add(person);
		}
		return list;
	}

	/**
	 * 获取记录总数
	 */
	public long getCount() {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		db.query("person", new String[]{"COUNT(*)"}, null, null, null, null, null);
		Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM person", null);
		cursor.moveToFirst();
		long result = cursor.getLong(0);
		return result;
	}
}
