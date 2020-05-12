package com.trs.jjrb.fragment.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trs.jjrb.R;
import com.trs.jjrb.activity.LoginActivity;
import com.trs.jjrb.activity.SettingActivity;
import com.trs.jjrb.activity.my.CeHuaListActivity;
import com.trs.jjrb.activity.xuanti.AddXuanTiActivity;
import com.trs.jjrb.fragment.BaseFragment;
import com.trs.jjrb.fragment.FragmentInit;
import com.trs.waijiaobu.Constant;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MyFragment extends BaseFragment implements FragmentInit {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static MyFragment newInstance(String param1, String param2) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int flateLayout() {
        return R.layout.fragment_my;
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


    @OnClick({R.id.rl_login, R.id.ib_setting, R.id.tv_title,
            R.id.tv_title1, R.id.tv_title2, R.id.tv_title3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_login:
                Intent intent = new Intent(mContext, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.ib_setting:
                Intent intentSet = new Intent(mContext, SettingActivity.class);
                intentSet.putExtra(SettingActivity.ARG_PARAM2, "个人信息");
                startActivity(intentSet);
                break;
            case R.id.tv_title:
                Intent intent1 = new Intent(mContext, CeHuaListActivity.class);
                intent1.putExtra(SettingActivity.ARG_PARAM1, Constant.PUSH_MSG);
                intent1.putExtra(SettingActivity.ARG_PARAM2, "资源订阅");
                startActivity(intent1);
                break;
            case R.id.tv_title1:
                Intent intent2 = new Intent(mContext, CeHuaListActivity.class);
                intent2.putExtra(SettingActivity.ARG_PARAM1, Constant.PUSH_MSG);
                intent2.putExtra(SettingActivity.ARG_PARAM2, "策划订阅");
                startActivity(intent2);
                break;
            case R.id.tv_title2:
                Intent intent3 = new Intent(mContext, CeHuaListActivity.class);
                intent3.putExtra(SettingActivity.ARG_PARAM1, Constant.PUSH_MSG);
                intent3.putExtra(SettingActivity.ARG_PARAM2, "重点推荐");
                startActivity(intent3);
                break;
            case R.id.tv_title3:
//                Intent intent4 = new Intent(mContext,LoginActivity.class);
//                intent4.putExtra(SettingActivity.ARG_PARAM1,Constant.PUSH_MSG);
//                intent4.putExtra(SettingActivity.ARG_PARAM2,"个人信息");
//                startActivity(intent4);
                break;
        }
    }
}
