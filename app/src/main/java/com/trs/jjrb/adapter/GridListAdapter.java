package com.trs.jjrb.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trs.jjrb.R;

import java.util.List;


/**
 * creator：liufan
 * data: 2019/11/20
 */
public class GridListAdapter extends RecyclerView.Adapter<GridListAdapter.ViewHoder> {

    private final List list;

    public GridListAdapter(Context context, List list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public GridListAdapter.ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        TextView tv = new TextView(viewGroup.getContext());
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT ,ViewGroup.LayoutParams.WRAP_CONTENT);
        tv.setPadding(10,10,10,10);
        params.setMargins(5,5,5,5);
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(14);
        tv.setTextColor(Color.GRAY);
        tv.setBackgroundResource(R.drawable.border_gray_translate);
        tv.setLayoutParams(params);
        return new ViewHoder(tv);
    }

    @Override
    public void onBindViewHolder(@NonNull GridListAdapter.ViewHoder viewHolder, int position) {
        TextView tv = (TextView) viewHolder.itemView;

        tv.setText((String) list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder{

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
