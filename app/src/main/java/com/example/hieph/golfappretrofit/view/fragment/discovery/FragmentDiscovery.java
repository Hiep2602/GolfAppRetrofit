package com.example.hieph.golfappretrofit.view.fragment.discovery;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.hieph.golfappretrofit.Presenter.DiscoveryPresenter;
import com.example.hieph.golfappretrofit.R;
import com.example.hieph.golfappretrofit.adapter.ITemDiscoveryAdapter;
import com.example.hieph.golfappretrofit.model.ITemData;
import com.example.hieph.golfappretrofit.view.ContractFragment;

import java.util.List;

/**
 * Created by hieph on 8/20/2018.
 */

public class FragmentDiscovery extends Fragment implements ContractFragment.View {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    DiscoveryPresenter discoveryPresenter;
    ITemDiscoveryAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentdiscovery,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        discoveryPresenter = new DiscoveryPresenter(this);
        discoveryPresenter.showImageDiscovery();
        int noOfColumns = caculate(getContext());
        progressBar = view.findViewById(R.id.progress);
        progressBar.setVisibility(view.VISIBLE);
        progressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(getContext(),R.color.colorPrimaryDark), PorterDuff.Mode.SRC_IN );
        recyclerView = view.findViewById(R.id.recycle);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.HORIZONTAL));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),noOfColumns,GridLayoutManager.HORIZONTAL,false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (position % 4){
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        return 4;
                }
                throw new IllegalStateException("internal error");
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);

    }
    private int caculate(Context mcontext){
        DisplayMetrics displayMetrics = mcontext.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels ;
        Log.d(getClass().getSimpleName(),"abc : " + dpWidth);
        int noOfColumns = (int) (dpWidth / 200);
        return noOfColumns;
    }
    @Override
    public void View(List<ITemData> ITemDatumCourses) {
        adapter = new ITemDiscoveryAdapter(ITemDatumCourses,getContext(),progressBar);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }
}
