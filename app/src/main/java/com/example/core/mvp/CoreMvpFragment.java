package com.example.core.mvp;

import android.support.v4.app.Fragment;

public class CoreMvpFragment extends Fragment implements ICoreMvpContract.View{

    private ICoreMvpContract.Presenter mPresenter;


    @Override
    public void finisView() {

    }

    @Override
    public void attachPresenter(ICoreMvpContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.attachView(this);
    }
}
