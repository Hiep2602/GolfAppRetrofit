package com.example.hieph.golfappretrofit.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hieph on 8/20/2018.
 */

public interface ApiCourse {
    String BASE_URL = "https://www.dropbox.com/s/cudvi8n8vzhrk0o/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
