package com.trs.jjrb.adapter.user;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.trs.jjrb.R;
import com.trs.jjrb.activity.ListActivity;
import com.trs.jjrb.activity.NewsDetailActivity;
import com.trs.jjrb.adapter.BaseAdapter;
import com.trs.jjrb.adapter.ListCommenAdapter;
import com.trs.jjrb.adapter.MyHolder;
import com.trs.jjrb.bean.Channel;
import com.trs.jjrb.bean.Document;
import com.trs.jjrb.glide.GlideHelper;
import com.trs.jjrb.glide.GlideImageLoader;
import com.trs.jjrb.util.SizeUtil;
import com.trs.jjrb.util.StringUtil;
import com.trs.jjrb.util.StringUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * creator：liufan
 * data: 2019/7/22
 */
public class CeHuaAdapter extends BaseAdapter {
    private final int TYPE_NORMAL = 0; //normal type

    public CeHuaAdapter(List listData, Context context) {
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
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_cehua_item, null);
            default:
                return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_cehua_item, null);
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
                title.setText("校服收2300家长抱怨负担重 校方:别人都穿你不");
                date.setText("2019/11/25");
                source.setText("新华社");
                break;
            case 1:
                title.setText("张云雷荤段子调侃张火丁 \"紫光阁\":做戏先做人");
                date.setText("2019/11/25");
                source.setText("人民论坛网");
                break;
            case 2:
                title.setText("“神州第一舰”重塑归来:垂发新型反舰导弹都不少");
                date.setText("2019-05-09");
                source.setText("新华社");
                break;
            case 3:
                title.setText("沈梓捷1.7秒绝杀！单外援深圳逆转新疆获2连胜");
                date.setText("2019-05-09");
                source.setText("新华社");
                break;
            case 4:
                title.setText("“中国间谍投诚”?媒体:澳情报部门和澳媒的脸要丢");
                date.setText("2019-05-09");
                source.setText("新华社");
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

    public CeHuaAdapter(Parcel in) {

    }

    public static final Creator<CeHuaAdapter> CREATOR = new Creator<CeHuaAdapter>() {
        @Override
        public CeHuaAdapter createFromParcel(Parcel in) {
            return new CeHuaAdapter(in);
        }

        @Override
        public CeHuaAdapter[] newArray(int size) {
            return new CeHuaAdapter[size];
        }
    };
}
