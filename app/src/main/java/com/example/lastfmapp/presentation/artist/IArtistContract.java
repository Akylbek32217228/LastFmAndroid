package com.example.lastfmapp.presentation.artist;

import com.example.core.mvp.ICoreMvpContract;
import com.example.lastfmapp.model.Track;

import java.util.List;

public interface  IArtistContract {

    interface View extends ICoreMvpContract.View<Presenter> {
        void showArtistTopTracks(List<Track> tracks);

        void showArtistName(String name);
    }


    interface Presenter  extends ICoreMvpContract.Presenter<View>{


    }
}
