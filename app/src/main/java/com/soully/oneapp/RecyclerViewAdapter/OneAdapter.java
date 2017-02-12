package com.soully.oneapp.RecyclerViewAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.soully.oneapp.R;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataOne;

import java.util.List;

/**
 * Created by Soully on 2017/1/19.
 */

public class OneAdapter extends RecyclerView.Adapter<OneAdapter.ViewHolder>{
    private List<RecyclerViewDataOne> mDataOneList;
    private OnRecycleViewListener onRecycleViewListener;
    View oneView;
    Context mContext;
    /*
  将数据源传进来
   */
    public OneAdapter(List<RecyclerViewDataOne> dataOneList){
        this.mDataOneList = dataOneList;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView biaoti;
        TextView title;
        TextView writer;
        TextView content;
        ImageView image;
        public ViewHolder(View itemView) {
            /*
            itemView子项的最外层布局
             */
            super(itemView);
            oneView = itemView;
           biaoti = (TextView) itemView.findViewById(R.id.recycler_one_biaoti);
            title = (TextView) itemView.findViewById(R.id.recycler_one_title);
            writer = (TextView) itemView.findViewById(R.id.recycler_one_writer);
            content = (TextView) itemView.findViewById(R.id.recycler_one_content);
            image = (ImageView) itemView.findViewById(R.id.recycler_one_image);
        }
    }
    /**
     创建了一个ViewHolder实例将布局加进去，返回ViewHolder实例
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_content_one,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        mContext = parent.getContext();
        return holder;
    }

    /**
     对Item赋值： 通过当前的position的值，确定哪些item在屏幕内，进行赋值
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final RecyclerViewDataOne dataOne = mDataOneList.get(position);
        holder.biaoti.setText(dataOne.getBiaoti());
        holder.title.setText(dataOne.getTitle());
        holder.content.setText(dataOne.getContent());
        holder.writer.setText(dataOne.getWriter());
        Glide.with(mContext).load(dataOne.getImage()).into(holder.image);
        if(onRecycleViewListener != null){//如果设置了回调，则设置监听事件
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();//和position值一样
                    onRecycleViewListener.onItemClick(holder.itemView,pos);
                }
            });
        }
    }

    /**
     *一共有多少子项
     */
    @Override
    public int getItemCount() {
        return mDataOneList.size();
    }
    public interface OnRecycleViewListener{
        void onItemClick(View view, int position);
    }
    public void setOnRecycleViewListener(OnRecycleViewListener mOnItemClickListener){
        this.onRecycleViewListener = mOnItemClickListener;
    }

}
