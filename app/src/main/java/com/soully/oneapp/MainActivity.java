package com.soully.oneapp;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.soully.oneapp.Fragment.FragmentFour;
import com.soully.oneapp.Fragment.FragmentOne;
import com.soully.oneapp.Fragment.FragmentThree;
import com.soully.oneapp.Fragment.FragmentTwo;
import com.soully.oneapp.Fragment.FragmentWait;

import com.soully.oneapp.Gson.yingshi.ID.Detail.Details;
import com.soully.oneapp.Gson.yingshi.ID.ID;
import com.soully.oneapp.Gson.yinyue.MusicDate.MusicDate;
import com.soully.oneapp.Gson.yinyue.MusicDetail.MusiciDetail;
import com.soully.oneapp.Gson.yuedu.Essay.Essay;
import com.soully.oneapp.Gson.yuedu.Serial.Serial;
import com.soully.oneapp.Gson.yuedu.SerialDetail.SerialDetail;
import com.soully.oneapp.Gson.yuedu.ShortDetail.ShortDetail;
import com.soully.oneapp.HttpUtil.HttpUtil;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    Fragment currentFragment = new Fragment();
    private NavigationView navigationView;
    FragmentOne FragmentOne =new FragmentOne();
    FragmentTwo FragmentTwo =new FragmentTwo();
    FragmentThree FragmentThree =new FragmentThree();
    FragmentFour FragmentFour =new FragmentFour();
    FragmentManager fragmentManager;
    private DrawerLayout drawerLayout;
    private int click = 0;
    int k =0 ;
    int p = 0;
    ProgressDialog progressDialog;
    int four = 0;
    int two = 0;
    int three = 0;
    String[] fourids = new String[100];
    String[] essayids = new String[100];
    String[] serialids = new String[100];
    String[] threeids = new String[100];

    JSONArray essaytitle = new JSONArray();
    JSONArray essayimage  = new JSONArray();
    JSONArray essaywriter  = new JSONArray();
    JSONArray essaycontent  = new JSONArray();
    JSONArray essayurl = new JSONArray();

    String serialtitle;
    String  serialimage;
    String serialwriter ;
    String serialcontent ;
    String  serialurl ;

    JSONArray threetitle = new JSONArray();
    JSONArray threeimage  = new JSONArray();
    JSONArray threewriter  = new JSONArray();
    JSONArray threecontent  = new JSONArray();
    JSONArray threeurl = new JSONArray();

    JSONArray fourtitle = new JSONArray();
    JSONArray fourimage  = new JSONArray();
    JSONArray fourwriter  = new JSONArray();
    JSONArray fourcontent  = new JSONArray();
    JSONArray foururl = new JSONArray();
    ACache aCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aCache = ACache.get(this);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        currentFragment = FragmentOne;
        transaction.add(R.id.fragment, FragmentOne).show(FragmentOne).commit();
        Log.d("current",currentFragment+"");



        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headview = navigationView.getHeaderView(0);
        ImageView icon = (ImageView) headview.findViewById(R.id.icon_image);
        icon.setOnClickListener(this);
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
        TextView textView = (TextView) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
          getSupportActionBar().setDisplayShowTitleEnabled(false);
            textView.setText("One&一个");
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
                        break;
                    case R.id.tianqi:
                        Intent intent1 = new Intent();
                        intent1.setClass(MainActivity.this, Tianqian.class);
                        startActivity(intent1);
                        break;
//                    case R.id.icon_image:
//                        if (click ==0)
//                        {
//                            Log.d("点击成功",click+"");
//                        Intent intent1 = new Intent(MainActivity.this,Pass.class);
//                        startActivityForResult(intent1,1);
//                        }else {
//                            Log.d("点击成功",click+"");
//                            Toast.makeText(MainActivity.this,"已经登录成功",Toast.LENGTH_SHORT).show();
//                        }
//                        break;
                }
                return true;
            }
        });

    }
 @Override
 public void onActivityResult(int requestCode,int resultCode,Intent data){
     switch (resultCode){
         case 2:
             click = 1;
             break;
         default:
     }
 }
    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.tab_0:
//                showFragment(FragmentWait);
                showFragment(FragmentOne);
                break;
            case R.id.tab_1:

                if (two == 0){
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.hide(currentFragment);
                    transaction.commit();
                    showProgressDialog();
                    two = 1;
                    HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/essay/bymonth/2017-02", new okhttp3.Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),"网络连接不稳定，请连接后重试",Toast.LENGTH_SHORT).show();
                                    two = 0;
                                    closeProgressDialog();
                                }
                            });

                        }
                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String responseData = response.body().string();
                            Gson gson = new Gson();
                            Essay essay = gson.fromJson(responseData, Essay.class);
                            for (int i = 0 ; i<essay.getData().size();i++,k++){
                                essayids[i] = essay.getData().get(i).getContentId();
                            }
                            Log.d("XXXXXX",essayids[19]);
                            getShortDetail();
                        }
                    });
                    HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/serialcontent/$%7Bid%7D", new okhttp3.Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    Toast.makeText(getApplicationContext(),"网络连接不稳定，请连接后重试",Toast.LENGTH_SHORT).show();
