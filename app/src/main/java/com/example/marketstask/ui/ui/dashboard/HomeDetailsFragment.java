package com.example.marketstask.ui.ui.dashboard;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.marketstask.BR;
import com.example.marketstask.R;
import com.example.marketstask.data.remote.models.PublicRepository;
import com.example.marketstask.databinding.FragmentHomeDetailsBinding;
import com.example.marketstask.di.components.FragmentComponent;
import com.example.marketstask.ui.ui.base.BaseFragment;


public class HomeDetailsFragment extends BaseFragment<FragmentHomeDetailsBinding, HomeDetailsViewModel> {

    public static String TAG = "DetailsFragment";

    PublicRepository mPublicRepository;

    @Override
    public int getBindingVariable() {
        return BR.model;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_details;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null && getArguments().getParcelable("REPO") != null){
            mPublicRepository = getArguments().getParcelable("REPO");
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        if(mPublicRepository != null){
            getmViewModel().initialise(mPublicRepository);
        }
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }
}