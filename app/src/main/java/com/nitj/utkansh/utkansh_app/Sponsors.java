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
import android.widget.Button;

import com.nitj.utkansh.utkansh_app.R;
import com.nitj.utkansh.utkansh_app.WebViewActivity;


public class Sponsors extends Fragment {

    private Button mSponsorsApply;
    private Button mSponsorsQuery;

    private static final String SponsorsApplyUrl="https://docs.google.com/forms/d/e/1FAIpQLSdnR4-E66oZMRmQV7l1xuLxqDibUSCbN77iBrsU6No6KERAvA/viewform";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View v = inflater.inflate(R.layout.fragment_sponsors, container, false);


        mSponsorsApply = (Button) v.findViewById(R.id.sponsors_apply_button);
        mSponsorsQuery = (Button) v.findViewById(R.id.sponsors_query_button);

        mSponsorsApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), WebViewActivity.class);
                i.putExtra("urls",SponsorsApplyUrl);
                startActivity(i);
            }
        });

        mSponsorsQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), WebViewActivity.class);
                i.putExtra("urls",SponsorsApplyUrl);
                startActivity(i);
            }
        });


        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_home, menu);
    }

}
