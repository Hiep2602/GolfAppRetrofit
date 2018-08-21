package com.example.hieph.golfappretrofit.view.fragment.notifications;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.hieph.golfappretrofit.Presenter.NotificationsPresenter;
import com.example.hieph.golfappretrofit.R;
import com.example.hieph.golfappretrofit.adapter.StaggeredNotificationAdapter;
import com.example.hieph.golfappretrofit.model.ITemData;
import com.example.hieph.golfappretrofit.view.ContractFragment;

import java.util.List;

/**
 * Created by hieph on 8/20/2018.
 */

public class FragmentNotifications extends Fragment implements ContractFragment.View{
    private List<ITemData> iTemData;
    private StaggeredNotificationAdapter adapter;
    NotificationsPresenter notificationsPresenter;
    RecyclerView recyclerView;
    ProgressBar progressBar;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentnotifications,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        notificationsPresenter = new NotificationsPresenter(this);
        notificationsPresenter.showDataNotification();
        //recyclerView = (AsymmetricGridView)view.findViewById(R.id.recyclerview);
        progressBar = view.findViewById(R.id.progressss);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(getContext(),R.color.colorPrimaryDark), PorterDuff.Mode.SRC_IN );
        recyclerView = view.findViewById(R.id.recycleviews);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2, LinearLayoutManager.VERTICAL,false);
        //recyclerView.setLayoutManager(gridLayoutManager);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3,LinearLayoutManager.HORIZONTAL,false);
        //recyclerView.setLayoutManager(glm);
//        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//               switch (position % 8 ){
//                   case 0:
//                   case 1:
//                   case 4:
//                   case 5:
//                       return 2;
//
//                   case 2:
//                   case 3:
//                   case 6:
//                   case 7:
//                       return 4;
//               }
//               throw new IllegalStateException("Internal error");
//            }
//        });
        recyclerView.setLayoutManager(gridLayoutManager);
    }
    @Override
    public void View(List<ITemData> ITemDatumCourses) {
        recyclerView.setHasFixedSize(true);
        adapter = new StaggeredNotificationAdapter(ITemDatumCourses,getContext(),progressBar);
        recyclerView.setAdapter(adapter);
    }
}
