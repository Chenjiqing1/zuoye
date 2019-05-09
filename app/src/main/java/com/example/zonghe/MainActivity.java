package com.example.zonghe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.example.zonghe.activity.Donghua;
import com.example.zonghe.activity.Erji;
import com.example.zonghe.activity.Jiaohu;
import com.example.zonghe.activity.Liu;
import com.example.zonghe.adapter.MyAdapter;
import com.example.zonghe.bean.User;
import com.example.zonghe.presenter.Presenter;
import com.google.gson.Gson;
import java.util.List;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView recyclerview;
    private Presenter presenter;
    private TextView suo,erji,donghua,jiaohu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.recyclerview);
        suo = findViewById(R.id.suo);
        donghua = findViewById(R.id.donghua);
        erji = findViewById(R.id.erji);
        jiaohu = findViewById(R.id.jiaohu);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerview.setLayoutManager(gridLayoutManager);
        presenter = new Presenter(this);
        suo.setOnClickListener(this);
        erji.setOnClickListener(this);
        donghua.setOnClickListener(this);
        jiaohu.setOnClickListener(this);
        presenter.doPre();
    }
    public void getshow(final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                User bean = gson.fromJson(data, User.class);
                List<User.ResultBean> list = bean.getResult();
                MyAdapter myadapter = new MyAdapter(MainActivity.this,list);
                recyclerview.setAdapter(myadapter);
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.suo:
                Intent intent = new Intent(MainActivity.this,Liu.class);
                startActivity(intent);
                break;
            case R.id.donghua:
                Intent intent1 = new Intent(MainActivity.this, Donghua.class);
                startActivity(intent1);
                break;
            case R.id.erji:
                Intent intent2 = new Intent(MainActivity.this, Erji.class);
                startActivity(intent2);
                break;
            case R.id.jiaohu:
                Intent intent3 = new Intent(MainActivity.this, Jiaohu.class);
                startActivity(intent3);
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.xielou();
    }
}
