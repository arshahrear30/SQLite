package com.smaka.sqlightdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public final static String DB_NAME="DB_name"; //1
    public final static int DB_VERSION=1;

    //DB_VERSION Upgrade হলে onUpgrade call হয় ।

    //3018
    // DB_VERSION=2, Upgrade হলে onCreate এর table আগের গুলো Delete করতে হয় ।তখন
    //db.execSQL("drop table if exists my_table"); লিখতে হবে onUpgrade এর ভিতরে ।
    //যত গুলো table থাকবে ততবার লিখতে হবে same code ।


    public DatabaseHelper(@Nullable Context context) { //2
        super(context, DB_NAME, null, 1);//4
    }

    //3017
    //context হলো যেই class এ কাজ করা হয় ঐ class এর environment যেমন : DatabaseHelper
    //String name এখানে name টা হলো database name
    //int version হলো database এর version

    @Override
    public void onCreate(SQLiteDatabase db) { //3
        //এই db ভিতরে sql command দিয়ে table create করা যায়
        //execSQL() মানে execute sql command ওর পেটে sql এর যা command দিবো তাই execute করবে
        db.execSQL("create table my_table ( id INTEGER primary key autoincrement,name TEXT,mobile TEXT)");//5
        //id INTIGER id নামে coloum create হইছে 3 ta coloum create হয়েছে


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { //6


    }


    public void insertData(String name,String mobile){//7

        SQLiteDatabase database=this.getWritableDatabase(); //8

        ContentValues conval=new ContentValues();//9 ContentValues মানে key value pair করা
        conval.put("name",name); //Name ধরে insertData String এ pass করে দিয়েছি
        conval.put("mobile",mobile);

        database.insert("my_table",null,conval); //10 table এ data insert করছে

    }

    public Cursor getAllData(){

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from my_table",null);
        return cursor;
        //rawQuery - যখন data read করে খুজতে/দেখতে যাবো তখন use করবো
        //select এর পর *  মানে ওই টেবিলের সবগুলো ডাটা select করে ফেলছি এখন যেকোন data নিয়ে কাজ করতে পারবো ঐ টেবিলের
        //Cursor ধরলে data টা 2 dymentionally select হয়


    }


}
