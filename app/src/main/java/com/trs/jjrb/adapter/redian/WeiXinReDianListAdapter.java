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
import com.trs.jjrb.adapter.MyHolder;
import com.trs.jjrb.adapter.xiansuo.JuJiaoListAdapter;
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
public class WeiXinReDianListAdapter extends BaseAdapter {
    private final int TYPE_NORMAL = 0; //normal type

    public WeiXinReDianListAdapter(List listData, Context context) {
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
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_weixin_redian_item, null);
            default:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_weixin_redian_item, null);
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
////                    source = "外交部";
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
                        ((TextView) holder.getView(R.id.tv_date)),
                        ((TextView) holder.getView(R.id.tv_source)));
                ImageView view = (ImageView) holder.getView(R.id.iv_pic);
                view.setVisibility(View.VISIBLE);
                GlideHelper.getInstance().loadResource(view,R.drawable.pic_list);

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

    private void setData(int position,TextView title,TextView date,TextView source){
        switch (position){
            case 0:
                title.setText("报应来了，这个国家乱了，苍天饶过谁");
                date.setText("2019/11/25");
                source.setText("黄生看金融");
                break;
            case 1:
                title.setText("原创丨伊朗暴乱幕后黑手被扒，高效平暴方式很神奇！" );
                date.setText("2019/11/25");
                source.setText("占豪");
                break;
            case 2:
                title.setText("朝鲜的耐心是有限的" );
                date.setText("2019-05-09");
                source.setText("新财迷");
                break;
            case 3:
                title.setText("面对特朗普的威逼，刚与中国达成合作的该国，坚定支持我们");
                date.setText("2019-05-09");
                source.setText("新财迷");
                break;
            case 4:
                title.setText("又一个美丽的她走了！鼎盛背后，到底有多少腐烂！");
                date.setText("2019-05-09");
                source.setText("新财迷");
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

    public WeiXinReDianListAdapter(Parcel in) {

    }

    public static final Creator<WeiXinReDianListAdapter> CREATOR = new Creator<WeiXinReDianListAdapter>() {
        @Override
        public WeiXinReDianListAdapter createFromParcel(Parcel in) {
            return new WeiXinReDianListAdapter(in);
        }

        @Override
        public WeiXinReDianListAdapter[] newArray(int size) {
            return new WeiXinReDianListAdapter[size];
        }
    };
}
