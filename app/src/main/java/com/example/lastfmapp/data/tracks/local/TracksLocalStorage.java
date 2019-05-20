package com.example.lastfmapp.data.tracks.local;

import com.example.core.Logger;
import com.example.core.realm.CoreRealmDataSourse;
import com.example.lastfmapp.data.tracks.ITracksRepository;
import com.example.lastfmapp.data.tracks.local.RObjects.RTrack;
import com.example.lastfmapp.data.tracks.local.RObjects.RTrackArtist;
import com.example.lastfmapp.model.Track;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class TracksLocalStorage extends CoreRealmDataSourse implements ITracksLocalStorage {

    ArrayList<Track> tracks = new ArrayList<>();

    public void getArtistTracks(String artistName, ITracksRepository.TracksCallback callback) {
        Realm realm = null;

        try {
            realm = getRealmInStance();

            RealmResults<RTrack> results = realm.where(RTrack.class).contains("uniqueId", artistName).findAll();
            callback.onSucces(TracksMapper.toTracks(realm.copyFromRealm(results)));

            //TODO: Search tracks by artistName
        } catch (Exception e) {
            Logger.e(e);
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }


    @Override
    public void getTracks(ITracksRepository.TracksCallback callback) {
        Realm realm = null;

        try {
            realm = getRealmInStance();

            RealmResults<RTrack> results = realm.where(RTrack.class).findAll();

            callback.onSucces(
                    TracksMapper.toTracks(realm.copyFromRealm(results))
            );
        } catch (Exception e) {
            Logger.e(e);
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    @Override
    public void setTracks(List<Track> tracks) {
        //this.tracks.addAll(tracks);
        Logger.d("     " + "setTrack from database      ");
        final List<RTrack> rTracks = TracksMapper.toRTracks(tracks);
        executeTransanction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (RTrack rTrack : rTracks) {

                    RTrack managedTrack = realm.where(RTrack.class)
                            .equalTo("uniqueId", rTrack.getUniqueId())
                            .findFirst();

                    if (managedTrack == null) {
                        realm.copyToRealm(rTrack);
                    } else {
                        managedTrack.setListeners(rTrack.getListeners());
                        managedTrack.setPlaycount(rTrack.getPlaycount());
                    }
                }

                //managedTrack.getImages().deleteAllFromRealm();
                //managedTrack.deleteFromRealm();
            }
        });

    }

    @Override
    public Track getTrack(String uniqueId) {
        Realm realm = null;
        Track track = null;
        RTrack rTrack;
        Logger.d("getTrackTracksLocalStorage");

        try {
            realm = getRealmInStance();
            rTrack = realm.where(RTrack.class).equalTo("uniqueId", uniqueId).findFirst();
            if ( rTrack != null) {
                track = TracksMapper.toTrack(realm.copyFromRealm(rTrack));
            } else {
                Logger.d("nullllllllll");
            }
        } catch (Exception e) {
            Logger.e(e);
        } finally {
            if (realm != null) {
                realm.close();
            }
        }

        /*for ( int i =0; i < tracks.size(); ++i) {
            if ( tracks.get(i).getUniqueId().equals(uniqueId)) {
                track = tracks.get(i);
            }
        }*/

        return track;
    }

    @Override
    public void setTrack(Track track) {

    }
}
