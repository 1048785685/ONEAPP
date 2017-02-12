package com.soully.oneapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.soully.oneapp.Fragment.FragmentFour;
import com.soully.oneapp.Fragment.FragmentOne;
import com.soully.oneapp.Fragment.FragmentThree;
import com.soully.oneapp.Fragment.FragmentTwo;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView_0 = (TextView) findViewById(R.id.tab_0);
        TextView textView_1 = (TextView) findViewById(R.id.tab_1);
        TextView textView_2 = (TextView) findViewById(R.id.tab_2);
        TextView textView_3 = (TextView) findViewById(R.id.tab_3);
        textView_0.setOnClickListener(this);
        textView_1.setOnClickListener(this);
        textView_2.setOnClickListener(this);
        textView_3.setOnClickListener(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.geren);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tab_0:
                replaceFragment(new FragmentOne());
                break;
            case  R.id.tab_1:
                replaceFragment(new FragmentTwo());
                break;
            case R.id.tab_2:
                replaceFragment(new FragmentThree());
                break;
            case R.id.tab_3:
                replaceFragment(new FragmentFour());
                break;
        }
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment,fragment);
        transaction.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.toolbar,menu);
        return true;
    }
}
