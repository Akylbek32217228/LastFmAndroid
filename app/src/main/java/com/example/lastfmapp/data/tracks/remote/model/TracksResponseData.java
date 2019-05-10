package com.example.lastfmapp.data.tracks.remote.model;


import com.example.lastfmapp.model.TrackEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TracksResponseData {
    @SerializedName("track")
    private List<TrackEntity> data;

    //TODO: Add attributes

    public TracksResponseData(List<TrackEntity> data) {
        this.data = data;
    }

    public List<TrackEntity> getData() {
        return data;
    }

    public void setData(List<TrackEntity> data) {
        this.data = data;
    }
}
