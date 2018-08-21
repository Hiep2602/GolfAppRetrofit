package com.example.hieph.golfappretrofit.view;

/**
 * Created by hieph on 8/20/2018.
 */

import com.example.hieph.golfappretrofit.model.ITemData;

import java.util.List;

/**
 * Created by hieph on 8/15/2018.
 */

public interface ContractFragment {
    interface View {
        void View(List<ITemData> ITemDatumCourses);
    }
    interface Presenter{
        void Presenter(List<ITemData> ITemDatumCourses);
    }
}
