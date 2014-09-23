package app.lap.androidsqlite_papang848;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View.OnClickListener;

public class MyDB848 extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "pang";
	private static final String TABLE_MEMBER = "members";

	public MyDB848(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + TABLE_MEMBER
				+ " (MemberID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " Name TEXT(100)," + " Tel TEXT(100));");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBER);
		onCreate(db);

	}
	//Insert
	public long InsertData(String strName, String strTel){
		try{
			SQLiteDatabase db;
			db = getWritableDatabase();
			
			ContentValues values = new ContentValues();
			values.put("Name", strName);
			values.put("Tel", strTel);
			
			long row = db.insert(TABLE_MEMBER, null, values);
			db.close();
			return row;
			
		}catch (Exception e) {
			
			
		}
		return -1;
	}
	//Select All Data
	
	public ArrayList<HashMap<String, String>> SelectAAllData(){
		try{
			ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String,String>>();
			HashMap<String, String> map;
			SQLiteDatabase db;
			db = this.getReadableDatabase();
			
			
			String strSQL = "SELECT * FROM " + TABLE_MEMBER;
			Cursor cursor = db.rawQuery(strSQL, null);
			if(cursor !=null){
				if(cursor.moveToFirst()){
					do{
						map = new HashMap<String, String>();
						map.put("Member", cursor.getString(0));
						map.put("Name", cursor.getString(1));
						map.put("Tel", cursor.getString(2));
						arrayList.add(map);
						
					}while (cursor.moveToNext());
					
				}
			}
			cursor.close();
			db.close();
			return arrayList;
			
			
		} catch (Exception e){
			return null;
		}
		
		
	}
		
}
