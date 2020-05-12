package com.trs.jjrb.adapter.xiansuo;

import android.content.Context;
import android.os.Parcel;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.activity.xiansuo.JuJiaoListActivity;
import com.trs.jjrb.adapter.BaseAdapter;
import com.trs.jjrb.adapter.MyHolder;
import com.trs.jjrb.bean.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * creator：liufan
 * data: 2019/7/22
 */
public class JuJiaoListAdapter extends BaseAdapter {
    private List<Document.List_datasEntity> bannerData;
    private List<String> imgUrls;
    private List<String> titles;
    private final int TYPE_1 = 1; //banner type
    private final int TYPE_NORMAL = 0; //normal type
    private final int TYPE_MANY_PIC = 2; //many pic type

    public JuJiaoListAdapter( List listData, Context context) {
        super(listData, context);

    }

    @Override
    protected int getItemType(int position) {
        if (position == 0 || position == 11)
            return TYPE_1;
        return TYPE_NORMAL;
    }

    @Override
    public MyHolder createHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_1:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_jujiao_item_1, null);
            case TYPE_NORMAL:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_jujiao_item, null);
            default:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_jujiao_item, null);
        }
    }

    @Override
    protected void bindHolder(MyHolder holder, int position) {
        switch (getItemType(position)) {
            case TYPE_1:
                ((TextView) holder.getView(R.id.tv_title)).setText(
                        "即时热点汇总");
                break;
            case TYPE_NORMAL:
//                Object obj = list.get(position);
//                String cname = null;
//                String date = null;
//                String source = null;
//                String url = null;
//                String logo = null;
//
//                if (obj instanceof Document.List_datasEntity) {
//                    Document.List_datasEntity document = (Document.List_datasEntity) obj;
//                    cname = document.getTitle();
//                    date = document.getUpdatedate();
//                    List<String> cimgs = document.getCimgs();
//                    if (cimgs != null && cimgs.size() > 0)
//                        logo = cimgs.get(0);
//                    url = document.getUrl();
//
//                } else if (obj instanceof Channel.GdEntity) {
//                    Channel.GdEntity channel = (Channel.GdEntity) obj;
//                    cname = channel.getCname();
//                    date = "";
//                    logo = channel.getLogo();
//                    url = channel.getDocuments();
//                }
                setData(position,((TextView) holder.getView(R.id.tv_title)),
                        ((TextView) holder.getView(R.id.tv_date)),
                        ((TextView) holder.getView(R.id.tv_source)));
//                final String finalUrl = url;
//                holder.getItemView().setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        String subUrl = StringUtil.subUrlSuffix(finalUrl);
//                        Intent intent = null;
//                        if ("documents".equals(subUrl) || "channels".equals(subUrl)) {
//                            intent = new Intent(context, ListActivity.class);
////                            intent.putExtra(ListActivity.ARG_PARAM2, finalCname);
//                        } else {
//                            intent = new Intent(context, NewsDetailActivity.class);
//                        }
//
//                        intent.putExtra(ListActivity.ARG_PARAM1, finalUrl);
//                        context.startActivity(intent);
//                    }
//                });
                break;
            default:
                break;
        }
    }

    private void setData(int position,TextView title,TextView date,TextView source){
        switch (position){
            case 0:
                title.setText("律师支招如何应对暴力裁员");
                date.setText("15:04:07");
                source.setText("荔枝新闻");
                break;
            case 1:
                title.setText("【e公司微访谈】赛意信息：“一体三翼”做好企业数字..");
                date.setText("15:03:18");
                source.setText("e公司");
                break;
            case 2:
                title.setText("比年轻人还会玩！");
                date.setText("15:03:02");
                source.setText("浙江24小时");
                break;
            case 3:
                title.setText("收评：沪指涨0.72% 煤炭、钢铁板块涨幅居前");
                date.setText("15:02:36");
                source.setText("e公司");
                break;
            case 4:
                title.setText("海南医生肖占祥表彰大会在省人民医院举行");
                date.setText("15:01:42");
                source.setText("南海网");
                break;
        }
    }

    public interface OnClickListener {
        void onClick(String finalu);
    }

    private OnClickListener mOnClickListener;

    public void setOnItemClickListener(OnClickListener listener) {
        mOnClickListener = listener;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public JuJiaoListAdapter(Parcel in) {

    }

    public static final Creator<JuJiaoListAdapter> CREATOR = new Creator<JuJiaoListAdapter>() {
        @Override
        public JuJiaoListAdapter createFromParcel(Parcel in) {
            return new JuJiaoListAdapter(in);
        }

        @Override
        public JuJiaoListAdapter[] newArray(int size) {
            return new JuJiaoListAdapter[size];
        }
    };
}
