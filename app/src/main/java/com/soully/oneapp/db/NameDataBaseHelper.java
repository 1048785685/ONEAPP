package com.soully.oneapp.db;

/**
 * Created by Soully on 2017/2/21.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Soully on 2017/2/18.
 */

public class NameDataBaseHelper extends SQLiteOpenHelper{
    public static final String Create_PassTwo = "create table PassTwo(account text,password text)";

    public NameDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }


    private Context mContext;
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Create_PassTwo);
        Toast.makeText(mContext,"Create succeeded",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}