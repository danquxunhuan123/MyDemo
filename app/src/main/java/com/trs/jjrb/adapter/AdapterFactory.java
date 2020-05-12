package com.trs.jjrb.adapter;

import android.content.Context;

import com.trs.jjrb.adapter.fenxi.FenXiAdapter;
import com.trs.jjrb.adapter.redian.DiYuReDianListAdapter;
import com.trs.jjrb.adapter.redian.ReDianListAdapter;
import com.trs.jjrb.adapter.redian.WangMeiAdapter;
import com.trs.jjrb.adapter.redian.WeiBoReDianListAdapter;
import com.trs.jjrb.adapter.redian.WeiXinReDianListAdapter;
import com.trs.jjrb.adapter.redian.ZhiMeiListAdapter;
import com.trs.jjrb.adapter.user.CeHuaAdapter;
import com.trs.jjrb.adapter.xiansuo.DuZheBaoLiaoAdapter;
import com.trs.jjrb.adapter.xiansuo.JuJiaoListAdapter;
import com.trs.jjrb.adapter.xiansuo.RenGongListAdapter;
import com.trs.jjrb.adapter.xiansuo.TuFaListAdapter;
import com.trs.jjrb.adapter.xiansuo.ZaiHaiListAdapter;
import com.trs.jjrb.adapter.xuanti.BaoTiHuiZongAdapter;
import com.trs.jjrb.adapter.xuanti.BuMenGuanLiAdapter;
import com.trs.jjrb.adapter.xuanti.XuanTiHuiZongAdapter;

/**
 * creator：liufan
 * data: 2019/7/31
 */
public interface AdapterFactory {
    BaseAdapter getAdapter(int tag, Context context);

    class AdapterCreator implements AdapterFactory {

        @Override
        public BaseAdapter getAdapter(int tag, Context context) {
            BaseAdapter adapter = null;
            switch (tag) {
                case 0:
                    adapter = new ReDianListAdapter(null, context);
                    break;
                case 1:
                    adapter = new FenXiAdapter(null, context);
                    break;
                case 2:
                    adapter = new WeiBoReDianListAdapter(null, context);
                    break;
                case 3:
                    adapter = new WeiXinReDianListAdapter(null, context);
                    break;
                case 4:
                    adapter = new CeHuaAdapter(null, context);
                    break;
                case 5:
                    adapter = new WangMeiAdapter(null, context);
                    break;
                case 6:
                    adapter = new DiYuReDianListAdapter(null, context);
                    break;
                case 7:
                    adapter = new BuMenGuanLiAdapter(null, context);
                    break;
                case 8:
                    adapter = new BaoTiHuiZongAdapter(null, context);
                    break;
                case 9:
                    adapter = new XuanTiHuiZongAdapter(null, context);
                    break;
                case 10:
                    adapter = new TuFaListAdapter(null, context);
                    break;
                case 11:
                    adapter = new ZaiHaiListAdapter(null, context);
                    break;
                case 12:
                    adapter = new JuJiaoListAdapter(null, context);
                    break;
                case 13:
                    adapter = new ZhiMeiListAdapter(null, context);
                    break;
                case 14:
                    adapter = new RenGongListAdapter(null, context);
                    break;
                case 15:
                    adapter = new DuZheBaoLiaoAdapter(null, context);
                    break;
            }
            return adapter;
        }
    }
}
