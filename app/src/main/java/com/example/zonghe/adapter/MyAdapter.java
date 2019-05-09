package com.example.zonghe.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.zonghe.R;
import com.example.zonghe.api.Api;
import com.example.zonghe.bean.User;

import java.util.List;

/**
 * description: 陈啊
 * author: 陈吉庆
 * date: 2019/5/5 10:41
 * update: $date$
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<User.ResultBean> list;

    public MyAdapter(Context context, List<User.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= View.inflate(viewGroup.getContext(), R.layout.buju,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(list.get(i).getCommodityName());
        Glide.with(context).load(list.get(i).getMasterPic()).into(viewHolder.tp);
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)//图片加载出来前，显示的图片
                .fallback( R.drawable.ic_launcher_background) //url为空的时候,显示的图片
                .error(android.R.drawable.alert_dark_frame);//图片加载失败后，显示的图片

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final ImageView tp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            tp = itemView.findViewById(R.id.tp);
        }
    }
}
