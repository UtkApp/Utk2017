package com.nitj.utkansh.utkansh_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class Utkansh extends AppCompatActivity {
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utkansh);

        android.support.v7.app.ActionBar actionBar =  getSupportActionBar();
        actionBar.hide();
        int secondsDelayed = 1;
        handler=new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Utkansh.this, com.nitj.utkansh.utkansh_app.LoginReg.class));
                finish();
            }
        };
        handler.postDelayed(runnable, secondsDelayed * 2000);

    }
}
