package com.example.lastfmapp.presentation.name.Track;

import com.example.core.mvp.CoreMvpPresenter;
import com.example.lastfmapp.data.tracks.ITracksRepository;

public class TrackPresenter extends CoreMvpPresenter<ITrackContract.View> implements ITrackContract.Presenter {

    private ITracksRepository repository;

    public TrackPresenter(ITracksRepository repository) {
        this.repository = repository;
    }
}
