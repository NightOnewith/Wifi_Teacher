package com.zijin.wifi_teacher.sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yin on 2017/4/1.
 */
public class UserDB extends SQLiteOpenHelper {


    public UserDB(Context context) {
        super(context, "USER.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user_table(_id integer primary key autoincrement,name vahchar(20),number vahchar(20),ip vahchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
