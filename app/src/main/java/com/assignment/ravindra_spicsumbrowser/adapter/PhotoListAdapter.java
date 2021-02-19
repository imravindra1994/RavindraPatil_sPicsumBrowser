package com.assignment.ravindra_spicsumbrowser.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.ravindra_spicsumbrowser.R;
import com.assignment.ravindra_spicsumbrowser.activity.PhotoViewActivity;
import com.assignment.ravindra_spicsumbrowser.model.Photo;
import com.google.android.material.textview.MaterialTextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.ViewHolder> {
    Context context;
    List<Photo> photoList=new ArrayList<>();

    public PhotoListAdapter(Context context, List<Photo> photos) {
        this.context = context;
        this.photoList = photos;
    }

    @NonNull
    @Override
    public PhotoListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.photo_list_item, parent, false);
        return new PhotoListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoListAdapter.ViewHolder holder, int position) {

        if (photoList.size() != 0) {
            Picasso.with(context).load("https://picsum.photos/"+photoList.get(position).id).placeholder(R.drawable.ic_launcher_background).into(holder.imageView);
            holder.titletv.setText(photoList.get(position).author);

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, PhotoViewActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("photo",photoList.get(position));
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        MaterialTextView titletv;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titletv = itemView.findViewById(R.id.txt_name);

            imageView = itemView.findViewById(R.id.image);


        }
    }
}
