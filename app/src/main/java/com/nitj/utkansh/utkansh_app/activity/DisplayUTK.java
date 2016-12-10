package com.nitj.utkansh.utkansh_app.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nitj.utkansh.utkansh_app.R;

public class DisplayUTK extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_utk);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getBaseContext());
        alertDialogBuilder.setTitle("Registration Successful");
        alertDialogBuilder
                .setMessage("Your UTK Number is " + "\nProceed to LogIn.").setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i = new Intent(getBaseContext(), LoginActivity.class);
                        startActivity(i);
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}