package com.example.ewelina.spisek;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ewelina on 2017-07-14.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "spisek.db";
    public static final String TABLE_NAME = "song_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "TITLE";
    public static final String COL_3 = "PLACE";
    public static final String COL_4 = "PAGE";
    public static final String COL_5 = "NR";
    public static final String COL_6 = "LYRICS";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT, PLACE TEXT, PAGE INTEGER, NR INTEGER, LYRICS TEXT );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String title, String place, String page, String nr, String lyrics){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, title);
        contentValues.put(COL_3, place);
        contentValues.put(COL_4, page);
        contentValues.put(COL_5, nr);
        contentValues.put(COL_6, lyrics);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1) return false;
        else return true;
    }

    public Cursor viewData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public boolean updateData(String id, String title, String place, String page, String nr, String lyrics) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, title);
        contentValues.put(COL_3, place);
        contentValues.put(COL_4, page);
        contentValues.put(COL_5, nr);
        contentValues.put(COL_6, lyrics);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[] { id });
        return true;
    }

    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] { id });
    }
}
