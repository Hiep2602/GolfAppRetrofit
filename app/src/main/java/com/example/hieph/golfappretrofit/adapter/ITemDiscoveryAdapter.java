package com.example.hieph.golfappretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.hieph.golfappretrofit.R;
import com.example.hieph.golfappretrofit.model.ITemData;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by hieph on 8/20/2018.
 */

public class ITemDiscoveryAdapter extends RecyclerView.Adapter<ITemDiscoveryAdapter.ViewHolder> {
    private List<ITemData> iTemData;
    Context mContext;
    ProgressBar progressBar;

    public ITemDiscoveryAdapter(List<ITemData> iTemData, Context mContext, ProgressBar progressBar) {
        this.iTemData = iTemData;
        this.mContext = mContext;
        this.progressBar = progressBar;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discovery, parent, false);
        progressBar.setVisibility(ProgressBar.VISIBLE);
        int height = parent.getMeasuredHeight() / 4;
        v.setMinimumHeight(height);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Picasso.with(mContext).load(iTemData.get(position).getImage()).into(holder.imageView1);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return iTemData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView1;
        int width = caculator();

        public ViewHolder(View v) {
            super(v);

            imageView1 = v.findViewById(R.id.imv_discovery1);

//            imageView2 = v.findViewById(R.id.imv_discovery2);
//            imageView3 = v.findViewById(R.id.imv_discovery3);
//            imageView4 = v.findViewById(R.id.imv_discovery4);
        }

        private int caculator() {
            DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            int dpWidth = displayMetrics.widthPixels;
            return dpWidth;
        }

    }
}