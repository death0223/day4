package com.example.day4.base;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.day4.contract.MainContract;

public  abstract class FragmentBase<P extends MainBasePresenter> extends Fragment implements MainBaseView {
    public P present;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getayoutId(), container, false);
        if (present==null){
            present=getfragment();
            present.attachView(this);
            initView(view);
            initDate();
        }
        return view;
    }

    protected abstract P getfragment();
    protected abstract int getayoutId();
    protected abstract void initView(View view);
    protected abstract void initDate();
}
