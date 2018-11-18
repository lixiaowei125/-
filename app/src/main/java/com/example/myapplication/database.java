package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class database {
    private List<beiwangluContent> beiwangluList = new ArrayList<>();
    private MyDatabaseHelper dbHelper;

    database() {}

    public void init(Context context) {
        dbHelper = new MyDatabaseHelper(context, "beiwanglu.db", null, 1);
    }

    public void create(Context context) {
        dbHelper = new MyDatabaseHelper(context, "beiwanglu.db", null, 1);
        dbHelper.getWritableDatabase();
    }

    public void save(String content, String date) {
        Date timer=new Date();
        String date_now=timer.toLocaleString();
        if(content!=null&&!"".equals(content)) {
            if (query(date).size() > 0) {
                if (!query(date).equals(content)) {
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    ContentValues value = new ContentValues();
                    value.put("content", content);
                    value.put("date", date_now);
                    db.update("NoteBook", value, "date = ?", new String[]{date + ""});
                }
            } else {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues value = new ContentValues();
                value.put("content", content);
                value.put("date", date_now);
                db.insert("NoteBook", null, value);
            }
        }
    }

    public void delete(String date) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("beiwanglu", "date=?", new String[]{date});
    }

    public void query() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        beiwangluList.clear();
        Cursor cursor = db.query("beiwanglu", null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do {
                beiwangluContent beiwanglucontent = new beiwangluContent();
                beiwanglucontent.set(cursor.getString(cursor.getColumnIndex("content")),
                        cursor.getString(cursor.getColumnIndex("date")));
                beiwangluList.add(beiwanglucontent);
            }
            while(cursor.moveToNext());
        }
        cursor.close();
    }

    public List<beiwangluContent> query(String date) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        beiwangluList.clear();
        Cursor cursor = db.query("beiwanglu", null, "date=?", new String[]{date}, null, null, null);
        if(cursor.moveToFirst()){
            do {
                beiwangluContent beiwanglucontent = new beiwangluContent();
                beiwanglucontent.set(cursor.getString(cursor.getColumnIndex("content")),
                        cursor.getString(cursor.getColumnIndex("date")));
                beiwangluList.add(beiwanglucontent);
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        return beiwangluList;
    }

    public List<beiwangluContent> getList() {
        query();
        return beiwangluList;
    }
}