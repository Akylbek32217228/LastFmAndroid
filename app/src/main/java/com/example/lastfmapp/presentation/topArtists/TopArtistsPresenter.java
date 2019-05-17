package com.example.lastfmapp.presentation.topArtists;

import com.example.core.mvp.CoreMvpPresenter;
import com.example.lastfmapp.data.artists.IArtistsRepository;
import com.example.lastfmapp.model.Artist;

import java.util.List;

public class TopArtistsPresenter extends CoreMvpPresenter<ITopArtistsContract.View>
        implements ITopArtistsContract.Presenter{

    private IArtistsRepository repository;

    public TopArtistsPresenter(IArtistsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getArtist() {

        repository.getArtists(new IArtistsRepository.ArtistsCallback() {
            @Override
            public void onSucces(List<Artist> artists) {
                if ( mView != null) {
                    mView.showArtists(artists);
                }
            }

            @Override
            public void onFailure(String message) {
                if ( mView != null) {
                    mView.showMessage(message);
                }
            }
        });
    }

    @Override
    public void onArtistClick(int pos) {

    }
}
