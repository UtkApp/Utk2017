package com.nitj.utkansh.utkansh_app;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

public class Merchandise extends ActionBarActivity {
    public static final String LOG_TAG = Home.class.getSimpleName();
    ViewPager viewPager = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchandise);
        android.support.v7.app.ActionBar actionBar =  getSupportActionBar();
        actionBar.hide();


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpagerTshirt);

        final TabLayout tabLayout;
        viewPager.setAdapter(new MyMerchandiseAdapter(getSupportFragmentManager()));


        tabLayout = (TabLayout) findViewById(R.id.sliding_tabsTshirt);
        tabLayout.setBackgroundColor(Color.parseColor("#424242"));
        tabLayout.setTabTextColors(Color.parseColor("#ffffff"), Color.parseColor("#ef6c00"));
        tabLayout.setupWithViewPager(viewPager);
    }


}



class MyMerchandiseAdapter extends FragmentStatePagerAdapter {

    private String tabTitles[] = new String[]{"Have a look here...", "Place your order here..."};

    public MyMerchandiseAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new ViewTshirt();
        } else if (position == 1) {
            fragment = new OrderTshirt();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitles[position];
    }


}



