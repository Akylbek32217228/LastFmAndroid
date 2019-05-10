package com.example.lastfmapp.presentation.name.TopArtists;

import com.example.core.mvp.CoreMvpPresenter;
import com.example.lastfmapp.data.artists.IArtistsRepository;
import com.example.lastfmapp.model.ArtistEntity;

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
            public void onSucces(List<ArtistEntity> artists) {
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

        /*ArrayList<ArtistEntity> list = new ArrayList<>();

        list.add(new ArtistEntity(1, "name", "image"));
        list.add(new ArtistEntity(2, "name", "image"));
        list.add(new ArtistEntity(3, "name", "image"));
        list.add(new ArtistEntity(4, "name", "image"));
        list.add(new ArtistEntity(5, "name", "image"));
        list.add(new ArtistEntity(6, "name", "image"));

        if ( mView != null) {
            mView.showArtists(list);
        }*/
    }

    @Override
    public void onArtistClick(int pos) {

    }
}
