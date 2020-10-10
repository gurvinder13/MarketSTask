package com.example.marketstask.di.modules;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;


import com.example.marketstask.ViewModelProviderFactory;
import com.example.marketstask.data.DataManager;
import com.example.marketstask.ui.ui.base.BaseFragment;
import com.example.marketstask.ui.ui.dashboard.HomeDetailsViewModel;
import com.example.marketstask.ui.ui.home.HomeViewModel;
import com.example.marketstask.utils.ScheduleProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    private BaseFragment<?, ?> fragment;

    public FragmentModule(BaseFragment<?, ?> fragment) {
        this.fragment = fragment;
    }

    @Provides
    HomeViewModel provideRepositoriesViewModel(DataManager dataManager, ScheduleProvider schedulerProvider) {
        Supplier<HomeViewModel> supplier = () -> new HomeViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<HomeViewModel> factory = new ViewModelProviderFactory<>(HomeViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(HomeViewModel.class);
    }

    @Provides
    HomeDetailsViewModel provideRepoDetailsViewModel(DataManager dataManager, ScheduleProvider schedulerProvider) {
        Supplier<HomeDetailsViewModel> supplier = () -> new HomeDetailsViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<HomeDetailsViewModel> factory = new ViewModelProviderFactory<>(HomeDetailsViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(HomeDetailsViewModel.class);
    }

}
