package com.trs.jjrb.activity;

import android.content.Intent;
import android.view.View;

import com.trs.jjrb.R;

import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @Override
    protected int flateLayout() {
        return R.layout.activity_login;
    }

    public void forgetPsd(View view) {
        Intent intent = new Intent(this,RegistActivity.class);
        intent.putExtra(RegistActivity.ARG_PARAM2,"忘记密码");
        startActivity(intent);
    }

    public void login(View view) {
    }

    public void regist(View view) {
        Intent intent = new Intent(this,RegistActivity.class);
        intent.putExtra(RegistActivity.ARG_PARAM2,"注册");
        startActivity(intent);
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
