package com.example.core.mvp;

public class CoreMvpPresenter implements ICoreMvpContract.Presenter{

    private ICoreMvpContract.View mView;

    @Override
    public void attachView(ICoreMvpContract.View view) {
        mView = view;
        mView.attachPresenter(this);
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
