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
public class BaoTiHuiZongAdapter extends BaseAdapter {
    private final int TYPE_NORMAL = 0; //normal type

    public BaoTiHuiZongAdapter(List listData, Context context) {
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

                setData(position,((TextView) holder.getView(R.id.tv_title)),
                        ((TextView) holder.getView(R.id.tv_1)),
                        ((TextView) holder.getView(R.id.tv_2)),
                ((TextView) holder.getView(R.id.tv_3)),
                ((TextView) holder.getView(R.id.tv_4)));
//                ((TextView) holder.getView(R.id.tv_title)).setText("“考试表情包”拉进师生关系"); //name
//                ((TextView) holder.getView(R.id.tv_1)).setText("司法");
//                ((TextView) holder.getView(R.id.tv_2)).setText("杨泽东");
//                ((TextView) holder.getView(R.id.tv_3)).setText("测试部门");
//                ((TextView) holder.getView(R.id.tv_4)).setText("2019-03-16");

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

    private void setData(int position, TextView title, TextView tv1, TextView tv2, TextView tv3, TextView tv4){
        switch (position){
            case 0:
                title.setText("中国第二艘航母通过台湾海峡");
                tv1.setText("政治");
                tv2.setText("王庆龙");
                tv3.setText("拓尔思测试");
                tv4.setText("2019-11-18");
                break;
            case 1:
                title.setText("北京今天终于供暖啦！！！");
                tv1.setText("生活");
                tv2.setText("周旭");
                tv3.setText("拓尔思测试");
                tv4.setText("2019-11-14");
                break;
            case 2:
                title.setText("双十一总成交额已通过");
                tv1.setText("财经");
                tv2.setText("周旭");
                tv3.setText("拓尔思测试");
                tv4.setText("2019-11-12");
                break;
            case 3:
                title.setText("考试表情包”拉近师生关系");
                tv1.setText("教育");
                tv2.setText("周旭");
                tv3.setText("拓尔思测试");
                tv4.setText("2019-11-07");
                break;
            case 4:
                title.setText("习近平向第二届世界顶尖科学家论坛（2019）致贺信");
                tv1.setText("政治");
                tv2.setText("周旭");
                tv3.setText("拓尔思测试");
                tv4.setText("2019-10-29");
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

    public BaoTiHuiZongAdapter(Parcel in) {

    }

    public static final Creator<BaoTiHuiZongAdapter> CREATOR = new Creator<BaoTiHuiZongAdapter>() {
        @Override
        public BaoTiHuiZongAdapter createFromParcel(Parcel in) {
            return new BaoTiHuiZongAdapter(in);
        }

        @Override
        public BaoTiHuiZongAdapter[] newArray(int size) {
            return new BaoTiHuiZongAdapter[size];
        }
    };
}
