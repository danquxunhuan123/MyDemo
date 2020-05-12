package com.trs.jjrb.fragment.redian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.trs.jjrb.R;
import com.trs.jjrb.activity.ListActivity;
import com.trs.jjrb.activity.redian.BangDanActivity;
import com.trs.jjrb.activity.redian.BangDanListActivity;
import com.trs.jjrb.activity.redian.DiYuReDianListActivity;
import com.trs.jjrb.activity.redian.JingJiListActivity;
import com.trs.jjrb.activity.redian.QuanWangReDianListActivity;
import com.trs.jjrb.activity.redian.TouTiaoListActivity;
import com.trs.jjrb.activity.redian.WeiBoReDianListActivity;
import com.trs.jjrb.activity.redian.WeiXinReDianListActivity;
import com.trs.jjrb.fragment.BaseFragment;
import com.trs.jjrb.fragment.FragmentInit;
import com.trs.waijiaobu.Constant;

import butterknife.OnClick;
import butterknife.Unbinder;

public class ReDianFragment extends BaseFragment implements FragmentInit {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static ReDianFragment newInstance(String param1, String param2) {
        ReDianFragment fragment = new ReDianFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int flateLayout() {
        return R.layout.fragment_redian;
    }

    @Override
    protected FragmentInit initInterface() {
        return this;
    }

    @Override
    public void initSomeThing() {
    }

    @Override
    public void getData() {
    }

    @OnClick({R.id.redian1, R.id.redian2, R.id.redian3, R.id.redian4, R.id.toutiao1, R.id.toutiao2, R.id.zhishu1, R.id.zhishu2, R.id.bangdan})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.redian1:
                toDetail("全网热点", QuanWangReDianListActivity.class);
//                toDetail("全网热点", ListActivity.class,
//                        0,R.layout.layout_activity_redian_list);
                break;
            case R.id.redian2:
                toDetail("微博热点", WeiBoReDianListActivity.class);
//                toDetail("全网热点", ListActivity.class,
//                        2,R.layout.layout_activity_weibo_redian_list);
                break;
            case R.id.redian3:
                toDetail("微信热点", WeiXinReDianListActivity.class);
                break;
            case R.id.redian4:
                toDetail("地域热点", DiYuReDianListActivity.class);
                break;
            case R.id.toutiao1:
                Intent wm = new Intent(mContext, TouTiaoListActivity.class);
                wm.putExtra(TouTiaoListActivity.ARG_PARAM2, "网媒头条");
                wm.putExtra(TouTiaoListActivity.ARG_PARAM1, Constant.PUSH_MSG);
                wm.putExtra(TouTiaoListActivity.ARG_PARAM3, 5);
                startActivity(wm);
                break;
            case R.id.toutiao2:
                Intent ii = new Intent(mContext, TouTiaoListActivity.class);
                ii.putExtra(TouTiaoListActivity.ARG_PARAM2, "纸媒头条");
                ii.putExtra(TouTiaoListActivity.ARG_PARAM1, Constant.PUSH_MSG);
                ii.putExtra(TouTiaoListActivity.ARG_PARAM3, 13);
                startActivity(ii);
                break;
            case R.id.zhishu1:
                Intent i = new Intent(mContext, JingJiListActivity.class);
                i.putExtra(ListActivity.ARG_PARAM2, "环比增长");
                i.putExtra(ListActivity.ARG_PARAM1, 0);
                startActivity(i);
                break;
            case R.id.zhishu2:
                Intent i1 = new Intent(mContext, JingJiListActivity.class);
                i1.putExtra(ListActivity.ARG_PARAM2, "同比增长");
                i1.putExtra(ListActivity.ARG_PARAM1, 1);
                startActivity(i1);
                break;
            case R.id.bangdan:
                Intent i2 = new Intent(mContext, BangDanActivity.class);
                i2.putExtra(ListActivity.ARG_PARAM2, "门户榜单");
                i2.putExtra(ListActivity.ARG_PARAM1, Constant.PUSH_MSG);
                startActivity(i2);
                break;
        }
    }

    private void toDetail(String title, Class cla) { //,int adapterCode,int layoutId
        Intent i = new Intent(mContext, cla);
        i.putExtra(ListActivity.ARG_PARAM2, title);
        i.putExtra(ListActivity.ARG_PARAM1, Constant.PUSH_MSG);
//        i.putExtra(ListActivity.ARG_PARAM3, adapterCode);
//        i.putExtra(ListActivity.ARG_PARAM4, layoutId);
        startActivity(i);
    }
}
