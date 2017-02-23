package com.soully.oneapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.soully.oneapp.db.NameDataBaseHelper;

import java.util.List;

/**
 * Created by Soully on 2017/2/18.
 */

public class Pass extends AppCompatActivity implements View.OnClickListener {
    String account_data;
    String pass_data;
    NameDataBaseHelper nameDataBaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pass);

        Button button = (Button) findViewById(R.id.denglu);
        EditText account = (EditText) findViewById(R.id.account);
        EditText password = (EditText) findViewById(R.id.password);
        TextView zhuce = (TextView) findViewById(R.id.zhuce);
        account_data = account.getText().toString();
        pass_data = password.getText().toString();
        zhuce.setOnClickListener(this);
        button.setOnClickListener(this);
//        List<Name> names = DataSupport.findAll(Name.class);
//        Log.d("xxxx",names.get(1).getName());
//        Log.d("xxxx",names.get(1).getMima());
    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.zhuce:
               Intent intent = new Intent(Pass.this,Sign_in.class);
               startActivityForResult(intent,1);
               break;
           case R.id.denglu:
//               SQLiteDatabase db =  name.getReadableDatabase();
//               Cursor cursor = db.query("Pass",null,null,null,null,null,null);
//               if (cursor.moveToFirst()){
//                   do{
//                       if (account_data == cursor.getString(cursor.getColumnIndex("account"))
//                               && pass_data == cursor.getString(cursor.getColumnIndex("password"))){
//                           Log.d("XXXXXXXX",cursor.getString(cursor.getColumnIndex("account")));
//                           Log.d("XXXXXXXX",cursor.getString(cursor.getColumnIndex("password")));
                           Intent intent1 = new Intent();
                           setResult(RESULT_OK,intent1);
                           finish();
//                       }
//                   }while (cursor.moveToFirst());
//               }{
//           }
               break;
       }
    }
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
                }
        }
    }
    public void getName(NameDataBaseHelper name){
        this.nameDataBaseHelper = name;
    }
}