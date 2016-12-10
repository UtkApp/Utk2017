package com.nitj.utkansh.utkansh_app.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.loopj.android.http.RequestParams;
import com.nitj.utkansh.utkansh_app.Home;
import com.nitj.utkansh.utkansh_app.R;
import com.nitj.utkansh.utkansh_app.app.AppConfig;
import com.nitj.utkansh.utkansh_app.app.AppController;
import com.nitj.utkansh.utkansh_app.helper.SQLiteHelper;
import com.nitj.utkansh.utkansh_app.helper.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends Activity
{

    String name,phone,email,college,utk;
    private Button btnRegister;
    private Button btnLinkToLogin;
    private EditText inputName;
    private EditText inputEmail;
    private EditText inputPhone;
    private EditText inputCollege;
    private ProgressDialog pDialog;
    private SessionManager session;
    private SQLiteHelper db;
    AlertDialog alertDialog;

    RequestParams params = new RequestParams();
   // GoogleCloudMessaging gcmObj;
    Context applicationContext;
    String regId = "";
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    AsyncTask<Void, Void, String> createRegIdTask;
    public static final String REG_ID = "regId";
    public static final String EMAIL_ID = "eMailId";


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        applicationContext = getApplicationContext();
        inputName = (EditText) findViewById(R.id.name);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPhone = (EditText) findViewById(R.id.phone);
        inputCollege = (EditText) findViewById(R.id.college);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLinkToLogin = (Button) findViewById(R.id.btnLinkToLoginScreen);
        session = new SessionManager(getApplicationContext());
        db = new SQLiteHelper(getApplicationContext());

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        SharedPreferences prefs = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        String registrationId = prefs.getString(REG_ID, "");
        if (session.isLoggedIn() && !TextUtils.isEmpty(registrationId))
        {
            Intent intent = new Intent(RegisterActivity.this,Home.class);
            startActivity(intent);
            finish();
        }
        // Register Button Click event
        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                name = inputName.getText().toString().trim();
                email = inputEmail.getText().toString().trim();
                phone = inputPhone.getText().toString().trim();
                college = inputCollege.getText().toString().trim();
                if (!name.isEmpty() && !email.isEmpty()  && !phone.isEmpty()&& !college.isEmpty())
                {
                    if(Utility.validate(email))
                    {
                        if(phone.length()==10)
                        {
                            pDialog.setMessage("Registering ...");
                            showDialog();
                            utk = "UTK"+phone.substring(4,10)+name;
                            registerUser(name,email,phone,college,utk);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Please enter valid 10 digit Phone no!", Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Please enter valid Email Id!", Toast.LENGTH_LONG).show();
                    }
                } else
                {
                    Toast.makeText(getApplicationContext(), "Please enter your details!", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Link to Login Screen
        btnLinkToLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view)
            {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }






    private void registerUser(final String name, final String email, final String phone, final String college, final String utk)
    {
        String tag_string_req = "req_register";
        StringRequest strReq = new StringRequest(Method.POST, AppConfig.URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                hideDialog();

                try {

                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error)
                    {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getBaseContext());
                        alertDialogBuilder.setTitle("Registration Successful");
                        alertDialogBuilder
                                .setMessage("Your UTK Number is "+utk+"\nProceed to LogIn.").setCancelable(false)
                                .setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.dismiss();
                                    }
                                });
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
                        alertDialog.show();
                        Intent i = new Intent(applicationContext, LoginActivity.class);
                        i.putExtra("regId", regId);
                        startActivity(i);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"User already registered!", Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(getApplicationContext(),
                        "Registration Failed! Check your internet connection.", Toast.LENGTH_LONG).show();
                hideDialog();
            }
        })
        {

            @Override
            protected Map<String, String> getParams()
            {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", name);
                params.put("email", email);
                params.put("phone", phone);
                params.put("college", college);
                params.put("utk",utk);
                return params;
            }
        };
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }













    // Check if Google Playservices is installed in Device or not
    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(this);
        // When Play services not found in device
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                // Show Error dialog to install Play services
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                finish();
            }
            return false;
        }
        return true;
    }
    @Override
    protected void onResume() {
        super.onResume();
        checkPlayServices();
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



}










