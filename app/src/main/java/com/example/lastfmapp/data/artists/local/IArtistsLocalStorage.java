package com.example.lastfmapp.data.artists.local;

import com.example.lastfmapp.data.artists.IArtistsRepository;
import com.example.lastfmapp.model.ArtistEntity;

import java.util.List;

public interface IArtistsLocalStorage {

    void getArtists(IArtistsRepository.ArtistsCallback callback);

    void setArtists(List<ArtistEntity> artists);

}
