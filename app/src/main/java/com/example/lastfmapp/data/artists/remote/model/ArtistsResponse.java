package com.example.lastfmapp.data.artists.remote.model;

import com.google.gson.annotations.SerializedName;

public class ArtistsResponse {
    @SerializedName("artists")
    private ArtistsResponseData artists;

    public ArtistsResponse(ArtistsResponseData artists) {
        this.artists = artists;
    }

    public ArtistsResponseData getArtists() {
        return artists;
    }

    public void setArtists(ArtistsResponseData artists) {
        this.artists = artists;
    }
}
