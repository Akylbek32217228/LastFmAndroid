package com.example.core.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lastfmapp.R;

public class CoreMvpActivity extends AppCompatActivity implements ICoreMvpContract.View{

    private ICoreMvpContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_mvp);
    }

    @Override
    public void finisView() {
        mPresenter = null;
    }

    @Override
    public void attachPresenter(ICoreMvpContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.attachView(this);
    }
}
