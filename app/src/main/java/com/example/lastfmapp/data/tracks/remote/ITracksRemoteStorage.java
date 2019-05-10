package com.example.lastfmapp.data.tracks.remote;

import com.example.lastfmapp.data.tracks.ITracksRepository;
import com.example.lastfmapp.model.TrackEntity;

public interface ITracksRemoteStorage {
    void getTracks(ITracksRepository.TracksCallback callback);

}
