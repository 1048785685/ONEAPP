package com.soully.oneapp.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.soully.oneapp.FirstActivity;
import com.soully.oneapp.Gson.yingshi.ID.Detail.Details;
import com.soully.oneapp.Gson.yingshi.ID.ID;
import com.soully.oneapp.HttpUtil.HttpUtil;
import com.soully.oneapp.MainActivity;
import com.soully.oneapp.R;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Soully on 2017/2/14.
 */

public class FragmentWait extends Fragment{
    ProgressDialog progressDialog;
    String[] ids = new String[30];
    String[] title = new String[30];
    String[] image = new String[30];
    String[] writer = new String[30];
    String[] content = new String[30];
    String[] url = new String[30];
    private FragmentManager manager;
    private FragmentTransaction ft;
    FragmentFour fragmentFour = new FragmentFour();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       final View view = inflater.inflate(R.layout.fragment_wait,container,false);
        showProgressDialog();
        manager = getFragmentManager();
        ft = manager.beginTransaction();
        Timer timer = new Timer();
        TimerTask tast = new TimerTask() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putStringArray("title",title);
                bundle.putStringArray("image",image);
                bundle.putStringArray("writer",writer);
                bundle.putStringArray("content",content);
                bundle.putStringArray("url",url);
                fragmentFour.setArguments(bundle);
                ft.replace(R.id.fragment, fragmentFour);
                ft.commit();
//                Intent intent = new Intent();
//                intent.setClass(getActivity(), FragmentFour.class);

//                String[] title = new String[30];
//                String[] image = new String[30];
//                String[] writer = new String[30];
//                String[] content = new String[30];
//                String[] url = new String[30];

//                intent.putExtras(bundle);
                closeProgressDialog();
//                startActivity(intent);
            }
        };
        timer.schedule(tast, 5000);

        HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/movie/list/0", new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(view.getContext(),"网络请求错误，请连接网络重试",Toast.LENGTH_LONG).show();
                closeProgressDialog();

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                Gson gson = new Gson();
                ID id = gson.fromJson(responseData,ID.class);
                for (int i = 0 ; i<id.getData().size();i++){
                    ids[i] = id.getData().get(i).getId();
                }
                Log.d("XXXXXX",ids[19]);
                getDetail();
            }
        });

        return view;
    }
    private void showProgressDialog(){
        if (progressDialog == null){
            progressDialog = new ProgressDialog(this.getContext());
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
    private void  getDetail(){
        for (int i = 0; i<20;i++){
            final int x = i;
            HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/movie/detail/"+ids[i], new okhttp3.Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Toast.makeText(getContext(),"网络请求错误，请连接网络重试",Toast.LENGTH_LONG).show();
                    closeProgressDialog();
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String responseData = response.body().string();
                    Gson gson = new Gson();
                    Details details = gson.fromJson(responseData,Details.class);
                    image[x] = details.getData().getDetailcover();
                    writer[x] = details.getData().getShareList().getWx().getDesc();
                    title[x] = details.getData().getTitle();
                    content[x] = details.getData().getOfficialstory();
                    url[x] = details.getData().getWebUrl();
                    Log.d("KKKK",url[x]);
                    Log.d("KKKK",content[x]);
                    Log.d("KKKK",title[x]);
                }
            });
        }

    }
}
