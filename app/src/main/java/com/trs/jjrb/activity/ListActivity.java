package com.trs.jjrb.activity;

import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.adapter.AdapterFactory;
import com.trs.jjrb.fragment.CommenListFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class ListActivity extends BaseActivity {
    @BindView(R.id.tv_cname)
    TextView cname;

    public static final String ARG_PARAM1 = "url";
    public static final String ARG_PARAM2 = "cname";
    public static final String ARG_PARAM3 = "adapter_code";
    public static final String ARG_PARAM4 = "layout_id";

    @Override
    protected void initView() {
        String title = getIntent().getStringExtra(ARG_PARAM2);
        if (!TextUtils.isEmpty(title))
            cname.setText(title);
    }

    @Override
    protected void getData() {
        String url = getIntent().getStringExtra(ARG_PARAM1);
        int code = getIntent().getIntExtra(ARG_PARAM3, 0);
        AdapterFactory factory = new AdapterFactory.AdapterCreator();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_content
                , CommenListFragment.newInstance(url, factory.getAdapter(code, this)))
                .commit();
    }

    @Override
    protected int flateLayout() {
        int layoutId = getIntent().getIntExtra(ARG_PARAM3, R.layout.layout_activity_list);
        return layoutId;
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
