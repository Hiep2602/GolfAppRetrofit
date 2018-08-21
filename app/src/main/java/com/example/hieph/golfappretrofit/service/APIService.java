package com.example.hieph.golfappretrofit.service;

import com.example.hieph.golfappretrofit.model.ITemData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hieph on 8/20/2018.
 */

public interface APIService {

    @GET("test_data.txt?dl=1")
    Call<ITemData.DataCourse> getResult();
}
