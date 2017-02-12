package com.soully.oneapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.soully.oneapp.DividerItemDecoration;
import com.soully.oneapp.R;
import com.soully.oneapp.RecyclerViewAdapter.OneAdapter;
import com.soully.oneapp.RecyclerViewAdapter.ThreeAdapter;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataOne;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataThree;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Soully on 2017/2/12.
 */

public class FragmentThree extends Fragment{
    private List<RecyclerViewDataThree> dataThreeList = new ArrayList<>();
    private ThreeAdapter threeAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    RecyclerViewDataThree recyclerViewDataThree = new RecyclerViewDataThree();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentthree,container,false);

        for (int i=0;i<3;i++){
            recyclerViewDataThree = new RecyclerViewDataThree();
            recyclerViewDataThree.setBiaoti("标题" + i);
            recyclerViewDataThree.setContent("内容" + i);
            recyclerViewDataThree.setTitle("Title" + i);
            recyclerViewDataThree.setWriter("writer" + i);
            recyclerViewDataThree.setMusicWriter("musicWriter" + i);
            recyclerViewDataThree.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
            dataThreeList.add(recyclerViewDataThree);
        }
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_three);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL_LIST));//加分割线
        linearLayoutManager = new LinearLayoutManager(view.getContext());//指定布局样式
        recyclerView.setLayoutManager(linearLayoutManager);//将布局加入到recyclerView中
        threeAdapter = new ThreeAdapter(dataThreeList);
        recyclerView.setAdapter(threeAdapter);
        return view;
    }
}
