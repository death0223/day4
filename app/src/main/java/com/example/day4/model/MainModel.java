package com.example.day4.model;

import com.example.day4.contract.MainContract;
import com.example.day4.util.NetCallBack;
import com.example.day4.util.RetrofitUtil;
import com.example.day4.util.UrlConstant;

public class MainModel implements MainContract.InMainModel {

    private static final Integer BANNER=0;

    @Override
    public <T> void getModel(String url, NetCallBack<T> callback, int flag) {
        if (flag==0){
            RetrofitUtil.getRetrofitUtil(UrlConstant.listurl).get(url,callback);
        }else {
            RetrofitUtil.getRetrofitUtil(UrlConstant.url).get(url,callback);

        }
    }


}
