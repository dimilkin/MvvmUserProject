package com.test.mvvmuserproject.model;

import android.widget.ProgressBar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("gender")
    private String gender;

    @SerializedName("email")
    private String email;

    @SerializedName("phone")
    private String phone;

   @SerializedName("name")
   @Expose
   private UserName name;

    @SerializedName("picture")
    @Expose
    private ProfilePicture picture;



    public UserModel(String gender, String email, String phone, UserName name, ProfilePicture picture) {
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.picture = picture;

    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public UserName getName() {
        return name;
    }

    public ProfilePicture getPicture() {
        return picture;
    }
}

