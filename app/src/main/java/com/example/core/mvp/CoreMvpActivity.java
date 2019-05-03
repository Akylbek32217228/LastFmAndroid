package com.example.core.mvp;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lastfmapp.R;

public abstract class CoreMvpActivity<T extends ICoreMvpContract.Presenter> extends AppCompatActivity
    implements ICoreMvpContract.View<T>{

    @Nullable
    protected T presenter;

    @Override
    public void finisView() {
        finish();
    }

    /*@Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityId());

        presenter = getPresenter();

    }*/

    @Override
    public void attachPresenter(T presenter) {
        this.presenter = presenter;
    }

    /*@LayoutRes
    protected abstract int getActivityId();

    protected abstract T getPresenter();*/


}
