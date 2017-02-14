package com.soully.oneapp.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.soully.oneapp.ACache;
import com.soully.oneapp.DividerItemDecoration;
import com.soully.oneapp.R;
import com.soully.oneapp.RecyclerViewAdapter.OneAdapter;
import com.soully.oneapp.RecyclerViewAdapter.TwoAdapter;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataOne;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataThree;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataTwo;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Soully on 2017/2/12.
 */

public class FragmentTwo extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private List<RecyclerViewDataTwo> dataTwoList = new ArrayList<>();
    private TwoAdapter twoAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    String pic;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenttwo,container,false);
       ACache aCache = ACache.get(this.getContext());
        pic = aCache.getAsString("image");
        for (int i=0;i < 3;i++){
            RecyclerViewDataTwo recyclerViewDataTwo = new RecyclerViewDataTwo();
            recyclerViewDataTwo.setBiaoti("Two标题" + i);
            recyclerViewDataTwo.setContent("Two内容" + i);
            recyclerViewDataTwo.setTitle("TwoTitle" + i);
            recyclerViewDataTwo.setWriter("Twowriter" + i);
            recyclerViewDataTwo.setImage(pic);
            dataTwoList.add(recyclerViewDataTwo);
        }
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.two_swipe);
        swipeRefreshLayout.setOnRefreshListener(this);//注册点击监听事件
        swipeRefreshLayout.setColorSchemeColors(R.color.colorAccent, R.color.colorPrimary,
                R.color.colorPrimaryDark);//设置进度条的颜色

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_two);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL_LIST));//加分割线
//        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        linearLayoutManager = new LinearLayoutManager(view.getContext());//指定布局样式
        recyclerView.setLayoutManager(linearLayoutManager);//将布局加入到recyclerView中
        twoAdapter = new TwoAdapter(dataTwoList);
        recyclerView.setAdapter(twoAdapter);
        /*
        上拉加载
        */
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastVisibleItem = -1;
            @Override
            public void onScrollStateChanged(final RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if ( newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == twoAdapter.getItemCount()) {
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            for (int i=0;i < 3;i++){
                                RecyclerViewDataTwo recyclerViewDataTwo = new RecyclerViewDataTwo();
                                recyclerViewDataTwo.setBiaoti("上拉标题" + i);
                                recyclerViewDataTwo.setContent("上拉内容" + i);
                                recyclerViewDataTwo.setTitle("上拉Title" + i);
                                recyclerViewDataTwo.setWriter("上拉writer" + i);
                                recyclerViewDataTwo.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
                                dataTwoList.add(recyclerViewDataTwo);
                            }
                            swipeRefreshLayout.setRefreshing(false);
                            twoAdapter.notifyDataSetChanged();
                        }
                    }, 1000);
                }
            }

            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            }

        });
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
                for (int i=0;i < 3;i++){
                    RecyclerViewDataTwo recyclerViewDataTwo = new RecyclerViewDataTwo();
                    recyclerViewDataTwo.setBiaoti("下拉标题" + i);
                    recyclerViewDataTwo.setContent("下拉内容" + i);
                    recyclerViewDataTwo.setTitle("下拉Title" + i);
                    recyclerViewDataTwo.setWriter("下拉writer" + i);
                    recyclerViewDataTwo.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
                    dataTwoList.add(0,recyclerViewDataTwo);
                }
                swipeRefreshLayout.setRefreshing(false);
                twoAdapter.notifyDataSetChanged();
            }
        }, 500);
    }

}
