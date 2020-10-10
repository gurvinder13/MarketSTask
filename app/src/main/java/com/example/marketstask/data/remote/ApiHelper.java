package com.example.marketstask.data.remote;


import com.example.marketstask.data.remote.models.PublicRepository;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Query;

public interface ApiHelper {

    Observable<List<PublicRepository>> doPublicRepoGetCall(@Query("since") long lastRepoId);

}
