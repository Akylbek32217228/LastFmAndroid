package com.example.lastfmapp.presentation.name.topTracks;



import com.example.lastfmapp.model.TrackEntity;
import com.example.lastfmapp.presentation.name.BaseInterface.BaseInterface;

import java.util.ArrayList;

public class  TopTracksPresenter implements TopTracksContract.Presenter, BaseInterface.Presenter {

    private TopTracksContract.View mView;

    @Override
    public void getTracks() {
        //TODO: Get tracks from Repository
        ArrayList<TrackEntity> trackEntities = new ArrayList<>();

        trackEntities.add(new TrackEntity(1, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(2, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(3, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(4, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(5, "name", "artist", "image"));

        if (mView != null) {
            mView.showTracks(trackEntities);
        }
    }

    @Override
    public void onTrackClick(int position) {

    }

    @Override
    public void attachView(BaseInterface.View view) {
        mView = (TopTracksContract.View) view;
        mView.attachPresenter(this);
    }

    @Override
    public void detachView() {

    }
}
