package com.example.marketstask.di.components;

import android.app.Application;


import com.example.marketstask.MyApplication;
import com.example.marketstask.data.DataManager;
import com.example.marketstask.di.modules.AppModule;
import com.example.marketstask.utils.ScheduleProvider;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class
})
public interface AppComponent {

    void inject(MyApplication app);

    DataManager getDataManager();

    ScheduleProvider getScheduleProvider();

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }


}
