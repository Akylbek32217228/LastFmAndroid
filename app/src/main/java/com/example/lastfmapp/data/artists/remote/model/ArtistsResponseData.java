package com.example.lastfmapp.data.artists.remote.model;

import com.example.lastfmapp.model.ArtistEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistsResponseData {
    @SerializedName("artist")
    List<ArtistEntity> data;

    public ArtistsResponseData(List<ArtistEntity> data) {
        this.data = data;
    }

    public List<ArtistEntity> getData() {
        return data;
    }

    public void setData(List<ArtistEntity> data) {
        this.data = data;
    }
}
