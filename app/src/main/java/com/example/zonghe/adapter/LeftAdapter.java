package com.example.zonghe.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zonghe.R;
import com.example.zonghe.bean.LeftBean;

import java.util.List;

/**
 * description: 陈啊
 * author: 陈吉庆
 * date: 2019/5/5 15:38
 * update: $date$
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder> {
        Context context;
        List<LeftBean.ResultEntity> list;

        public LeftAdapter(Context context, List<LeftBean.ResultEntity> list) {
            this.context = context;
            this.list = list;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = View.inflate(viewGroup.getContext(), R.layout.left_layout,null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
            viewHolder.name.setText(list.get(i).getName());
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPosition = viewHolder.getLayoutPosition();
                    View itemView = viewHolder.itemView;
                    if (click!=null){
                        click.click(itemView,layoutPosition);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView name;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.left_text);
            }
        }

        public interface Click{
            void click(View view,int position);
        }
        public Click click;

        public void setClick(Click click){
            this.click = click;
        }
    }

