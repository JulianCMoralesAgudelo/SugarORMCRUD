package com.iud.app_grupo_40;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminDatabse extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME = "FeedReader.db";
    public static final String SQL_CREATE= "CREATE TABLE usuarios(documento INTEGER PRIMARY KEY, username TEXT, password TEXT)";

    public AdminDatabse(@Nullable Context context, @Nullable String name,@Nullable String username,  int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS estudiante");
        db.execSQL(SQL_CREATE);
    }
}
