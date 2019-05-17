package com.example.lastfmapp.presentation.topArtists;

import com.example.core.mvp.ICoreMvpContract;
import com.example.lastfmapp.model.Artist;

import java.util.List;

public interface ITopArtistsContract {

    interface View extends ICoreMvpContract.View<Presenter>{

        void showArtists(List<Artist> artists);

        void openArtist(Artist artist);

    }

    interface Presenter extends ICoreMvpContract.Presenter<View> {

        void getArtist();

        void onArtistClick(int pos);



    }

}
