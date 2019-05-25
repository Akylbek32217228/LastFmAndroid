package com.example.lastfmapp.data.tracks.remote.model;

import com.google.gson.annotations.SerializedName;

public class TopTracksResponse {

    @SerializedName("toptracks")
    private TracksResponseData tracks;

    public TopTracksResponse(TracksResponseData tracks) {
        this.tracks = tracks;
    }

    public TracksResponseData getTracks() {
        return tracks;
    }

    public void setTracks(TracksResponseData tracks) {
        this.tracks = tracks;
    }
}
