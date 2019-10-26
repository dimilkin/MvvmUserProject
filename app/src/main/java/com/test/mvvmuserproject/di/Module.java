package com.test.mvvmuserproject.di;

import com.test.mvvmuserproject.model.UsersAPI;
import com.test.mvvmuserproject.model.UsersService;

import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@dagger.Module
public class Module {

    private static final String BASE_URL = "https://randomuser.me/api/";

    @Provides
    public UsersAPI provideUsersAPI () {
        return  new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(UsersAPI.class);
    }


    @Provides
    public UsersService providesUsersService(){
       return new UsersService().getInstance();
    }



}
