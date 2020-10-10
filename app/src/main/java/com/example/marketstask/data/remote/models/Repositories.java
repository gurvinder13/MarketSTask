package com.example.marketstask.data.remote.models;

import java.util.List;

public class Repositories {

    List<PublicRepository> repoList;

    public List<PublicRepository> getRepoList() {
        return repoList;
    }

    public void setRepoList(List<PublicRepository> repoList) {
        this.repoList = repoList;
    }
}
