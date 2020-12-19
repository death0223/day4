package com.example.day4.contract;

import com.example.day4.base.MainBaseView;
import com.example.day4.util.NetCallBack;

import javax.security.auth.callback.Callback;

public class MainContract {
    public interface InMainModel{
        <T> void getModel(String url, NetCallBack<T> callback,int flag);

    }
    public interface InMainPresent{
        void getShow();
        void getStudent();
    }
    public interface InMainView extends MainBaseView{
        void getBean(Object object);
        void getError(String string);
    }
}
