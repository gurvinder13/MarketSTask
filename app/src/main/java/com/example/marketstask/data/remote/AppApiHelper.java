package com.example.marketstask.data.remote;

import com.example.marketstask.AppConfig;
import com.example.marketstask.data.remote.models.PublicRepository;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class AppApiHelper implements ApiHelper{

    private ApiService apiService;

    @Inject
    public AppApiHelper(){
        // Client initialisation
        OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder()
                .addInterceptor(new NetworkInterceptor())
                .connectTimeout(AppConfig.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(AppConfig.CONNECTION_TIMEOUT, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpBuilder.build())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    @Override
    public Observable<List<PublicRepository>> doPublicRepoGetCall(long lastRepoId) {
        return apiService.performGetPublicReposCall(lastRepoId);
    }
}
