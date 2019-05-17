package com.example.lastfmapp.presentation.artist;

import com.example.core.mvp.CoreMvpPresenter;
import com.example.lastfmapp.data.artists.IArtistsRepository;

public class ArtistPresenter extends CoreMvpPresenter<IArtistContract.View> implements IArtistContract.Presenter{

    private IArtistsRepository repository;

    public ArtistPresenter(IArtistsRepository repository) {
        this.repository = repository;
    }
}
