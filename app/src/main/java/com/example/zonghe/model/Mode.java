package com.example.zonghe.model;

import com.example.zonghe.api.Api;
import com.example.zonghe.util.Okhttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * description: 陈啊
 * author: 陈吉庆
 * date: 2019/5/5 10:25
 * update: $date$
 */
public class Mode implements IModel {
    @Override
    public void getZhanshi(String url, final showCallback showCallback) {
        Okhttp.doGet(Api.Zhanshi, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                    showCallback.chenggong(response.body().string());
            }
        });
    }

    @Override
    public void getLeft(String url, final LeftCallback leftCallback) {
        Okhttp.doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                leftCallback.onSuccess(response.body().string());
            }
        });
    }

    @Override
    public void getRight(String url, final RightCallback rightCallback) {
        Okhttp.doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                rightCallback.onSuccess(response.body().string());
            }
        });
    }
}
