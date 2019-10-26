package com.test.mvvmuserproject.model;

import com.google.gson.annotations.SerializedName;

public class UserName {

    @SerializedName("first")
    private String firstName;

    @SerializedName("last")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
