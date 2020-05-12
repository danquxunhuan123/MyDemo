package com.trs.jjrb.fragment.fenxi;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;

import com.trs.jjrb.R;
import com.trs.jjrb.adapter.AdapterFactory;
import com.trs.jjrb.fragment.BaseFragment;
import com.trs.jjrb.fragment.CommenListFragment;
import com.trs.jjrb.fragment.FragmentInit;
import com.trs.jjrb.view.ICommenListView;

import java.util.List;

public class ListFenXiFragment extends BaseFragment implements
        FragmentInit {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static ListFenXiFragment newInstance(String param1, String param2) {
        ListFenXiFragment fragment = new ListFenXiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int flateLayout() {
        return R.layout.layout_list_fenxi;
    }

    @Override
    public void initSomeThing() {
    }

    @Override
    protected FragmentInit initInterface() {
        return this;
    }

    @Override
    public void getData() {
        String url = getArguments().getString(ARG_PARAM1);
        AdapterFactory factory = new AdapterFactory.AdapterCreator();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_content
                , CommenListFragment.newInstance(url, factory.getAdapter(1, mContext)))
                .commit();

    }
}
