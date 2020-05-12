package com.trs.jjrb.activity.xiansuo;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.activity.BaseActivity;
import com.trs.jjrb.adapter.AdapterFactory;
import com.trs.jjrb.adapter.BaseAdapter;
import com.trs.jjrb.adapter.xiansuo.ZaiHaiListAdapter;
import com.trs.jjrb.fragment.CommenListFragment;
import com.trs.jjrb.view.IListView;

import butterknife.BindView;
import butterknife.OnClick;

public class ZaiHaiListActivity extends BaseActivity
{

    @BindView(R.id.iv_back)
    ImageView back;
    @BindView(R.id.tv_cname)
    TextView cname;

    public static final String ARG_PARAM1 = "url";
    public static final String ARG_PARAM2 = "cname";

    @Override
    protected void initView() {
        String title = getIntent().getStringExtra(ARG_PARAM2);
        if (!TextUtils.isEmpty(title))
            cname.setText(title);
    }

    @Override
    protected void getData() {
        String url = getIntent().getStringExtra(ARG_PARAM1);
        AdapterFactory factory = new AdapterFactory.AdapterCreator();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_content
                , CommenListFragment.newInstance(url, factory.getAdapter(11, this)))
                .commit();

    }

    @Override
    protected int flateLayout() {
        return R.layout.layout_activity_zaihai_list;
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
