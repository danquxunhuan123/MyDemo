package com.trs.jjrb.activity.xiansuo;

import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.trs.jjrb.R;
import com.trs.jjrb.activity.BaseActivity;
import com.trs.jjrb.fragment.FragmentFactory;

import butterknife.OnClick;

public class TuFaActivity extends BaseActivity{

    @Override
    protected int flateLayout() {
        return R.layout.activity_tufa_layout;
    }

    @Override
    protected void initView() {
        FragmentFactory mFragmentFactory = new FragmentFactory.FragmentCreator();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_content, mFragmentFactory.getFragment(5)).commit();
    }

    @OnClick(R.id.iv_back)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
