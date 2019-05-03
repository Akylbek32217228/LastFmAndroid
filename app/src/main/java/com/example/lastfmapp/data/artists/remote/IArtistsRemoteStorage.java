package com.example.lastfmapp.data.artists.remote;

import com.example.lastfmapp.data.artists.IArtistsRepository;

public interface IArtistsRemoteStorage {

    void getArtists(IArtistsRepository.ArtistsCallback callback);
}
