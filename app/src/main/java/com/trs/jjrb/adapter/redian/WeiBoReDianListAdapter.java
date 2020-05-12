package com.trs.jjrb.adapter.redian;

import android.content.Context;
import android.os.Parcel;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.adapter.BaseAdapter;
import com.trs.jjrb.adapter.MyHolder;

import java.util.List;

/**
 * creator：liufan
 * data: 2019/7/22
 */
public class WeiBoReDianListAdapter extends BaseAdapter {
    private final int TYPE_NORMAL = 0; //normal type

    public WeiBoReDianListAdapter(List listData, Context context) {
        super(listData, context);
    }

    @Override
    protected int getItemType(int position) {
        return TYPE_NORMAL;
    }

    @Override
    public MyHolder createHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_NORMAL:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_weibo_redian_item, null);
            default:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_weibo_redian_item, null);
        }
    }

    @Override
    protected void bindHolder(MyHolder holder, int position) {
        switch (getItemType(position)) {
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
//
//                cname = StringUtils.replaceStr(cname);

                setData(position,((TextView) holder.getView(R.id.tv_title)),
                        ((TextView) holder.getView(R.id.tv_num)));

//                final String finalUrl = url;
//                holder.getItemView().setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        String subUrl = StringUtil.subUrlSuffix(finalUrl);
//                        Intent intent = null;
//                        if ("documents".equals(subUrl) || "channels".equals(subUrl)) {
//                            intent = new Intent(context, ListActivity.class);
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

    private void setData(int position,TextView title,TextView date){
        switch (position){
            case 0:
                title.setText("【深圳打造区块链“创新高地”】");
                date.setText("7048");
                break;
            case 1:
                title.setText("【区税务局联合多部门举办宪法宣誓活动】");
                date.setText("4640");
                break;
            case 2:
                title.setText("【市税务局让纳税人多跑“网路”少跑“马路”】 ");
                date.setText("3230");
                break;
            case 3:
                title.setText("【国家税务总局宿松县税务局长铺税务分局局长许言一接受纪律审查和监察调查】");
                date.setText("3230");
                break;
            case 4:
                title.setText("【全市政务服务系统作风效能建设暨专项整治推进会召开】");
                date.setText("3214");
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

    public WeiBoReDianListAdapter(Parcel in) {

    }

    public static final Creator<WeiBoReDianListAdapter> CREATOR = new Creator<WeiBoReDianListAdapter>() {
        @Override
        public WeiBoReDianListAdapter createFromParcel(Parcel in) {
            return new WeiBoReDianListAdapter(in);
        }

        @Override
        public WeiBoReDianListAdapter[] newArray(int size) {
            return new WeiBoReDianListAdapter[size];
        }
    };
}
