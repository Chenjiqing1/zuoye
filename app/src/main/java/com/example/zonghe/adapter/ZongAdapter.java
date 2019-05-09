package com.example.zonghe.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zonghe.R;
import com.example.zonghe.activity.Xiangqing;
import com.example.zonghe.bean.ZongBean;

import java.util.List;

/**
 * description: 陈啊
 * author: 陈吉庆
 * date: 2019/5/5 15:42
 * update: $date$
 */
public class ZongAdapter extends RecyclerView.Adapter<ZongAdapter.ViewHolder> {
        Context context;
        List<ZongBean.ResultEntity> list;

        public ZongAdapter(Context context, List<ZongBean.ResultEntity> list) {
            this.context = context;
            this.list = list;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = View.inflate(viewGroup.getContext(), R.layout.zong_layout,null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            viewHolder.name.setText(list.get(i).getCommodityName());
            Glide.with(context).load(list.get(i).getMasterPic()).into(viewHolder.img);
           viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(context, Xiangqing.class);
                   context.startActivity(intent);
               }
           });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView name;
            private final ImageView img;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.texts);
                img = itemView.findViewById(R.id.imgs);
            }
        }
    }
