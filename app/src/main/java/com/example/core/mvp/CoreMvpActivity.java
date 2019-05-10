package com.example.core.mvp;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.core.CoreUtils;
import com.example.lastfmapp.R;

public abstract class CoreMvpActivity<T extends ICoreMvpContract.Presenter> extends AppCompatActivity
    implements ICoreMvpContract.View<T>{

    @Nullable
    protected T presenter;

    @Override
    public void finisView() {
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityId());

        initView();

        presenter = providPresenter();
        if ( presenter != null) {
            presenter.attachView(this);
        }

    }

    protected abstract T providPresenter();

    protected abstract void initView();

    @Override
    public void attachPresenter(T presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showMessage(String message) {
        CoreUtils.showShortToast(this, message);
    }

    @LayoutRes
    protected abstract int getActivityId();




}
