package com.trs.jjrb.adapter.redian;

import android.content.Context;
import android.os.Parcel;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.adapter.BaseAdapter;
import com.trs.jjrb.adapter.MyHolder;
import com.trs.jjrb.bean.Document;

import java.util.List;

/**
 * creator：liufan
 * data: 2019/7/22
 */
public class ZhiMeiListAdapter extends BaseAdapter {
    private List<Document.List_datasEntity> bannerData;
    private List<String> imgUrls;
    private List<String> titles;
    private final int TYPE_1 = 1; //banner type
    private final int TYPE_NORMAL = 0; //normal type
    private final int TYPE_MANY_PIC = 2; //many pic type

    public ZhiMeiListAdapter(List listData, Context context) {
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
                        "纸媒头版top10");
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
                        ((TextView) holder.getView(R.id.tv_index)));

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

    private void setData(int position,TextView title,TextView date){
        switch (position){
            case 0:
                title.setText("中办国办印发《关于强化知识产权保护的意见》 ");
                date.setText(String.valueOf(position));
                break;
            case 1:
                title.setText("把失业保险基金花在“稳就业”这个刀刃上 ");
                date.setText(String.valueOf(position));
                break;
            case 2:
                title.setText("消费保持平稳增长，要看哪些指标 ");
                date.setText(String.valueOf(position));
                break;
            case 3:
                title.setText("稳岗补贴频落地 帮扶企业添动力 ");
                date.setText(String.valueOf(position));
                break;
            case 4:
                title.setText("长沙“单车干部”进村来");
                date.setText(String.valueOf(position));
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

    public ZhiMeiListAdapter(Parcel in) {

    }

    public static final Creator<ZhiMeiListAdapter> CREATOR = new Creator<ZhiMeiListAdapter>() {
        @Override
        public ZhiMeiListAdapter createFromParcel(Parcel in) {
            return new ZhiMeiListAdapter(in);
        }

        @Override
        public ZhiMeiListAdapter[] newArray(int size) {
            return new ZhiMeiListAdapter[size];
        }
    };
}
