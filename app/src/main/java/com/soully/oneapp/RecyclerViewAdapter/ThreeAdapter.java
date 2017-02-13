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
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataThree;
import com.soully.oneapp.RecyclerViewData.RecyclerViewDataTwo;

import java.util.List;

/**
 * Created by Soully on 2017/1/19.
 */

public class ThreeAdapter extends RecyclerView.Adapter<ThreeAdapter.ViewHolder>{
    private List<RecyclerViewDataThree> mDataList;
//    private OnRecycleViewListener onRecycleViewListener;

    Context mContext;
    /*
  将数据源传进来
   */
    public ThreeAdapter(List<RecyclerViewDataThree> dataList){
        this.mDataList = dataList;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView biaoti;
        TextView title;
        TextView writer;
        TextView content;
        ImageView image;
        TextView musicWriter;
        public ViewHolder(View itemView) {
            /*
            itemView子项的最外层布局
             */
            super(itemView);
            musicWriter = (TextView) itemView.findViewById(R.id.recycler_three_musicWriter);
            biaoti = (TextView) itemView.findViewById(R.id.recycler_three_biaoti);
            title = (TextView) itemView.findViewById(R.id.recycler_three_title);
            writer = (TextView) itemView.findViewById(R.id.recycler_three_writer);
            content = (TextView) itemView.findViewById(R.id.recycler_three_content);
            image = (ImageView) itemView.findViewById(R.id.recycler_three_image);
        }
    }
    /**
     创建了一个ViewHolder实例将布局加进去，返回ViewHolder实例
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_content_three,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        mContext = parent.getContext();
        return holder;
    }

    /**
     对Item赋值： 通过当前的position的值，确定哪些item在屏幕内，进行赋值
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final RecyclerViewDataThree data = mDataList.get(position);
        holder.biaoti.setText(data.getBiaoti());
        holder.title.setText(data.getTitle());
        holder.content.setText(data.getContent());
        holder.writer.setText(data.getWriter());
        holder.musicWriter.setText(data.getMusicWriter());
        Glide.with(mContext).load(data.getImage()).into(holder.image);
//        if(onRecycleViewListener != null){//如果设置了回调，则设置监听事件
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    int pos = holder.getLayoutPosition();//和position值一样
//                    onRecycleViewListener.onItemClick(holder.itemView,pos);
//                }
//            });
//        }
    }

    /**
     *一共有多少子项
     */
    @Override
    public int getItemCount() {
        return mDataList.size();
    }
//    public interface OnRecycleViewListener{
//        void onItemClick(View view, int position);
//    }
//    public void setOnRecycleViewListener(OnRecycleViewListener mOnItemClickListener){
//        this.onRecycleViewListener = mOnItemClickListener;
//    }

}
