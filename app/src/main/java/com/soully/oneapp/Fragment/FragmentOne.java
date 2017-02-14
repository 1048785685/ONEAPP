package com.soully.oneapp.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.soully.oneapp.DividerItemDecoration;
import com.soully.oneapp.R;
import com.soully.oneapp.RecyclerViewAdapter.OneAdapter;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataOne;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataOneFirst;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataThree;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Soully on 2017/2/12.
 */

public class FragmentOne extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private List<RecyclerViewDataOne> dataOneList = new ArrayList<>();
    private List<RecyclerViewDataOneFirst> dataOneFirstList = new ArrayList<>();
    private OneAdapter oneAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentone,container,false);


        for (int i=0 ; i < 3; i++){
            RecyclerViewDataOne recyclerViewDataOne = new RecyclerViewDataOne();
            recyclerViewDataOne.setBiaoti("标题" + i);
            recyclerViewDataOne.setContent("内容" + i);
            recyclerViewDataOne.setTitle("Title" + i);
            recyclerViewDataOne.setWriter("writer" + i);
            recyclerViewDataOne.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
            dataOneList.add(recyclerViewDataOne);
        }
        RecyclerViewDataOneFirst recyclerViewDataOneFirst = new RecyclerViewDataOneFirst();
        recyclerViewDataOneFirst.setShouye_huihuazuozhe("作家");
        recyclerViewDataOneFirst.setShouye_image("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
        recyclerViewDataOneFirst.setShouye_suibi("随笔");
        recyclerViewDataOneFirst.setShouye_suibizuozhe("随笔作家");
        dataOneFirstList.add(recyclerViewDataOneFirst);


        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.one_swipe);
        swipeRefreshLayout.setOnRefreshListener(this);//注册点击监听事件
        swipeRefreshLayout.setColorSchemeColors(R.color.colorAccent, R.color.colorPrimary,
                R.color.colorPrimaryDark);//设置进度条的颜色

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_one);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL_LIST));//加分割线
//        ((SimpleItemAnimator)recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        linearLayoutManager = new LinearLayoutManager(view.getContext());//指定布局样式
        recyclerView.setLayoutManager(linearLayoutManager);//将布局加入到recyclerView中
        oneAdapter = new OneAdapter(dataOneList,dataOneFirstList);
        recyclerView.setAdapter(oneAdapter);
        return view;
    }

    /**
     * Called when a swipe gesture triggers a refresh.
     */
    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i=0 ; i < 3; i++){
                    RecyclerViewDataOne recyclerViewDataOne = new RecyclerViewDataOne();
                    recyclerViewDataOne.setBiaoti("One标题" + i);
                    recyclerViewDataOne.setContent("One内容" + i);
                    recyclerViewDataOne.setTitle("OneTitle" + i);
                    recyclerViewDataOne.setWriter("Onewriter" + i);
                    recyclerViewDataOne.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
                    dataOneList.add(1,recyclerViewDataOne);
                }
                swipeRefreshLayout.setRefreshing(false);
                oneAdapter.notifyDataSetChanged();
            }
        }, 500);
    }
}
