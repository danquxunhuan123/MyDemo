package com.trs.jjrb.activity.my;

import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.activity.BaseActivity;
import com.trs.jjrb.adapter.AdapterFactory;
import com.trs.jjrb.fragment.CommenListFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class CeHuaListActivity extends BaseActivity {
    @BindView(R.id.tv_cname)
    TextView cname;

    public static final String ARG_PARAM1 = "url";
    public static final String ARG_PARAM2 = "cname";

    @Override
    protected void initView() {
        String url = getIntent().getStringExtra(ARG_PARAM1);
        AdapterFactory factory = new AdapterFactory.AdapterCreator();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_content
                , CommenListFragment.newInstance(url, factory.getAdapter(4, this)))
                .commit();
    }

    @Override
    protected void getData() {
        String title = getIntent().getStringExtra(ARG_PARAM2);
        if (!TextUtils.isEmpty(title))
            cname.setText(title);
    }

    @Override
    protected int flateLayout() {
        return R.layout.layout_activity_list;
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
