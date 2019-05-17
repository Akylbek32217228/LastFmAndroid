package com.example.lastfmapp.data.tracks.remote;

import com.example.lastfmapp.data.tracks.ITracksRepository;

public interface ITracksRemoteStorage {
    void getTracks(ITracksRepository.TracksCallback callback);

}
