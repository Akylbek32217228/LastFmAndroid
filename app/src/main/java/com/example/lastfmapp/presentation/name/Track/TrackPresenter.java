package com.example.lastfmapp.presentation.name.Track;

import com.example.lastfmapp.presentation.name.BaseInterface.BaseInterface;

public class TrackPresenter implements TrackContract.Presenter {

    private TrackContract.View mView;

    @Override
    public void attachView(BaseInterface.View view) {
        mView = (TrackContract.View) view;
        mView.attachPresenter(this);
    }

    @Override
    public void detachView() {

    }
}
