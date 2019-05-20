package com.example.lastfmapp.data.tracks.local.RObjects;

import io.realm.RealmObject;

public class RTrackArtist extends RealmObject {

    private String name;
    private String mbid;
    private String url;

    public RTrackArtist() {
    }

    public RTrackArtist(String name, String mbid, String url) {
        this.name = name;
        this.mbid = mbid;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return name + " " + url;
    }

}
