package com.example.zonghe.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * description: 陈啊
 * author: 陈吉庆
 * date: 2019/5/5 21:01
 * update: $date$
 */
public class Zhexian extends View {
    private Paint mLinePaint;
    private final static int textSize=40;
    private Path mPath;
    private final static int startX = 80;
    private final static int startY = 900;
    public Zhexian(Context context) {
        super(context);
    }
    public Zhexian(Context context,  AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Zhexian(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mLinePaint = new Paint();
        mLinePaint.setColor(Color.RED);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setTextSize(textSize);
        mLinePaint.setStrokeWidth(5);
        mPath = new Path();
        mPath.moveTo(startX,startY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(mPath,mLinePaint);
        canvas.drawLine(startX,startY,800,startY,mLinePaint);//x
        canvas.drawLine(startX,startY,startX,100,mLinePaint);//Y
        canvas.drawText("0",100-mLinePaint.measureText("0")-20,800+textSize,mLinePaint);
        for (int i = 100; i <= 600; i+=100) {
            String text = i+"";
            float textWidth = mLinePaint.measureText(text);
            canvas.drawText(text,startX+i-textWidth/2,startY+textSize,mLinePaint);//x坐标
            canvas.drawText(text,startX-textWidth,startY-i+textSize/2,mLinePaint);//y坐标
        }
        canvas.drawLine(80,900,160,700,mLinePaint);
        canvas.drawLine(160,700,300,700,mLinePaint);
        canvas.drawLine(300,700,350,600,mLinePaint);
        canvas.drawLine(350,600,450,700,mLinePaint);

    }
    public void addPoi(int x, int y) {
        mPath.lineTo(startX+x,startY-y);
        invalidate();
    }
}
