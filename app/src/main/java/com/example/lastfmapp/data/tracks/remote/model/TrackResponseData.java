package com.example.lastfmapp.data.tracks.remote.model;

import com.example.lastfmapp.model.Track;
import com.google.gson.annotations.SerializedName;

public class TrackResponseData {
    @SerializedName("track")
    Track track;


    public TrackResponseData(Track track) {
        this.track = track;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
