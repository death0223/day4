package com.example.day4.presenter;

import com.example.day4.base.MainBasePresenter;
import com.example.day4.bean.NewBean;
import com.example.day4.bean.StudentBean;
import com.example.day4.contract.MainContract;
import com.example.day4.model.MainModel;
import com.example.day4.util.NetCallBack;

public class NewPresenter extends MainBasePresenter<MainContract.InMainView> implements MainContract.InMainPresent {

    private MainContract.InMainView view;
    private final MainModel model;

    public NewPresenter(MainContract.InMainView view) {
        this.view = view;
        model = new MainModel();
    }

    @Override
    public void getShow() {
        model.getModel("exam2003/anewslist.json", new NetCallBack<NewBean>() {
            @Override
            public void onSuccess(NewBean newBean) {
                view.getBean(newBean);
            }

            @Override
            public void onFail(String error) {
                view.getError(error);
            }
        },1);
    }

    @Override
    public void getStudent() {
        model.getModel("exam2003/astudent.json", new NetCallBack<StudentBean>() {
            @Override
            public void onSuccess(StudentBean studentBean) {
                view.getBean(studentBean);
            }

            @Override
            public void onFail(String error) {

            }
        },1);
    }

}
