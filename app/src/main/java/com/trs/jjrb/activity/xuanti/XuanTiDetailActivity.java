package com.trs.jjrb.activity.xuanti;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.activity.BaseActivity;

import net.cachapa.expandablelayout.ExpandableLayout;

import butterknife.BindView;
import butterknife.OnClick;

public class XuanTiDetailActivity extends BaseActivity {
    @BindView(R.id.expand1)
    ExpandableLayout expand1;
    @BindView(R.id.expand2)
    ExpandableLayout expand2;
    @BindView(R.id.expand3)
    ExpandableLayout expand3;
    @BindView(R.id.expand4)
    ExpandableLayout expand4;
    @BindView(R.id.tv_cname)
    TextView tvCname;

    public static final String ARG_PARAM2 = "cname";

    @Override
    protected void getData() {
        String title = getIntent().getStringExtra(ARG_PARAM2);
        if (!TextUtils.isEmpty(title))
            tvCname.setText(title);
    }

    @Override
    protected int flateLayout() {
        return R.layout.activity_xuan_ti_detail;
    }

    @OnClick({R.id.iv_back, R.id.tv_title1, R.id.tv_title2,
            R.id.tv_title3, R.id.tv_title4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_title1:
                expand1.toggle();
                break;
            case R.id.tv_title2:
                expand2.toggle();
                break;
            case R.id.tv_title3:
                expand3.toggle();
                break;
            case R.id.tv_title4:
                expand4.toggle();
                break;
        }
    }
}
