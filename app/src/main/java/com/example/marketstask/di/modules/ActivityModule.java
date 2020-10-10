package com.example.marketstask.di.modules;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;


import com.example.marketstask.ViewModelProviderFactory;
import com.example.marketstask.data.DataManager;
import com.example.marketstask.ui.ui.HomeViewModel;
import com.example.marketstask.ui.ui.base.BaseActivity;
import com.example.marketstask.utils.ScheduleProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private BaseActivity<?, ?> activity;

    public ActivityModule(BaseActivity<?, ?> activity) {
        this.activity = activity;
    }

    @Provides
    HomeViewModel provideFeedViewModel(DataManager dataManager, ScheduleProvider schedulerProvider) {
        Supplier<HomeViewModel> supplier = () -> new HomeViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<HomeViewModel> factory = new ViewModelProviderFactory<>(HomeViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(HomeViewModel.class);
    }

}
