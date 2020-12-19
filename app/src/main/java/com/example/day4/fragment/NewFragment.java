package com.example.day4.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day4.R;
import com.example.day4.adatper.NewAdatper;
import com.example.day4.base.FragmentBase;
import com.example.day4.base.MainBaseView;
import com.example.day4.bean.NewBean;
import com.example.day4.contract.MainContract;
import com.example.day4.presenter.NewPresenter;

import java.util.ArrayList;
import java.util.List;

public class NewFragment extends FragmentBase<NewPresenter> implements MainContract.InMainView {

    private ArrayList<NewBean.NewsBean> list;
    private NewAdatper adatper;

    @Override
    protected NewPresenter getfragment() {
        return new NewPresenter(this);
    }

    @Override
    protected int getayoutId() {
        return R.layout.fragment_new;
    }

    @Override
    protected void initView(View view) {
        RecyclerView rel = view.findViewById(R.id.new_rel);

        list = new ArrayList<>();
        adatper = new NewAdatper(getActivity(), list);
        rel.setLayoutManager(new LinearLayoutManager(getActivity()));
        rel.setAdapter(adatper);
    }

    @Override
    protected void initDate() {
        present.getShow();
    }

    @Override
    public void getBean(Object object) {
        NewBean bean= (NewBean) object;
        List<NewBean.NewsBean> news = bean.getNews();
        list.addAll(news);
        adatper.notifyDataSetChanged();
    }

    @Override
    public void getError(String string) {

    }
}