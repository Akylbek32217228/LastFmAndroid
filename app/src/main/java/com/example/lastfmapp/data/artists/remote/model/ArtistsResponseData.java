package com.example.lastfmapp.data.artists.remote.model;

import com.example.lastfmapp.model.Artist;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistsResponseData {
    @SerializedName("artist")
    List<Artist> data;

    public ArtistsResponseData(List<Artist> data) {
        this.data = data;
    }

    public List<Artist> getData() {
        return data;
    }

    public void setData(List<Artist> data) {
        this.data = data;
    }
}