//                                    two = 0;
//                                    closeProgressDialog();
//                                }
//                            });
                        }
                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String responseData = response.body().string();
                            Gson gson = new Gson();
                            SerialDetail serialDetail = gson.fromJson(responseData, SerialDetail.class);
                            serialtitle = serialDetail.getData().getTitle();
                            serialcontent = serialDetail.getData().getExcerpt();
                            serialimage = serialDetail.getData().getAuthor().getWebUrl();
                            serialurl = serialDetail.getData().getWebUrl();
                            serialwriter = serialDetail.getData().getShareList().getWx().getDesc();
                        }
                    });
                    Timer timer = new Timer();
                    TimerTask tast = new TimerTask() {
                        @Override
                        public void run() {
                            aCache.put("essayimage",essayimage);
                            aCache.put("essaytitle",essaytitle);
                            aCache.put("essaycontent",essaycontent);
                            aCache.put("essayurl",essayurl);
                            aCache.put("essaywriter",essaywriter);
                            aCache.put("serialurl",serialurl);
                            aCache.put("serialwriter",serialwriter);
                            aCache.put("serialtitle", serialtitle);
                            aCache.put("serialcontent",serialcontent);
                            aCache.put("serialimage",serialimage);
                            showFragment(FragmentTwo);
                            closeProgressDialog();
                        }
                    };
                    timer.schedule(tast, 3000);
                }
                else {
                    showFragment(FragmentTwo);
                }

                break;
            case R.id.tab_2:
                if (three == 0){
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.hide(currentFragment);
                    transaction.commit();
                    showProgressDialog();
                    three = 1;
                    HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/music/bymonth/2017-02", new okhttp3.Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            //Toast.makeText(view.getContext(),"网络请求错误，请连接网络重试",Toast.LENGTH_LONG).show();
//                            closeProgressDialog();
//                            showFragment(currentFragment);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),"网络连接不稳定，请连接后重试",Toast.LENGTH_SHORT).show();
                                    three = 0;
                                    closeProgressDialog();
                                }
                            });

                        }
                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String responseData = response.body().string();
                            Gson gson = new Gson();
                            MusicDate musicDate = gson.fromJson(responseData,MusicDate.class);
                            for (int i = 0 ; i<musicDate.getData().size();i++,p++){
                                threeids[i] = musicDate.getData().get(i).getId();
                            }
                            Log.d("XXXXXX",threeids[19]);
                            getthreeDetail();
                        }
                    });
                    Timer timer = new Timer();
                    TimerTask tast = new TimerTask() {
                        @Override
                        public void run() {
                            aCache.put("image",threeimage);
                            aCache.put("title",threetitle);
                            aCache.put("content",threecontent);
                            aCache.put("url",threeurl);
                            aCache.put("writer",threewriter);
                            showFragment(FragmentThree);
                            closeProgressDialog();
                        }
                    };
                    timer.schedule(tast,3000);
                }
                else {
                    showFragment(FragmentThree);
                }

                break;
            case R.id.tab_3:
                if (four == 0){
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.hide(currentFragment);
                    transaction.commit();
                    showProgressDialog();
                    four = 1;
                    HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/movie/list/$%7Bid%7D", new okhttp3.Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
//                            Toast.makeText(view.getContext(),"网络请求错误，请连接网络重试",Toast.LENGTH_LONG).show();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),"网络连接不稳定，请连接后重试",Toast.LENGTH_SHORT).show();
                                    four = 0;
                                    closeProgressDialog();
//                                    FragmentTransaction transaction = fragmentManager.beginTransaction();
//                                    transaction.show(currentFragment);
//                                    transaction.commit();
                                }
                            });

                        }
                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String responseData = response.body().string();
                            Gson gson = new Gson();
                            ID id = gson.fromJson(responseData,ID.class);
                            for (int i = 0 ; i<id.getData().size();i++){
                                fourids[i] = id.getData().get(i).getId();
                            }
                            Log.d("XXXXXX",fourids[19]);
                            getfourDetail();
                        }
                    });
                    Timer timer = new Timer();
                    TimerTask tast = new TimerTask() {
                        @Override
                        public void run() {
                            aCache.put("image",fourimage);
                            aCache.put("title",fourtitle);
                            aCache.put("content",fourcontent);
                            aCache.put("url",foururl);
                            aCache.put("writer",fourwriter);
                            showFragment(FragmentFour);
                            closeProgressDialog();
                        }
                    };
                    timer.schedule(tast, 3000);
                }
                else {
                showFragment(FragmentFour);
                }

