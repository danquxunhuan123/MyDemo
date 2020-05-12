package com.trs.jjrb.activity.xiansuo;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.activity.BaseActivity;
import com.trs.jjrb.adapter.GridListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddXianSuoActivity extends BaseActivity {
    @BindView(R.id.tv_cname)
    TextView cname;

    public static final String ARG_PARAM1 = "url";
    public static final String ARG_PARAM2 = "cname";
    @BindView(R.id.tv_bq)
    EditText tvBq;
    @BindView(R.id.tv_phone)
    EditText tvPhone;
    @BindView(R.id.tv_address)
    EditText tvAddress;
    @BindView(R.id.rv_channel)
    RecyclerView rvChannel;
    @BindView(R.id.tv_txt)
    EditText tvTxt;

    @Override
    protected void getData() {
        String title = getIntent().getStringExtra(ARG_PARAM2);

        if (!TextUtils.isEmpty(title))
            cname.setText(title);
        initChannel();
    }

    @Override
    protected int flateLayout() {
        return R.layout.activity_add_xian_suo;
    }

    private void initChannel() {
        List list = new ArrayList();
        list.add("政治");
        list.add("财经");
        list.add("司法");
        list.add("军事");
        list.add("社会");
        list.add("地产");
        list.add("科技");
        list.add("游戏");
        list.add("动漫");
        list.add("电商");
        list.add("娱乐");
        GridLayoutManager manager = new GridLayoutManager(this, 6);
        rvChannel.setLayoutManager(manager);
        rvChannel.setAdapter(new GridListAdapter(this, list));
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
