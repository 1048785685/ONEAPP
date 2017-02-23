package com.soully.oneapp.Fragment;

import android.app.ProgressDialog;
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
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.soully.oneapp.ACache;
import com.soully.oneapp.Change_four;
import com.soully.oneapp.DividerItemDecoration;
import com.soully.oneapp.FirstActivity;
import com.soully.oneapp.Gson.yingshi.ID.Detail.Details;
import com.soully.oneapp.Gson.yingshi.ID.ID;
import com.soully.oneapp.HttpUtil.HttpUtil;
import com.soully.oneapp.MainActivity;
import com.soully.oneapp.R;
import com.soully.oneapp.RecyclerViewAdapter.FourAdapter;
import com.soully.oneapp.RecyclerViewAdapter.OneAdapter;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataFour;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataOne;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataTwo;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Response;


/**
 * Created by Soully on 2017/2/12.
 */

public class FragmentFour extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private List<RecyclerViewDataFour> dataFourList = new ArrayList<>();
    private FourAdapter fourAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    ProgressDialog progressDialog;

    String[] title = new String[100];
    String[] image = new String[100];
    String[] writer = new String[100];
    String[] content = new String[100];
    String[] url = new String[100];
    String[] updateids = new String[100];
    String[] updatetitle = new String[100];
    String[] updateimage = new String[100];
    String[] updatewriter = new String[100];
    String[] updatecontent = new String[100];
    String[] updateurl = new String[100];
    JSONArray fourtitle = new JSONArray();
    JSONArray fourimage  = new JSONArray();
    JSONArray fourwriter  = new JSONArray();
    JSONArray fourcontent  = new JSONArray();
    JSONArray foururl = new JSONArray();
    int item=0;
    ACache aCache;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragmentfour,container,false);

//        HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/movie/list/0", new okhttp3.Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Toast.makeText(view.getContext(),"网络请求错误，请连接网络重试",Toast.LENGTH_LONG).show();
//                closeProgressDialog();
//
//            }
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String responseData = response.body().string();
//                Gson gson = new Gson();
//                ID id = gson.fromJson(responseData,ID.class);
//                for (int i = 0 ; i<id.getData().size();i++){
//                    ids[i] = id.getData().get(i).getId();
//                }
//                Log.d("XXXXXX",ids[19]);
//                getDetail();
//            }
//        });

//        Timer timer = new Timer();
//        TimerTask tast = new TimerTask() {
//            @Override
//            public void run() {
        aCache =ACache.get(getContext());
        fourcontent = aCache.getAsJSONArray("content");
        fourwriter = aCache.getAsJSONArray("writer");
        foururl = aCache.getAsJSONArray("url");
        fourimage = aCache.getAsJSONArray("image");
        fourtitle = aCache.getAsJSONArray("title");
        for (int i =0; i<fourtitle.length();i++){
            try {
                content[i] = fourcontent.get(i).toString();
                writer[i] = fourwriter.get(i).toString();
                title[i] = fourtitle.get(i).toString();
                url[i] = foururl.get(i).toString();
                image[i] = fourimage.get(i).toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
                for (int i=0;i<4;i++,item++){
                    RecyclerViewDataFour recyclerViewDataFour = new RecyclerViewDataFour();
                    recyclerViewDataFour.setBiaoti("-影视-");
                    recyclerViewDataFour.setContent(content[item]);
                    recyclerViewDataFour.setTitle(title[item]);
                    recyclerViewDataFour.setWriter(writer[item]);
                    if (image[i] == null)
                    {
                        recyclerViewDataFour.setImage("http://cn.bing.com/az/hprichbg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
                    }else {
                        recyclerViewDataFour.setImage(image[item]);
                    }
                    dataFourList.add(recyclerViewDataFour);
                }
                //fourAdapter.notifyDataSetChanged();
                swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.four_swipe);
                swipeRefreshLayout.setOnRefreshListener(FragmentFour.this);//注册点击监听事件
                swipeRefreshLayout.setColorSchemeColors(R.color.colorAccent, R.color.colorPrimary,
                        R.color.colorPrimaryDark);//设置进度条的颜色
                recyclerView = (RecyclerView) view.findViewById(R.id.recycler_four);
                recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL_LIST));//加分割线
                linearLayoutManager = new LinearLayoutManager(view.getContext());//指定布局样式
                recyclerView.setLayoutManager(linearLayoutManager);//将布局加入到recyclerView中
                fourAdapter = new FourAdapter(dataFourList);
                recyclerView.setAdapter(fourAdapter);
//                closeProgressDialog();


