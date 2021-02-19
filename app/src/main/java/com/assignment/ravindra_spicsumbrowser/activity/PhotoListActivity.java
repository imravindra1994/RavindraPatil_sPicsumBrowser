package com.assignment.ravindra_spicsumbrowser.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.assignment.ravindra_spicsumbrowser.R;
import com.assignment.ravindra_spicsumbrowser.adapter.PhotoListAdapter;
import com.assignment.ravindra_spicsumbrowser.apiinterface.ApiInterface;
import com.assignment.ravindra_spicsumbrowser.core.RestAPI;
import com.assignment.ravindra_spicsumbrowser.model.Photo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoListActivity extends AppCompatActivity {

    private RecyclerView rv_PhotoList;
    List<Photo> photoList=new ArrayList<>();
    RestAPI restAPI=new RestAPI();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);

        rv_PhotoList=findViewById(R.id.photo_rv);

        restAPI.create(ApiInterface.class).getAllPhoto().enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response.body()!=null)
                {
                    photoList=response.body();
                    GridLayoutManager layoutManager = new GridLayoutManager(PhotoListActivity.this, 2);
                    rv_PhotoList.setLayoutManager(layoutManager);
                    PhotoListAdapter adapter = new PhotoListAdapter(getApplicationContext(), photoList);
                    rv_PhotoList.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });

    }
}