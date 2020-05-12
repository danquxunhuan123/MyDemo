package com.trs.jjrb.adapter.xiansuo;

import android.content.Context;
import android.os.Parcel;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.adapter.BaseAdapter;
import com.trs.jjrb.adapter.MyHolder;
import com.trs.jjrb.glide.GlideHelper;

import java.util.List;

/**
 * creator：liufan
 * data: 2019/7/22
 */
public class DuZheBaoLiaoAdapter extends BaseAdapter {
    private final int TYPE_NORMAL = 0; //normal type

    public DuZheBaoLiaoAdapter(List listData, Context context) {
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
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_dzbl_item, null);
            default:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_dzbl_item, null);
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
//                if (!TextUtils.isEmpty(logo)) {
//                    view.setVisibility(View.VISIBLE);
//                    GlideHelper.getInstance().load(view, logo);
//                } else {
//                    view.setVisibility(View.GONE);
//                }
//
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
                title.setText("从“提篮叫卖”到“全球买卖”");
                date.setText("2019-11-19");
                source.setText("wql123");
                break;
            case 1:
                title.setText("商务部11月18日发布的最新数据");
                date.setText("2019-11-19");
                source.setText("wql123");
                break;
            case 2:
                title.setText("将爱国情转化为奋斗行");
                date.setText("2019-05-09");
                source.setText("zhou12");
                break;
            case 3:
                title.setText("国家密集出台的税收优惠政策，为企业研发创新发展提供了有利条件");
                date.setText("2019-11-14");
                source.setText("wql123");
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

    public DuZheBaoLiaoAdapter(Parcel in) {

    }

    public static final Creator<DuZheBaoLiaoAdapter> CREATOR = new Creator<DuZheBaoLiaoAdapter>() {
        @Override
        public DuZheBaoLiaoAdapter createFromParcel(Parcel in) {
            return new DuZheBaoLiaoAdapter(in);
        }

        @Override
        public DuZheBaoLiaoAdapter[] newArray(int size) {
            return new DuZheBaoLiaoAdapter[size];
        }
    };
}
