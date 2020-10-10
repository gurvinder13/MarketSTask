package com.example.marketstask.ui.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;


import com.example.marketstask.data.DataManager;
import com.example.marketstask.data.remote.models.PublicRepository;

import io.reactivex.disposables.CompositeDisposable;

public class HomeDataSourceFactory extends DataSource.Factory<Long, PublicRepository> {

    private MutableLiveData<HomeDataSourceClass> liveData;
    private DataManager dataManager;
    private CompositeDisposable compositeDisposable;

    public HomeDataSourceFactory(DataManager dataManager, CompositeDisposable compositeDisposable) {
        this.dataManager = dataManager;
        this.compositeDisposable = compositeDisposable;
        liveData = new MutableLiveData<>();
    }

    public MutableLiveData<HomeDataSourceClass> getMutableLiveData() {
        return liveData;
    }

    @Override
    public DataSource<Long, PublicRepository> create() {
        HomeDataSourceClass dataSourceClass = new HomeDataSourceClass(dataManager, compositeDisposable);
        liveData.postValue(dataSourceClass);
        return dataSourceClass;
    }
}
