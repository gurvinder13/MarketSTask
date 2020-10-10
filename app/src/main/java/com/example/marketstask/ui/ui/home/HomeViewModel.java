package com.example.marketstask.ui.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;


import com.example.marketstask.data.DataManager;
import com.example.marketstask.data.remote.models.PublicRepository;
import com.example.marketstask.ui.ui.base.BaseViewModel;
import com.example.marketstask.utils.ScheduleProvider;

import io.reactivex.disposables.CompositeDisposable;

public class HomeViewModel extends BaseViewModel {

    private LiveData<PagedList<PublicRepository>> mReposList;
    private HomeDataSourceFactory mHomeDataSourceFactory;

    private LiveData<String> progressLoadStatus = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public HomeViewModel(DataManager dataManager, ScheduleProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        mHomeDataSourceFactory = new HomeDataSourceFactory(getDataManager(), getCompositeDisposable());
        initializePaging();
    }

    private void initializePaging(){
        PagedList.Config pagedListConfig = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(10)
                .setPageSize(10).build();
        mReposList = new LivePagedListBuilder<>(mHomeDataSourceFactory, pagedListConfig).build();
        progressLoadStatus = Transformations.switchMap(mHomeDataSourceFactory.getMutableLiveData(), HomeDataSourceClass::getProgressLiveStatus);
    }

    public LiveData<String> getProgressLoadStatus() {
        return progressLoadStatus;
    }

    public LiveData<PagedList<PublicRepository>> getListLiveData() {
        return mReposList;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }

}