package com.example.zonghe.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zonghe.R;
import com.example.zonghe.api.Api;
import com.example.zonghe.bean.RightBean;
import com.example.zonghe.bean.ZongBean;
import com.example.zonghe.util.Okhttp;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
/**
 * description: 陈啊
 * author: 陈吉庆
 * date: 2019/5/5 15:40
 * update: $date$
 */
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ViewHolder> {
        Context context;
        Handler handler =new Handler();
        List<RightBean.ResultEntity> list;
        public RightAdapter(Context context, List<RightBean.ResultEntity> list) {
            this.context = context;
            this.list = list;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = View.inflate(viewGroup.getContext(), R.layout.right_layout,null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
            viewHolder.name.setText(list.get(i).getName());
            GridLayoutManager gridLayoutManager =new GridLayoutManager(context,2);
            viewHolder.recycle_view.setLayoutManager(gridLayoutManager);
            Okhttp.doGet(Api.Zonng + list.get(i).getId(), new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String string  = null;
                            try {
                                string = response.body().string();
                                Gson gson =new Gson();
                                ZongBean zongBean = gson.fromJson(string, ZongBean.class);
                                List<ZongBean.ResultEntity> result = zongBean.getResult();
                                ZongAdapter zongAdapter = new ZongAdapter(context,result);
                                viewHolder.recycle_view.setAdapter(zongAdapter);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    });
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView name;
            private final RecyclerView recycle_view;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.right_text);
                recycle_view = itemView.findViewById(R.id.recycle_view);
            }
        }
    }

