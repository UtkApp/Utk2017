package com.nitj.utkansh.utkansh_app;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.nitj.utkansh.utkansh_app.activity.LoginActivity;
import com.nitj.utkansh.utkansh_app.helper.SQLiteHelper;
import com.nitj.utkansh.utkansh_app.helper.SessionManager;

public class Home extends AppCompatActivity {
    public static  final String LOG_TAG=Home.class.getSimpleName();
    ViewPager viewPager=null;

    private SessionManager session;
    private SQLiteHelper db;
    private MySQLiteHelper helperEvent;
    private SQLiteDatabase database;
    private String email,regId;


    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    public static final String REG_ID = "regId";
    public static final String EMAIL_ID = "eMailId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        db = new SQLiteHelper(getApplicationContext());
        session = new SessionManager(getApplicationContext());

        SharedPreferences prefs = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        regId = prefs.getString(REG_ID, "");
        email=prefs.getString(EMAIL_ID, "");
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerList.setDividerHeight(0);
        MyArrayAdapterDrawer a=new MyArrayAdapterDrawer(this, mNavigationDrawerItemTitles);
        mDrawerList.setAdapter(a);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mTitle = mDrawerTitle = getTitle();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setupDrawer();

        if (!session.isLoggedIn()) {
            logoutUser();
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        final TabLayout tabLayout;
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setBackgroundColor(Color.parseColor("#424242"));
        tabLayout.setTabTextColors(Color.parseColor("#ffffff"), Color.parseColor("#ef6c00"));
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R.menu.menu_home, menu);
        MenuItem menuItem=menu.findItem(R.id.action_share);
        ShareActionProvider mShareActionProvider=new ShareActionProvider(this);
        if(mShareActionProvider!=null)
        {
            mShareActionProvider.setShareIntent(createShareForecastIntent());
            MenuItemCompat.setActionProvider(menuItem, mShareActionProvider);
        }
        else
        {
        }
        return true;
    }
    private Intent createShareForecastIntent()
    {
        Intent shareIntent=new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,"A lot of interesting events at Utkansh'16 and don't want to miss any of them? Check out the official app for NIT Jalandhar Utkansh'16, Vernal Parade with features like In-App Registration, Real Time Notifications, GPS Navigation, Buy Merchandise, Full Schedule and a lot more. Download now at http://play.google.com/store/apps/details?id=com.nitj.utkansh.utkansh2016 ");
        return shareIntent;
    }


    private void setupDrawer()
    {
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close)
        {
            public void onDrawerClosed(View view)
            {
                super.onDrawerClosed(view);
                //getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
                //getSupportActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }


    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        // If the nav drawer is open, hide action items related to the content view
        // boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        //menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    private void selectItem(int position)
    {
        Intent intent;
        switch(position)
        {
            case 0:
                intent = new Intent(this,MyProfile.class);
                startActivity(intent);
                break;

            case 1:
                intent=new Intent(this,Bookmarks.class);
                startActivity(intent);
                break;
            case 2:
                intent=new Intent(this,MapsTest.class);
                startActivity(intent);
                break;
            case 3:
                intent=new Intent(this,Merchandise.class);
                startActivity(intent);
                break;
            case 4:
                intent=new Intent(this,Notifications.class);
                startActivity(intent);
                break;
            case 5:
                logoutUser();
                break;

            case 6:
                intent=new Intent(this,Developers.class);
                startActivity(intent);
                break;
            default:
                intent=null;

        }


    }

    private void logoutUser() {
        session.setLogin(false);
        helperEvent = new MySQLiteHelper(getBaseContext(), "mydatabase.db", null, 1);
        database=helperEvent.getWritableDatabase();
        String q = "update EventInfo set bookmark = 0";
        database.execSQL(q);
        db.deleteTables();

        Logout lg=new Logout();

        lg.unRegisterUserForNotifications(email,regId);
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}






class MyAdapter extends FragmentStatePagerAdapter {

    private String tabTitles[] = new String[]{"Pro Shows","About", "Clubs", "Sponsors", "Contact Us"};

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new Starnite();
        } else if (position == 1) {
            fragment = new About();
        } else if (position == 2) {
            fragment = new Clubs();
        } else if (position == 3) {
            fragment = new Sponsors();
        } else if (position == 4) {
            fragment = new Contact();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitles[position];
    }


}



