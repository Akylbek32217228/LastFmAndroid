package com.example.lastfmapp.presentation.name.TopArtists;

import com.example.core.mvp.ICoreMvpContract;
import com.example.lastfmapp.model.ArtistEntity;

import java.util.List;

public interface ITopArtistsContract {

    interface View extends ICoreMvpContract.View<Presenter>{

        void showArtists(List<ArtistEntity> artists);

        void openArtist(ArtistEntity artist);

        void showMessage(String Message);

    }

    interface Presenter extends ICoreMvpContract.Presenter<View> {

        void getArtist();

        void onArtistClick(int pos);



    }

}
