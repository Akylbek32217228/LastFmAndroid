package com.example.lastfmapp.presentation.name.topTracks;


import com.example.core.mvp.ICoreMvpContract;
import com.example.lastfmapp.model.TrackEntity;

import java.util.List;

public interface ITopTracksContract {

    interface View extends ICoreMvpContract.View<Presenter>{

        void showTracks(List<TrackEntity> tracks);

        void openTrack(TrackEntity track);

        void showMessage(String message);


    }

    interface Presenter extends ICoreMvpContract.Presenter<View>{
        void getTracks();

        void onTrackClick(int position);

    }
}
