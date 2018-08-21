package com.example.hieph.golfappretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.example.hieph.golfappretrofit.R;
import com.example.hieph.golfappretrofit.model.ITemData;

import java.util.List;

/**
 * Created by hieph on 8/20/2018.
 */

public class StaggeredNotificationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context mContext;
    private List<ITemData> iTemData;
    ProgressBar progressBar;

    public StaggeredNotificationAdapter(List<ITemData> iTemData, Context mContext, ProgressBar progressBar ) {
        this.mContext = mContext;
        this.iTemData = iTemData;
        this.progressBar = progressBar;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notifications,parent,false);
                return new ContentViewHolder(view);

            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notifications_minfile,parent,false);
                return new HeaderViewHolder(view);
        }
        progressBar.setVisibility(ProgressBar.VISIBLE);
        throw new IllegalStateException("internal error");

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case 0:
                ContentViewHolder contentViewHolder = (ContentViewHolder) holder;
                Glide.with(mContext)
                        .load(iTemData.get(position).getImage())
                        .into(((ContentViewHolder) holder).imageView);
                break;
            case 1:
                HeaderViewHolder headerViewHolder = (HeaderViewHolder)holder;
                Glide.with(mContext)
                        .load(iTemData.get(position).getImage())
                        .into(((HeaderViewHolder) holder).imageView);
                Glide.with(mContext)
                        .load(iTemData.get(position).getImage())
                        .into(((HeaderViewHolder) holder).imageView1);
                Glide.with(mContext)
                        .load(iTemData.get(position).getImage())
                        .into(((HeaderViewHolder) holder).imageView2);
                Glide.with(mContext)
                        .load(iTemData.get(position).getImage())
                        .into(((HeaderViewHolder) holder).imageView3);
                break;
        }
        progressBar.setVisibility(ProgressBar.INVISIBLE);


    }

    @Override
    public int getItemCount() {
        return iTemData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position %2 *1;
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ContentViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imv_image);
        }
    }
    public static class HeaderViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        ImageView imageView1;
        ImageView imageView2;
        ImageView imageView3;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imv_anh1);
            imageView1 = itemView.findViewById(R.id.imv_anh2);
            imageView2 = itemView.findViewById(R.id.imv_anh3);
            imageView3 = itemView.findViewById(R.id.imv_anh4);
        }
    }
}
