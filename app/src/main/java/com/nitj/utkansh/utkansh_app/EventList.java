package com.nitj.utkansh.utkansh_app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Vector;

public class EventList extends AppCompatActivity {

    TextView tv;
    String event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        Intent intent = getIntent();
        String society = intent.getStringExtra("society");
        Vector<String> names = new Vector<String>();
        MySQLiteHelper helper = new MySQLiteHelper(getBaseContext(), "mydatabase.db", null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from EventInfo where society=='" + society + "'", null);
        while (cursor.moveToNext()) {
            event = cursor.getString(1);
            names.addElement(event);
        }
        String[] events = names.toArray(new String[names.size()]);
        MyArrayAdapterEventsList adapter = new MyArrayAdapterEventsList(this,events,society);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.listitem );
        //adapter.addAll(names);
        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setDividerHeight(0);
        //listView.addHeaderView(tv);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parentListView, View viewLinearLayout, int position, long id) {
                LinearLayout ll = (LinearLayout) viewLinearLayout;
                TextView tv=(TextView)ll.findViewById(R.id.labelClubs);
                String name = (String) tv.getText();
                System.out.println(name);
                Intent intent = new Intent(getBaseContext(), Event.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }

}
