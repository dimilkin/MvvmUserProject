package com.test.mvvmuserproject.model;

import com.test.mvvmuserproject.di.DaggerComponent;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;


public class UsersService {


    private static UsersService instance;

    @Inject
    public UsersAPI api;


    public UsersService() {
        DaggerComponent.create().inject(this);
    }

    public static UsersService getInstance() {
        if (instance == null) {
            instance = new UsersService();
        }
        return instance;
    }

    public Single<JsonResponse> getUsers() {
        return api.getUsers();
    }
}
