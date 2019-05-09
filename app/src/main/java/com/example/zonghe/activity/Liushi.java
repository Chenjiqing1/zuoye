package com.example.zonghe.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.zonghe.R;

/**
 * description: 陈啊
 * author: 陈吉庆
 * date: 2019/5/5 10:47
 * update: $date$
 */
public class Liushi extends ViewGroup {
    int zuo=20;
    int shang=20;
    public Liushi(Context context) {
        super(context);
    }

    public Liushi(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Liushi(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        context.obtainStyledAttributes(attrs, R.styleable.chen);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int zuoyou=zuo;
        int shangxia=shang;
        for (int i=0;i<getChildCount();i++){
            int measuredHeight = getChildAt(i).getMeasuredHeight();
            int measuredWidth = getChildAt(i).getMeasuredWidth();
            if(getChildAt(i).getVisibility()== View.GONE){
                continue;
            }if(measuredWidth+zuo+zuoyou>getWidth()){
                zuoyou=20;
                shangxia=measuredHeight+shang;
                getChildAt(i).layout(zuoyou,shangxia,zuoyou+measuredWidth,shangxia+measuredHeight);
            }else{
                getChildAt(i).layout(zuoyou,shangxia,zuoyou+measuredWidth,shangxia+measuredHeight);
            }
            zuoyou+=measuredWidth+zuo;

        }
    }
}
