package com.example.lastfmapp.presentation.name.TopArtists;

import com.example.lastfmapp.model.ArtistEntity;
import com.example.lastfmapp.presentation.name.BaseInterface.BaseInterface;

import java.util.ArrayList;

public class TopArtistsPresenter implements TopArtistsContract.Presenter{

    private TopArtistsContract.View mView;

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
    public void attachView(BaseInterface.View view) {
        mView = (TopArtistsContract.View) view;
        mView.attachPresenter(this);
    }

    @Override
    public void detachView() {

    }
}
