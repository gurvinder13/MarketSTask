package com.example.marketstask.data;

import android.content.Context;


import com.example.marketstask.data.remote.ApiHelper;
import com.example.marketstask.data.remote.models.PublicRepository;
import com.google.gson.Gson;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDataManager implements DataManager{

    private final ApiHelper mApiHelper;

    private final Context mContext;


    private final Gson mGson;


    @Inject
    public AppDataManager(Context context,  ApiHelper apiHelper, Gson gson){
        this.mContext = context;
        this.mApiHelper = apiHelper;

        this.mGson = gson;
    }

    @Override
    public Observable<List<PublicRepository>> doPublicRepoGetCall(long lastRepoId) {
        return mApiHelper.doPublicRepoGetCall(lastRepoId);
    }
}
