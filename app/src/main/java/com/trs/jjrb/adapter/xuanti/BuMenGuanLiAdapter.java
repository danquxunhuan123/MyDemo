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
public class BuMenGuanLiAdapter extends BaseAdapter {
    private final int TYPE_NORMAL = 0; //normal type

    public BuMenGuanLiAdapter(List listData, Context context) {
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
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.xuanti_item, null);
            default:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.xuanti_item, null);
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
                ((TextView) holder.getView(R.id.tv_title)).setText("经济日报策划部门"); //name
                ((TextView) holder.getView(R.id.tv_date)).setText("2019/11/19");

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

    public BuMenGuanLiAdapter(Parcel in) {

    }

    public static final Creator<BuMenGuanLiAdapter> CREATOR = new Creator<BuMenGuanLiAdapter>() {
        @Override
        public BuMenGuanLiAdapter createFromParcel(Parcel in) {
            return new BuMenGuanLiAdapter(in);
        }

        @Override
        public BuMenGuanLiAdapter[] newArray(int size) {
            return new BuMenGuanLiAdapter[size];
        }
    };
}
