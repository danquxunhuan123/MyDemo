package com.trs.jjrb.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.trs.jjrb.R;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {
    @BindView(R.id.tv_cname)
    TextView cname;

    public static final String ARG_PARAM1 = "url";
    public static final String ARG_PARAM2 = "cname";

    @Override
    protected int flateLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected void getData() {
        String title = getIntent().getStringExtra(ARG_PARAM2);

        if (!TextUtils.isEmpty(title)) {
            cname.setText(title);
        }
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
