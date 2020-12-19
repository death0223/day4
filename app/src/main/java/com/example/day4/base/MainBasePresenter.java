package com.example.day4.base;

public class MainBasePresenter<V extends MainBaseView> {
    public V iView;

    public void attachView(V v){
        iView=v;
    }

}
