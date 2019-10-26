package com.test.mvvmuserproject.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.test.mvvmuserproject.R;
import com.test.mvvmuserproject.model.UserModel;
import com.test.mvvmuserproject.viewmodel.ListViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //test something here

    @BindView(R.id.usersList)
    RecyclerView usersList;

    @BindView(R.id.loading_view)
    ProgressBar loadingView;

    @BindView(R.id.error_message)
    TextView errorMesage;

    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    private ListViewModel viewModel;
    private UsersListAdapter adapter = new UsersListAdapter(new ArrayList<>());
    private ArrayList<UserModel> userResponce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        viewModel.refresh();

        refreshLayout.setOnRefreshListener(() -> {
                viewModel.refresh();
                refreshLayout.setRefreshing(false);
        });

        usersList.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration devider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        devider.setDrawable(getResources().getDrawable(R.drawable.recycler_devider));
        usersList.addItemDecoration(devider);
        usersList.setAdapter(adapter);


        observeViewModel();
    }

    private void observeViewModel() {

        viewModel.users.observe(this, response -> {
            if (response != null) {
                usersList.setVisibility(View.VISIBLE);
                userResponce = new ArrayList<>(Arrays.asList(response.getUsersArray()));
                adapter.updateUsers(userResponce);
            }
        });

        viewModel.loadingError.observe(this, isError -> {
            if (isError != null) {
                errorMesage.setVisibility(isError ? View.VISIBLE : View.GONE);
            }
        });

        viewModel.isLoading.observe(this, loading -> {
            if (loading != null) {
                loadingView.setVisibility(loading ? View.VISIBLE : View.GONE);
                if (loading) {
                    usersList.setVisibility(View.GONE);
                    errorMesage.setVisibility(View.GONE);
                }
            }
        });
    }
}
