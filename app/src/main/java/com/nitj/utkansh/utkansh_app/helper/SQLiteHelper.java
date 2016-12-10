package com.nitj.utkansh.utkansh_app.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;

public class SQLiteHelper extends SQLiteOpenHelper
{

    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "user_notifications";

    SQLiteDatabase database;
    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        database=getWritableDatabase();
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOGIN_TABLE = "CREATE TABLE user(id integer primary key autoincrement, name text, email text, phone text, college text, utk text)";
        String CREATE_NOTIFICATION_TABLE = "CREATE TABLE notifications(id integer primary key autoincrement, notification text)";

        db.execSQL(CREATE_LOGIN_TABLE);
        db.execSQL(CREATE_NOTIFICATION_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS notifications");
        // Create tables again
        onCreate(db);
    }


    public void addUser(String name, String email, String phone, String college, String utk) {
        database= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("phone", phone);
        values.put("college", college);
        values.put("utk", utk);

        // Inserting Row
        long id = database.insert("user", null, values);
        database.close(); // Closing database connection
    }

    /**
     * Getting user data from database
     * */
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "SELECT * FROM user";
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            user.put("name", cursor.getString(1));
            user.put("email", cursor.getString(2));
            user.put("phone", cursor.getString(3));
            user.put("college", cursor.getString(4));
            user.put("utk", cursor.getString(5));
        }
        cursor.close();
        database.close();
        // return user
        return user;
    }



    public void addNotification(String noti) {
        String selectQuery = "SELECT * FROM notifications where notification = '"+noti+"'";
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if(!cursor.moveToFirst())
        {
            database = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("notification",noti);
            long id = database.insert("notifications", null, values);
        }
        database.close();
    }
    public String[] getNotifications() {
        String selectQuery = "SELECT * FROM notifications";
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        String [] notiarray = new String[cursor.getCount()];
        int i = 0;
        while(cursor.moveToNext())
        {
            notiarray[i++]=cursor.getString(1);
        }

        cursor.close();
        database.close();
        return notiarray;
    }


    public void deleteTables() {
        database = this.getWritableDatabase();
        // Delete All Rows
        database.delete("user", null, null);
        database.delete("notifications", null, null);
        database.close();

    }

}