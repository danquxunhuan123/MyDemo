package com.trs.jjrb.activity.xuanti;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.activity.BaseActivity;
import com.trs.jjrb.adapter.GridListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class AddXuanTiActivity extends BaseActivity {

    public static final String ARG_PARAM1 = "url";
    public static final String ARG_PARAM2 = "cname";
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_cname)
    TextView tvCname;
    @BindView(R.id.tv_name)
    EditText tvName;
    @BindView(R.id.tv_px)
    EditText tvPx;
    @BindView(R.id.rg_state)
    RadioGroup rgState;
    @BindView(R.id.tv_spr)
    EditText tvSpr;
    @BindView(R.id.rv_zz)
    RecyclerView rvZz;
    @BindView(R.id.rv_ry)
    RecyclerView rvRy;

    @Override
    protected void getData() {
        String title = getIntent().getStringExtra(ARG_PARAM2);

        if (!TextUtils.isEmpty(title))
            tvCname.setText(title);
        initChannel();
    }

    @Override
    protected int flateLayout() {
        return R.layout.activity_add_xuan_ti;
    }

    private void initChannel() {
        List list = new ArrayList();
        for (int i = 0; i < 3; i++) {
            list.add("杨泽东");
        }
        rvZz.setLayoutManager(new GridLayoutManager(this, 3));
        rvZz.setAdapter(new GridListAdapter(this, list));
        rvRy.setLayoutManager(new GridLayoutManager(this, 3));
        rvRy.setAdapter(new GridListAdapter(this, list));
    }

    public void cancle(View view) {
    }

    public void commit(View view) {
    }

    @OnClick({R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

}
