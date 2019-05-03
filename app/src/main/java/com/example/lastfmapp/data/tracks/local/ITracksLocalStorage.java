package com.example.lastfmapp.data.tracks.local;

import com.example.lastfmapp.data.tracks.ITracksRepository;
import com.example.lastfmapp.model.TrackEntity;

import java.util.List;

public interface ITracksLocalStorage {
    void getTracks(ITracksRepository.TracksCallback callback);

    void setTracks(List<TrackEntity> tracks);
}
