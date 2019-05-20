package com.example.lastfmapp.presentation.topTracks;


import com.example.core.mvp.ICoreMvpContract;
import com.example.lastfmapp.model.Artist;
import com.example.lastfmapp.model.Track;

import java.util.List;

public interface ITopTracksContract {

    interface View extends ICoreMvpContract.View<Presenter>{

        void showTracks(List<Track> tracks);


        void openTrackDetails(Track track);


        void openArtistDetails(Artist artist);

        void startRefresh();

        void stopRefresh();

    }

    interface Presenter extends ICoreMvpContract.Presenter<View>{
        void getTracks();

        void onTrackClick(int position);

        void onArtistClick(int pos);
    }
}
