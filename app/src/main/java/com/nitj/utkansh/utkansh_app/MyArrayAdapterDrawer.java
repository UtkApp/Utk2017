package com.nitj.utkansh.utkansh_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyArrayAdapterDrawer extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public MyArrayAdapterDrawer(Context context, String[] values) {
        super(context, R.layout.icon_listitem_drawer, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.icon_listitem_drawer, null, false);
        TextView textView = (TextView) rowView.findViewById(R.id.labelDrawer);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logoDrawer);
        textView.setText(values[position]);

        // Change icon based on name
        String s = values[position];

        //System.out.println(s);
        if (s.equals("Profile")) {
            imageView.setImageResource(R.drawable.profile_icon);
        } else if (s.equals("Bookmarks")) {
            imageView.setImageResource(R.drawable.bookmark_icon);
        } else if (s.equals("Maps")) {
            imageView.setImageResource(R.drawable.map_icon);}
        else if (s.equals("Merchandise")) {
            imageView.setImageResource(R.drawable.merchandise_icon);
        }else if (s.equals("Notifications")) {

            imageView.setImageResource(R.drawable.notification_icon);
        }
       else if (s.equals("Logout")) {
            imageView.setImageResource(R.drawable.moveouticon);}
        else if (s.equals("Developers")) {

            imageView.setImageResource(R.drawable.developers_icon);
        }
        else if (s.equals("Share")) {

            imageView.setImageResource(R.drawable.share_icon);
        }
        return rowView;
    }
}
