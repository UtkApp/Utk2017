package com.nitj.utkansh.utkansh_app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SearchActivity extends AppCompatActivity {
    private List<String> searchList=new ArrayList<>();
    private ArrayList<String> suggestionList;
    private RecyclerView recyclerView;
    private SearchAdapter adapter;
    private LinearLayoutManager layoutManager;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* if(Build.VERSION.SDK_INT>=21)
        {
            TransitionInflater transitionInflater=TransitionInflater.from(this);
            Transition transition=transitionInflater.inflateTransition(R.transition.transition_slide_right);
            getWindow().setEnterTransition(transition);
            getWindow().setReturnTransition(transition);
        }*/
        getSupportActionBar().hide();
        setContentView(R.layout.activity_search);

        editText= (EditText) findViewById(R.id.et_search);
        recyclerView = (RecyclerView) findViewById(R.id.rv_search);
        recyclerView.setVisibility(View.GONE);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
/****************************************************************************/
        String event,match;
        Vector<String> names = new Vector<String>();
        Vector<String> socieites = new Vector<String>();
        MySQLiteHelper helper = new MySQLiteHelper(this, "mydatabase.db", null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from EventInfo where name like'%" + "" + "%'", null);
        // Toast.makeText(getActivity(),cursor+"", Toast.LENGTH_SHORT).show();
        String soc="",str;
        if(cursor!=null && cursor.getCount()>0)
        {
            while (cursor.moveToNext()) {
                event = cursor.getString(1);
                ((ArrayList<String>) searchList).add(cursor.getString(1));
                str=cursor.getString(2);
                if(!str.equals(soc)){
                    soc=str;
                    //System.out.println(soc);
                ((ArrayList<String>) searchList).add(soc);

                }
                names.addElement(event);
                socieites.addElement(cursor.getString(2));
            }
            /*String[] events = names.toArray(new String[names.size()]);
            String[] societie = socieites.toArray(new String[names.size()]);
            //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.listitem );
            //adapter.addAll(names);
            RecyclerView listView = (RecyclerView) findViewById(R.id.listViewSearch);

            listView.setDividerHeight(0);
            //listView.addHeaderView(tv);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView parentListView, View viewLinearLayout, int position, long id) {
                    LinearLayout ll = (LinearLayout) viewLinearLayout;
                    TextView tv=(TextView)ll.findViewById(R.id.labelClubs);
                    String name = (String) tv.getText();
                    Intent intent = new Intent(getActivity(), Event.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
            });*/
        }
        else
            Toast.makeText(this, "Sorry, No Results found..", Toast.LENGTH_SHORT).show();
/**************************************************************************************************/
       /* ScaleInAnimationAdapter AnimationAdapter=new ScaleInAnimationAdapter(adapter);
        AnimationAdapter.setDuration(500);
        AnimationAdapter.setInterpolator(new OvershootInterpolator());
        recyclerView.setAdapter(AnimationAdapter);*/
        adapter = new SearchAdapter(this, (ArrayList<String>) searchList);
        recyclerView.setAdapter(adapter);
        searchsuggestions();


    }

    private void searchsuggestions() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

               String str=s.toString().trim().toLowerCase();
                if(str.length()!=0){recyclerView.setVisibility(View.VISIBLE);}
                else{recyclerView.setVisibility(View.GONE);}
                List<String> filteredList = new ArrayList<>();
                if(s.length()>0)
                {
                    for(String string : searchList)
                    {
                        if (string.toLowerCase().contains(str))
                        {
                            filteredList.add(string);
                        }
                    }

                }
                else
                {
                    filteredList=searchList;
                }
                layoutManager = new LinearLayoutManager(SearchActivity.this);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);
                adapter = new SearchAdapter(SearchActivity.this, (ArrayList<String>) filteredList);
           /*     ScaleInAnimationAdapter AnimationAdapter=new ScaleInAnimationAdapter(adapter);
                AnimationAdapter.setDuration(500);
                AnimationAdapter.setInterpolator(new OvershootInterpolator());*/
                recyclerView.setAnimation(AnimationUtils.loadAnimation(SearchActivity.this,android.R.anim.slide_in_left));
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void searchResult(View v)
    {
        editText.requestFocus();
        editText.setText("");

    }

    public void removesearchbar(View view) {
        //view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            finish();

        }
    }
}
