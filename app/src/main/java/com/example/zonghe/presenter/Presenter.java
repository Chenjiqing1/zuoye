package com.example.zonghe.presenter;

import com.example.zonghe.MainActivity;
import com.example.zonghe.activity.Erji;
import com.example.zonghe.api.Api;
import com.example.zonghe.model.IModel;
import com.example.zonghe.model.Mode;

import java.lang.ref.Reference;

/**
 * description: 陈啊
 * author: 陈吉庆
 * date: 2019/5/5 10:32
 * update: $date$
 */
public class Presenter<T> implements IPresenter{
    private Reference<T> tReference;
    private MainActivity mainActivity;
    private final Mode mode;
    private Erji erji;

    public Presenter( Erji erji) {
        this.erji = erji;
        mode=new Mode();
    }

    public Presenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        mode=new Mode();
    }

    @Override
    public void doPre() {
        mode.getZhanshi(Api.Zhanshi, new IModel.showCallback() {
            @Override
            public void chenggong(String data) {
                mainActivity.getshow(data);
            }
        });
    }

    @Override
    public void getLeft() {
        mode.getLeft(Api.Left, new IModel.LeftCallback() {
            @Override
            public void onSuccess(String data) {
                erji.getLeft(data);
            }
        });
    }

    @Override
    public void Right(String id) {
        mode.getRight(Api.Right+id, new IModel.RightCallback() {
            @Override
            public void onSuccess(String data) {
                erji.getRight(data);
            }
        });
    }
    public void xielou(){
        if (tReference!=null){
            tReference.clear();
            tReference=null;
        }

    }
}
