package com.soully.oneapp.Fragment;

import android.content.Intent;
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
import android.widget.Toast;

import com.google.gson.Gson;
import com.soully.oneapp.ACache;
import com.soully.oneapp.Change_Two;
import com.soully.oneapp.Change_four;
import com.soully.oneapp.DividerItemDecoration;
import com.soully.oneapp.Gson.yuedu.Essay.Essay;
import com.soully.oneapp.Gson.yuedu.ShortDetail.ShortDetail;
import com.soully.oneapp.HttpUtil.HttpUtil;
import com.soully.oneapp.R;
import com.soully.oneapp.RecyclerViewAdapter.FourAdapter;
import com.soully.oneapp.RecyclerViewAdapter.OneAdapter;
import com.soully.oneapp.RecyclerViewAdapter.TwoAdapter;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataOne;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataThree;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataTwo;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;


/**
 * Created by Soully on 2017/2/12.
 */

public class FragmentTwo extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private List<RecyclerViewDataTwo> dataTwoList = new ArrayList<>();
    private TwoAdapter twoAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    ACache aCache;
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
    int k = 0;
    String[] updateids = new String[100];
    String[] updatetitle = new String[100];
    String[] updateimage = new String[100];
    String[] updatewriter = new String[100];
    String[] updatecontent = new String[100];
    String[] updateurl = new String[100];

    String[] title = new String[100];
    String[] image = new String[100];
    String[] writer = new String[100];
    String[] content = new String[100];
    String[] url = new String[100];
    int item = -1 ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenttwo,container,false);
        aCache =ACache.get(getContext());
        essaycontent=aCache.getAsJSONArray("essaycontent");
        essayimage=aCache.getAsJSONArray("essayimage");
        essaytitle = aCache.getAsJSONArray("essaytitle");
        essayurl=aCache.getAsJSONArray("essayurl");
        essaywriter=aCache.getAsJSONArray("essaywriter");

        serialurl=aCache.getAsString("serialurl");
        serialwriter=aCache.getAsString("serialwriter");
        serialtitle=aCache.getAsString("serialtitle");
        serialcontent=aCache.getAsString("serialcontent");
        serialimage=aCache.getAsString("serialimage");
        for (int i = 0;i<essaytitle.length();i++){
            try {
                title[i] = essaytitle.get(i).toString();
                image[i] = essayimage.get(i).toString();
                writer[i] = essaywriter.get(i).toString();
                content[i] = essaycontent.get(i).toString();
                url[i] = essayurl.get(i).toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        for (int i=0;i < 4;i++,item++){
            RecyclerViewDataTwo recyclerViewDataTwo = new RecyclerViewDataTwo();
            if (i == 0){
                recyclerViewDataTwo.setBiaoti("-连载-");
                recyclerViewDataTwo.setContent(serialcontent);
                recyclerViewDataTwo.setTitle(serialtitle);
                recyclerViewDataTwo.setWriter(serialwriter);
                if (serialimage == null)
                {
                    recyclerViewDataTwo.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
                }else {
                    recyclerViewDataTwo.setImage(serialimage);
                }
            }else {
                recyclerViewDataTwo.setBiaoti("-阅读-");
                recyclerViewDataTwo.setContent(content[item]);
                recyclerViewDataTwo.setTitle(title[item]);
                recyclerViewDataTwo.setWriter(writer[item]);
                if (image[item] == null)
                {
                    recyclerViewDataTwo.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
                }else {
                    recyclerViewDataTwo.setImage(image[item]);
                }
            }
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

        twoAdapter.setOnRecycleViewListener(new TwoAdapter.OnRecycleViewListener() {

            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), Change_Two.class);
                Bundle bundle = new Bundle();
                if(position == 0){
                    bundle.putString("url",serialurl);
                }else {
                bundle.putString("url",url[position-1]);
                }
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

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
                            if (item < title.length-3) {
                                for (int i = 0; i < 3; i++, item++) {
                                    RecyclerViewDataTwo recyclerViewDataTwo = new RecyclerViewDataTwo();
                                    recyclerViewDataTwo.setBiaoti("-阅读-");
                                    recyclerViewDataTwo.setContent(content[item]);
                                    recyclerViewDataTwo.setTitle(title[item]);
                                    recyclerViewDataTwo.setWriter(writer[item]);
                                    if (image[item] == null) {
                                        recyclerViewDataTwo.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
                                    } else {
                                        recyclerViewDataTwo.setImage(image[item]);
                                    }
                                    dataTwoList.add(recyclerViewDataTwo);
                                }
                            }
                            swipeRefreshLayout.setRefreshing(false);
                            twoAdapter.notifyDataSetChanged();
                        }
                    }, 3000);
                }
            }

            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }

        });
        return view;
    }

    /**
     * Called when a swipe gesture triggers a refresh.
     */
    @Override
    public void onRefresh() {
        HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/essay/bymonth/2017-02", new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getContext(),"网络请求错误，请连接网络重试",Toast.LENGTH_LONG).show();
                //closeProgressDialog();

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                Gson gson = new Gson();
                Essay essay = gson.fromJson(responseData, Essay.class);
                for (int i = 0 ; i<essay.getData().size();i++,k++){
                    updateids[i] = essay.getData().get(i).getContentId();
                }
                //Log.d("XXXXXX",essayids[19]);
                getShortDetail();
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int it=0;
                Log.d("XXXXXX","succeed three");
                if (title[0].equals(updatetitle[0])){
                    Log.d("XXXXXX","fault");
                    Toast.makeText(getContext(),"没有数据更新",Toast.LENGTH_SHORT).show();
                }else {
                    for (int j = 0;updatetitle[j].equals(title[0])==false;j++)
                    {
                        Log.d("XXXXXX","succeed four");
                        it = j+1;
                    }
                    for (int p=0;p<updatetitle.length;p++){
                        title[p] = updatetitle[p];
                        content[p] = updatecontent[p];
                        writer[p] = updatewriter[p];
                        image[p] = updateimage[p];
                    }
                        for (int i = 0; i < it; i++,item++) {
                            RecyclerViewDataTwo recyclerViewDataTwo = new RecyclerViewDataTwo();
                            recyclerViewDataTwo.setBiaoti("-阅读-");
                            recyclerViewDataTwo.setContent(content[i]);
                            recyclerViewDataTwo.setTitle(title[i]);
                            recyclerViewDataTwo.setWriter(writer[i]);
                            if (image[i] == null) {
                                recyclerViewDataTwo.setImage("http://cn.bing.com/az/hprichbg" +
                                        "/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
                            } else {
                                recyclerViewDataTwo.setImage(image[i]);
                            }
                            dataTwoList.add(1, recyclerViewDataTwo);
                        }
                }

                swipeRefreshLayout.setRefreshing(false);
                twoAdapter.notifyDataSetChanged();
            }
        }, 5000);
    }
    public void getShortDetail() {
        for (int i = 0; i < k; i++) {
            final int x = i;
            HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/essay/" + updateids[i], new okhttp3.Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Gson gson = new Gson();
                    String Data = response.body().string();
                    ShortDetail shortDetail = gson.fromJson(Data, ShortDetail.class);
                    updatetitle[x]=shortDetail.getData().getHpTitle();
                    updatecontent[x]=shortDetail.getData().getGuideWord();
                    updatewriter[x]=shortDetail.getData().getHpAuthor();
                    updateimage[x]=shortDetail.getData().getAuthor().get(0).getWebUrl();
                    updateurl[x]=shortDetail.getData().getWebUrl();
                }
            });
        }
    }
}
