package com.example.day4.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.day4.contract.MainContract;

public abstract class MainBase<P extends MainBasePresenter> extends AppCompatActivity implements MainBaseView{
    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        if (presenter==null){
            presenter=add();
            presenter.attachView(this);
        }
        initView();
        initDate();
    }

    protected abstract void initView();
    protected abstract void initDate();
    protected abstract int getLayout();
    public abstract P add();
}
