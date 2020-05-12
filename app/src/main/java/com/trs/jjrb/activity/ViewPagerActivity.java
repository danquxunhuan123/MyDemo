package com.trs.jjrb.activity;

import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.fragment.FragmentFactory;
import com.trs.jjrb.util.StringUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class ViewPagerActivity extends BaseActivity{

    @BindView(R.id.tv_cname)
    TextView cname;

    public static final String ARG_PARAM1 = "title_name";
    public static final String ARG_PARAM2 = "fragment_type";

    @Override
    protected int flateLayout() {
        return R.layout.activity_view_pager;
    }

    @Override
    protected void initView() {
        int index = getIntent().getIntExtra(ARG_PARAM2,5);
        FragmentFactory mFragmentFactory = new FragmentFactory.FragmentCreator();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_content, mFragmentFactory.getFragment(index)).commit();
    }

    @Override
    protected void getData() {
        String title = getIntent().getStringExtra(ARG_PARAM1);
        if (!TextUtils.isEmpty(title))
            cname.setText(title);
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
