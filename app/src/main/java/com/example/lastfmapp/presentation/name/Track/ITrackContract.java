package com.example.lastfmapp.presentation.name.Track;

import com.example.core.mvp.ICoreMvpContract;
import com.example.lastfmapp.model.TrackEntity;

public interface ITrackContract{

    interface View extends ICoreMvpContract.View<Presenter> {

        //void openTrack(TrackEntity track);

    }

    interface Presenter extends ICoreMvpContract.Presenter<View>{


    }

}
