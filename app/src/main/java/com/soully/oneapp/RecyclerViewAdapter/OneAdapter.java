package com.soully.oneapp.RecyclerViewAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.soully.oneapp.R;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataOne;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataOneFirst;


import java.util.List;

/**
 * Created by Soully on 2017/1/19.
 */

public class OneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<RecyclerViewDataOne> mDataOneList;
    private List<RecyclerViewDataOneFirst> mDataOneFirstList;
    private OneAdapter.OnRecycleViewListener onRecycleViewListener;
    public static final int first_item = 0;//第一个item
    public static final int other_item = 1;//其余item
    public static final int last_item = 2;//最后一个item
    Context mContext;
    /*
  将数据源传进来
   */
    public OneAdapter(List<RecyclerViewDataOne> dataOneList,List<RecyclerViewDataOneFirst> dataOneFirstList){
        this.mDataOneList = dataOneList;
        this.mDataOneFirstList = dataOneFirstList;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView biaoti;
        TextView title;
        TextView writer;
        TextView content;
        ImageView image;
        public ViewHolder(final View itemView) {
            /*
            itemView子项的最外层布局
             */
            super(itemView);
           biaoti = (TextView) itemView.findViewById(R.id.recycler_one_biaoti);
            title = (TextView) itemView.findViewById(R.id.recycler_one_title);
            writer = (TextView) itemView.findViewById(R.id.recycler_one_writer);
            content = (TextView) itemView.findViewById(R.id.recycler_one_content);
            image = (ImageView) itemView.findViewById(R.id.recycler_one_image);
            if(onRecycleViewListener != null){//如果设置了回调，则设置监听事件
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos = getLayoutPosition();//和position值一样
                        Log.d("XXXXXXXXXXXX",pos +"POS");
                        onRecycleViewListener.onItemClick(itemView,pos);
                    }
                });
            }
        }
    }
    /**
     创建了一个ViewHolder实例将布局加进去，返回ViewHolder实例
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       if (viewType == first_item){
           mContext = parent.getContext();
           View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_content_one_first,parent,false);
           return new FirstItemViewHolder(view);
       }else if (viewType == last_item){
           mContext = parent.getContext();
           View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_content_one_last,parent,false);
           return new lastItemViewHolder(view);
       }else {
           mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_content_one,parent,false);
           return new ViewHolder(view);
       }
    }

    /**
     对Item赋值： 通过当前的position的值，确定哪些item在屏幕内，进行赋值
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FirstItemViewHolder){
            ((FirstItemViewHolder) holder).shouye_huihuazuozhe.setText(mDataOneFirstList.get(position).getShouye_huihuazuozhe());
            Glide.with(mContext).load(mDataOneFirstList.get(position).getShouye_image()).into(((FirstItemViewHolder) holder).shouye_image);
            ((FirstItemViewHolder) holder).shouye_suibi.setText(mDataOneFirstList.get(position).getShouye_suibi());
            ((FirstItemViewHolder) holder).shouye_suibizuozhe.setText(mDataOneFirstList.get(position).getShouye_suibizuozhe());
        }else if (holder instanceof ViewHolder){
            Glide.with(mContext).load(mDataOneList.get(position).getImage()).into(((ViewHolder) holder).image);
            ((ViewHolder) holder).writer.setText(mDataOneList.get(position).getWriter());
            ((ViewHolder) holder).content.setText(mDataOneList.get(position).getContent());
            ((ViewHolder) holder).title.setText(mDataOneList.get(position).getTitle());
            ((ViewHolder) holder).biaoti.setText(mDataOneList.get(position).getBiaoti());
        }else if (holder instanceof lastItemViewHolder){
            ((lastItemViewHolder) holder).imageView.setImageResource(R.mipmap.chakan);
        }
    }
    public class FirstItemViewHolder extends RecyclerView.ViewHolder {
        TextView shouye_huihuazuozhe;
        TextView shouye_suibi;
        TextView shouye_suibizuozhe;
        ImageView shouye_image;
        public FirstItemViewHolder(final View itemView) {
            super(itemView);
            shouye_suibi = (TextView) itemView.findViewById(R.id.shouye_suibi);
            shouye_suibizuozhe = (TextView) itemView.findViewById(R.id.shouye_suibizuozhe);
            shouye_image = (ImageView) itemView.findViewById(R.id.shouye_image);
            shouye_huihuazuozhe = (TextView) itemView.findViewById(R.id.shouye_huihuazuozhe);
            if(onRecycleViewListener != null){//如果设置了回调，则设置监听事件
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos = getLayoutPosition();//和position值一样
                        onRecycleViewListener.onItemClick(itemView,pos);
                    }
                });
            }
        }
    }
    public class lastItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public lastItemViewHolder(final View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.recycler_one_last_image);
            if(onRecycleViewListener != null){//如果设置了回调，则设置监听事件
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos = getLayoutPosition();//和position值一样
                        onRecycleViewListener.onItemClick(itemView,pos);
                    }
                });
            }
        }
    }

    /**
     *一共有多少子项
     */
    @Override
    public int getItemCount() {
        return mDataOneList.size();
    }
    @Override
    public int getItemViewType(int position){
        if (position+1 == getItemCount()){
            return last_item;
        }else if (position == 0){
            return first_item;
        }else {
            return other_item;
        }
    }


    public interface OnRecycleViewListener{
        void onItemClick(View view, int position);
    }
    public void setOnRecycleViewListener(OneAdapter.OnRecycleViewListener mOnItemClickListener){
        this.onRecycleViewListener = mOnItemClickListener;
    }

}
