package com.example.zonghe.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zonghe.R;

public class Liu extends AppCompatActivity {
private Liushi liu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liu);
        final EditText editText = findViewById(R.id.EditText_id);
        Button button_id = findViewById(R.id.Button_id);
        liu = findViewById(R.id.liu);

        button_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString().trim();
                final TextView textView = new TextView(Liu.this);
                textView.setText(s);
                liu.addView(textView);
                editText.setText(null);
                textView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        textView.setVisibility(View.GONE);
                        return true;
                    }
                });
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s1 = textView.getText().toString();
                        editText.setText(s1);
                    }
                });


            }

        });
    }
}
