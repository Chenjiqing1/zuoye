package com.example.zonghe.util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * description: 陈啊
 * author: 陈吉庆
 * date: 2019/5/3 16:19
 * update: $date$
 */
public class Okhttp {

    public static void doGet(String url, Callback callback){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).method("GET", null).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
    public Interceptor lanjieqi(){
        Interceptor interceptor = new Interceptor(){
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response proceed = chain.proceed(request);
                return proceed;
            }

        };
        return interceptor;
    }



}
