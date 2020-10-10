package com.example.marketstask.ui;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.marketstask.DisplaySnackBarInterface;
import com.example.marketstask.InsertSnackBarLayoutPresenter;
import com.example.marketstask.R;
import com.example.marketstask.databinding.ActivityHomeBinding;
import com.example.marketstask.di.components.ActivityComponent;
import com.example.marketstask.ui.ui.HomeViewModel;
import com.example.marketstask.ui.ui.base.BaseActivity;
import com.example.marketstask.ui.ui.dashboard.HomeDetailsFragment;
import com.example.marketstask.ui.ui.home.HomeFragment;
import com.example.marketstask.ui.ui.notifications.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeViewModel>implements DisplaySnackBarInterface {

    BottomNavigationView navView;
    boolean detailsRendered;

    @Override
    public int getBindingVariable() {
        return -1;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navView = findViewById(R.id.nav_view);
        /*AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);*/
        pushFragment(new HomeFragment(), HomeFragment.TAG, false);
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    protected void onResume(){
        super.onResume();

        navView.findViewById(R.id.navigation_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushFragment(new HomeFragment(), HomeFragment.TAG, false);
            }
        });

        navView.findViewById(R.id.navigation_dashboard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushFragment(new HomeDetailsFragment(), HomeDetailsFragment.TAG, true);
            }
        });

        navView.findViewById(R.id.navigation_notifications).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushFragment(new SettingsFragment(), SettingsFragment.TAG, false);
            }
        });
    }

    public void pushFragment(Fragment fragment, Bundle args, String nameTag, boolean addToBackStack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        fragment.setArguments(args);
        if(detailsRendered){
            Fragment detailsFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
            getSupportFragmentManager().popBackStack(HomeDetailsFragment.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            if(detailsFragment != null){
                ft.hide(detailsFragment);
                ft.add(R.id.nav_host_fragment, fragment);
            } else{
                ft.remove(fragment);
            }
        } else{
            ft.replace(R.id.nav_host_fragment, fragment);
        }
        if(fragment instanceof HomeDetailsFragment){
            detailsRendered = true;
        }
        ft.commit();
    }

    public void pushFragment(Fragment fragment, String nameTag, boolean addToBackStack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if(detailsRendered){
            Fragment detailsFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
            getSupportFragmentManager().popBackStack(HomeDetailsFragment.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            if(detailsFragment != null){
                ft.hide(detailsFragment);
                ft.add(R.id.nav_host_fragment, fragment);
            } else{
                ft.remove(fragment);
            }
        } else{
            ft.replace(R.id.nav_host_fragment, fragment);
        }
        if(fragment instanceof HomeDetailsFragment){
            detailsRendered = true;
        }
        ft.commit();
    }

    @Override
    public void displaySnackBar(boolean flag) {
        new InsertSnackBarLayoutPresenter().insertLayout(R.id.container, this, flag);

    }

    @Override
    public void onBackPressed()
    {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(HomeDetailsFragment.TAG);
        if(!(fragment instanceof HomeFragment)){
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);;
            pushFragment(new HomeFragment(), HomeFragment.TAG, true);
        } else{
            finish();
        }
    }

}