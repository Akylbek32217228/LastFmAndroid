package com.example.lastfmapp.presentation.name.Artist;

import com.example.lastfmapp.presentation.name.BaseInterface.BaseInterface;
import com.example.lastfmapp.presentation.name.TopArtists.TopArtistsContract;

public class ArtistPresenter implements ArtistContract.Presenter{
    private ArtistContract.View mView;

    @Override
    public void attachView(BaseInterface.View view) {
        mView = (ArtistContract.View) view;
        mView.attachPresenter(this);
    }

    @Override
    public void detachView() {

    }
}
