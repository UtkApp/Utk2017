package com.nitj.utkansh.utkansh_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyArrayAdapterEventsList extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    private final String society;

    public MyArrayAdapterEventsList(Context context, String[] values, String society) {
        super(context, R.layout.icon_listitem_clubs_events, values);
        this.context = context;
        this.values = values;
        this.society = society;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.icon_listitem_clubs_events, null, false);
        TextView textView = (TextView) rowView.findViewById(R.id.labelClubs);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logoClubs);
        textView.setText(values[position]);

        // Change icon based on name
        String s = society;
        String[] clubs=getContext().getResources().getStringArray(R.array.clubs);
        //System.out.println(s);
        if (s.equals(clubs[0])) {
            imageView.setImageResource(R.drawable.star);
        } else if (s.equals(clubs[1])) {
            imageView.setImageResource(R.drawable.finearts);
        } else if (s.equals(clubs[2])) {
            imageView.setImageResource(R.drawable.dance);
        } else if (s.equals(clubs[3])) {
            imageView.setImageResource(R.drawable.drama);
        } else if (s.equals(clubs[4])) {
            imageView.setImageResource(R.drawable.music);
        } else if (s.equals(clubs[5])) {
            imageView.setImageResource(R.drawable.video);
        } else if (s.equals(clubs[6])) {
            imageView.setImageResource(R.drawable.photo);
        } else if (s.equals(clubs[7])) {
            imageView.setImageResource(R.drawable.lads);
        } else if (s.equals(clubs[8])) {
            imageView.setImageResource(R.drawable.rajbhasha);
        } else if (s.equals(clubs[9])) {
            imageView.setImageResource(R.drawable.ic_quest);
        } else if (s.equals(clubs[10])) {
            imageView.setImageResource(R.drawable.miscelle);
        }
        return rowView;
    }
}
