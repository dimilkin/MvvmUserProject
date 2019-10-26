package com.test.mvvmuserproject.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.test.mvvmuserproject.di.DaggerComponent;
import com.test.mvvmuserproject.model.JsonResponse;
import com.test.mvvmuserproject.model.UserModel;
import com.test.mvvmuserproject.model.UsersService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ListViewModel extends ViewModel {

    public MutableLiveData<JsonResponse> users = new MutableLiveData<JsonResponse>();
    public MutableLiveData <Boolean> isLoading = new MutableLiveData<Boolean>();
    public MutableLiveData<Boolean> loadingError = new MutableLiveData<Boolean>();

    public ListViewModel() {
        DaggerComponent.create().inject(this);
    }

    @Inject
    public UsersService usersService;

    private CompositeDisposable disposable = new CompositeDisposable();

    public void refresh(){
        getUsers();
    }

    private void getUsers() {
      isLoading.setValue(true);
      disposable.add(
              usersService.getUsers()
              .subscribeOn(Schedulers.newThread())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribeWith(new DisposableSingleObserver<JsonResponse>() {
                  @Override
                  public void onSuccess( JsonResponse response) {

                      users.setValue(response);
                      isLoading.setValue(false);
                      loadingError.setValue(false);
                                        }

                  @Override
                  public void onError(Throwable e) {

                      loadingError.setValue(true);
                      isLoading.setValue(false);
                      e.printStackTrace();
                  }
              })
      );

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
