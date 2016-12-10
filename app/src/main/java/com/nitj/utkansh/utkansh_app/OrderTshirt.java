package com.nitj.utkansh.utkansh_app;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.nitj.utkansh.utkansh_app.helper.SQLiteHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderTshirt extends Fragment {

    private String URL_TSHIRT = "http://www.utkansh.com/UtkanshAndroidApp/Tshirt/new_tshirt.php";
    String quantity1,quantity2,quantity3,Stringsize,Stringroomno,Stringhostel;
    Spinner spinnerBH,spinnerGH,t1,t2,t3,spinnerSize;
    LinearLayout llmale,llfemale;
    RadioGroup rg;
    int type1,type2,type3,amount;
    EditText Editroomno;
    private ProgressDialog pDialog;

    private SQLiteHelper db;
    boolean error;

    Button btn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        final View rootview= inflater.inflate(R.layout.fragment_order_tshirt, container, false);
        pDialog = new ProgressDialog(getActivity());
        pDialog.setCancelable(false);
        spinnerBH = (Spinner) rootview.findViewById(R.id.spinner2);
        spinnerGH= (Spinner) rootview.findViewById(R.id.spinner3);
        spinnerSize=(Spinner)rootview.findViewById(R.id.spinner7);
        t1 = (Spinner)rootview.findViewById(R.id.t1);
        t2 =(Spinner) rootview.findViewById(R.id.t2);
        t3=(Spinner) rootview.findViewById(R.id.t3);
        Editroomno =(EditText)rootview.findViewById(R.id.room);
        btn=(Button)rootview.findViewById(R.id.orderButton);
        String[] boys_hostel = getResources().getStringArray(R.array.boys_hostel);
        String[] girls_hostel = getResources().getStringArray(R.array.girls_hostel);
        String[] quantity= getResources().getStringArray(R.array.quantity);
        String[] size= getResources().getStringArray(R.array.size);
        db = new SQLiteHelper(getActivity());
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), R.layout.listitem,boys_hostel);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), R.layout.listitem,girls_hostel);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getActivity(), R.layout.listitem,quantity);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(getActivity(), R.layout.listitem,size);

        rg = (RadioGroup)rootview.findViewById(R.id.gender);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.MaleTshirt) {
                    llmale = (LinearLayout) getActivity().findViewById(R.id.llmale);
                    llmale.setVisibility(View.VISIBLE);
                    llfemale = (LinearLayout) getActivity().findViewById(R.id.llfemale);
                    llfemale.setVisibility(View.GONE);
                } else {
                    llmale = (LinearLayout) getActivity().findViewById(R.id.llmale);
                    llmale.setVisibility(View.GONE);
                    llfemale = (LinearLayout) getActivity().findViewById(R.id.llfemale);
                    llfemale.setVisibility(View.VISIBLE);
                }
            }
        });

        spinnerBH.setAdapter(adapter1);
        spinnerBH.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                Stringhostel = (tv.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {

            }

        });
        spinnerGH.setAdapter(adapter2);
        spinnerGH.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                Stringhostel = (tv.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {

            }

        });
        t1.setAdapter(adapter3);
        t1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                quantity1 = (tv.getText().toString());
                type1 = Integer.parseInt(tv.getText().toString());
                int total = addallType(type1, type2, type3);
                amount = total * 250;
                TextView amt = (TextView) rootview.findViewById(R.id.amount);
                amt.setText("Rs " + amount);
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {
                type1 = 0;
                quantity1 = "0";
            }

        });
        t2.setAdapter(adapter3);
        t2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                quantity2 = (tv.getText().toString());
                type2 = Integer.parseInt(tv.getText().toString());
                int total = addallType(type1, type2, type3);
                amount = total * 250;
                TextView amt = (TextView) rootview.findViewById(R.id.amount);
                amt.setText("Rs " + amount);
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {
                type2 = 0;
                quantity1 = "0";
            }

        });
        t3.setAdapter(adapter3);
        t3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                quantity3 = (tv.getText().toString());
                type3 = Integer.parseInt(tv.getText().toString());
                int total = addallType(type1, type2, type3);
                amount = total * 250;
                TextView amt = (TextView) rootview.findViewById(R.id.amount);
                amt.setText("Rs " + amount);
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {
                type3 = 0;
                quantity1 = "0";
            }

        });
        spinnerSize.setAdapter(adapter4);
        spinnerSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                Stringsize = (tv.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {
                Stringsize = "size";
            }

        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stringroomno = Editroomno.getText().toString().trim();
                HashMap<String,String> values = db.getUserDetails();
                String email = values.get("email");
                if(Stringsize.equals("Select Size")||Stringhostel.equals("Select Boys Hostel")||Stringhostel.equals("Select Girls Hostel")||Stringroomno.equals(""))
                {
                    Toast.makeText(getActivity(), "Please fill all details", Toast.LENGTH_LONG).show();
                }
                else
                {
                    pDialog.setMessage("Ordering ...");
                    showDialog();
                    new HttpAsyncTask().execute(quantity1, quantity2, quantity3, Stringsize, Stringroomno, Stringhostel, email);

                }
            }
        });

        return rootview;
    }

    private class HttpAsyncTask extends AsyncTask< String, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        protected Void doInBackground(String arg[]) {
            String q1 = arg[0];
            String q2 = arg[1];
            String q3 = arg[2];
            String s = arg[3];
            String r = arg[4];
            String h = arg[5];
            String e = arg[6];
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("quantity1", q1));
            params.add(new BasicNameValuePair("quantity2", q2));
            params.add(new BasicNameValuePair("quantity3", q3));
            params.add(new BasicNameValuePair("size", s));
            params.add(new BasicNameValuePair("roomno", r));
            params.add(new BasicNameValuePair("hostel", h));
            params.add(new BasicNameValuePair("email", e));
            ServiceHandler serviceClient = new ServiceHandler();
            String json = serviceClient.makeServiceCall(URL_TSHIRT, ServiceHandler.POST, params);
            if (json != null) {
                try {
                    JSONObject jsonObj = new JSONObject(json);
                    error = jsonObj.getBoolean("error");
                } catch (JSONException ex) {
                    ex.printStackTrace();
                }
            }
                return null;
        }

        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            hideDialog();
            if (!error) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle("Order successful!");
                alertDialogBuilder
                        .setMessage("Your order has been scheduled to be delivered at your doorstep.").setCancelable(false)
                        .setPositiveButton("Proceed to Home Page", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(getActivity(), Home.class);
                                startActivity(intent);
                                getActivity().finish();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
                alertDialog.show();
            }
            else
            {
                Toast.makeText(getActivity(),"Failed to order T-shirts! Please try after some time", Toast.LENGTH_LONG).show();
            }
        }
    }
    public int addallType(int a,int b,int c)
    {
        int d=a+b+c;
        return d;
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

