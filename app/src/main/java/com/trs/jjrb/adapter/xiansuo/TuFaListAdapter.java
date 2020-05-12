package com.trs.jjrb.adapter.xiansuo;

import android.content.Context;
import android.os.Parcel;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.adapter.BaseAdapter;
import com.trs.jjrb.adapter.MyHolder;
import com.trs.jjrb.adapter.redian.WeiBoReDianListAdapter;
import com.trs.jjrb.bean.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * creator：liufan
 * data: 2019/7/22
 */
public class TuFaListAdapter extends BaseAdapter {
    private final int TYPE_NORMAL = 0; //normal type

    public TuFaListAdapter(List listData, Context context) {
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
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_jujiao_item, null);
            default:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_jujiao_item, null);
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
                        ((TextView) holder.getView(R.id.tv_source)));
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

    private void setData(int position,TextView title,TextView date,TextView source){
        switch (position){
            case 0:
                title.setText("山西省省长：平遥煤矿事故性质十分恶劣 影响极坏");
                date.setText("2019/11/25");
                source.setText("中国山西省");
                break;
            case 1:
                title.setText("地震无法消失 但他要让震中房屋不倒");
                date.setText("2019/11/25");
                source.setText("人民论坛网");
                break;
            case 2:
                title.setText("惊险！引擎起火 菲航客机紧急迫降");
                date.setText("2019/05/09");
                source.setText("亚洲东南亚");
                break;
            case 3:
                title.setText("甘肃发布法定传染病疫情，艾滋病死亡率最高");
                date.setText("2019/05/09");
                source.setText("中国甘肃省");
                break;
            case 4:
                title.setText("深圳年轻妈妈突发急性白血病，CAR-T细胞免疫疗法让她重获新生");
                date.setText("2019/05/09");
                source.setText("中国广东省");
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

    public TuFaListAdapter(Parcel in) {

    }

    public static final Creator<TuFaListAdapter> CREATOR = new Creator<TuFaListAdapter>() {
        @Override
        public TuFaListAdapter createFromParcel(Parcel in) {
            return new TuFaListAdapter(in);
        }

        @Override
        public TuFaListAdapter[] newArray(int size) {
            return new TuFaListAdapter[size];
        }
    };
}
