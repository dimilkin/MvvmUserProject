package com.test.mvvmuserproject.view;

import android.content.Context;
import android.widget.ImageView;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.test.mvvmuserproject.R;

public class Util {

    public static void loadImage (ImageView view, String url, CircularProgressDrawable progressDrawable){

        RequestOptions options = new RequestOptions()
                .placeholder(progressDrawable)
                .error(R.mipmap.ic_launcher_round);
        Glide.with(view.getContext())
                .setDefaultRequestOptions(options)
                .load(url)
                .into(view);
    }

    public static CircularProgressDrawable getProgressDrawable (Context context){
        CircularProgressDrawable progressDrawable = new CircularProgressDrawable(context);
        progressDrawable.setStrokeWidth(15f);
        progressDrawable.setCenterRadius(44f);
        progressDrawable.start();
        return progressDrawable;
    }

}
