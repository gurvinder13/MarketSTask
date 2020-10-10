package com.example.marketstask.ui.ui.base;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;


import com.example.marketstask.data.DataManager;
import com.example.marketstask.utils.ScheduleProvider;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel {

    private final ObservableBoolean mIsLoading = new ObservableBoolean();

    private final DataManager mDataManager;

    private final ScheduleProvider mScheduleProvider;

    private CompositeDisposable mCompositeDisposable;

    public BaseViewModel(DataManager dataManager,
                         ScheduleProvider schedulerProvider) {
        this.mDataManager = dataManager;
        this.mScheduleProvider = schedulerProvider;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mCompositeDisposable.dispose();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    public ScheduleProvider getSchedulerProvider() {
        return mScheduleProvider;
    }


}
