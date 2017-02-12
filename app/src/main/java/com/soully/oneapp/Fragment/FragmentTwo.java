package com.soully.oneapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.soully.oneapp.DividerItemDecoration;
import com.soully.oneapp.R;
import com.soully.oneapp.RecyclerViewAdapter.OneAdapter;
import com.soully.oneapp.RecyclerViewAdapter.TwoAdapter;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataOne;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataTwo;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Soully on 2017/2/12.
 */

public class FragmentTwo extends Fragment{
    private List<RecyclerViewDataTwo> dataTwoList = new ArrayList<>();
    private TwoAdapter twoAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    RecyclerViewDataTwo recyclerViewDataTwo = new RecyclerViewDataTwo();
    private  TextView toolbar_title;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenttwo,container,false);


        for (int i=0;i < 3;i++){
            recyclerViewDataTwo = new RecyclerViewDataTwo();
            recyclerViewDataTwo.setBiaoti("标题" + i);
            recyclerViewDataTwo.setContent("内容" + i);
            recyclerViewDataTwo.setTitle("Title" + i);
            recyclerViewDataTwo.setWriter("writer" + i);
            recyclerViewDataTwo.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
            dataTwoList.add(recyclerViewDataTwo);
        }
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_two);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL_LIST));//加分割线
        linearLayoutManager = new LinearLayoutManager(view.getContext());//指定布局样式
        recyclerView.setLayoutManager(linearLayoutManager);//将布局加入到recyclerView中
        twoAdapter = new TwoAdapter(dataTwoList);
        recyclerView.setAdapter(twoAdapter);
        return view;
    }

}
