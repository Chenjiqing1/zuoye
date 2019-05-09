package com.example.zonghe.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.zonghe.R;
import com.example.zonghe.adapter.LeftAdapter;
import com.example.zonghe.adapter.RightAdapter;
import com.example.zonghe.bean.LeftBean;
import com.example.zonghe.bean.RightBean;
import com.example.zonghe.presenter.Presenter;
import com.google.gson.Gson;

import java.util.List;

public class Erji extends AppCompatActivity {
   private Presenter presenter;
    private RecyclerView recycler_view1;
    private RecyclerView recycler_view2;
    private LeftAdapter leftAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erji);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(Erji.this,LinearLayoutManager.VERTICAL,false);
        LinearLayoutManager linearLayoutManager1 =new LinearLayoutManager(Erji.this,LinearLayoutManager.VERTICAL,false);
        presenter = new Presenter(this);
        recycler_view1 = findViewById(R.id.recycle_view1);
        recycler_view2 = findViewById(R.id.recycle_view2);
        recycler_view1.setLayoutManager(linearLayoutManager);
        recycler_view2.setLayoutManager(linearLayoutManager1);
        presenter.getLeft();
    }

    public void getRight(final String data) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson =new Gson();
                RightBean rightBean = gson.fromJson(data, RightBean.class);
                List<RightBean.ResultEntity> result = rightBean.getResult();
                RightAdapter rightAdapter =new RightAdapter(Erji.this,result);
                recycler_view2.setAdapter(rightAdapter);
            }
        });

    }

    public void getLeft(final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson =new Gson();
                final LeftBean leftBean = gson.fromJson(data, LeftBean.class);
                List<LeftBean.ResultEntity> list = leftBean.getResult();
                leftAdapter = new LeftAdapter(Erji.this,list);
                recycler_view1.setAdapter(leftAdapter);
                leftAdapter.setClick(new LeftAdapter.Click() {
                    @Override
                    public void click(View view,int position) {
                        String id = leftBean.getResult().get(position).getId();
                        presenter.Right(id);
                    }
                });
            }
        });
    }
}
