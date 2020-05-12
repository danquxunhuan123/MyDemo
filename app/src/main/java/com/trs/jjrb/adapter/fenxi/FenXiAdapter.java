package com.trs.jjrb.adapter.fenxi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trs.jjrb.R;
import com.trs.jjrb.activity.xuanti.XuanTiDetailActivity;
import com.trs.jjrb.adapter.BaseAdapter;
import com.trs.jjrb.adapter.MyHolder;
import com.trs.jjrb.bean.Document;

import java.util.List;

/**
 * creator：liufan
 * data: 2019/7/22
 */
public class FenXiAdapter extends BaseAdapter {
    private final int TYPE_NORMAL = 0; //normal type

    public FenXiAdapter(List listData, Context context) {
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
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.fenxii_item, null);
            default:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.fenxii_item, null);
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

//                cname = StringUtils.replaceStr(cname);

                setData(position,((TextView) holder.getView(R.id.tv_title)),
                        ((TextView) holder.getView(R.id.tv_date1)),
                        ((TextView) holder.getView(R.id.tv_date2)),
                        ((TextView) holder.getView(R.id.tv_baodao_num)));
//                final String finalUrl = url;
                holder.getItemView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, XuanTiDetailActivity.class);
                        intent.putExtra(XuanTiDetailActivity.ARG_PARAM2,"汪洋主席发表惠台新26条");
                        context.startActivity(intent);
                    }
                });
                break;
            default:
                break;
        }
    }

    private void setData(int position, TextView title, TextView date, TextView date1, TextView source){
        switch (position){
            case 0:
                title.setText("习总书记国事访问");
                date.setText("2019-11-01");
                date1.setText("2019-11-13");
                source.setText("69353");
                break;
            case 1:
                title.setText("十九届四中全会");
                date.setText("2019-10-25");
                date1.setText("2019-11-13");
                source.setText("43401");
                break;
            case 2:
                title.setText("首届江苏（大丰）旅游经济高质量发展峰会");
                date.setText("2019-10-16");
                date1.setText("2019-11-11");
                source.setText("403");
                break;
            case 3:
                title.setText("汪洋主席发表惠台新26条");
                date.setText("2019-11-08");
                date1.setText("2019-11-08");
                source.setText("187920");
                break;
            case 4:
                title.setText("第二届中国国际进口博览会");
                date.setText("2019-11-13");
                date1.setText("2019-11-13");
                source.setText("19250");
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

    public FenXiAdapter(Parcel in) {

    }

    public static final Creator<FenXiAdapter> CREATOR = new Creator<FenXiAdapter>() {
        @Override
        public FenXiAdapter createFromParcel(Parcel in) {
            return new FenXiAdapter(in);
        }

        @Override
        public FenXiAdapter[] newArray(int size) {
            return new FenXiAdapter[size];
        }
    };
}
