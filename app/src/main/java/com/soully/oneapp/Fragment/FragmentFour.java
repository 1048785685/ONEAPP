package com.soully.oneapp.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.soully.oneapp.DividerItemDecoration;
import com.soully.oneapp.R;
import com.soully.oneapp.RecyclerViewAdapter.FourAdapter;
import com.soully.oneapp.RecyclerViewAdapter.OneAdapter;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataFour;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataOne;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataTwo;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Soully on 2017/2/12.
 */

public class FragmentFour extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private List<RecyclerViewDataFour> dataFourList = new ArrayList<>();
    private FourAdapter fourAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentfour,container,false);


        for (int i=0;i<3;i++){
            RecyclerViewDataFour recyclerViewDataFour = new RecyclerViewDataFour();
            recyclerViewDataFour.setBiaoti("标题" + i);
            recyclerViewDataFour.setContent("内容" + i);
            recyclerViewDataFour.setTitle("Title" + i);
            recyclerViewDataFour.setWriter("writer" + i);
            recyclerViewDataFour.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
            dataFourList.add(recyclerViewDataFour);
        }
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.four_swipe);
        swipeRefreshLayout.setOnRefreshListener(this);//注册点击监听事件
        swipeRefreshLayout.setColorSchemeColors(R.color.colorAccent, R.color.colorPrimary,
                R.color.colorPrimaryDark);//设置进度条的颜色

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_four);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL_LIST));//加分割线
        linearLayoutManager = new LinearLayoutManager(view.getContext());//指定布局样式
        recyclerView.setLayoutManager(linearLayoutManager);//将布局加入到recyclerView中
        fourAdapter = new FourAdapter(dataFourList);
        recyclerView.setAdapter(fourAdapter);

        /*
        上拉加载
        */
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastVisibleItem = -1;
            @Override
            public void onScrollStateChanged(final RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if ( newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == fourAdapter.getItemCount()) {
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            for (int i=0;i<3;i++){
                                RecyclerViewDataFour recyclerViewDataFour = new RecyclerViewDataFour();
                                recyclerViewDataFour.setBiaoti("上拉标题" + i);
                                recyclerViewDataFour.setContent("上拉内容" + i);
                                recyclerViewDataFour.setTitle("上拉Title" + i);
                                recyclerViewDataFour.setWriter("上拉writer" + i);
                                recyclerViewDataFour.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
                                dataFourList.add(recyclerViewDataFour);
                            }
                            swipeRefreshLayout.setRefreshing(false);
                            fourAdapter.notifyDataSetChanged();
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
                for (int i=0;i<3;i++){
                    RecyclerViewDataFour recyclerViewDataFour = new RecyclerViewDataFour();
                    recyclerViewDataFour.setBiaoti("下拉标题" + i);
                    recyclerViewDataFour.setContent("下拉内容" + i);
                    recyclerViewDataFour.setTitle("下拉Title" + i);
                    recyclerViewDataFour.setWriter("下拉writer" + i);
                    recyclerViewDataFour.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
                    dataFourList.add(0,recyclerViewDataFour);
                }
                swipeRefreshLayout.setRefreshing(false);
                fourAdapter.notifyDataSetChanged();
            }
        }, 500);
    }
}
