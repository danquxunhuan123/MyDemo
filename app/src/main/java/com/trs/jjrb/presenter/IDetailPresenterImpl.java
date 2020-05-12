package com.trs.jjrb.presenter;

import android.content.Context;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.trs.jjrb.bean.Detail;
import com.trs.jjrb.model.IModel;
import com.trs.jjrb.model.IModelImpl;
import com.trs.jjrb.okhttp.callback.MyCallback;
import com.trs.waijiaobu.presenter.inter.IDetailPresenter;
import com.trs.waijiaobu.presenter.inter.IDetailView;

import okhttp3.Call;

/**
 * creator：liufan
 * data: 2019/7/24
 */
public class IDetailPresenterImpl implements IDetailPresenter {
    IDetailView mView;
    private IModel mModel;
    private Context mContext;

    public IDetailPresenterImpl(Context context, IDetailView view) {
        this.mView = view;
        mContext = context;
        mModel = new IModelImpl();
    }

    @Override
    public void getData(String url) {
        mModel.getDetailData(mContext, url, new MyCallback(mContext) {
            @Override
            public void OnResponse(Call call, String json) {
                if (json.startsWith("{")) {
                    Gson gson = new Gson();
                    Detail detail = gson.fromJson(json, Detail.class);
                    mView.getData(detail);
                } else {
                    ToastUtils.showShort("error json format");
                }
            }

            @Override
            public void OnFailure(Call call, String error) {

            }
        });
    }
}
