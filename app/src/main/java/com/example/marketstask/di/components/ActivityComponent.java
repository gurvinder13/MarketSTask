package com.example.marketstask.di.components;


import com.example.marketstask.di.modules.ActivityModule;
import com.example.marketstask.di.scopes.ActivityScope;
import com.example.marketstask.ui.HomeActivity;

import dagger.Component;

@ActivityScope
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(HomeActivity activity);
}
