package com.trs.jjrb.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.trs.jjrb.R;
import com.trs.jjrb.adapter.BaseAdapter;
import com.trs.jjrb.adapter.xiansuo.DuZheBaoLiaoAdapter;
import com.trs.jjrb.adapter.xuanti.BuMenGuanLiAdapter;
import com.trs.jjrb.adapter.xuanti.XuanTiHuiZongAdapter;
import com.trs.jjrb.presenter.IListCommenPresenterImpl;
import com.trs.jjrb.presenter.inter.IListCommenPresenter;
import com.trs.jjrb.util.StringUtil;
import com.trs.jjrb.view.ICommenListView;

import java.util.List;

import butterknife.BindView;

public class CommenListFragment extends BaseFragment implements ICommenListView,
        SwipeRefreshLayout.OnRefreshListener,
//        BaseAdapter.OnLoadMoreListener,
        FragmentInit {

    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private static final String LIST_URL = "url";
    private static final String LIST_ADAPTER = "list_adapter";

    private BaseAdapter adapter;
    private String url;
    private IListCommenPresenter mPresenter;
    private int pageCount = 0;
    private String subUrl;

    public static CommenListFragment newInstance(String url, BaseAdapter adapter) {
        CommenListFragment fragment = new CommenListFragment();
        Bundle args = new Bundle();
        args.putString(LIST_URL, url);
        args.putParcelable(LIST_ADAPTER, adapter);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int flateLayout() {
        return R.layout.layout_list_xuanti;
    }

    @Override
    public void initSomeThing() {
        swipeRefreshLayout.setOnRefreshListener(this);
        mPresenter = new IListCommenPresenterImpl(mContext, this);
    }

    @Override
    protected FragmentInit initInterface() {
        return this;
    }

    @Override
    public void getData() {
        adapter = getArguments().getParcelable(LIST_ADAPTER);
//        adapter.setOnLoadMoreListener(this);
        recycleView.setLayoutManager(new LinearLayoutManager(mContext));
        recycleView.setAdapter(adapter);

        url = getArguments().getString(LIST_URL);
        subUrl = StringUtil.subUrlSuffix(url);
        mPresenter.getList(url);
    }

    @Override
    public void onFailure() {
        pageCount--;
        if (adapter != null)
            adapter.loadMoreEnd();
    }

    @Override
    public void onRefresh() {
        pageCount = 0;
        swipeRefreshLayout.setRefreshing(true);
        mPresenter.getList(url);
    }

//    @Override
//    public void OnLoadMore() {
//        if (subUrl.startsWith("documents")) {
//            String moreUrl = url;
//            pageCount++;
//            moreUrl = moreUrl.replace("documents", "documents_" + pageCount);
//            mPresenter.getList(moreUrl);
//        } else {
//            adapter.loadMoreEnd();
//        }
//    }

    @Override
    public void getList(List<Object> list) {
        if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing())
            swipeRefreshLayout.setRefreshing(false);

        if (adapter instanceof DuZheBaoLiaoAdapter)
            list= list.subList(0,4);
        else if (adapter instanceof BuMenGuanLiAdapter
                || adapter instanceof XuanTiHuiZongAdapter){
            list = list.subList(0,1);
        }else if (list.size() > 5)
            list = list.subList(0,5);

        if (pageCount == 0)
            adapter.updateData(list);
        else
            adapter.addData(list);
    }

}
