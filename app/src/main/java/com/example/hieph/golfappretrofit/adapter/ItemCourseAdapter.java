package com.example.hieph.golfappretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.hieph.golfappretrofit.R;
import com.example.hieph.golfappretrofit.model.ITemData;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by hieph on 8/20/2018.
 */
public class ItemCourseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ITemData> ITemDatumCourses;
    Context mContext;
    ProgressBar progressBar;

    public ItemCourseAdapter(List<ITemData> ITemDatumCourses, Context mContext, ProgressBar progressBar) {
        this.ITemDatumCourses = ITemDatumCourses;
        this.mContext = mContext;
        this.progressBar = progressBar;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        switch (viewType) {
            case 0:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_golf, parent, false);
                return new ViewHolder(v);
            case 10:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent, false);
                return new ViewHolder2(v);
            case 20:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coursetwenty, parent, false);
                return new ViewHolder3(v);

        }
        progressBar.setVisibility(ProgressBar.VISIBLE);
        throw new IllegalStateException("internal error");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 0:
                ViewHolder viewHolder = (ViewHolder) holder;
                ((ViewHolder) holder).tvCreate_at.setText(ITemDatumCourses.get(position).getCreated_at());
                ((ViewHolder) holder).tvUpdate_at.setText(ITemDatumCourses.get(position).getName());
                Picasso.with(mContext).load(ITemDatumCourses.get(position).getImage()).into(((ViewHolder) holder).imv_image);
                Log.d(getClass().getSimpleName(), "abc" + ITemDatumCourses.get(position).getImage());
                break;
            case 10:
                ViewHolder2 viewHolder2 = (ViewHolder2) holder;
                ((ViewHolder2) holder).tvCreate_at.setText(ITemDatumCourses.get(position).getCreated_at());
                ((ViewHolder2) holder).tvUpdate_at.setText(ITemDatumCourses.get(position).getName());
                Picasso.with(mContext).load(ITemDatumCourses.get(position).getImage()).into(((ViewHolder2) holder).imv_image);
                Log.d(getClass().getSimpleName(), "abc" + ITemDatumCourses.get(position).getImage());
                break;

            case 20:
                ViewHolder3 viewHolder3 = (ViewHolder3) holder;
                ((ViewHolder3) holder).tvCreate_at.setText(ITemDatumCourses.get(position).getCreated_at());
                ((ViewHolder3) holder).tvUpdate_at.setText(ITemDatumCourses.get(position).getName());
                Picasso.with(mContext).load(ITemDatumCourses.get(position).getImage()).into(((ViewHolder3) holder).imv_image);
                Log.d(getClass().getSimpleName(), "abc" + ITemDatumCourses.get(position).getImage());
                break;
        }
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return ITemDatumCourses.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return 0;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                return 10;
            default:
                return 20;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCreate_at;
        TextView tvUpdate_at;
        ImageView imv_image;

        public ViewHolder(View v) {
            super(v);
            tvCreate_at = v.findViewById(R.id.tv_golfresort);
            tvUpdate_at = v.findViewById(R.id.tv_sangolf);
            imv_image = v.findViewById(R.id.imv_itemlogin);
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView tvCreate_at;
        TextView tvUpdate_at;
        ImageView imv_image;

        public ViewHolder2(View itemView) {
            super(itemView);
            tvCreate_at = itemView.findViewById(R.id.tv_golfresort);
            tvUpdate_at = itemView.findViewById(R.id.tv_sangolf);
            imv_image = itemView.findViewById(R.id.imv_itemlogin);
        }
    }

    public class ViewHolder3 extends RecyclerView.ViewHolder {
        TextView tvCreate_at;
        TextView tvUpdate_at;
        ImageView imv_image;

        public ViewHolder3(View itemView) {
            super(itemView);
            tvCreate_at = itemView.findViewById(R.id.tv_createat);
            tvUpdate_at = itemView.findViewById(R.id.tv_updateat);
            imv_image = itemView.findViewById(R.id.imv_itemlogin);
        }
    }
}

