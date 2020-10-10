package com.example.marketstask.di.components;


import com.example.marketstask.di.modules.FragmentModule;
import com.example.marketstask.di.scopes.FragmentScope;
import com.example.marketstask.ui.ui.dashboard.HomeDetailsFragment;
import com.example.marketstask.ui.ui.home.HomeFragment;

import dagger.Component;

@FragmentScope
@Component(modules = FragmentModule.class, dependencies = AppComponent.class)
public interface FragmentComponent {

    void inject(HomeFragment fragment);

    void inject(HomeDetailsFragment fragment);

}

