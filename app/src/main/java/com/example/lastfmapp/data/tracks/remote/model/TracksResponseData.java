package com.example.lastfmapp.data.tracks.remote.model;


import com.example.lastfmapp.model.Track;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TracksResponseData {
    @SerializedName("track")
    private List<Track> data;

    //TODO: Add attributes

    public TracksResponseData(List<Track> data) {
        this.data = data;
    }

    public List<Track> getData() {
        return data;
    }

    public void setData(List<Track> data) {
        this.data = data;
    }
}