//            }
//        };
//        timer.schedule(tast, 5000);
                fourAdapter.setOnRecycleViewListener(new FourAdapter.OnRecycleViewListener() {

                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getContext(), Change_four.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("url",url[position]);
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
                if ( newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == fourAdapter.getItemCount()) {
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (item < title.length-3) {
                                for (int i = 0; i < 3; i++, item++) {
                                    RecyclerViewDataFour recyclerViewDataFour = new RecyclerViewDataFour();
                                    recyclerViewDataFour.setBiaoti("-影视-");
                                    recyclerViewDataFour.setContent(content[item]);
                                    recyclerViewDataFour.setTitle(title[item]);
                                    recyclerViewDataFour.setWriter(writer[item]);
                                    if (image[item] == null) {
                                        recyclerViewDataFour.setImage("http://cn.bing.com/az/hprich" +
                                                "bg/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
                                    } else {
                                        recyclerViewDataFour.setImage(image[item]);
                                    }
                                    dataFourList.add(recyclerViewDataFour);
                                }
                            }
                            swipeRefreshLayout.setRefreshing(false);
                            fourAdapter.notifyDataSetChanged();
                        }
                    }, 1000);
                }
            }

            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
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
//    private void closeProgressDialog(){
//        if (progressDialog!=null){
//            progressDialog.dismiss();
//        }
//    }
    /**
     * Called when a swipe gesture triggers a refresh.
     */
    @Override
    public void onRefresh() {
        Log.d("XXXXXX","succeed one");
//        HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/movie/list/$%7Bid%7D", new okhttp3.Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//               Toast.makeText(getContext(),"网络请求错误，请连接网络重试",Toast.LENGTH_LONG).show();
//                //closeProgressDialog();
//
//            }
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Log.d("XXXXXX","succeed two");
//                String responseData = response.body().string();
//                Gson gson = new Gson();
//                ID id = gson.fromJson(responseData,ID.class);
//                for (int i = 0 ; i<id.getData().size();i++){
//                    updateids[i] = id.getData().get(i).getId();
//                }
//                getfourDetail();
//
//            }
//        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                int it=0;
//                Log.d("XXXXXX","succeed three");
//                if (title[0].equals(updatetitle[0])){
//                    Log.d("XXXXXX","fault");
//                    Toast.makeText(getContext(),"没有数据更新",Toast.LENGTH_SHORT).show();
//                }else {
//                    for (int j = 0;updatetitle[j].equals(title[0])==false;j++)
//                    {
//                        Log.d("XXXXXX","succeed four");
//                        it = j+1;
//                    }
//                    for (int p=0;p<updatetitle.length;p++){
//                        title[p] = updatetitle[p];
//                        content[p] = updatecontent[p];
//                        writer[p] = updatewriter[p];
//                        image[p] = updateimage[p];
//                    }
//                        for (int i = 0; i < it; i++,item++) {
//                            RecyclerViewDataFour recyclerViewDataFour = new RecyclerViewDataFour();
//                            recyclerViewDataFour.setBiaoti("-影视-");
//                            recyclerViewDataFour.setContent(content[i]);
//                            recyclerViewDataFour.setTitle(title[i]);
//                            recyclerViewDataFour.setWriter(writer[i]);
//                            if (image[i] == null) {
//                                recyclerViewDataFour.setImage("http://cn.bing.com/az/hprichbg" +
//                                        "/rb/PalaudelaMusica_ZH-CN12110358984_1920x1080.jpg");
//                            } else {
//                                recyclerViewDataFour.setImage(image[i]);
//                            }
//                            dataFourList.add(0, recyclerViewDataFour);
//                        }
//                }
                        swipeRefreshLayout.setRefreshing(false);
                        fourAdapter.notifyDataSetChanged();
            }
        }, 4000);
    }
    private void  getfourDetail(){
        Log.d("XXXXXX","1");
        for (int i = 0; i<20;i++){
            final int x = i;
            HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/movie/detail/"+updateids[i], new okhttp3.Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Toast.makeText(getContext(),"网络请求错误，请连接网络重试",Toast.LENGTH_LONG).show();
                    //closeProgressDialog();
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String responseData = response.body().string();
                    Gson gson = new Gson();
                    Details details = gson.fromJson(responseData,Details.class);
                    updateimage[x]=details.getData().getDetailcover();
                    updatewriter[x]=details.getData().getShareList().getWx().getDesc();
                    updatetitle[x]=details.getData().getTitle();
                    updatecontent[x]=details.getData().getOfficialstory();
                    updateurl[x]=details.getData().getWebUrl();
                    Log.d("XXXXXX",updateurl[x]);
//                    Log.d("KKKK",foururl[x]);
//                    Log.d("KKKK",fourcontent[x]);

                }
            });
        }

    }
}
