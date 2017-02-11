package com.nitj.utkansh.utkansh_app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.nitj.utkansh.utkansh_app.ImgLoader.BitmapLoader;

import java.util.Vector;

public class EventList extends AppCompatActivity {

    TextView tv;
    String event,eventname;

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
        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.el_ctl);
        collapsingToolbarLayout.setTitle(society);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar0);
        collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(this,R.color.my_dark_blue));

        com.mikhaellopez.circularimageview.CircularImageView imageView =(com.mikhaellopez.circularimageview.CircularImageView)findViewById(R.id.el_img);
        Bitmap bmp= BitmapLoader.decodeSampledBitmapFromResource(
                getResources(),getImgID(society),(int)BitmapLoader.convertDpToPixel(100,this)
                ,(int)BitmapLoader.convertDpToPixel(100,this));
        imageView.setImageBitmap(bmp);
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

    private int getImgID(String society) {
        int[] image_id = {R.drawable.cover1,R.drawable.fine_arts_club,R.drawable.dance_club,R.drawable.dramatics_club,
                R.drawable.music_club,R.drawable.movie_club,R.drawable.photography_club,R.drawable.literary_and_debating_club,
                R.drawable.rajbhasa_samiti,R.drawable.quest,R.drawable.others};
       String clb[]= getResources().getStringArray(R.array.clubs);
        for(int i=0;i<clb.length;i++){
            if(clb[i].equals(society))
                return image_id[i];
        }
        return R.drawable.cover1;
    }

}
