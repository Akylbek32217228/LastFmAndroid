package com.example.lastfmapp.presentation.track;

import com.example.core.mvp.ICoreMvpContract;
import com.example.lastfmapp.model.Track;

public interface ITrackContract{

    interface View extends ICoreMvpContract.View<Presenter> {
        void showTrack(Track track);
        //void openTrack(Track track);

    }

    interface Presenter extends ICoreMvpContract.Presenter<View>{

    }

}
