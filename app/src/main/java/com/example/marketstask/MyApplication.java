package com.example.marketstask;

import android.app.Application;

import com.example.marketstask.di.components.AppComponent;
import com.example.marketstask.di.components.DaggerAppComponent;


public class MyApplication extends Application {

    private static MyApplication myApplication;
    private static AppConfig appConfig;
    public static synchronized MyApplication getInstance() {
        return myApplication;
    }

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();

        appComponent.inject(this);

    }
    /**
     * @param listener This function is used to check the network connection state through receiver in
     *                 whole app.
     */
    public void setConnectivityListener(NetworkChangeReceiver.ConnectivityReceiverListener listener) {
        NetworkChangeReceiver.connectivityReceiverListener = listener;
    }
}
