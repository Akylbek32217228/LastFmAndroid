package com.example.lastfmapp.presentation.name.topTracks;



import com.example.core.mvp.CoreMvpPresenter;
import com.example.lastfmapp.data.tracks.ITracksRepository;
import com.example.lastfmapp.model.TrackEntity;

import java.util.ArrayList;
import java.util.List;

public class  TopTracksPresenter extends CoreMvpPresenter<ITopTracksContract.View>
        implements ITopTracksContract.Presenter {

    private ITracksRepository repository;

    public TopTracksPresenter(ITracksRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getTracks() {
        //TODO: Get tracks from Repository
        repository.getTracks(new ITracksRepository.TracksCallback() {
            @Override
            public void onSucces(List<TrackEntity> tracks) {
                if ( mView != null) {
                    mView.showTracks(tracks);
                }
            }

            @Override
            public void onFailure(String message) {
                if (mView != null) {
                    mView.showMessage(message);
                }
            }
        });
    }

    @Override
    public void onTrackClick(int position) {

    }

}
