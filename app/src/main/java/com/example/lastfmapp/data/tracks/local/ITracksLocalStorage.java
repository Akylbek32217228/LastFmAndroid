package com.example.lastfmapp.data.tracks.local;

import com.example.lastfmapp.data.tracks.ITracksRepository;
import com.example.lastfmapp.model.Track;

import java.util.List;

public interface ITracksLocalStorage {
    void getTracks(ITracksRepository.TracksCallback callback);

    void setTracks(List<Track> tracks);

    Track getTrack(String uniqueId);

    void setTrack(Track track);

    void getArtistTracks(String artistName, ITracksRepository.TracksCallback callback);
}
