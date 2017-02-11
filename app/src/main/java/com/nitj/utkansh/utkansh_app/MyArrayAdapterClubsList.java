package com.nitj.utkansh.utkansh_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyArrayAdapterClubsList extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public MyArrayAdapterClubsList(Context context, String[] values) {
        super(context, R.layout.icon_listitem_clubs_events, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.icon_listitem_clubs_events, null, false);
        TextView textView = (TextView) rowView.findViewById(R.id.labelClubs);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logoClubs);
        textView.setText(values[position]);

        // Change icon based on name
        String s = values[position];

        //System.out.println(s);
        if (s.equals("Attractions")) {
            imageView.setImageResource(R.drawable.star);
        } else if (s.equals("Fine Arts Club")) {
            imageView.setImageResource(R.drawable.finearts);
        } else if (s.equals("Dance Club")) {
            imageView.setImageResource(R.drawable.dance);
        } else if (s.equals("Dramatics Club")) {
            imageView.setImageResource(R.drawable.drama);
        } else if (s.equals("Music Club")) {
            imageView.setImageResource(R.drawable.music);
        } else if (s.equals("Movie Club")) {
            imageView.setImageResource(R.drawable.video);
        } else if (s.equals("Photography Club")) {
            imageView.setImageResource(R.drawable.photo);
        } else if (s.equals("Literary and Debating Club")) {
            imageView.setImageResource(R.drawable.lads);
        } else if (s.equals("Rajbhasa Samiti")) {
            imageView.setImageResource(R.drawable.rajbhasha);
        } else if (s.equals("Yoga Club")) {
            imageView.setImageResource(R.drawable.ic_quest);
        } else if (s.equals("Others")) {
            imageView.setImageResource(R.drawable.miscelle);
        }
        return rowView;
    }
}
