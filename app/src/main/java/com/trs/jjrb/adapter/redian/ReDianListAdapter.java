package com.trs.jjrb.adapter.redian;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.activity.ListActivity;
import com.trs.jjrb.activity.NewsDetailActivity;
import com.trs.jjrb.adapter.BaseAdapter;
import com.trs.jjrb.adapter.MyHolder;
import com.trs.jjrb.bean.Channel;
import com.trs.jjrb.bean.Document;
import com.trs.jjrb.glide.GlideHelper;
import com.trs.jjrb.util.StringUtil;
import com.trs.jjrb.util.StringUtils;

import java.util.List;

/**
 * creator：liufan
 * data: 2019/7/22
 */
public class ReDianListAdapter extends BaseAdapter{
    private final int TYPE_NORMAL = 0; //normal type

    public ReDianListAdapter(List listData, Context context) {
        super(listData, context);
    }

    public ReDianListAdapter(Parcel in) {

    }

    @Override
    protected int getItemType(int position) {
        return TYPE_NORMAL;
    }

    @Override
    public MyHolder createHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_NORMAL:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_redian_item, null);
            default:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_redian_item, null);
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
                title.setText("中办国办印发强化知识产权保护意见");
                date.setText("2019/11/25");
                source.setText("新华社");
                break;
            case 1:
                title.setText("联播+| 为世界谋大同 习近平频提这一主张");
                date.setText("2019/11/25");
                source.setText("人民论坛网");
                break;
            case 2:
                title.setText("日兰高铁日曲段11月26日开通 沂蒙革命老区接入全国高铁网");
                date.setText("2019-05-09");
                source.setText("新华社");
                break;
            case 3:
                title.setText("监管层接连出拳打击虚拟货币交易");
                date.setText("2019-05-09");
                source.setText("新华社");
                break;
            case 4:
                title.setText("11月24日粘胶短纤与人棉纱比价指数为91.75");
                date.setText("2019-05-09");
                source.setText("新华社");
                break;
        }
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Creator<ReDianListAdapter> CREATOR = new Creator<ReDianListAdapter>() {
        @Override
        public ReDianListAdapter createFromParcel(Parcel in) {
            return new ReDianListAdapter(in);
        }

        @Override
        public ReDianListAdapter[] newArray(int size) {
            return new ReDianListAdapter[size];
        }
    };

    public interface OnClickListener {
        void onClick(String finalu);
    }

    private OnClickListener mOnClickListener;

    public void setOnItemClickListener(OnClickListener listener) {
        mOnClickListener = listener;
    }

}
