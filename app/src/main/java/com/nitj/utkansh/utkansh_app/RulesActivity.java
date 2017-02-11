package com.nitj.utkansh.utkansh_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RulesActivity extends AppCompatActivity {
    String name,rules;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        Intent intent=getIntent();
        name=intent.getStringExtra("name");
        setTitle(name+"'s RuleBook");
        rules=intent.getStringExtra("rules");
        TextView rules_tv = (TextView)findViewById(R.id.rules_tv);
        rules_tv.setText(rules);
    }
}
