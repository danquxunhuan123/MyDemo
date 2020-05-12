package com.trs.jjrb.adapter.redian;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.activity.ListActivity;
import com.trs.jjrb.activity.NewsDetailActivity;
import com.trs.jjrb.adapter.BaseAdapter;
import com.trs.jjrb.adapter.ListCommenAdapter;
import com.trs.jjrb.adapter.MyHolder;
import com.trs.jjrb.bean.Channel;
import com.trs.jjrb.bean.Document;
import com.trs.jjrb.glide.GlideHelper;
import com.trs.jjrb.util.StringUtil;
import com.trs.jjrb.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * creator：liufan
 * data: 2019/7/22
 */
public class BangDanListAdapter extends BaseAdapter {
    private List<Document.List_datasEntity> bannerData;
    private List<String> imgUrls;
    private List<String> titles;
    private final int TYPE_BANNER = 1; //banner type
    private final int TYPE_NORMAL = 0; //normal type
    private final int TYPE_MANY_PIC = 2; //many pic type

    public BangDanListAdapter(List<Document.List_datasEntity> top_datas, List listData, Context context) {
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
        return TYPE_NORMAL;
    }

    @Override
    public MyHolder createHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_NORMAL:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_bangdan_item, null);
            default:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_bangdan_item, null);
        }
    }

    @Override
    protected void bindHolder(MyHolder holder, int position) {
        switch (getItemType(position)) {
            case TYPE_NORMAL:
                Object obj = list.get(position);
                String cname = null;
                String date = null;
                String source = null;
                String url = null;
                String logo = null;

                if (obj instanceof Document.List_datasEntity) {
                    Document.List_datasEntity document = (Document.List_datasEntity) obj;
                    cname = document.getTitle();
                    date = document.getUpdatedate();
//                    source = "外交部";
                    List<String> cimgs = document.getCimgs();
                    if (cimgs != null && cimgs.size() > 0)
                        logo = cimgs.get(0);
                    url = document.getUrl();

                } else if (obj instanceof Channel.GdEntity) {
                    Channel.GdEntity channel = (Channel.GdEntity) obj;
                    cname = channel.getCname();
//                    date = channel.getLmt();
                    date = "";
//                    source = "外交部";
//            cimgs = data.getCimgs();
                    logo = channel.getLogo();
                    url = channel.getDocuments();
                }

                cname = StringUtils.replaceStr(cname);
                ((TextView) holder.getView(R.id.tv_title)).setText(
                        "牢牢把握主题教育的主线——论扎实开展“不忘初心、牢记使命”");
                ((TextView) holder.getView(R.id.tv_date)).setText("2019-05-09");
                ((TextView) holder.getView(R.id.tv_source)).setText("新华社");
                ImageView view = (ImageView) holder.getView(R.id.iv_pic);
//                if (!TextUtils.isEmpty(logo)) {
                view.setVisibility(View.VISIBLE);
                GlideHelper.getInstance().loadResource(view,R.drawable.pic_list);
//                    GlideHelper.getInstance().load(view, logo);
//                } else {
//                    view.setVisibility(View.GONE);
//                }

                final String finalUrl = url;
//                final String finalCname = cname;
                holder.getItemView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        if (!finalUrl.endsWith(".json")) {
//                            if (mOnClickListener != null)
//                                mOnClickListener.onClick(finalUrl);
//                            return;
//                        }

                        String subUrl = StringUtil.subUrlSuffix(finalUrl);
                        Intent intent = null;
                        if ("documents".equals(subUrl) || "channels".equals(subUrl)) {
                            intent = new Intent(context, ListActivity.class);
//                            intent.putExtra(ListActivity.ARG_PARAM2, finalCname);
                        } else {
                            intent = new Intent(context, NewsDetailActivity.class);
                        }

                        intent.putExtra(ListActivity.ARG_PARAM1, finalUrl);
                        context.startActivity(intent);
                    }
                });
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

    public BangDanListAdapter(Parcel in) {

    }

    public static final Creator<BangDanListAdapter> CREATOR = new Creator<BangDanListAdapter>() {
        @Override
        public BangDanListAdapter createFromParcel(Parcel in) {
            return new BangDanListAdapter(in);
        }

        @Override
        public BangDanListAdapter[] newArray(int size) {
            return new BangDanListAdapter[size];
        }
    };
}
