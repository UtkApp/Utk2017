package com.nitj.utkansh.utkansh_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;


public class ClubsGrid extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        RecyclerView.LayoutManager layoutManager;
        ArrayList<Clubs_set> list = new ArrayList<Clubs_set>();

        int[] image_id = {R.drawable.star,R.drawable.finearts,R.drawable.dance,R.drawable.drama,
                R.drawable.music,R.drawable.video,R.drawable.photo,R.drawable.lads,R.drawable.rajbhasha,
                R.drawable.ic_quest,R.drawable.miscelle};

        String [] name;

        View v =  inflater.inflate(R.layout.fragment_clubs_grid, container, false);

        name = getResources().getStringArray(R.array.clubs);
        int count = 0;
        for(String Name : name)
        {
            Clubs_set clubs_set = new Clubs_set(image_id[count],name[count]);
            count++;
            list.add(clubs_set);
        }


        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new ClubAdapter(list,getContext(),getActivity());
        recyclerView.setAdapter(adapter);

        Animation animation=AnimationUtils.loadAnimation(getContext(),R.anim.recycle_anim);
        recyclerView.setAnimation(animation);

        return v;
    }
}
