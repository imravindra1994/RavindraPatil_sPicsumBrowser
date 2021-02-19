package com.assignment.ravindra_spicsumbrowser.apiinterface;

import com.assignment.ravindra_spicsumbrowser.model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/list")
    public Call<List<Photo>> getAllPhoto();
}
