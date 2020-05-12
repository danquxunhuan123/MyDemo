package com.trs.jjrb.adapter.xiansuo;

import android.content.Context;
import android.os.Parcel;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.adapter.BaseAdapter;
import com.trs.jjrb.adapter.MyHolder;
import com.trs.jjrb.adapter.fenxi.FenXiAdapter;
import com.trs.jjrb.bean.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * creator：liufan
 * data: 2019/7/22
 */
public class RenGongListAdapter extends BaseAdapter {
    private final int TYPE_NORMAL = 0; //normal type

    public RenGongListAdapter(List listData, Context context) {
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
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_rengong_item, null);
            default:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_rengong_item, null);
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

                setData(position,((TextView) holder.getView(R.id.tv_title)),
                        ((TextView) holder.getView(R.id.tv_date)),
                        ((TextView) holder.getView(R.id.tv_name)),
                        ((TextView) holder.getView(R.id.tv_city)),
                        ((TextView) holder.getView(R.id.tv_num)));
//                ((TextView) holder.getView(R.id.tv_title)).setText("互联网【降维打击】商业简史");
//                ((TextView) holder.getView(R.id.tv_date)).setText("2019-03-16");
//                ((TextView) holder.getView(R.id.tv_name)).setText("杨泽东");
//                ((TextView) holder.getView(R.id.tv_city)).setText("北京");
//                ((TextView) holder.getView(R.id.tv_num)).setText("15000000000");
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

    private void setData(int position, TextView title, TextView date, TextView name, TextView city, TextView num){
        switch (position){
            case 0:
                title.setText("84岁老人花300亿重建圆明园，却遭众人反对，如今已经完工！");
                date.setText("2019-11-19");
                name.setText("杨泽东");
                city.setText("北京");
                num.setText("13263333411");
                break;
            case 1:
                title.setText("互联网「降维打击」商业简史");
                date.setText("2019-11-10");
                name.setText("杨泽东");
                city.setText("北京");
                num.setText("13263333411");
                break;
            case 2:
                title.setText("铁路部门备战“双11” 推“高铁+电商”等新服务");
                date.setText("2019-11-10");
                name.setText("杨泽东");
                city.setText("北京");
                num.setText("13167293918");
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

    public RenGongListAdapter(Parcel in) {

    }

    public static final Creator<RenGongListAdapter> CREATOR = new Creator<RenGongListAdapter>() {
        @Override
        public RenGongListAdapter createFromParcel(Parcel in) {
            return new RenGongListAdapter(in);
        }

        @Override
        public RenGongListAdapter[] newArray(int size) {
            return new RenGongListAdapter[size];
        }
    };
}
