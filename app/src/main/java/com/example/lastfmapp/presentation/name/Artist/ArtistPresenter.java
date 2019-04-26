package com.example.lastfmapp.presentation.name.Artist;

public class ArtistPresenter implements IArtistContract.Presenter{
    private IArtistContract.View mView;


    @Override
    public void attachView(IArtistContract.View view) {
        mView = view;
        mView.attachPresenter(this);
    }

    @Override
    public void detachView() {

    }
}
