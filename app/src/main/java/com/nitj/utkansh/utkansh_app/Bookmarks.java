package com.nitj.utkansh.utkansh_app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Vector;

public class Bookmarks extends AppCompatActivity {

    String event;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarks);
        showBookmarkedEvents();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showBookmarkedEvents();
    }

    private void showBookmarkedEvents()
    {
        Vector<String> bookmarks = new Vector<String>();
        com.nitj.utkansh.utkansh_app.MySQLiteHelper helper = new com.nitj.utkansh.utkansh_app.MySQLiteHelper(getBaseContext(), "mydatabase.db", null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from EventInfo where bookmark == 1", null);
        while (cursor.moveToNext()) {
            event = cursor.getString(1);
            bookmarks.addElement(event);
        }
        if(bookmarks.isEmpty())
        {
            bookmarks.addElement("No bookmarks to show yet. Click on the star on the Event Page to bookmark.");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.listitem );
        adapter.addAll(bookmarks);
        ListView listView = (ListView) findViewById(R.id.listViewBookmark);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parentListView, View viewTextView, int position, long id) {

                TextView tv = (TextView) viewTextView;
                String name = (String) tv.getText();
                Intent intent = new Intent(getBaseContext(), Event.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

    }


}
