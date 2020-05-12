package com.trs.jjrb.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.trs.jjrb.adapter.redian.ReDianListAdapter;
import com.trs.jjrb.bean.Channel;
import com.trs.jjrb.bean.Document;
import com.trs.jjrb.model.IModel;
import com.trs.jjrb.model.IModelImpl;
import com.trs.jjrb.okhttp.callback.MyCallback;
import com.trs.jjrb.presenter.inter.IListCommenPresenter;
import com.trs.jjrb.util.StringUtil;
import com.trs.jjrb.view.ICommenListView;
import com.trs.jjrb.view.IListView;

import java.util.List;

import okhttp3.Call;

/**
 * creator：liufan
 * data: 2019/11/22
 */
public class IListCommenPresenterImpl implements IListCommenPresenter {
    private ICommenListView mView;
    private Context mContext;
    private IModel mModel;

    public IListCommenPresenterImpl(Context context, ICommenListView view) {
        mContext = context;
        mModel = new IModelImpl();
        mView = view;
    }

    @Override
    public void getList(final String url) {
        mModel.getChannelList(mContext, url, new MyCallback(mContext) {
            @Override
            public void OnResponse(Call call, String json) {
                if (json.startsWith("{")) {
                    Gson gson = new Gson();
                    String subUrl = StringUtil.subUrlSuffix(url);
                    Object object = null;
                    if ("channels".equals(subUrl)) {
                        object = gson.fromJson(json, Channel.class);
                    } else if (subUrl.startsWith("documents")) {  //"documents".equals(subUrl)
                        object = gson.fromJson(json, Document.class);
                    }

                    List list = null;
                    if (object instanceof Channel)
                        list = ((Channel) object).getGd();
                    else if (object instanceof Document)
                        list = ((Document) object).getList_datas();

                    mView.getList(list);
                } else {
                    mView.onFailure();
                }
            }

            @Override
            public void OnFailure(Call call, String error) {
                mView.onFailure();
            }
        });
    }
}
