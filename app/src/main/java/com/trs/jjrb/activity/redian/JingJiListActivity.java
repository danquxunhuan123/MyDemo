package com.trs.jjrb.activity.redian;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JingJiListActivity extends BaseActivity {

    @BindView(R.id.tv_cname)
    TextView cname;
    @BindView(R.id.iv_1)
    ImageView iv1;
    @BindView(R.id.iv_2)
    ImageView iv2;

    public static final String ARG_PARAM1 = "url";
    public static final String ARG_PARAM2 = "cname";

    @Override
    protected void initView() {
    }

    @Override
    protected void getData() {
        int index = getIntent().getIntExtra(ARG_PARAM1,0);
        if (index == 0){
            iv1.setImageResource(R.drawable.hb_1);
            iv2.setImageResource(R.drawable.hb_2);
        }
        if (index == 1){
            iv1.setImageResource(R.drawable.tb_1);
            iv2.setImageResource(R.drawable.tb_2);
        }

        String title = getIntent().getStringExtra(ARG_PARAM2);
        if (!TextUtils.isEmpty(title))
            cname.setText(title);
    }

    @Override
    protected int flateLayout() {
        return R.layout.layout_activity_jingji_list;
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
