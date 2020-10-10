package com.example.marketstask;

import android.content.Context;



public class InsertSnackBarLayoutPresenter implements InsertSnackBarLayoutInterface {

    @Override
    public void insertLayout(int layout, Context context, boolean flag) {
        Utilites.NoInternetConnection(context, layout, flag);
    }
}
