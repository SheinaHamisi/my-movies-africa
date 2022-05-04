package com.example.mymovieapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    //DB name
    private static final String DB_NAME = "notificationdb";

    //DB version
    private static final int DB_VERSION = 1;

    //Table name
    private static final String TABLE_NAME = "notificationtable";

    //ID column
    private static final String ID_COL = "id";

    //Notification title column
    private static final String TITLE_COL = "title";

    //Notification message column
    private static final String TEXT_COL = "text";

    //Constructor
    public DBHandler(Context context){
        super(context, DB_NAME, null, DB_VERSION);

    }

    //
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
