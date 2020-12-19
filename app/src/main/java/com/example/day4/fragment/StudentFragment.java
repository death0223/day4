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
import com.example.day4.adatper.StudentAdatper;
import com.example.day4.base.FragmentBase;
import com.example.day4.base.MainBaseView;
import com.example.day4.bean.NewBean;
import com.example.day4.bean.StudentBean;
import com.example.day4.contract.MainContract;
import com.example.day4.presenter.NewPresenter;

import java.util.ArrayList;
import java.util.List;

public class StudentFragment extends FragmentBase<NewPresenter> implements MainContract.InMainView {

    private ArrayList<StudentBean.StudenlistBean> list;
    private StudentAdatper adatper;

    @Override
    protected NewPresenter getfragment() {
        return new NewPresenter(this);
    }

    @Override
    protected int getayoutId() {
        return R.layout.fragment_student;
    }

    @Override
    protected void initView(View view) {
        RecyclerView rel = view.findViewById(R.id.student_rel);

        list = new ArrayList<>();
        adatper = new StudentAdatper(getActivity(), list);
        rel.setLayoutManager(new LinearLayoutManager(getActivity()));
        rel.setAdapter(adatper);
    }

    @Override
    protected void initDate() {
        present.getStudent();
    }

    @Override
    public void getBean(Object object) {
        StudentBean studentBean= (StudentBean) object;
        List<StudentBean.StudenlistBean> studenlist = studentBean.getStudenlist();
        list.addAll(studenlist);
        adatper.notifyDataSetChanged();
    }

    @Override
    public void getError(String string) {

    }
}