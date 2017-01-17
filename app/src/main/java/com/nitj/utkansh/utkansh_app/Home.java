package com.nitj.utkansh.utkansh_app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.LayoutInflater;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.nitj.utkansh.utkansh_app.activity.LoginActivity;
import com.nitj.utkansh.utkansh_app.helper.SQLiteHelper;
import com.nitj.utkansh.utkansh_app.helper.SessionManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.concurrent.ExecutionException;

public class Home extends AppCompatActivity {
    public static final String LOG_TAG = Home.class.getSimpleName();
    ViewPager viewPager = null;

    private SessionManager session;
    private SQLiteHelper db;
    private MySQLiteHelper helperEvent;
    private SQLiteDatabase database;
    private String email, regId;


    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    public static final String REG_ID = "regId";
    public static final String EMAIL_ID = "eMailId";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        db = new SQLiteHelper(getApplicationContext());
        session = new SessionManager(getApplicationContext());

        SharedPreferences prefs = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        regId = prefs.getString(REG_ID, "");
        email = prefs.getString(EMAIL_ID, "");
        mNavigationDrawerItemTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        LayoutInflater inflater = getLayoutInflater();

        View listHeaderView = inflater.inflate(R.layout.header_list, null, false);

        mDrawerList.addHeaderView(listHeaderView);


        mDrawerList.setDividerHeight(0);
        MyArrayAdapterDrawer a = new MyArrayAdapterDrawer(this, mNavigationDrawerItemTitles);
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
        tabLayout.setBackgroundColor(Color.parseColor("#FF630016"));
        tabLayout.setTabTextColors(Color.parseColor("#ffffff"), Color.parseColor("#ef6c00"));
        tabLayout.setupWithViewPager(viewPager);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        //Check if app version is latest
        Checkversion();
    }

    public void onCall0(View view) {
        String phoneCallUri = "tel:918591871094";
        Intent phoneCallIntent = new Intent(Intent.ACTION_CALL);
        phoneCallIntent.setData(Uri.parse(phoneCallUri));
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(phoneCallIntent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R.menu.menu_home, menu);

        /*MenuItem menuItem=menu.findItem(R.id.action_search);
        ShareActionProvider mShareActionProvider=new ShareActionProvider(this);
        if(mShareActionProvider!=null)
        {
            mShareActionProvider.setShareIntent(createShareForecastIntent());
            MenuItemCompat.setActionProvider(menuItem, mShareActionProvider);
        }
        else
        {
        }
*/
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


    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerClosed(View view) {
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
        int id = item.getItemId();
        if (id == R.id.action_search) {
            ActivityOptionsCompat activityOptionsCompat=ActivityOptionsCompat.makeSceneTransitionAnimation(this,null);
            Intent intent = new Intent(this,SearchActivity.class);
            this.startActivity(intent,activityOptionsCompat.toBundle());
            return true;

        }

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Home Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
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
        switch (position) {
            case 1:
                intent = new Intent(this, MyProfile.class);
                startActivity(intent);
                break;

            case 2:
                intent = new Intent(this, Bookmarks.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(this, MapsTest.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(this, Merchandise.class);
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(this, Notifications.class);
                startActivity(intent);
                break;
            case 6:
                logoutUser();
                break;

            case 7:
                intent = new Intent(this, Developers.class);
                startActivity(intent);
                break;
            case 8:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;


            default:
                intent=null;

        }


    }

    private void logoutUser() {
        session.setLogin(false);
        helperEvent = new MySQLiteHelper(getBaseContext(), "mydatabase.db", null, 1);
        database = helperEvent.getWritableDatabase();
        String q = "update EventInfo set bookmark = 0";
        database.execSQL(q);
        db.deleteTables();

        Logout lg = new Logout();

        lg.unRegisterUserForNotifications(email, regId);
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


    //For Making sure app is updated
    private String getCurrentVersion(){
        PackageManager pm = this.getPackageManager();
        PackageInfo pInfo = null;

        try {
            pInfo =  pm.getPackageInfo(this.getPackageName(),0);

        } catch (PackageManager.NameNotFoundException e1) {
            e1.printStackTrace();
        }
        String currentVersion = pInfo.versionName;

        return currentVersion;
    }
    private class GetLatestVersion extends AsyncTask<String, String, String> {
        String latestVersion;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                //It retrieves the latest version by scraping the content of current version from play store at runtime
                String urlOfAppFromPlayStore = "https://play.google.com/store/apps/details?id=com.nitj.utkansh.utkansh2016";
                Document doc = Jsoup.connect(urlOfAppFromPlayStore).get();
                latestVersion = doc.getElementsByAttributeValue("itemprop","softwareVersion").first().text();

            }catch (Exception e){
                e.printStackTrace();

            }

            return latestVersion;
        }
    }

    private void Checkversion() {
        String latestVersion = "";
        String currentVersion = getCurrentVersion();
        Log.d(LOG_TAG, "Current version = " + currentVersion);
        try {
            latestVersion = new GetLatestVersion().execute().get();
            Log.d(LOG_TAG, "Latest version = " + latestVersion);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //If the versions are not the same
        if ((!currentVersion.equals(latestVersion)) && (latestVersion != null && !latestVersion.isEmpty())) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("An Update is Available");
            builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Click button action
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nitj.utkansh.utkansh2016")));
                    dialog.dismiss();
                }
            });

            builder.setNegativeButton("Later", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Cancel button action
                }
            });

            builder.setCancelable(false);
            builder.show();
        }


    }

}


class MyAdapter extends FragmentStatePagerAdapter {

    private String tabTitles[] = new String[]{"Pro Shows", "Clubs", "Sponsors", "Contact Us","Camera"};

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new Starnite();
        } else if (position == 1) {
            fragment = new ClubsNew();
        } else if (position == 2) {
            fragment = new Sponsors();
        }
        else if (position == 3) {
            fragment = new Contact();
        }
        else if (position == 4) {
            fragment = new Camera();
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



