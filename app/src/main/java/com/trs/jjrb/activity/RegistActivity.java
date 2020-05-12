package com.trs.jjrb.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.util.StringUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class RegistActivity extends BaseActivity {
    @BindView(R.id.tv_cname)
    TextView cname;
    @BindView(R.id.btn_regist)
    Button regist;

    public static final String ARG_PARAM1 = "url";
    public static final String ARG_PARAM2 = "cname";
    @Override
    protected int flateLayout() {
        return R.layout.activity_regist;
    }

    @Override
    protected void getData() {
        String title = getIntent().getStringExtra(ARG_PARAM2);

        if (!TextUtils.isEmpty(title)){
            regist.setText(title);
            cname.setText(title);
        }
    }

    public void getCode(View view) {
    }

    public void commit(View view) {
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
