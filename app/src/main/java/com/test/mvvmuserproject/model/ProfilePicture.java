package com.test.mvvmuserproject.model;

import com.google.gson.annotations.SerializedName;

public class ProfilePicture {

    @SerializedName("large")
    private String largePicture;

    @SerializedName("medium")
    private String mediumPicture;

    @SerializedName("thumbnail")
    private String thumbPicture;


    public String getLargePicture() {
        return largePicture;
    }

    public String getMediumPicture() {
        return mediumPicture;
    }

    public String getThumbPicture() {
        return thumbPicture;
    }
}
