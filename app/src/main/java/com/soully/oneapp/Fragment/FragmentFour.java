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
import com.soully.oneapp.RecyclerViewAdapter.FourAdapter;
import com.soully.oneapp.RecyclerViewAdapter.OneAdapter;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataFour;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataOne;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Soully on 2017/2/12.
 */

public class FragmentFour extends Fragment{
    private List<RecyclerViewDataFour> dataFourList = new ArrayList<>();
    private FourAdapter fourAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    RecyclerViewDataFour recyclerViewDataFour = new RecyclerViewDataFour();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentfour,container,false);


        for (int i=0;i<3;i++){
            recyclerViewDataFour = new RecyclerViewDataFour();
            recyclerViewDataFour.setBiaoti("标题" + i);
            recyclerViewDataFour.setContent("内容" + i);
            recyclerViewDataFour.setTitle("Title" + i);
            recyclerViewDataFour.setWriter("writer" + i);
            recyclerViewDataFour.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
            dataFourList.add(recyclerViewDataFour);
        }
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_four);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL_LIST));//加分割线
        linearLayoutManager = new LinearLayoutManager(view.getContext());//指定布局样式
        recyclerView.setLayoutManager(linearLayoutManager);//将布局加入到recyclerView中
        fourAdapter = new FourAdapter(dataFourList);
        recyclerView.setAdapter(fourAdapter);
        return view;
    }
}
