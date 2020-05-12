package com.trs.jjrb.adapter.xiansuo;

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
import com.trs.jjrb.adapter.ListBigPicAdapter;
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
public class ZaiHaiListAdapter extends BaseAdapter {
    private final int TYPE_NORMAL = 0; //normal type

    public ZaiHaiListAdapter( List listData, Context context) {
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
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_zaihai_item, null);
            default:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_zaihai_item, null);
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
                        ((TextView) holder.getView(R.id.tv_t2)),
                        ((TextView) holder.getView(R.id.tv_t3)),
                        ((TextView) holder.getView(R.id.tv_t4)));
                ImageView view = (ImageView) holder.getView(R.id.iv_pic);
                GlideHelper.getInstance().loadResource(view, R.drawable.pic_list);
//                    GlideHelper.getInstance().load(view, logo);
//                } else {
//                    view.setVisibility(View.GONE);
//                }

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

    private void setData(int position, TextView view, TextView title, TextView date, TextView source){
        switch (position){
            case 0:
                view.setText("吉林省和龙市发布道路冰雪黄色预警");
                title.setText("预警级别：黄色预警");
                date.setText("预警发布时间：2019/11/25 14:25:00");
                source.setText("灾害发生地域：吉林省和龙市");
                break;
            case 1:
                view.setText("吉林省敦化市发布道路冰雪黄色预警");
                title.setText("预警级别：黄色预警");
                date.setText("预警发布时间：2019/11/25 14:00:00");
                source.setText("灾害发生地域：吉林省敦化市");
                break;
            case 2:
                view.setText("广西壮族自治区靖西县发布大风蓝色预警");
                title.setText("预警级别：蓝色预警");
                date.setText("预警发布时间：2019/11/25 14:25:00");
                source.setText("灾害发生地域：广西壮族自治区靖西县");
                break;
            case 3:
                view.setText("江西省永修县发布大风蓝色预警");
                title.setText("预警级别：蓝色预警");
                date.setText("预警发布时间：2019/11/25 14:25:00");
                source.setText("灾害发生地域：江西省永修县");
                break;
            case 4:
                view.setText("江西省彭泽县发布大风蓝色预警");
                title.setText("预警级别：蓝色预警");
                date.setText("预警发布时间：2019/11/25 14:25:00");
                source.setText("灾害发生地域：江西省彭泽县");
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

    public ZaiHaiListAdapter(Parcel in) {

    }

    public static final Creator<ZaiHaiListAdapter> CREATOR = new Creator<ZaiHaiListAdapter>() {
        @Override
        public ZaiHaiListAdapter createFromParcel(Parcel in) {
            return new ZaiHaiListAdapter(in);
        }

        @Override
        public ZaiHaiListAdapter[] newArray(int size) {
            return new ZaiHaiListAdapter[size];
        }
    };
}
