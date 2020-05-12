package com.trs.jjrb.fragment.redian;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.trs.jjrb.R;
import com.trs.jjrb.activity.redian.BangDanActivity;
import com.trs.jjrb.adapter.AdapterFactory;
import com.trs.jjrb.adapter.ViewPagerAdapter;
import com.trs.jjrb.bean.Channel;
import com.trs.jjrb.fragment.BaseFragment;
import com.trs.jjrb.fragment.CommenListFragment;
import com.trs.jjrb.fragment.FragmentFactory;
import com.trs.jjrb.fragment.FragmentInit;
import com.trs.jjrb.fragment.xuanti.ListXuanTiFragment;
import com.trs.jjrb.presenter.IIndicatorFragmentPresenterImpl;
import com.trs.jjrb.presenter.inter.IIndicatorFragmentPresenter;
import com.trs.jjrb.util.ProgressUtil;
import com.trs.jjrb.view.IIndicatorFragmentView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class BangDanFragment extends BaseFragment implements IIndicatorFragmentView
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

    public BangDanFragment() {
    }

    public static BangDanFragment newInstance(String param1, String param2) {
        BangDanFragment fragment = new BangDanFragment();
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
        return R.layout.fragment_bangdan;
    }

    @Override
    public void getXW(Channel channel) {
        ProgressUtil.getInstance(mContext).dismiss();

        mTitles.clear();
        mFragments.clear();

        AdapterFactory factory = new AdapterFactory.AdapterCreator();
        String doc = "https://www.fmprc.gov.cn/chn/gxh/tyb/mobile/xwfw/xwmtfw_589721/channels.json";
        mTitles.add("热度");
        mFragments.add(CommenListFragment.newInstance(doc, factory.getAdapter(4, mContext)));
        mTitles.add("新上榜");
        mFragments.add(CommenListFragment.newInstance(doc, factory.getAdapter(4, mContext)));
        mTitles.add("最新");
        mFragments.add(CommenListFragment.newInstance(doc, factory.getAdapter(4, mContext)));
        mTitles.add("趋势");
        mFragments.add(CommenListFragment.newInstance(doc, factory.getAdapter(4, mContext)));
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

    @OnClick({R.id.iv_toggle})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_toggle:
                ((BangDanActivity)getActivity()).toggleDrawer();
                break;
        }
    }
}
