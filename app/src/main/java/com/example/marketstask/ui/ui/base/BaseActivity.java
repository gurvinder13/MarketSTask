package com.example.marketstask.ui.ui.base;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;


import com.example.marketstask.DisplaySnackBarInterface;
import com.example.marketstask.InsertSnackBarLayoutInterface;
import com.example.marketstask.InsertSnackBarLayoutPresenter;
import com.example.marketstask.MyApplication;
import com.example.marketstask.NetworkChangeReceiver;
import com.example.marketstask.di.components.ActivityComponent;
import com.example.marketstask.di.components.DaggerActivityComponent;
import com.example.marketstask.di.modules.ActivityModule;

import javax.inject.Inject;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity
        implements BaseFragment.Callback,
        NetworkChangeReceiver.ConnectivityReceiverListener{
    private int firstTime;
    private final BroadcastReceiver networkChangeReceiver = new NetworkChangeReceiver();
    private InsertSnackBarLayoutInterface snackInterface;
    private DisplaySnackBarInterface displaySnackBarInterface;
    private T mViewDataBinding;

    @Inject
    protected V mViewModel;

    public abstract int getBindingVariable();

    public abstract @LayoutRes int getLayoutId();

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection(getBuildComponent());
        super.onCreate(savedInstanceState);
        snackInterface = new InsertSnackBarLayoutPresenter();
        firstTime = 1;
        try {
            displaySnackBarInterface = (DisplaySnackBarInterface) BaseActivity.this;
        }
        catch (Exception e) {
            Log.d("che", "onCreate: ex" +e.getMessage());
        }
        performDataBinding();
    }

    private ActivityComponent getBuildComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(((MyApplication)getApplication()).appComponent)
                .activityModule(new ActivityModule(this))
                .build();
    }

    public abstract void performDependencyInjection(ActivityComponent buildComponent);

    private void performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
    }

    public V getmViewModel() {
        return mViewModel;
    }

    public void setmViewModel(V mViewModel) {
        this.mViewModel = mViewModel;
    }

    @Override
    protected void onResume() {
        super.onResume();
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeReceiver, intentFilter);
        // register connection status listener
        MyApplication.getInstance().setConnectivityListener(this);
    }
    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showSnack(isConnected);
    }

    private void showSnack(boolean isConnected) {
        if (isConnected) {
            if (firstTime != 1) {
                displaySnackBarInterface.displaySnackBar(true);
            }

        } else {
            displaySnackBarInterface.displaySnackBar(false);

        }
        firstTime = 2;
    }

    @Override
    protected void onPause() {
        super.onPause();
        firstTime = 1;
        unregisterReceiver(networkChangeReceiver);
    }
    @Override
    protected void onStop() {
        super.onStop();
        firstTime = 1;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void intInter(DisplaySnackBarInterface displaySnackBarInterface){
        this.displaySnackBarInterface = displaySnackBarInterface;
    }
}
