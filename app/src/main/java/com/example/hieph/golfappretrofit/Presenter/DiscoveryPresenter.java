package com.example.hieph.golfappretrofit.Presenter;



import com.example.hieph.golfappretrofit.model.CourseModel;
import com.example.hieph.golfappretrofit.model.ITemData;
import com.example.hieph.golfappretrofit.view.ContractFragment;

import java.util.List;

/**
 * Created by hieph on 8/17/2018.
 */

public class DiscoveryPresenter implements ContractFragment.Presenter {
    ContractFragment.View viewDiscovery;
    CourseModel courseModel;

    public DiscoveryPresenter(ContractFragment.View viewDiscovery) {
        this.viewDiscovery = viewDiscovery;
    }
    public void showImageDiscovery(){
        courseModel = new CourseModel(this);
        courseModel.getDataCourse();
    }

    @Override
    public void Presenter(List<ITemData> ITemDatumCourses) {
        viewDiscovery.View(ITemDatumCourses);
    }
}
