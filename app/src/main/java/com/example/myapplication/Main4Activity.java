package com.example.myapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar =(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        FloatingActionButton fx=(FloatingActionButton) findViewById(R.id.fb);
        fx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"好应用与伙伴分享",Snackbar.LENGTH_SHORT).setAction("要得",new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent textIntent = new Intent(Intent.ACTION_SEND);
                        textIntent.setType("text/plain");
                        textIntent.putExtra(Intent.EXTRA_TEXT, "");
                        startActivity(Intent.createChooser(textIntent, "分享"));
                    }
                })
                        .show();
            }
        });
    }
            @Override
            public boolean onOptionsItemSelected(MenuItem item){
                switch (item.getItemId()){
                    case android.R.id.home:
                        finish();
                        return true;
                }
                return super.onOptionsItemSelected(item);
            }
}
