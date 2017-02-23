package com.soully.oneapp;


import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.soully.oneapp.db.NameDataBaseHelper;


/**
 * Created by Soully on 2017/2/18.
 */

public class Sign_in extends AppCompatActivity{
    String account_data;
    String password_data;
   NameDataBaseHelper nameDataBaseHelper;
    EditText account;
    EditText password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sing_in);
         account = (EditText) findViewById(R.id.zhuce_account);
       password = (EditText) findViewById(R.id.zhuce_password);

        Button button = (Button) findViewById(R.id.zhuce_save);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                account_data = account.getText().toString();
//                password_data  = password.getText().toString();
//                SQLiteDatabase db = nameDataBaseHelper.getReadableDatabase();
//                ContentValues values = new ContentValues();
//                values.put("account",account_data);
//                values.put("password",password_data);
//                Log.d("XXX",account_data);
//                Log.d("XXX",password_data);
//                db.insert("Pass",null,values);

                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
    public void getName(NameDataBaseHelper name){
        this.nameDataBaseHelper = name;
    }
}
