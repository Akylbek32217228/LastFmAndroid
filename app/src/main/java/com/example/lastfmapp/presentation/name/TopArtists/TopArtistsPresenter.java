package com.example.lastfmapp.presentation.name.TopArtists;

import com.example.lastfmapp.model.ArtistEntity;

import java.util.ArrayList;

public class TopArtistsPresenter implements ITopArtistsContract.Presenter{

    private ITopArtistsContract.View mView;

    @Override
    public void getArtist() {
        ArrayList<ArtistEntity> list = new ArrayList<>();

        list.add(new ArtistEntity(1, "name", "image"));
        list.add(new ArtistEntity(2, "name", "image"));
        list.add(new ArtistEntity(3, "name", "image"));
        list.add(new ArtistEntity(4, "name", "image"));
        list.add(new ArtistEntity(5, "name", "image"));
        list.add(new ArtistEntity(6, "name", "image"));

        if ( mView != null) {
            mView.showArtists(list);
        }
    }

    @Override
    public void onArtistClick(int pos) {

    }


    @Override
    public void attachView(ITopArtistsContract.View view) {
        mView  = view;
        mView.attachPresenter(this);
    }

    @Override
    public void detachView() {

    }
}
