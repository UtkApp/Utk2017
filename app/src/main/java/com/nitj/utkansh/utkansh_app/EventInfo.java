package com.nitj.utkansh.utkansh_app;

import android.database.sqlite.SQLiteDatabase;

public class EventInfo {

    public static void onCreate(SQLiteDatabase db)
    {
        String query = "create table EventInfo("
                + "_id integer primary key autoincrement,"//0
                + "name text not null,"//1
                + "society text,"//2
                + "description text,"//3
                + "time text,"//4
                + "venue text,"//5
                + "bookmark integer not null default 0,"//6
                +"location text"//7
                + ")";
        db.execSQL(query);
    }

    public static void onUpdate(SQLiteDatabase db, int oldVersion, int newVersion){
        String query = "drop table if exists EventInfo";
        db.execSQL(query);
        onCreate(db);
    }
}
