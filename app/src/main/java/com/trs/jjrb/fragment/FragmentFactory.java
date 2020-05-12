package com.trs.jjrb.fragment;

import android.support.v4.app.Fragment;

import com.trs.jjrb.fragment.fenxi.ListFenXiFragment;
import com.trs.jjrb.fragment.my.MyFragment;
import com.trs.jjrb.fragment.redian.BangDanFragment;
import com.trs.jjrb.fragment.redian.ReDianFragment;
import com.trs.jjrb.fragment.xiansuo.TuFaFragment;
import com.trs.jjrb.fragment.xiansuo.XianSuoFragment;
import com.trs.jjrb.fragment.xuanti.XuanTiFragment;
import com.trs.waijiaobu.Constant;

/**
 * creator：liufan
 * data: 2019/7/31
 */
public interface FragmentFactory {
    Fragment getFragment(int tag);

    class FragmentCreator implements FragmentFactory{

        @Override
        public Fragment getFragment(int tag) {
            Fragment fragment = null;
            switch (tag){
                case 0:
                    fragment = ReDianFragment.newInstance("", "");
                    break;
                case 1:
                    fragment = XianSuoFragment.newInstance("", "");
                    break;
                case 2:
                    fragment = XuanTiFragment.newInstance(Constant.XWFW, "");
                    break;
                case 3:
                    fragment = ListFenXiFragment.newInstance(Constant.PUSH_MSG, "");
                    break;
                case 4:
                    fragment = MyFragment.newInstance("", "");
                    break;
                case 5:
                    fragment = TuFaFragment.newInstance(Constant.XWFW, "");
                    break;
                case 6:
                    fragment = BangDanFragment.newInstance(Constant.XWFW, "");
                    break;
            }
            return fragment;
        }
    }
}
