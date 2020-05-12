package com.trs.jjrb.fragment.xuanti;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.telecom.Call;
import android.view.View;
import android.widget.ImageButton;

import com.trs.jjrb.R;
import com.trs.jjrb.activity.xuanti.AddXuanTiActivity;
import com.trs.jjrb.adapter.AdapterFactory;
import com.trs.jjrb.adapter.ViewPagerAdapter;
import com.trs.jjrb.bean.Channel;
import com.trs.jjrb.fragment.BaseFragment;
import com.trs.jjrb.fragment.CommenListFragment;
import com.trs.jjrb.fragment.FragmentInit;
import com.trs.jjrb.presenter.IIndicatorFragmentPresenterImpl;
import com.trs.jjrb.presenter.inter.IIndicatorFragmentPresenter;
import com.trs.jjrb.util.ProgressUtil;
import com.trs.jjrb.view.IIndicatorFragmentView;
import com.trs.waijiaobu.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

public class XuanTiFragment extends BaseFragment implements IIndicatorFragmentView
        , FragmentInit {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ViewPagerAdapter adapter;
    private List<String> mTitles = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> titleCache = new ArrayList<>();
    private Map<String, Fragment> maps = new HashMap<>();

    private IIndicatorFragmentPresenter mPresenter;

    public XuanTiFragment() {
    }

    public static XuanTiFragment newInstance(String param1, String param2) {
        XuanTiFragment fragment = new XuanTiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected FragmentInit initInterface() {
        return this;
    }

    @Override
    public void initSomeThing() {
        mPresenter = new IIndicatorFragmentPresenterImpl(mContext, this);
    }

    @Override
    public void getData() {
        String url = getArguments().getString(ARG_PARAM1);
        mPresenter.getXW(url);
        ProgressUtil.getInstance(mContext).show();
    }

    @Override
    public void onDestroy() {
        ProgressUtil.getInstance(mContext).release();
        super.onDestroy();
    }

    @Override
    protected int flateLayout() {
        return R.layout.fragment_xuanti;
    }

    @Override
    public void getXW(Channel channel) {
        ProgressUtil.getInstance(mContext).dismiss();

        mTitles.clear();
        mFragments.clear();

        AdapterFactory factory = new AdapterFactory.AdapterCreator();
        mTitles.add("部门管理");
        mFragments.add(CommenListFragment.newInstance(Constant.PUSH_MSG, factory.getAdapter(7, mContext)));
        mTitles.add("报题汇总");
        mFragments.add(CommenListFragment.newInstance(Constant.PUSH_MSG, factory.getAdapter(8, mContext)));
        mTitles.add("选题汇总");
        mFragments.add(CommenListFragment.newInstance(Constant.PUSH_MSG, factory.getAdapter(9, mContext)));
//        List<Channel.GdEntity> gd = channel.getGd();
//        for (int i = 0; i < gd.size(); i++) {
//            String cname = gd.get(i).getCname();
//            String doc = gd.get(i).getDocuments();
//            mTitles.add(cname);
//
//            ListXuanTiFragment listFragment = ListXuanTiFragment.newInstance(doc, cname);
//            mFragments.add(listFragment);
//            maps.put(cname, listFragment);
//        }

        titleCache.addAll(mTitles);

        if (adapter == null) {
            adapter = new ViewPagerAdapter(getChildFragmentManager(), mTitles, mFragments);
            viewPager.setAdapter(adapter);
            viewPager.setOffscreenPageLimit(mFragments.size());
            tabLayout.setupWithViewPager(viewPager);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    @OnClick({R.id.ib_add})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_add:

                Intent intent = new Intent(mContext,AddXuanTiActivity.class);
                intent.putExtra(AddXuanTiActivity.ARG_PARAM2,"新建部门");
                startActivity(intent);
                break;
        }
    }
}
