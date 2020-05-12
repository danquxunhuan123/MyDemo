package com.trs.jjrb.activity.redian;

import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.activity.BaseActivity;
import com.trs.jjrb.adapter.AdapterFactory;
import com.trs.jjrb.adapter.GridListAdapter;
import com.trs.jjrb.fragment.CommenListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class WeiXinReDianListActivity extends BaseActivity
{

    @BindView(R.id.iv_back)
    ImageView back;
    @BindView(R.id.tv_cname)
    TextView cname;
    @BindView(R.id.ll_top)
    LinearLayout top;
    @BindView(R.id.tv_wz)
    TextView tvWz;
    @BindView(R.id.tv_gzh)
    TextView tvGzh;

    public static final String ARG_PARAM1 = "url";
    public static final String ARG_PARAM2 = "cname";

    @Override
    protected void initView() {
        String title = getIntent().getStringExtra(ARG_PARAM2);
        if (!TextUtils.isEmpty(title))
            cname.setText(title);

        top.addView(getTopView(),2);
    }

    private View getTopView(){
        List list = new ArrayList();
        list.add("总榜");
        list.add("政治");
        list.add("媒体");
        list.add("财经");
        list.add("环保");
        list.add("科技");
        list.add("房产");
        list.add("健康");
        list.add("教育");
        list.add("体育");
        list.add("文化");
        list.add("社会");
        RecyclerView recyclerView = new RecyclerView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        recyclerView.setPadding(10,15,10,15);
        recyclerView.setLayoutParams(params);
        recyclerView.setBackgroundColor(Color.WHITE);
        GridLayoutManager manager = new GridLayoutManager(this, 6);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new GridListAdapter(this,list));
        return recyclerView;
    }

    @Override
    protected void getData() {
        String url = getIntent().getStringExtra(ARG_PARAM1);
        AdapterFactory factory = new AdapterFactory.AdapterCreator();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_content
                , CommenListFragment.newInstance(url, factory.getAdapter(3, this)))
                .commit();
    }

    @Override
    protected int flateLayout() {
        return R.layout.layout_activity_weixin_redian_list;
    }

    @OnClick({R.id.iv_back,R.id.tv_wz, R.id.tv_gzh})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_wz:
                break;
            case R.id.tv_gzh:
                break;
        }
    }
}
