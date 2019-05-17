package com.example.lastfmapp.presentation.track;

import com.example.core.Logger;
import com.example.core.mvp.CoreMvpPresenter;
import com.example.lastfmapp.data.tracks.ITracksRepository;
import com.example.lastfmapp.model.Track;

public class TrackPresenter extends CoreMvpPresenter<ITrackContract.View> implements ITrackContract.Presenter {

    private ITracksRepository repository;
    private String uniqueId;

    public TrackPresenter(ITracksRepository repository, String uniqueId) {
        this.repository = repository;
        this.uniqueId = uniqueId;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        Logger.d("onViewCreatedTrackPresenter");
        Track track = repository.getTrack(uniqueId);

        if (mView != null && track != null) {
            mView.showTrack(track);
        }
    }
}
