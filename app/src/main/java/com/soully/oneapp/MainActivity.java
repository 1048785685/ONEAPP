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
import android.util.Log;
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
import com.soully.oneapp.Fragment.FragmentWait;

import java.io.BufferedReader;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
     Fragment currentFragment = new Fragment();
    private NavigationView navigationView;
   FragmentOne FragmentOne =new FragmentOne();
FragmentTwo FragmentTwo =new FragmentTwo();
 FragmentThree FragmentThree =new FragmentThree();
FragmentFour FragmentFour =new FragmentFour();
    FragmentManager fragmentManager;
//    private Fragment FragmentWait = new FragmentWait();
//    Fragment from=manager.findFragmentById(R.id.content_frame);
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        currentFragment = FragmentOne;
        transaction.add(R.id.fragment, FragmentOne).show(FragmentOne).commit();
        Log.d("current",currentFragment+"");
//        Log.d("current",FragmentOne+"");
//        Log.d("current",FragmentTwo+"");
//        Log.d("current",FragmentThree+"");
//        Log.d("current",FragmentFour+"");


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

        ACache aCache = ACache.get(this);
        aCache.put("image","http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");

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
//                showFragment(FragmentWait);
                showFragment(FragmentOne);
                break;
            case R.id.tab_1:
                showFragment(FragmentTwo);
                break;
            case R.id.tab_2:
                showFragment(FragmentThree);
                break;
            case R.id.tab_3:
                showFragment(FragmentFour);
                break;
        }
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
    private void showFragment(Fragment fragment) {
        Log.d("current",currentFragment+"");
        if (currentFragment!=fragment) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.hide(currentFragment);
            currentFragment = fragment;
            if (!fragment.isAdded()) {
                transaction.add(R.id.fragment, fragment).show(fragment).commit();
            } else {
                transaction.show(fragment).commit();
            }
        }
        Log.d("current",currentFragment+"");
    }



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
