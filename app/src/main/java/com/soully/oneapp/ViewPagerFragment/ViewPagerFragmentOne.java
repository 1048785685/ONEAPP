package com.soully.oneapp.ViewPagerFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.os.Handler;
import android.view.ViewGroup;

import com.soully.oneapp.ACache;
import com.soully.oneapp.DividerItemDecoration;
import com.soully.oneapp.R;
import com.soully.oneapp.RecyclerViewAdapter.OneAdapter;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataOne;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataOneFirst;
import com.soully.oneapp.YeMian.YemianFive;
import com.soully.oneapp.YeMian.YemianFour;
import com.soully.oneapp.YeMian.YemianOne;
import com.soully.oneapp.YeMian.YemianSix;
import com.soully.oneapp.YeMian.YemianThree;
import com.soully.oneapp.YeMian.YemianTwo;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Soully on 2017/2/15.
 */

public class ViewPagerFragmentOne extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private List<RecyclerViewDataOne> dataOneList = new ArrayList<>();
    private List<RecyclerViewDataOneFirst> dataOneFirstList = new ArrayList<>();
    private OneAdapter oneAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ViewPager viewPager;
    ACache aCache;
    JSONArray jsonArrayshouyequestionid = new JSONArray();
    JSONArray jsonArrayshouyequestiontitle = new JSONArray();
    JSONArray jsonArrayshouyequestioncontent = new JSONArray();
    JSONArray jsonArrayshouyequestionname = new JSONArray();
    JSONArray jsonArrayshouyequestionimage = new JSONArray();
    JSONArray jsonArrayhpcontent =  new JSONArray();
    JSONArray jsonArrayhpImfUrl =  new JSONArray();
    JSONArray jsonArrayhpAuthor =  new JSONArray();
    JSONArray jsonArrayhpTextAuthors=  new JSONArray();
    JSONArray jsonArrayshouyeessayID = new JSONArray();
    JSONArray jsonArrayshouyeessaytitle = new JSONArray();
    JSONArray jsonArrayshouyeessayword = new JSONArray();
    JSONArray jsonArrayshouyeessayzuozhe = new JSONArray();
    JSONArray jsonArrayshouyeessayzuozheimage = new JSONArray();
    JSONArray jsonArrayshouyeserialId = new JSONArray();
    JSONArray jsonArrayshouyeserialtitle = new JSONArray();
    JSONArray jsonArrayshouyeserialword = new JSONArray();
    JSONArray jsonArrayshouyeserialname = new JSONArray();
    JSONArray jsonArrayshouyeserialuserimage = new JSONArray();
    //JSONArray jsonArrayshouyeID = new JSONArray();
    //JSONArray jsonArraypraisenum = new JSONArray();
    //JSONArray jsonArraysharenum = new JSONArray();
    //JSONArray jsonArrayshouyeessaytime = new JSONArray();
    //JSONArray jsonArrayshouyequestiontime = new JSONArray();
    // JSONArray jsonArrayshouyeserialreadnum = new JSONArray();
    //JSONArray jsonArrayshouyeserialtime = new JSONArray();
    //String[] shouyeID = new String [10];
    String[] hpcontent = new String [10];
    String[] hpImfUrl = new String[10];
    String[] hpAuthor = new String[10];
    String[] hpTextAuthors = new String[10];
    String[] shouyeessayID = new String[10];
    String[] shouyeessaytitle = new String[10];
    String[] shouyeessayword = new String[10];//首页随笔
    String[] shouyeessayzuozhe = new String[10];
    String[] shouyeessayzuozheimage = new String[10];//作者的头像
    String[] shouyeserialId = new String[10];
    String[] shouyeserialtitle = new String[10];
    String[] shouyeserialword = new String[10];
    String[] shouyeserialname = new String[10];
    String[] shouyeserialuserimage = new String[10];
    String[] shouyequestionid =new String[10];
    String[] shouyequestiontitle = new String[10];
    String[] shouyequestioncontent =new String[10];
    String[] shouyequestionname =new String[10];
    String[] shouyequestionimage =new String[10];
    //int[] praisenum = new int[10];
//int[] sharenum = new int[10];
    //String[] shouyeessaytime = new String[10];
    //String[] shouyequestiontime =new String[10];
    //String[] shouyeserialreadnum = new String[10];
