package com.greenface.scamproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Green Face on 5/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "account.db";
    private static final String TABLE_NAME = "account";
    private static final String ID = "id";
    private static final String EMAIL = "email";
    private static final String USER_NAME = "username";
    private static final String PASSWORD = "password";
    SQLiteDatabase db;
    private static final String TABLE_CRTEATE = "create table account (id integer primary key not null , " +
            "email text not null , username text not null , password text not null);";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CRTEATE);
        this.db = db;
    }

    public void insertAccount(Account a){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from account";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(ID,count);
        values.put(EMAIL,a.getEmail());
        values.put(USER_NAME,a.getUsername());
        values.put(PASSWORD,a.getPassword());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public String searchPass(String uname){
        db = this.getReadableDatabase();
        String query = "select username, password from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String u;
        String p = "not found";
        if(cursor.moveToFirst()){
            do{
                u = cursor.getString(0);
                if(u.equals(uname)){
                    p = cursor.getString(1);
                    break;
                }
            } while(cursor.moveToNext());
        }
        return p;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}

