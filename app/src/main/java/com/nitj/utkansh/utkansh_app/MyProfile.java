package com.nitj.utkansh.utkansh_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nitj.utkansh.utkansh_app.activity.LoginActivity;
import com.nitj.utkansh.utkansh_app.helper.SQLiteHelper;
import com.nitj.utkansh.utkansh_app.helper.SessionManager;

import java.util.HashMap;

public class MyProfile extends AppCompatActivity {

    private SQLiteHelper db;
    private MySQLiteHelper helperEvent;
    private SQLiteDatabase database;

    private SessionManager session;
    private String email,regId;
    public static final String REG_ID = "regId";
    public static final String EMAIL_ID = "eMailId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        // SQLite database handler
        db = new SQLiteHelper(getApplicationContext());
       
        session = new SessionManager(getApplicationContext());

        SharedPreferences prefs = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        regId = prefs.getString(REG_ID, "");
        email=prefs.getString(EMAIL_ID,"");

        HashMap<String,String> values=db.getUserDetails();
        String name=values.get("name");
        String utk=values.get("utk");
        TextView nameUser=(TextView)findViewById(R.id.nameProfile);
        nameUser.setText(name);
        TextView utkNumberUser=(TextView)findViewById((R.id.utkNumber));
        utkNumberUser.setText(utk);
        Button logoutButton = (Button)findViewById(R.id.buttonLogoutProfile);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutUser();

            }
        });
    }
    private void logoutUser() {
        session.setLogin(false);
        helperEvent = new MySQLiteHelper(getBaseContext(), "mydatabase.db", null, 1);
        database=helperEvent.getWritableDatabase();
        String q = "update EventInfo set bookmark = 0";
        database.execSQL(q);
        db.deleteTables();

        Logout lg=new Logout();

        lg.unRegisterUserForNotifications(email, regId);
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

}
