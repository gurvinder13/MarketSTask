package com.example.marketstask.ui.ui.dashboard;

import androidx.lifecycle.MutableLiveData;

import com.example.marketstask.data.DataManager;
import com.example.marketstask.data.remote.models.PublicRepository;
import com.example.marketstask.ui.ui.base.BaseViewModel;
import com.example.marketstask.utils.ScheduleProvider;


public class HomeDetailsViewModel extends BaseViewModel {

    public MutableLiveData<String> authorName;

    public MutableLiveData<String> type;

    public MutableLiveData<String> login;

    public MutableLiveData<String> admin;

    public MutableLiveData<String> repoName;

    public MutableLiveData<String> fullName;

    public MutableLiveData<String> isPrivate;

    public MutableLiveData<String> fork;

    public MutableLiveData<String> description;

    public MutableLiveData<String> avatarUrl;

    public HomeDetailsViewModel(DataManager dataManager, ScheduleProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        authorName = new MutableLiveData<>();
        type = new MutableLiveData<>();
        login = new MutableLiveData<>();
        admin = new MutableLiveData<>();
        repoName = new MutableLiveData<>();
        fullName = new MutableLiveData<>();
        isPrivate = new MutableLiveData<>();
        fork = new MutableLiveData<>();
        description = new MutableLiveData<>();
        avatarUrl = new MutableLiveData<>();
    }

    public void initialise(PublicRepository publicRepository){
        authorName.setValue(publicRepository.owner.login);
        type.setValue(publicRepository.owner.type);
        login.setValue(publicRepository.owner.login);
        admin.setValue(String.valueOf(publicRepository.owner.isSiteAdmin));
        repoName.setValue(publicRepository.name);
        fullName.setValue(publicRepository.fullName);
        isPrivate.setValue(String.valueOf(publicRepository.isPrivate));
        fork.setValue(publicRepository.fork);
        description.setValue(publicRepository.description);
        avatarUrl.setValue(publicRepository.owner.avatarUrl);
    }

}