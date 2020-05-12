package com.trs.jjrb.adapter.xuanti;

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
public class XuanTiHuiZongAdapter extends BaseAdapter {
    private final int TYPE_NORMAL = 0; //normal type

    public XuanTiHuiZongAdapter(List listData, Context context) {
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
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.bthz_item, null);
            default:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.bthz_item, null);
        }
    }

    @Override
    protected void bindHolder(MyHolder holder, int position) {
        switch (getItemType(position)) {
            case TYPE_NORMAL:
//                Object obj = list.get(position);
//                String cname = null;
//                String date = null;
//                String url = null;
//
//                if (obj instanceof Document.List_datasEntity) {
//                    Document.List_datasEntity document = (Document.List_datasEntity) obj;
//                    cname = document.getTitle();
//                    date = document.getUpdatedate();
//                    List<String> cimgs = document.getCimgs();
//                    if (cimgs != null && cimgs.size() > 0)
//                    url = document.getUrl();
//
//                } else if (obj instanceof Channel.GdEntity) {
//                    Channel.GdEntity channel = (Channel.GdEntity) obj;
//                    cname = channel.getCname();
//                    date = "";
//                    url = channel.getDocuments();
//                }
//
//                cname = StringUtils.replaceStr(cname);
                ((TextView) holder.getView(R.id.tv_title)).setText("“考试表情包”拉进师生关系"); //name
                ((TextView) holder.getView(R.id.tv_1)).setText("司法");
                ((TextView) holder.getView(R.id.tv_2)).setText("杨泽东");
                ((TextView) holder.getView(R.id.tv_3)).setText("测试部门");
                ((TextView) holder.getView(R.id.tv_4)).setText("2019-03-16");

//                final String finalUrl = url;
//                holder.getItemView().setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(context, XuanTiDetailActivity.class);
//                        intent.putExtra(XuanTiDetailActivity.ARG_PARAM2,"汪洋主席发表惠台新26条");
//                        context.startActivity(intent);
//                    }
//                });
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

    public XuanTiHuiZongAdapter(Parcel in) {

    }

    public static final Creator<XuanTiHuiZongAdapter> CREATOR = new Creator<XuanTiHuiZongAdapter>() {
        @Override
        public XuanTiHuiZongAdapter createFromParcel(Parcel in) {
            return new XuanTiHuiZongAdapter(in);
        }

        @Override
        public XuanTiHuiZongAdapter[] newArray(int size) {
            return new XuanTiHuiZongAdapter[size];
        }
    };
}
