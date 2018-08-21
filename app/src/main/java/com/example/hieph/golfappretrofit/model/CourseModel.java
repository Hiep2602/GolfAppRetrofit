package com.example.hieph.golfappretrofit.model;

import com.example.hieph.golfappretrofit.service.APIService;
import com.example.hieph.golfappretrofit.service.ApiCourse;
import com.example.hieph.golfappretrofit.view.ContractFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by hieph on 8/15/2018.
 */

public class CourseModel {
    ContractFragment.Presenter presentercourse;
    ApiCourse apiCourse;
    APIService apiService;

    public CourseModel(ContractFragment.Presenter presentercourse) {
        this.presentercourse = presentercourse;
    }

    public void getDataCourse() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.dropbox.com/s/cudvi8n8vzhrk0o/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();

        apiService = apiCourse.retrofit.create(APIService.class);
        Call<ITemData.DataCourse> call = apiService.getResult();
        call.enqueue(new Callback<ITemData.DataCourse>() {
            @Override
            public void onResponse(Call<ITemData.DataCourse> call, Response<ITemData.DataCourse> response) {
                ITemData.DataCourse dataCourse = response.body();
                List<ITemData> result = dataCourse.getData();
                presentercourse.Presenter(result);
            }

            @Override
            public void onFailure(Call<ITemData.DataCourse> call, Throwable t) {

            }
        });

    }
}