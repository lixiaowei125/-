package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_beiwanglu = "create table beiwanglu ( "
            + "content text primary key,"
            + "date text)";
    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    //创建数据库
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_beiwanglu);
    }

    //更新数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}