package com.nitj.utkansh.utkansh_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

public class ClubsNew extends Fragment {
    View rootview;


    @Override
    public void onStop() {
        super.onStop();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        rootview = inflater.inflate(R.layout.fragment_clubs_new,container,false);
        Fragment fGrid = new ClubsGrid();
        getChildFragmentManager().beginTransaction().replace(R.id.clubs_container,fGrid).commit();
        //CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) rootview.findViewById(R.id.collapsing_toolbar);
        //collapsingToolbarLayout.setContentScrimColor(Color.parseColor("#FF630016"));

        return rootview;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_home, menu);
    }

}
