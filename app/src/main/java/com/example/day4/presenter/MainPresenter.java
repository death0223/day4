package com.example.day4.presenter;


import com.example.day4.base.MainBasePresenter;
import com.example.day4.bean.ListBean;
import com.example.day4.contract.MainContract;
import com.example.day4.model.MainModel;
import com.example.day4.util.NetCallBack;

public class MainPresenter extends MainBasePresenter<MainContract.InMainView> implements MainContract.InMainPresent {

    private MainContract.InMainView view;
    private final MainModel model;

    public MainPresenter(MainContract.InMainView view) {
        this.view = view;
        model = new MainModel();
    }

    @Override
    public void getShow() {
        model.getModel("banner/json", new NetCallBack<ListBean>() {
            @Override
            public void onSuccess(ListBean listBean) {
                view.getBean(listBean);
            }

            @Override
            public void onFail(String error) {

            }
        },0);
    }

    @Override
    public void getStudent() {

    }
}
