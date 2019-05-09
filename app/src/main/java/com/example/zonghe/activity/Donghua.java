package com.example.zonghe.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.zonghe.R;

public class Donghua extends AppCompatActivity {

    private ImageView tu;
    private Button dong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donghua);
        tu = findViewById(R.id.tu);
        dong = findViewById(R.id.dong);
        dong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tu.animate().translationY(100)
                        .setDuration(1000).start();
                tu.animate().rotation(360)
                        .setDuration(2000).start();

            }
        });
    }
}
