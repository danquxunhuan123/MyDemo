package com.trs.jjrb.fragment.xiansuo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trs.jjrb.R;
import com.trs.jjrb.activity.redian.BangDanListActivity;
import com.trs.jjrb.activity.redian.QuanWangReDianListActivity;
import com.trs.jjrb.activity.redian.WeiBoReDianListActivity;
import com.trs.jjrb.activity.xiansuo.DuZheBaoLiaoActivity;
import com.trs.jjrb.activity.xiansuo.JuJiaoListActivity;
import com.trs.jjrb.activity.xiansuo.RenGongXianSuoActivity;
import com.trs.jjrb.activity.xiansuo.TuFaActivity;
import com.trs.jjrb.activity.xiansuo.WangMinListActivity;
import com.trs.jjrb.activity.xiansuo.ZaiHaiListActivity;
import com.trs.jjrb.fragment.BaseFragment;
import com.trs.jjrb.fragment.FragmentInit;
import com.trs.waijiaobu.Constant;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class XianSuoFragment extends BaseFragment implements FragmentInit {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static XianSuoFragment newInstance(String param1, String param2) {
        XianSuoFragment fragment = new XianSuoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int flateLayout() {
        return R.layout.fragment_xiansuo;
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

    @OnClick({R.id.tv_xiansuo1, R.id.tv_xiansuo2, R.id.tv_xiansuo3, R.id.tv_xiansuo4, R.id.tv_xiansuo5, R.id.tv_xiansuo6, R.id.tv_xiansuo7, R.id.tv_xiansuo8, R.id.tv_xiansuo9, R.id.tv_xiansuo10, R.id.tv_xiansuo11})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_xiansuo1:
                toDetail("自然灾害", ZaiHaiListActivity.class);
                break;
            case R.id.tv_xiansuo2:
                toDetail("突发事件", TuFaActivity.class);
                break;
            case R.id.tv_xiansuo3:
                toDetail("实时聚焦", JuJiaoListActivity.class);
                break;
            case R.id.tv_xiansuo4:
                toDetail("网民关注", WangMinListActivity.class);
                break;
            case R.id.tv_xiansuo5:
                toDetail("近期政策", JuJiaoListActivity.class);
                break;
            case R.id.tv_xiansuo6:
                toDetail("近期会议", WeiBoReDianListActivity.class);
                break;
            case R.id.tv_xiansuo7:
                toDetail("历史今天", WangMinListActivity.class);
                break;
            case R.id.tv_xiansuo8:
                toDetail("自定义订阅", BangDanListActivity.class);
                break;
            case R.id.tv_xiansuo9:
                toDetail("微博爆料", WeiBoReDianListActivity.class);
                break;
            case R.id.tv_xiansuo10:
                toDetail("读者爆料", DuZheBaoLiaoActivity.class);
                break;
            case R.id.tv_xiansuo11:
                toDetail("人工线索", RenGongXianSuoActivity.class);
                break;
        }
    }

    private void toDetail(String title, Class cla) {
        Intent i = new Intent(mContext, cla);
        i.putExtra(QuanWangReDianListActivity.ARG_PARAM2, title);
        i.putExtra(QuanWangReDianListActivity.ARG_PARAM1, Constant.PUSH_MSG);
        startActivity(i);
    }
}
