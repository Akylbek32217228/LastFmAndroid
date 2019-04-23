package com.example.lastfmapp.presentation.name.topTracks;


import com.example.lastfmapp.model.TrackEntity;
import com.example.lastfmapp.presentation.name.BaseInterface.BaseInterface;

import java.util.List;

public interface TopTracksContract {

    interface View extends BaseInterface.View{

        void showTracks(List<TrackEntity> tracks);

        void openTrack(TrackEntity track);

        void showMessage(String message);


    }

    interface Presenter extends BaseInterface.Presenter{
        void getTracks();

        void onTrackClick(int position);

    }
}
