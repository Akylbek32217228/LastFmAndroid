package com.example.lastfmapp.data.tracks.remote;

import com.example.lastfmapp.data.tracks.ITracksRepository;

public interface ITracksRemotes {
    void getTracks(ITracksRepository.TracksCallback callback);
}
