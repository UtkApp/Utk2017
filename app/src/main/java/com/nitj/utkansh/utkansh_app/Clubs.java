
package com.nitj.utkansh.utkansh_app;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Clubs extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootview= inflater.inflate(R.layout.fragment_clubs, container, false);

        String [] soc = {"Attractions","Fine Arts Club","Dance Club","Dramatics Club","Music Club","Movie Club","Photography Club","Literary and Debating Club","Rajbhasa Samiti","Yoga Club","Others"};
        ListView listView = (ListView) rootview.findViewById(R.id.listView);
        listView.setDividerHeight(0);

        MyArrayAdapterClubsList adapter = new MyArrayAdapterClubsList(getActivity(),soc);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parentListView, View viewLinearLayout, int position, long id) {

                LinearLayout ll = (LinearLayout) viewLinearLayout;
                TextView tv=(TextView)ll.findViewById(R.id.labelClubs);
                String society = (String) tv.getText();
                Intent intent = new Intent(getActivity(), EventList.class);
                intent.putExtra("society", society);
                startActivity(intent);
            }
        });
        return rootview;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_home, menu);
    }

}
