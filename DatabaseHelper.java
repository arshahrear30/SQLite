package com.smaka.sqlightdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public final static String DB_NAME="DB_name";
    public final static int DB_VERSION=1;


    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }
    //context হলো যেই class এ কাজ করা হয় ঐ class এর environment যেমন : DatabaseHelper
    //String name এখানে name টা হলো database name
    //int version হলো database এর version

    @Override
    public void onCreate(SQLiteDatabase db) {
        //এই db ভিতরে sql command দিয়ে table create করা যায়
        //execSQL() মানে execute sql command ওর পেটে sql এর যা command দিবো তাই execute করবে
        db.execSQL("create table my_table(id INTIGER primary key autoincrement,name TEXT,mobile TEXT)");//id INTIGER id নামে coloum create হইছে 3 ta coloum create হয়েছে


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
