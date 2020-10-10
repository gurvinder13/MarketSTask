package com.example.marketstask.ui.ui.home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.example.marketstask.R;
import com.example.marketstask.databinding.FragmentHomeBinding;
import com.example.marketstask.di.components.FragmentComponent;
import com.example.marketstask.ui.ui.base.BaseFragment;

import java.util.Objects;

public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeViewModel> {

    public static String TAG = "RepositoriesFragment";

    @Override
    public int getBindingVariable() {
        return -1;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume(){
        super.onResume();
        init();
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    private void init() {

        getViewDataBinding().list.setLayoutManager(new LinearLayoutManager(this.getContext()));
        HomeListAdapter adapter = new HomeListAdapter(getActivity());
        getViewDataBinding().list.setAdapter(adapter);

        getmViewModel().getListLiveData().observe(getViewLifecycleOwner(), adapter::submitList);

        getmViewModel().getProgressLoadStatus().observe(getViewLifecycleOwner(), status -> {
            if (Objects.requireNonNull(status).equalsIgnoreCase("Loading...")) {
                //getViewDataBinding().progress.setVisibility(View.VISIBLE);
            } else if (status.equalsIgnoreCase("Loaded")) {
                //getViewDataBinding().progress.setVisibility(View.GONE);
            }
        });

    }

}