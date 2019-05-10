package com.example.lastfmapp.data.tracks.local;

import com.example.lastfmapp.data.tracks.ITracksRepository;
import com.example.lastfmapp.model.TrackEntity;

import java.util.ArrayList;
import java.util.List;

public class TracksLocalStorage implements ITracksLocalStorage {

    private ArrayList<TrackEntity> list;

    @Override
    public void getTracks(ITracksRepository.TracksCallback callback) {
        //TODO: Fetch from database
    }

    @Override
    public void setTracks(List<TrackEntity> tracks) {
        //TODO: Save to DB
        list.addAll(tracks);
    }

    @Override
    public void getTrack(ITracksRepository.TrackCallback callback) {


    }

    @Override
    public void setTrack(TrackEntity track) {

    }
}