//String[] shouyeserialtime = new String[10];


    int k = 1;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewpager_one,container,false);

        getData();
//        for (int i =0;i<3;i++){
//        RecyclerViewDataOne recyclerViewDataOne = new RecyclerViewDataOne();
//            recyclerViewDataOne.setBiaoti("PageOne标题" + i);
//            recyclerViewDataOne.setContent("PageOne内容" + i);
//            recyclerViewDataOne.setTitle("PageOneTitle" + i);
//            recyclerViewDataOne.setWriter("PageOnewriter" + i);
//            recyclerViewDataOne.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
//            dataOneList.add(recyclerViewDataOne);
//        }
//        SharedPreferences sharedPreferences =this.getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
//        try {
//            jsonArrayhpcontent = new JSONArray(sharedPreferences.getString("hpcontent", "[]"));
//            jsonArrayhpAuthor = new JSONArray(sharedPreferences.getString("hpauthor","[]"));
//            jsonArrayhpImfUrl = new JSONArray(sharedPreferences.getString("hpimfurl","[]"));
//            jsonArrayhpTextAuthors = new JSONArray(sharedPreferences.getString("hptextauthors","[]"));
//            for (int i = 0;i<jsonArrayhpcontent.length();i++){
//                hpcontent[i] = jsonArrayhpcontent.get(i).toString();
//                hpImfUrl[i] = jsonArrayhpImfUrl.getString(i);
//                hpAuthor[i] = jsonArrayhpAuthor.getString(i);
//                hpTextAuthors[i] = jsonArrayhpTextAuthors.getString(i);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
       addViewdate();


        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.one_swipe);
        swipeRefreshLayout.setOnRefreshListener(this);//注册点击监听事件
        swipeRefreshLayout.setColorSchemeColors(R.color.colorAccent, R.color.colorPrimary,
                R.color.colorPrimaryDark);//设置进度条的颜色
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_one);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL_LIST));//加分割线;
        linearLayoutManager = new LinearLayoutManager(view.getContext());//指定布局样式
        recyclerView.setLayoutManager(linearLayoutManager);//将布局加入到recyclerView中
        oneAdapter = new OneAdapter(dataOneList,dataOneFirstList);
        recyclerView.setAdapter(oneAdapter);
        oneAdapter.setOnRecycleViewListener(new OneAdapter.OnRecycleViewListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("XXXX",position+"");

                if (position == 7){
                    viewPager.setCurrentItem(1);
                }else if(position == 0){

                }else if (position ==1){
                    Intent intent = new Intent(view.getContext(), YemianOne.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("idone"+k, Integer.parseInt(shouyeessayID[0]));
                  Log.d("XXXXXXXXXXXXXXXXXXX","idone"+k);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else if (position==2){
                    Intent intent = new Intent(view.getContext(), YemianTwo.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("idtwo"+k, Integer.parseInt(shouyeessayID[1]));

                    intent.putExtras(bundle);
                    startActivity(intent);
                }else if (position==3){
                    Intent intent = new Intent(view.getContext(), YemianThree.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("idthree"+k, Integer.parseInt(shouyeserialId[0]));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else if (position==4){
                    Intent intent = new Intent(view.getContext(), YemianFour.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("idfour"+k, Integer.parseInt(shouyeserialId[1]));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else if (position==5){
                    Intent intent = new Intent(view.getContext(), YemianFive.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("idfive"+k, Integer.parseInt(shouyequestionid[0]));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else if (position==6){
                    Intent intent = new Intent(view.getContext(), YemianSix.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("idsix"+k, Integer.parseInt(shouyequestionid[1]));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
        return view;
    }
    public void getViewpager(ViewPager viewPager){
        this.viewPager = viewPager;
    }

    /**
     * Called when a swipe gesture triggers a refresh.
     */
    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                for (int i=0 ; i < 3; i++){
//                    RecyclerViewDataOne recyclerViewDataOne = new RecyclerViewDataOne();
//                    recyclerViewDataOne.setBiaoti("PageOne标题" + i);
//                    recyclerViewDataOne.setContent("PageOne内容" + i);
//                    recyclerViewDataOne.setTitle("PageOneTitle" + i);
//                    recyclerViewDataOne.setWriter("PageOnewriter" + i);
//                    recyclerViewDataOne.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
//                    dataOneList.add(1,recyclerViewDataOne);
//                }
                swipeRefreshLayout.setRefreshing(false);
                oneAdapter.notifyDataSetChanged();
            }
        }, 500);
    }
    public void getData(){

        aCache = ACache.get(this.getContext());
        jsonArrayhpcontent = aCache.getAsJSONArray("hpcontent");
        jsonArrayhpImfUrl=aCache.getAsJSONArray("hpimfurl");
        jsonArrayhpAuthor=aCache.getAsJSONArray("hpauthor");
        jsonArrayhpTextAuthors=aCache.getAsJSONArray("hptextauthors");

        jsonArrayshouyeessayID=aCache.getAsJSONArray("shouyeessayid");
        jsonArrayshouyeessaytitle=aCache.getAsJSONArray("shouyeessaytitle");
        jsonArrayshouyeessayword=aCache.getAsJSONArray("shouyeessayword");
        jsonArrayshouyeessayzuozhe=aCache.getAsJSONArray("shouyeessayzuozhe");
        jsonArrayshouyeessayzuozheimage=aCache.getAsJSONArray("shouyeessayzuozheimage");

        jsonArrayshouyeserialId=aCache.getAsJSONArray("shouyeserialid");
        jsonArrayshouyeserialtitle=aCache.getAsJSONArray("shouyeserialtitle");
        jsonArrayshouyeserialword=aCache.getAsJSONArray("shouyeserialword");
        jsonArrayshouyeserialname=aCache.getAsJSONArray("shouyeserialname");
        jsonArrayshouyeserialuserimage=aCache.getAsJSONArray("shouyeserialuserimage");

        jsonArrayshouyequestionid=aCache.getAsJSONArray("shouyequestionid");
        jsonArrayshouyequestioncontent=aCache.getAsJSONArray("shouyequestioncontent");
        jsonArrayshouyequestiontitle=aCache.getAsJSONArray("shouyequestiontitle");
        jsonArrayshouyequestionimage=aCache.getAsJSONArray("shouyequestionimage");
        jsonArrayshouyequestionname=aCache.getAsJSONArray("shouyequestionname");

        for (int i =0 ; i<jsonArrayshouyeessaytitle.length();i++){
            try {
                hpcontent[i] = jsonArrayhpcontent.get(i).toString();
                hpImfUrl[i] = jsonArrayhpImfUrl.get(i).toString();
                hpAuthor[i] = jsonArrayhpAuthor.get(i).toString();
                hpTextAuthors[i] = jsonArrayhpTextAuthors.get(i).toString();

                shouyeessayID[i] = jsonArrayshouyeessayID.get(i).toString();
                shouyeessaytitle[i] = jsonArrayshouyeessaytitle.get(i).toString();
                shouyeessayword[i] = jsonArrayshouyeessayword.get(i).toString();
                shouyeessayzuozhe[i] = jsonArrayshouyeessayzuozhe.get(i).toString();
                shouyeessayzuozheimage[i] = jsonArrayshouyeessayzuozheimage.get(i).toString();

                shouyeserialId[i] = jsonArrayshouyeserialId.get(i).toString();
                shouyeserialtitle[i] = jsonArrayshouyeserialtitle.get(i).toString();
                shouyeserialword[i] = jsonArrayshouyeserialword.get(i).toString();
                shouyeserialname[i] = jsonArrayshouyeserialname.get(i).toString();
                shouyeserialuserimage[i] = jsonArrayshouyeserialuserimage.get(i).toString();

                shouyequestionid[i] =  jsonArrayshouyequestionid.get(i).toString();
                shouyequestioncontent[i] = jsonArrayshouyequestioncontent.get(i).toString();
                shouyequestiontitle[i] = jsonArrayshouyequestiontitle.get(i).toString();
                shouyequestionimage[i] = jsonArrayshouyequestionimage.get(i).toString();
                shouyequestionname[i] = jsonArrayshouyequestionname.get(i).toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
    public void addViewdate(){
        for (int i=0;i<8;i++){
            RecyclerViewDataOne recyclerViewDataOne = new RecyclerViewDataOne();
            Log.d("i为多少",i+"");
            if (i == 0) {
                Log.d("i为多少",0+"");
                recyclerViewDataOne.setBiaoti("PageOne标题" + i);
                recyclerViewDataOne.setContent("PageOne内容" + i);
                recyclerViewDataOne.setTitle("PageOneTitle" + i);
                recyclerViewDataOne.setWriter("PageOnewriter" + i);
                recyclerViewDataOne.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
            }
            if (i==1) {
                Log.d("i为多少",12+"");
                recyclerViewDataOne.setBiaoti("-阅读-");
                recyclerViewDataOne.setContent(shouyeessayword[i-1]);
                recyclerViewDataOne.setTitle(shouyeessaytitle[i-1]);
                recyclerViewDataOne.setWriter(shouyeessayzuozhe[i-1]);
                if (shouyeessayzuozheimage[i - 1] == null) {
                    recyclerViewDataOne.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
                } else {
                    recyclerViewDataOne.setImage(shouyeessayzuozheimage[i-1]);
                }
            }if(i==2){
                Log.d("i为多少",12+"");
                recyclerViewDataOne.setBiaoti("-阅读-");
                recyclerViewDataOne.setContent(shouyeessayword[i-1]);
                recyclerViewDataOne.setTitle(shouyeessaytitle[i-1]);
                recyclerViewDataOne.setWriter(shouyeessayzuozhe[i-1]);
                if (shouyeessayzuozheimage[i - 1] == null) {
                    recyclerViewDataOne.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
                } else {
                    recyclerViewDataOne.setImage(shouyeessayzuozheimage[i-1]);
                }
            }
            if (i==3) {
                Log.d("i为多少",34+"");
                recyclerViewDataOne.setBiaoti("-连载-");
                recyclerViewDataOne.setContent(shouyeserialword[i-3]);
                recyclerViewDataOne.setTitle(shouyeserialtitle[i-3]);
                recyclerViewDataOne.setWriter(shouyeserialname[i-3]);
                if (shouyeserialuserimage[i - 3] == null) {
                    recyclerViewDataOne.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
                } else {
                    recyclerViewDataOne.setImage(shouyeserialuserimage[i-3]);
                }
            }if (i==4){
                Log.d("i为多少",34+"");
                recyclerViewDataOne.setBiaoti("-连载-");
                recyclerViewDataOne.setContent(shouyeserialword[i-3]);
                recyclerViewDataOne.setTitle(shouyeserialtitle[i-3]);
                recyclerViewDataOne.setWriter(shouyeserialname[i-3]);
                if (shouyeserialuserimage[i - 3] == null) {
                    recyclerViewDataOne.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
                } else {
                    recyclerViewDataOne.setImage(shouyeserialuserimage[i-3]);
                }
            }if (i==5){
                Log.d("i为多少",56+"");
                recyclerViewDataOne.setBiaoti("-问答-");
                recyclerViewDataOne.setContent(shouyequestioncontent[i-5]);
                recyclerViewDataOne.setTitle(shouyequestiontitle[i-5]);
                recyclerViewDataOne.setWriter(shouyequestionname[i-5]);
                if (shouyequestionimage[i-5] == null)
                {
                    recyclerViewDataOne.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
                }else {
                    recyclerViewDataOne.setImage(shouyequestionimage[i-5]);
                }
            }if (i==6){
                Log.d("i为多少",56+"");
                recyclerViewDataOne.setBiaoti("-问答-");
                recyclerViewDataOne.setContent(shouyequestioncontent[i-5]);
                recyclerViewDataOne.setTitle(shouyequestiontitle[i-5]);
                recyclerViewDataOne.setWriter(shouyequestionname[i-5]);
                if (shouyequestionimage[i-5] == null)
                {
                    recyclerViewDataOne.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
                }else {
                    recyclerViewDataOne.setImage(shouyequestionimage[i-5]);
                }
            }
            dataOneList.add(recyclerViewDataOne);
        }
        RecyclerViewDataOneFirst recyclerViewDataOneFirst = new RecyclerViewDataOneFirst();
        recyclerViewDataOneFirst.setShouye_huihuazuozhe(hpAuthor[0]);
        if ( hpImfUrl[0] == null){
            recyclerViewDataOneFirst.setShouye_image("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
        }else {
            recyclerViewDataOneFirst.setShouye_image(hpImfUrl[0]);
        }
        recyclerViewDataOneFirst.setShouye_suibi(hpcontent[0]);
        recyclerViewDataOneFirst.setShouye_suibizuozhe( hpTextAuthors[0]);
        dataOneFirstList.add(recyclerViewDataOneFirst);

    }
}
