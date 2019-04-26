package com.example.lastfmapp.presentation.name.Track;

public class TrackPresenter implements ITrackContract.Presenter {

    private ITrackContract.View mView;


    @Override
    public void attachView(ITrackContract.View view) {
        mView  = view;
        mView.attachPresenter(this);
    }

    @Override
    public void detachView() {

    }
}
