package com.trs.jjrb.fragment.xuanti;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.trs.jjrb.R;
import com.trs.jjrb.adapter.BaseAdapter;
import com.trs.jjrb.adapter.ListBigPicAdapter;
import com.trs.jjrb.adapter.ListPicLeftAdapter;
import com.trs.jjrb.adapter.MyHolder;
import com.trs.jjrb.adapter.xuanti.BuMenGuanLiAdapter;
import com.trs.jjrb.bean.Channel;
import com.trs.jjrb.bean.Document;
import com.trs.jjrb.fragment.BaseFragment;
import com.trs.jjrb.fragment.FragmentInit;
import com.trs.jjrb.presenter.IListPresenterImpl;
import com.trs.jjrb.util.StringUtil;
import com.trs.jjrb.view.IListView;
import com.trs.waijiaobu.presenter.inter.IListPresenter;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

import java.util.List;

import butterknife.BindView;

public class ListXuanTiFragment extends BaseFragment implements IListView,
        SwipeRefreshLayout.OnRefreshListener,
        BaseAdapter.OnLoadMoreListener, FragmentInit {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private String url;
    private IListPresenter mPresenter;
    private String cname;
    private BaseAdapter adapter;
    private int pageCount = 0;
    private String subUrl;

    public static ListXuanTiFragment newInstance(String param1, String param2) {
        ListXuanTiFragment fragment = new ListXuanTiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
//        recycleView.setRecyclerListener(new RecyclerView.RecyclerListener() {
//            @Override
//            public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
//                NiceVideoPlayer player = (NiceVideoPlayer) ((MyHolder) viewHolder).getView(R.id.video_player);
//                if (player == NiceVideoPlayerManager.instance().getCurrentNiceVideoPlayer()) {
//                    NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
//                }
//            }
//        });

        mPresenter = new IListPresenterImpl(mContext, this);
    }

    @Override
    protected FragmentInit initInterface() {
        return this;
    }

    @Override
    public void getData() {
        url = getArguments().getString(ARG_PARAM1);
        cname = getArguments().getString(ARG_PARAM2);

        subUrl = StringUtil.subUrlSuffix(url);

        swipeRefreshLayout.setRefreshing(true);
        mPresenter.getListData(url);

    }

    @Override
    public void getListData(Object obj) {
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(false);

       /* List mList = null;
        List top_datas = null;
        if (obj instanceof Channel)
            mList = ((Channel) obj).getGd();
        else if (obj instanceof Document) {
            Document doc = (Document) obj;

            mList = doc.getList_datas();
            top_datas = doc.getTop_datas();

            if (top_datas != null && top_datas.size() > 0) {
                Document.List_datasEntity entity = new Document.List_datasEntity();
                mList.add(0, entity);
            }
        }

        if (adapter == null) {
            if ("走出国境".equals(cname))
                adapter = new ListPicLeftAdapter(mList, mContext);
            else if ("发言人表态".equals(cname) || "外交部新闻".equals(cname))
                adapter = new ListBigPicAdapter(mList, mContext);
            else
                adapter = new ListCommenAdapter(null, mList, mContext);

            adapter.setOnLoadMoreListener(this);
            recycleView.setLayoutManager(new LinearLayoutManager(mContext));
            recycleView.setAdapter(adapter);
        } else {
            if (pageCount == 0) {
                if (adapter instanceof ListCommenAdapter) {
                    ((ListCommenAdapter) adapter).setBannerData(top_datas);
                }
                adapter.updateData(mList);
            } else
                adapter.addData(mList);
        }*/


        if (obj instanceof Channel) {
            List<Channel.GdEntity> mList = ((Channel) obj).getGd();

            if (adapter == null) {
                if ("走出国境".equals(cname))
                    adapter = new ListPicLeftAdapter(mList, mContext);
                else
                    adapter = new BuMenGuanLiAdapter(mList, mContext);

                adapter.setOnLoadMoreListener(this);
                recycleView.setLayoutManager(new LinearLayoutManager(mContext));
                recycleView.setAdapter(adapter);
            } else {
                if (pageCount == 0)
                    adapter.updateData(mList);
                else
                    adapter.addData(mList);
            }
        } else if (obj instanceof Document) {
            Document doc = (Document) obj;

            List<Document.List_datasEntity> mList = doc.getList_datas();
            List<Document.List_datasEntity> top_datas = doc.getTop_datas();
            if (top_datas != null && top_datas.size() > 0) {
                Document.List_datasEntity entity = new Document.List_datasEntity();
                mList.add(0, entity);
            }

            if (adapter == null) {
                if ("发言人表态".equals(cname) || "外交部新闻".equals(cname))
                    adapter = new ListBigPicAdapter(mList, mContext);
                else {
                    adapter = new BuMenGuanLiAdapter( mList, mContext);
                }

                adapter.setOnLoadMoreListener(this);
                recycleView.setLayoutManager(new LinearLayoutManager(mContext));
                recycleView.setAdapter(adapter);
            } else {
                if (pageCount == 0) {
//                    if (adapter instanceof BuMenGuanLiAdapter) {
//                        ((BuMenGuanLiAdapter) adapter).setBannerData(top_datas);
//                    }
                    adapter.updateData(mList);
                } else
                    adapter.addData(mList);
            }
        }
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
        mPresenter.getListData(url);
    }

    @Override
    public void OnLoadMore() {
        if (subUrl.startsWith("documents")) {
            String moreUrl = url;
            pageCount++;
            moreUrl = moreUrl.replace("documents", "documents_" + pageCount);
            mPresenter.getListData(moreUrl);
        } else {
            adapter.loadMoreEnd();
        }
    }
}
