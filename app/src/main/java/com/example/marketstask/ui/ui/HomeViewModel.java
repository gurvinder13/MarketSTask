package com.example.marketstask.ui.ui;

import androidx.lifecycle.MutableLiveData;

import com.example.marketstask.data.DataManager;
import com.example.marketstask.data.remote.models.PublicRepository;
import com.example.marketstask.ui.ui.base.BaseViewModel;
import com.example.marketstask.utils.ScheduleProvider;


public class HomeViewModel extends BaseViewModel {

    MutableLiveData<PublicRepository> selectedRepo = new MutableLiveData<>();

    public HomeViewModel(DataManager dataManager, ScheduleProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void initialise(PublicRepository repo){
        selectedRepo.setValue(repo);
    }

}
