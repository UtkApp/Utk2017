package com.nitj.utkansh.utkansh_app;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nitj.utkansh.utkansh_app.helper.SQLiteHelper;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Event extends AppCompatActivity {

    String name,description,time,venue,society,team;
    String message;
    boolean error;
    CheckBox cBox;
    int bookmark,img_id;
    EditText editteam;
    ImageView imageView;
    TextView nameE,descriptionE,timeE,venueE;
    LinearLayout descriptionLayout,timeLayout,venueLayout,teamLayout;
    Button navigate,register;
    RelativeLayout rl ;
    SQLiteDatabase databaseEvent;
    MySQLiteHelper helperEvent;
    private ProgressDialog pDialog;
    private SQLiteHelper helperUser;
    CoordinatorLayout main_content;
    private String URL_REGISTER_EVENT = "http://www.utkansh.com/UtkanshAndroidApp/RegisterEvents/new_register_for_events.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_new);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        main_content=(CoordinatorLayout) findViewById(R.id.main_content);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
          collapsingToolbarLayout.setTitle(name);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
        //Context context = this;
        collapsingToolbarLayout.setContentScrimColor(Color.parseColor("#FF630016"));
        /*ContextCompat.getColor(context,R.color.orange)*/



        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        editteam =(EditText)findViewById(R.id.team);
        teamLayout=(LinearLayout)findViewById(R.id.teamLayout);
        helperUser = new SQLiteHelper(getApplicationContext());
        helperEvent = new MySQLiteHelper(getBaseContext(), "mydatabase.db", null, 1);
        cBox = (CheckBox)findViewById(R.id.cb);
        cBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                databaseEvent = helperEvent.getWritableDatabase();

                if (cBox.isChecked()) {
                    Snackbar.make(main_content,"Bookmarked!",Snackbar.LENGTH_SHORT);
                    databaseEvent.execSQL("update EventInfo set bookmark=1 where name=='" + name + "'");
                } else {
                    databaseEvent.execSQL("update EventInfo set bookmark=0 where name=='" + name + "'");
                }
            }
        });



        register = (Button)findViewById(R.id.registerEventButton);
        //FloatingActionButton fab_register = (FloatingActionButton)findViewById(R.id.fab_register);
        databaseEvent = helperEvent.getReadableDatabase();
        Cursor cursor = databaseEvent.rawQuery("Select * from EventInfo where name=='" + name + "'", null);

        if(cursor.moveToFirst())
        {
            society=cursor.getString(2);
            if(society.equals("Others") || society.equals("Attractions"))
            {
                //fab_register.setVisibility(View.GONE);
                register.setVisibility(View.GONE);
                teamLayout.setVisibility(View.GONE);
                if(name.equals("Panache - Fashion Show")||name.equals("Mega Sonic - Battle Of Bands"))
                {
                    //fab_register.setVisibility(View.VISIBLE);
                    register.setVisibility(View.VISIBLE);
                    teamLayout.setVisibility(View.VISIBLE);

                }
            }
            description = cursor.getString(3);
            if(!description.equals(""))
            {
                descriptionLayout = (LinearLayout)findViewById(R.id.description);
                descriptionLayout.setVisibility(View.VISIBLE);
                descriptionE=(TextView)findViewById(R.id.descriptionEvent);
                descriptionE.setText(description);
            }
            time = cursor.getString(4);
            if(!time.equals(""))
            {
                timeLayout = (LinearLayout)findViewById(R.id.time);
                timeLayout.setVisibility(View.VISIBLE);
                timeE=(TextView)findViewById(R.id.timeEvent);
                timeE.setText(time);
            }
            venue = cursor.getString(5);
            if(!venue.equals(""))
            {
                venueLayout = (LinearLayout)findViewById(R.id.venue);
                venueLayout.setVisibility(View.VISIBLE);
                venueE=(TextView)findViewById(R.id.venueEvent);
                venueE.setText(venue);
                rl = (RelativeLayout)findViewById(R.id.navi_layout);
                rl.setVisibility(View.VISIBLE);
            }

            bookmark=cursor.getInt(6);
            if(bookmark==1)
                cBox.setChecked(true);
            else
                cBox.setChecked(false);

            img_id=cursor.getInt(8);
            if(img_id!=0){
                imageView=(ImageView)findViewById(R.id.collapse_toolbar_image);
                imageView.setImageResource(img_id);
            }
        }
        else
        {
            nameE.setText("Nothing to display");
        }

        navigate = (Button)findViewById(R.id.navigation_button);
        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MapsTestEvents.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team = editteam.getText().toString().trim();;
                if(team.equals(""))
                {
                    Toast.makeText(getBaseContext(), "Please enter your team name", Toast.LENGTH_LONG).show();                }
                else
                {
                    pDialog.setMessage("Registering ...");
                    showDialog();
                    registerForEvent();
                }

            }
        });
    }
    public void onRegisterClick(View view){
        Snackbar.make(main_content,"Do you want to register?",Snackbar.LENGTH_LONG)
                .setAction("YES", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        team = editteam.getText().toString().trim();;
                        if(team.equals(""))
                        {
                            Snackbar.make(main_content, "Please enter your team name", Snackbar.LENGTH_LONG).show();                }
                        else
                        {
                            pDialog.setMessage("Registering ...");
                            showDialog();
                            registerForEvent();
                        }
                    }
                }).setActionTextColor(getResources().getColor(R.color.bg_main)).show();

    }
    public void registerForEvent()
    {
        HashMap<String,String> values = helperUser.getUserDetails();
        String email = values.get("email");
        new HttpAsyncTask().execute(email, name,team);
    }

    private void showDialog()
    {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog()
    {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    private class HttpAsyncTask extends AsyncTask< String, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        protected Void doInBackground(String arg[]) {
            String email = arg[0];
            String event_name = arg[1];
            String team_name = arg[2];

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("email",email));
            params.add(new BasicNameValuePair("event_name", event_name));
            params.add(new BasicNameValuePair("team", team_name));

            ServiceHandler serviceClient = new ServiceHandler();
            String json = serviceClient.makeServiceCall(URL_REGISTER_EVENT, ServiceHandler.POST, params);
            if (json != null) {
                try {
                    JSONObject jsonObj = new JSONObject(json);
                    error = jsonObj.getBoolean("error");
                    message = jsonObj.getString("message");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                hideDialog();
                Toast.makeText(getBaseContext(),"Registration Failed! Please try after some time", Toast.LENGTH_LONG).show();
            }
            return null;
        }
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if(!error)
            {
                hideDialog();
                if(message.equals("Already Registered"))
                {
                    Toast.makeText(getBaseContext(),message,Toast.LENGTH_LONG).show();
                }
                else if(message.equals("Registeration Successful"))
                {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getBaseContext());
                    alertDialogBuilder.setTitle("Registration successful!");
                    alertDialogBuilder
                            .setMessage("You have been successfully registered!").setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
                    alertDialog.show();
                }
            }
            else
            {
                hideDialog();
                Toast.makeText(getBaseContext(),message,Toast.LENGTH_LONG).show();
            }

        }
    }

}
