package com.example.hieph.golfappretrofit.view.fragment.course;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.hieph.golfappretrofit.Presenter.CoursePresenter;
import com.example.hieph.golfappretrofit.R;
import com.example.hieph.golfappretrofit.adapter.ItemCourseAdapter;
import com.example.hieph.golfappretrofit.model.ITemData;
import com.example.hieph.golfappretrofit.view.ContractFragment;

import java.util.List;

/**
 * Created by hieph on 8/20/2018.
 */

public class FragmentCourse extends Fragment implements ContractFragment.View{
    private RecyclerView recyclerView;
    private ItemCourseAdapter adapter;
    CoursePresenter coursePresenter;
    ProgressBar progressBar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentcourse,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        coursePresenter = new CoursePresenter(this);
        coursePresenter.showData();
        progressBar = view.findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(getContext(),R.color.colorPrimaryDark), PorterDuff.Mode.SRC_IN );
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }
    @Override
    public void View(List<ITemData> ITemDatumCourses) {
        adapter = new ItemCourseAdapter(ITemDatumCourses, getContext(), progressBar);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

    }
}
