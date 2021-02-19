package com.assignment.ravindra_spicsumbrowser.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.assignment.ravindra_spicsumbrowser.R;
import com.assignment.ravindra_spicsumbrowser.model.Photo;
import com.google.android.material.textview.MaterialTextView;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class PhotoViewActivity extends AppCompatActivity {

    private MaterialTextView txt_name;
    private ImageView image;
    Photo photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);


        txt_name=findViewById(R.id.txt_name);
        image=findViewById(R.id.image);

        photo= (Photo) getIntent().getSerializableExtra("photo");

        Picasso.with(getApplicationContext()).load("https://picsum.photos/"+photo.id).placeholder(R.drawable.ic_launcher_background).into(image);
        txt_name.setText(photo.author);


    }
}