package com.example.hieph.golfappretrofit.Presenter;


import com.example.hieph.golfappretrofit.model.CourseModel;
import com.example.hieph.golfappretrofit.model.ITemData;
import com.example.hieph.golfappretrofit.view.ContractFragment;

import java.util.List;

public class CoursePresenter implements ContractFragment.Presenter {
    ContractFragment.View viewCourse;
    CourseModel courseModel;
    public CoursePresenter(ContractFragment.View viewCourse) {
        this.viewCourse = viewCourse;

    }
    public void showData(){
        courseModel = new CourseModel( this);
        courseModel.getDataCourse();
    }


    @Override
    public void Presenter(List<ITemData> ITemDatumCourses) {
        viewCourse.View(ITemDatumCourses);
    }
}
