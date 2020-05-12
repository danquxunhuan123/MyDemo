package com.trs.jjrb.activity.redian;

import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.blankj.utilcode.util.TimeUtils;
import com.trs.jjrb.R;
import com.trs.jjrb.activity.BaseActivity;
import com.trs.jjrb.adapter.AdapterFactory;
import com.trs.jjrb.adapter.GridListAdapter;
import com.trs.jjrb.fragment.CommenListFragment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class WeiBoReDianListActivity extends BaseActivity{

    @BindView(R.id.iv_back)
    ImageView back;
    @BindView(R.id.tv_cname)
    TextView cname;
    @BindView(R.id.ll_top)
    LinearLayout topView;

    public static final String ARG_PARAM1 = "url";
    public static final String ARG_PARAM2 = "cname";
    private PopupWindow pop;

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
                , CommenListFragment.newInstance(url, factory.getAdapter(2, this)))
                .commit();
    }

    @Override
    protected int flateLayout() {
        return R.layout.layout_activity_weibo_redian_list;
    }

    @OnClick({R.id.iv_back, R.id.tv_city, R.id.tv_time})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                if (pop != null && pop.isShowing()) pop.dismiss();
                finish();
                break;
            case R.id.tv_city:
                selectCity();
                break;
            case R.id.tv_time:
                selectTime();
                break;
        }
    }

    private void selectCity() {
        if (pop == null){
            List list = new ArrayList();
            list.add("全部");
            list.add("北京");
            list.add("河北");
            list.add("天津");
            list.add("山西");
            list.add("山东");
            RecyclerView recyclerView = new RecyclerView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            recyclerView.setPadding(10,15,10,15);
            recyclerView.setLayoutParams(params);
            recyclerView.setBackgroundColor(Color.WHITE);
            GridLayoutManager manager = new GridLayoutManager(this, 6);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(new GridListAdapter(this,list));

            pop = new PopupWindow(recyclerView,
                    LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            pop.setBackgroundDrawable(null);
            pop.setOutsideTouchable(false);
        }else {
            if (pop.isShowing()){
                pop.dismiss();
                return;
            }
        }

        pop.showAsDropDown(topView,0,0);
    }

    private void selectTime() {
        //时间选择器
        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                Toast.makeText(WeiBoReDianListActivity.this
                        ,TimeUtils.date2String(date),
                        Toast.LENGTH_SHORT).show();
            }
        })
                .setLabel("","","",
                        "","","")
                .isCenterLabel(true)
                .isDialog(false)
                .build();
        pvTime.show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if (pop != null && pop.isShowing()) pop.dismiss();
        }
        return super.onKeyDown(keyCode, event);
    }
}
