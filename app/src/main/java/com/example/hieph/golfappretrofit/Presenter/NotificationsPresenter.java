package com.example.hieph.golfappretrofit.Presenter;


import com.example.hieph.golfappretrofit.model.CourseModel;
import com.example.hieph.golfappretrofit.model.ITemData;
import com.example.hieph.golfappretrofit.view.ContractFragment;

import java.util.List;

/**
 * Created by hieph on 8/18/2018.
 */

public class NotificationsPresenter implements ContractFragment.Presenter {
    ContractFragment.View viewNotifications;
    CourseModel courseModel;

    public NotificationsPresenter(ContractFragment.View viewNotifications) {
        this.viewNotifications = viewNotifications;
    }
    public void showDataNotification(){
        courseModel = new CourseModel(this);
        courseModel.getDataCourse();
    }

    @Override
    public void Presenter(List<ITemData> ITemDatumCourses) {
        viewNotifications.View(ITemDatumCourses);
    }
}
