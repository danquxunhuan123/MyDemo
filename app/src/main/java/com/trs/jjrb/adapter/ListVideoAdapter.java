package com.trs.jjrb.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.SizeUtils;
import com.trs.jjrb.R;
import com.trs.jjrb.activity.ListActivity;
import com.trs.jjrb.activity.NewsDetailActivity;
import com.trs.jjrb.bean.Document;
import com.trs.jjrb.util.SizeUtil;
import com.trs.jjrb.util.StringUtils;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

import java.util.List;

/**
 * creator：liufan
 * data: 2019/7/22
 */
public class ListVideoAdapter extends BaseAdapter {
    public ListVideoAdapter(List listData, Context context) {
        super(listData, context);
    }

    @Override
    protected int getItemType(int position) {
        return 0;
    }

    @Override
    public MyHolder createHolder(ViewGroup parent, int viewType) {
        return MyHolder.getComViewHolder(parent.getContext(), R.layout.list_item_video, null);
    }

    @Override
    protected void bindHolder(MyHolder holder, int position) {
        Document.List_datasEntity data = (Document.List_datasEntity) list.get(position);
        if (getItemType(position) == 0) {
            String cname = StringUtils.replaceStr(data.getTitle());
            ((TextView) holder.getView(R.id.tv_title)).setText(cname);
            ((TextView) holder.getView(R.id.tv_date)).setText(data.getUpdatedate());
//            ((TextView) holder.getView(R.id.tv_source)).setText("外交部");
            NiceVideoPlayer mNiceVideoPlayer = (NiceVideoPlayer) holder.getView(R.id.video_player);
            if (mNiceVideoPlayer == null){
                SizeUtil.setSpaceWandH(mNiceVideoPlayer, 16, 9, SizeUtils.dp2px(10) * 2);
                mNiceVideoPlayer.setPlayerType(NiceVideoPlayer.TYPE_IJK); // or NiceVideoPlayer.TYPE_NATIVE
            }
            mNiceVideoPlayer.setUp("", null);
            TxVideoPlayerController controller = new TxVideoPlayerController(context);
            controller.setTitle("");
//            List<String> cimgs = data.getCimgs();
//            if (cimgs != null && cimgs.size() > 0) {
//                controller.setImage(cimgs.get(0));
//            } else {
//                view.setVisibility(View.GONE);
//            }
            mNiceVideoPlayer.setController(controller);
        }

        final String finalUrl = data.getUrl();
        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewsDetailActivity.class);
                intent.putExtra(ListActivity.ARG_PARAM1, finalUrl);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public ListVideoAdapter(Parcel in) {

    }

    public static final Creator<ListVideoAdapter> CREATOR = new Creator<ListVideoAdapter>() {
        @Override
        public ListVideoAdapter createFromParcel(Parcel in) {
            return new ListVideoAdapter(in);
        }

        @Override
        public ListVideoAdapter[] newArray(int size) {
            return new ListVideoAdapter[size];
        }
    };
}
