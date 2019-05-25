package com.example.lastfmapp.presentation.artist;

import com.example.core.mvp.CoreMvpPresenter;
import com.example.lastfmapp.data.tracks.ITracksRepository;
import com.example.lastfmapp.model.Track;

import java.util.List;

public class ArtistPresenter extends CoreMvpPresenter<IArtistContract.View> implements IArtistContract.Presenter{

    private ITracksRepository repository;
    private String name;

    public ArtistPresenter(ITracksRepository repository, String name) {
        this.repository = repository;
        this.name = name;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        if ( mView != null) {
            mView.showArtistName(name);
        }
        repository.getArtistTopTracks(name, new ITracksRepository.TracksCallback() {
            @Override
            public void onSucces(List<Track> result) {
                if (mView != null) {
                    mView.showArtistTopTracks(result);
                }
            }

            @Override
            public void onFailure(String message) {

            }
        });


    }
}
