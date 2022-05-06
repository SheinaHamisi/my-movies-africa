package com.example.mymovieapp;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

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

    Context context;

    //Constructor
    public DBHandler(Context context){
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;

    }

    //Create db
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TITLE_COL + " TEXT, " + TEXT_COL + "TEXT)";

        sqLiteDatabase.execSQL(query);

    }

    public  void addNewNotification(String title, String text){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(TITLE_COL, title);
        values.put(TEXT_COL, text);

        sqLiteDatabase.insert(TABLE_NAME, null, values);
        Log.d(TAG, "addNewNotification: Saved");

        sqLiteDatabase.close();

    }
    public ArrayList<NotificationModal> readNotifications() {
        // on below line we are creating a database for reading our database.
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorNotifications = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<NotificationModal> notificationModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorNotifications.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                notificationModalArrayList.add(new NotificationModal(cursorNotifications.getString(1),
                        cursorNotifications.getString(3)));
            } while (cursorNotifications.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor and returning our array list.
        cursorNotifications.close();
        return notificationModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldNotification, int newNotification) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


}
