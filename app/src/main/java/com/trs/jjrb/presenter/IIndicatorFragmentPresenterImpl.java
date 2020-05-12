package com.trs.jjrb.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.trs.jjrb.bean.Channel;
import com.trs.jjrb.model.IModel;
import com.trs.jjrb.model.IModelImpl;
import com.trs.jjrb.okhttp.callback.MyCallback;
import com.trs.jjrb.presenter.inter.IIndicatorFragmentPresenter;
import com.trs.jjrb.view.IIndicatorFragmentView;

import okhttp3.Call;

/**
 * creator：liufan
 * data: 2019/7/23
 */
public class IIndicatorFragmentPresenterImpl implements IIndicatorFragmentPresenter {
    IModel mModel;
    IIndicatorFragmentView view;
    private Context mContext;

    public IIndicatorFragmentPresenterImpl(Context context, IIndicatorFragmentView view) {
        mModel = new IModelImpl();
        mContext = context;
        this.view = view;
    }

    @Override
    public void getXW(String url) {
        mModel.getChannel(mContext, url, new MyCallback(mContext) {
            @Override
            public void OnResponse(Call call, String json) {
                Gson gson = new Gson();
                Channel channel = gson.fromJson(json, Channel.class);
                view.getXW(channel);
            }

            @Override
            public void OnFailure(Call call, String error) {

            }
        });
    }
}
