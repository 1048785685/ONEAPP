package com.soully.oneapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
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
    private Fragment currentFragment = new Fragment();
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
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
        if (actionBar != null) {
//          getSupportActionBar().setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.geren);
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.us:
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, AboutUs.class);
                        startActivity(intent);
                }
                return true;
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab_0:
                replaceFragment(new FragmentOne());
//                showFragment(new FragmentOne());
                break;
            case R.id.tab_1:
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

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment, fragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // 处理返回逻辑
                drawerLayout.openDrawer(navigationView);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * 展示Fragment
     */
//    private void showFragment(Fragment fragment) {
//        if (fragment != currentFragment) {
//            if (!fragment.isAdded()) {
//                getFragmentManager().beginTransaction().hide(currentFragment)
//                        .add(R.id.fragment, fragment).commit();
//            } else {
//                getFragmentManager().beginTransaction().hide(currentFragment)
//                        .show(fragment).commit();
//            }
//            currentFragment = fragment;
//        }
//    }

    
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event)
//    {
//        if (keyCode == KeyEvent.KEYCODE_BACK)
//        {
//            if ()
//
//        }
//
//        return false;
//
//    }

}
