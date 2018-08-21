package com.example.hieph.golfappretrofit.model;




import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.hieph.golfappretrofit.R;
import com.example.hieph.golfappretrofit.asymmetricgridview.AGVRecyclerViewAdapter;

import com.example.hieph.golfappretrofit.asymmetricgridview.AsymmetricItem;
import com.example.hieph.golfappretrofit.asymmetricgridview.AsymmetricRecyclerView;
import com.example.hieph.golfappretrofit.asymmetricgridview.AsymmetricRecyclerViewAdapter;
import com.example.hieph.golfappretrofit.asymmetricgridview.Utils;


import java.util.List;
/**
 * Created by hieph on 8/20/2018.
 */

public class RecycleviewActivity extends AppCompatActivity {
    private final DemoUtils demoUtils = new DemoUtils();

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        AsymmetricRecyclerView recyclerView = (AsymmetricRecyclerView) findViewById(R.id.recyclerView);


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(demoUtils.moarItems(50));
        recyclerView.setRequestedColumnCount(3);
        recyclerView.setDebugging(true);
        recyclerView.setRequestedHorizontalSpacing(Utils.dpToPx(this, 3));
        recyclerView.addItemDecoration(
                new SpacesItemDecoration(getResources().getDimensionPixelSize(R.dimen.recycler_padding)));
        recyclerView.setAdapter(new AsymmetricRecyclerViewAdapter<>(this, recyclerView, adapter));
    }

    class RecyclerViewAdapter extends AGVRecyclerViewAdapter<ViewHolder> {
        private final List<DemoItem> items;

        RecyclerViewAdapter(List<DemoItem> items) {
            this.items = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Log.d("RecyclerViewActivity", "onCreateView");
            return new ViewHolder(parent, viewType);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Log.d("RecyclerViewActivity", "onBindView position=" + position);
//            holder.bind(items.get(position));
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        @Override
        public AsymmetricItem getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getItemViewType(int position) {
            return position % 2 == 0 ? 1 : 0;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
         ImageView imageView;

        ViewHolder(ViewGroup parent, int viewType) {
            super(LayoutInflater.from(parent.getContext()).inflate(
                    viewType == 0 ? R.layout.adapter_item : R.layout.adapter_item_odd, parent, false));
            if (viewType == 0) {
                imageView  = (ImageView) itemView.findViewById(R.id.textview);
            } else {
                imageView = (ImageView) itemView.findViewById(R.id.textview_odd);
            }
        }

    }
}
