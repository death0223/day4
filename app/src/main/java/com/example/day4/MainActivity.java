package com.example.day4;

import android.content.Context;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.day4.adatper.TabAdatper;
import com.example.day4.base.MainBase;
import com.example.day4.bean.ListBean;
import com.example.day4.contract.MainContract;
import com.example.day4.fragment.NewFragment;
import com.example.day4.fragment.StudentFragment;
import com.example.day4.presenter.MainPresenter;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MainBase<MainPresenter> implements MainContract.InMainView {

    private Banner banner;
    private TabLayout tab;
    private ViewPager vp;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> list;

    protected void initDate() {
        presenter.getShow();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public MainPresenter add() {
        return new MainPresenter(this);
    }

    protected void initView() {
        banner = findViewById(R.id.banner);
        tab = findViewById(R.id.tab);
        vp = findViewById(R.id.vp);

        list = new ArrayList<>();
        list.add("学校新闻");
        list.add("班级成绩查询");
        fragments = new ArrayList<>();
        fragments.add(new NewFragment());
        fragments.add(new StudentFragment());
        TabAdatper adatper = new TabAdatper(getSupportFragmentManager(), list, fragments);
        vp.setAdapter(adatper);
        tab.setupWithViewPager(vp);
    }

    @Override
    public void getBean(Object object) {
        ListBean listBean= (ListBean) object;
        List<ListBean.DataBean> bannerlist = listBean.getData();
        banner.setImages(bannerlist).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                ListBean.DataBean bb= (ListBean.DataBean) path;
                Glide.with(context).load(bb.getImagePath()).into(imageView);
            }
        }).start();
    }

    @Override
    public void getError(String string) {

    }
}