//                showProgressDialog();
//                HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/movie/list/0", new okhttp3.Callback() {
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//                        Toast.makeText(MainActivity.this,"网络请求错误，请连接网络重试",Toast.LENGTH_LONG).show();
//                        closeProgressDialog();
//                    }
//                    @Override
//                    public void onResponse(Call call, Response response) throws IOException {
//                        String responseData = response.body().string();
//                        Gson gson = new Gson();
//                        ID id = gson.fromJson(responseData,ID.class);
//                        for (int i = 0 ; i<id.getData().size();i++){
//
//                        }
//                    }
//                });
                break;
            case R.id.icon_image:
                Log.d("点击成功",click+"");
                        if (click ==0)
                        {
                            click  = click+1;
                            Log.d("点击成功",click+"");
                        Intent intent1 = new Intent(MainActivity.this,Pass.class);
                        startActivityForResult(intent1,2);
                        }else {
                            Log.d("点击成功",click+"");
                            Toast.makeText(MainActivity.this,"已经登录成功",Toast.LENGTH_SHORT).show();
                        }
                break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK )
        {
            // 创建退出对话框
            AlertDialog isExit = new AlertDialog.Builder(this).create();
            // 设置对话框标题
            isExit.setTitle("系统提示");
            // 设置对话框消息
            isExit.setMessage("确定要退出吗");
            // 添加选择按钮并注册监听
            isExit.setButton("确定", listener);
            isExit.setButton2("取消", listener);
            // 显示对话框
            isExit.show();

        }
        return false;
    }
    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener()
    {
        public void onClick(DialogInterface dialog, int which)
        {
            switch (which)
            {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
                    int sdk_Version = android.os.Build.VERSION.SDK_INT;
                    if (sdk_Version >= 8) {
                        Intent startMain = new Intent(Intent.ACTION_MAIN);
                        startMain.addCategory(Intent.CATEGORY_HOME);
                        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(startMain);
                        System.exit(0);
                    } else if (sdk_Version < 8) {
                        ActivityManager activityMgr = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                        activityMgr.restartPackage(getPackageName());
                    }
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
                default:
                    break;
            }
        }
    };

    public void getShortDetail() {
        for (int i = 0; i < k; i++) {
            HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/essay/" + essayids[i], new okhttp3.Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    //Toast.makeText(getBaseContext(),"网络请求错误，请连接网络重试",Toast.LENGTH_LONG).show();
//                    closeProgressDialog();
//                    showFragment(currentFragment);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Gson gson = new Gson();
                    String Data = response.body().string();
                    ShortDetail shortDetail = gson.fromJson(Data, ShortDetail.class);
                    essaytitle.put(shortDetail.getData().getHpTitle());
                    essaycontent.put(shortDetail.getData().getGuideWord());
                    essaywriter.put(shortDetail.getData().getHpAuthor());
                    essayimage.put(shortDetail.getData().getAuthor().get(0).getWebUrl());
                    essayurl.put(shortDetail.getData().getWebUrl());
                }
            });
        }
    }
    public  void getthreeDetail(){
        for(int i = 0;i<p;i++)

            HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/music/detail/"+threeids[i], new okhttp3.Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Toast.makeText(getBaseContext(),"网络请求错误，请连接网络重试",Toast.LENGTH_LONG).show();
                    closeProgressDialog();
                    showFragment(currentFragment);
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String responseData=response.body().string();
                    Gson gson=new Gson();
                    MusiciDetail musicDetail=gson.fromJson(responseData,MusiciDetail.class);
                    threetitle.put(musicDetail.getData().getStoryTitle());
                    threecontent.put(musicDetail.getData().getStorySummary());
                    threewriter.put(musicDetail.getData().getAuthor().getUserName());
                    threeimage.put(musicDetail.getData().getCover());
                    //.put(musicDetail.getData().getMusicId());
                    threeurl.put(musicDetail.getData().getWebUrl());
                    Log.d("---------getDetail---",musicDetail.getData().getStoryTitle());
                }
            });
    }
    private void  getfourDetail(){
        for (int i = 0; i<20;i++){
            HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/movie/detail/"+fourids[i], new okhttp3.Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Toast.makeText(getBaseContext(),"网络请求错误，请连接网络重试",Toast.LENGTH_LONG).show();
                    closeProgressDialog();
                    showFragment(currentFragment);
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String responseData = response.body().string();
                    Gson gson = new Gson();
                    Details details = gson.fromJson(responseData,Details.class);
                    fourimage.put(details.getData().getDetailcover());
                    fourwriter.put(details.getData().getShareList().getWx().getDesc());
                    fourtitle.put(details.getData().getTitle());
                    fourcontent.put(details.getData().getOfficialstory());
                    foururl.put(details.getData().getWebUrl());
//                    Log.d("KKKK",foururl[x]);
//                    Log.d("KKKK",fourcontent[x]);

                }
            });
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
            case R.id.toolbar_sousuo:
                Intent intent = new Intent(MainActivity.this,Find.class);
                startActivity(intent);
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
private void showProgressDialog(){
    if (progressDialog == null){
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在加载...");
        progressDialog.setCanceledOnTouchOutside(false);
    }
    progressDialog.show();
}
private void closeProgressDialog(){
    if (progressDialog!=null){
        progressDialog.dismiss();
    }
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
