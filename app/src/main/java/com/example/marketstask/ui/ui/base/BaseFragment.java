package com.example.marketstask.ui.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;


import com.example.marketstask.MyApplication;
import com.example.marketstask.di.components.DaggerFragmentComponent;
import com.example.marketstask.di.components.FragmentComponent;
import com.example.marketstask.di.modules.FragmentModule;

import javax.inject.Inject;

public abstract class BaseFragment <T extends ViewDataBinding, V extends BaseViewModel> extends Fragment {

    @Inject
    protected V mViewModel;

    private BaseActivity mActivity;
    private View mRootView;
    private T mViewDataBinding;

    public abstract int getBindingVariable();

    /**
     * @return layout resource id
     */
    public abstract @LayoutRes int getLayoutId();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection(getBuildComponent());
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
       mRootView = mViewDataBinding.getRoot();
       return mRootView;
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.setLifecycleOwner(this);
        mViewDataBinding.executePendingBindings();
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public abstract void performDependencyInjection(FragmentComponent buildComponent);


    private FragmentComponent getBuildComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(((MyApplication)(getContext().getApplicationContext())).appComponent)
                .fragmentModule(new FragmentModule(this))
                .build();
    }

    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    public V getmViewModel() {
        return mViewModel;
    }

    public void setmViewModel(V mViewModel) {
        this.mViewModel = mViewModel;
    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }

}
