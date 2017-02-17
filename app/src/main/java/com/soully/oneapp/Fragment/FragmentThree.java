package com.soully.oneapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.soully.oneapp.DividerItemDecoration;
import com.soully.oneapp.R;
import com.soully.oneapp.RecyclerViewAdapter.ThreeAdapter;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataThree;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataTwo;

import java.util.ArrayList;
import java.util.List;
import android.os.Handler;
import android.widget.TextView;

/**
 * Created by Soully on 2017/2/12.
 */

public class FragmentThree extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private List<RecyclerViewDataThree> dataThreeList = new ArrayList<>();
    private ThreeAdapter threeAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentthree,container,false);



        for (int i=0;i<3;i++){
            RecyclerViewDataThree recyclerViewDataThree = new RecyclerViewDataThree();
            recyclerViewDataThree.setBiaoti("Three标题" + i);
            recyclerViewDataThree.setContent("Three内容" + i);
            recyclerViewDataThree.setTitle("ThreeTitle" + i);
            recyclerViewDataThree.setWriter("Threewriter" + i);
            recyclerViewDataThree.setMusicWriter("ThreemusicWriter" + i);
            recyclerViewDataThree.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
            dataThreeList.add(recyclerViewDataThree);
        }

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.three_swipe);
        swipeRefreshLayout.setOnRefreshListener(this);//注册点击监听事件
        swipeRefreshLayout.setColorSchemeColors(R.color.colorAccent, R.color.colorPrimary,
                R.color.colorPrimaryDark);//设置进度条的颜色

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_three);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL_LIST));//加分割线
//        ((SimpleItemAnimator)recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        linearLayoutManager = new LinearLayoutManager(view.getContext());//指定布局样式
        recyclerView.setLayoutManager(linearLayoutManager);//将布局加入到recyclerView中
        threeAdapter = new ThreeAdapter(dataThreeList);
        recyclerView.setAdapter(threeAdapter);

        /*
        上拉加载
        */
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastVisibleItem = -1;
            @Override
            public void onScrollStateChanged(final RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if ( newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == threeAdapter.getItemCount()) {
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            for (int i=0;i < 3;i++){
                                RecyclerViewDataThree recyclerViewDataThree = new RecyclerViewDataThree();
                                recyclerViewDataThree.setBiaoti("上拉标题" + i);
                                recyclerViewDataThree.setContent("上拉内容" + i);
                                recyclerViewDataThree.setTitle("上拉Title" + i);
                                recyclerViewDataThree.setWriter("上拉writer" + i);
                                recyclerViewDataThree.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
                                dataThreeList.add(recyclerViewDataThree);
                            }
                            swipeRefreshLayout.setRefreshing(false);
                            threeAdapter.notifyDataSetChanged();
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

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<3;i++){
                    RecyclerViewDataThree recyclerViewDataThree = new RecyclerViewDataThree();
                    recyclerViewDataThree.setBiaoti("下拉标题" + i);
                    recyclerViewDataThree.setContent("下拉内容" + i);
                    recyclerViewDataThree.setTitle("下拉Title" + i);
                    recyclerViewDataThree.setWriter("下拉writer" + i);
                    recyclerViewDataThree.setMusicWriter("下拉musicWriter" + i);
                    recyclerViewDataThree.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
                    dataThreeList.add(0,recyclerViewDataThree);
                }
                swipeRefreshLayout.setRefreshing(false);
                threeAdapter.notifyDataSetChanged();
            }
        }, 500);
    }

}
