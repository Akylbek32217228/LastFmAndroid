package com.example.lastfmapp.presentation.track;

import com.example.core.Logger;
import com.example.core.mvp.CoreMvpPresenter;
import com.example.lastfmapp.data.lyrics.ILyricsRepository;
import com.example.lastfmapp.data.tracks.ITracksRepository;
import com.example.lastfmapp.model.Track;

public class TrackPresenter extends CoreMvpPresenter<ITrackContract.View> implements ITrackContract.Presenter {

    private ITracksRepository repositoryTrack;
    private ILyricsRepository repositoryLyric;
    private String uniqueId;

    public TrackPresenter(ITracksRepository repositoryTrack, ILyricsRepository repositoryLyric, String uniqueId) {
        this.repositoryTrack = repositoryTrack;
        this.uniqueId = uniqueId;
        this.repositoryLyric = repositoryLyric;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        Logger.d("onViewCreatedTrackPresenter " + "      " + uniqueId);
        final Track track = repositoryTrack.getTrack(uniqueId);
        String lyric;

        if (mView != null && track != null) {
            mView.showTrack(track);
        }

        if ( track != null) {
            repositoryLyric.getLyrics(new ILyricsRepository.LyricsCallback() {
                @Override
                public void onSucces(String result) {
                    if ( mView != null) {
                        mView.showLyrics(result);
                        mView.setVisibility(false);
                    }
                }

                @Override
                public void onFailure(String message) {
                    Logger.d("errorrrrrrrrr!!!!!!!!!!!!!!!!!");
                    mView.setVisibility(false);
                }
            }, track.getArtist().getName(), track.getName());
        }
    }
}
