package com.example.marketstask.di.modules;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.example.marketstask.AppConfig;
import com.example.marketstask.data.AppDataManager;
import com.example.marketstask.data.DataManager;

import com.example.marketstask.data.remote.ApiHelper;
import com.example.marketstask.data.remote.AppApiHelper;
import com.example.marketstask.di.scopes.DatabaseInfo;
import com.example.marketstask.di.scopes.PreferenceInfo;
import com.example.marketstask.utils.AppScheduleProvider;
import com.example.marketstask.utils.ScheduleProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    Gson provideGson(){
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    ScheduleProvider provideScheduleProvider(){
        return new AppScheduleProvider();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    AppConfig provideAppConfig(AppConfig appConfig){
        return appConfig;
    }


    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConfig.PREF_NAME;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConfig.DB_NAME;
    }


}
