package com.trs.jjrb.adapter.redian;

import android.content.Context;
import android.os.Parcel;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.adapter.BaseAdapter;
import com.trs.jjrb.adapter.MyHolder;
import com.trs.jjrb.bean.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * creator：liufan
 * data: 2019/7/22
 */
public class JingJiListAdapter extends BaseAdapter {
    private List<Document.List_datasEntity> bannerData;
    private List<String> imgUrls;
    private List<String> titles;
    private final int TYPE_1 = 1; //banner type
    private final int TYPE_NORMAL = 0; //normal type
    private final int TYPE_MANY_PIC = 2; //many pic type

    public JingJiListAdapter(List<Document.List_datasEntity> top_datas, List listData, Context context) {
        super(listData, context);

        initBannerData(top_datas);
    }

    private void initBannerData(List<Document.List_datasEntity> top_datas) {
        if (top_datas != null && top_datas.size() > 0) {
            this.bannerData = top_datas;
            imgUrls = new ArrayList<>();
            titles = new ArrayList<>();
            for (Document.List_datasEntity entity : top_datas) {
                imgUrls.add(entity.getCimgs().get(0));
                titles.add(entity.getTitle());
            }
        }
    }

    public void setBannerData(List<Document.List_datasEntity> top_datas) {
        initBannerData(top_datas);
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
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_toutiao_item_1, null);
            case TYPE_NORMAL:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_toutiao_item, null);
            default:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_toutiao_item, null);
        }
    }

    @Override
    protected void bindHolder(MyHolder holder, int position) {
        switch (getItemType(position)) {
            case TYPE_1:
                ((TextView) holder.getView(R.id.tv_title)).setText(
                        "时事热点top10");
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
                ((TextView) holder.getView(R.id.tv_index)).setText(
                        String.valueOf(position));
                ((TextView) holder.getView(R.id.tv_title)).setText(
                        "习近平的G20金句");

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

    public JingJiListAdapter(Parcel in) {

    }

    public static final Creator<JingJiListAdapter> CREATOR = new Creator<JingJiListAdapter>() {
        @Override
        public JingJiListAdapter createFromParcel(Parcel in) {
            return new JingJiListAdapter(in);
        }

        @Override
        public JingJiListAdapter[] newArray(int size) {
            return new JingJiListAdapter[size];
        }
    };
}
