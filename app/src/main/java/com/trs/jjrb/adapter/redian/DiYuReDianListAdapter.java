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
public class DiYuReDianListAdapter extends BaseAdapter {
    private final int TYPE_NORMAL = 0; //normal type

    public DiYuReDianListAdapter(List listData, Context context) {
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
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_diyu_redian_item, null);
            default:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_diyu_redian_item, null);
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
                        ((TextView) holder.getView(R.id.tv_date)),
                        ((TextView) holder.getView(R.id.tv_source)));
                ImageView view = (ImageView) holder.getView(R.id.iv_pic);
                view.setVisibility(View.VISIBLE);
                GlideHelper.getInstance().loadResource(view,R.drawable.pic_list);

//                final String finalUrl = url;
//                holder.getItemView().setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
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
                title.setText("7省市率先使用医保电子凭证 看病不带卡刷刷医保码");
                date.setText("2019/11/25");
                source.setText("人民日报");
                break;
            case 1:
                title.setText("中办国办印发强化知识产权保护意见");
                date.setText("2019/11/25");
                source.setText("经济参考报");
                break;
            case 2:
                title.setText("骗取个人信息盗刷银行卡 “携号转网”这些骗局...");
                date.setText("2019-05-09");
                source.setText("新浪网");
                break;
            case 3:
                title.setText("坚持问题导向 解决党风问题");
                date.setText("2019-05-09");
                source.setText("新京报评论");
                break;
            case 4:
                title.setText("江南华南局地降温超10℃ 南方7省会开启入冬");
                date.setText("2019-05-09");
                source.setText("中国新闻网");
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

    public DiYuReDianListAdapter(Parcel in) {

    }

    public static final Creator<DiYuReDianListAdapter> CREATOR = new Creator<DiYuReDianListAdapter>() {
        @Override
        public DiYuReDianListAdapter createFromParcel(Parcel in) {
            return new DiYuReDianListAdapter(in);
        }

        @Override
        public DiYuReDianListAdapter[] newArray(int size) {
            return new DiYuReDianListAdapter[size];
        }
    };
}
