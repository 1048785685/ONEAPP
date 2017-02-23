package com.soully.oneapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by Soully on 2017/2/18.
 */

public class Find extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find);
        Button button = (Button) findViewById(R.id.find_sousuo);
        EditText editText = (EditText) findViewById(R.id.find_shuru);
    }
}
