package com.example.core.mvp;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.core.CoreUtils;

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
        setContentView(getLayoutId());

        initView();

        presenter = providePresenter();
        if ( presenter != null) {
            presenter.attachView(this);
            presenter.onViewCreated();
        }

    }

    protected abstract T providePresenter();

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
    protected abstract int getLayoutId();




}
