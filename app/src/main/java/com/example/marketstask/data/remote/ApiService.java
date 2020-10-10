package com.example.marketstask.data.remote;


import com.example.marketstask.data.remote.models.PublicRepository;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/repositories")
    public Observable<List<PublicRepository>> performGetPublicReposCall(@Query("since") long lastRepoId);

}
