package com.test.mvvmuserproject.di;


import com.test.mvvmuserproject.model.UsersService;
import com.test.mvvmuserproject.viewmodel.ListViewModel;

@dagger.Component(modules = Module.class)
public interface Component {

    void inject (UsersService service);

    void inject (ListViewModel viewModel);
}
