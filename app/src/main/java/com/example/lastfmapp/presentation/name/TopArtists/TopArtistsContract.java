package com.example.lastfmapp.presentation.name.TopArtists;

import com.example.lastfmapp.model.ArtistEntity;
import com.example.lastfmapp.presentation.name.BaseInterface.BaseInterface;

import java.util.List;

public interface TopArtistsContract {

    interface View extends BaseInterface.View{

        void showArtists(List<ArtistEntity> artists);

        void openArtist(ArtistEntity artist);

        void showMessage(String Message);

    }

    interface Presenter extends BaseInterface.Presenter {

        void getArtist();

        void onArtistClick(int pos);



    }

}
