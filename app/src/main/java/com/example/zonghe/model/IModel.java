package com.example.zonghe.model;

/**
 * description: 陈啊
 * author: 陈吉庆
 * date: 2019/5/5 10:25
 * update: $date$
 */
public interface IModel {
    void getZhanshi(String url,showCallback showCallback);
    interface showCallback{
        void chenggong(String data);
    }

    void getLeft(String url, LeftCallback leftCallback);
    interface LeftCallback{
        void onSuccess(String data);
    }

    void getRight(String url,RightCallback rightCallback);
    interface RightCallback{
        void onSuccess(String data);
    }

}
