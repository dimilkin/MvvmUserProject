package com.test.mvvmuserproject.model;

import java.lang.reflect.Array;
import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface UsersAPI {

    @GET ("?results=10")
    Single <JsonResponse> getUsers ();



}
