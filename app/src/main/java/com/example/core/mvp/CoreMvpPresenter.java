package com.example.core.mvp;

import android.support.annotation.Nullable;

public abstract class CoreMvpPresenter<T extends ICoreMvpContract.View> implements ICoreMvpContract.Presenter<T>{
    @Nullable
    protected T mView;

    @Override
    public void attachView(T view) {
        mView = view;
        mView.attachPresenter(this);
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
