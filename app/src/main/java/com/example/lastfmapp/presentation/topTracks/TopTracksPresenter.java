package com.example.lastfmapp.presentation.topTracks;



import com.example.core.Logger;
import com.example.core.mvp.CoreMvpPresenter;
import com.example.lastfmapp.data.tracks.ITracksRepository;
import com.example.lastfmapp.model.Track;

import java.util.ArrayList;
import java.util.List;

public class TopTracksPresenter extends CoreMvpPresenter<ITopTracksContract.View>
        implements ITopTracksContract.Presenter {

    private ITracksRepository repository;
    private ArrayList<Track> mCache = new ArrayList<>();

    public TopTracksPresenter(ITracksRepository repository) {
        this.repository = repository;
    }

    private void setCache(List<Track> tracks) {
        mCache.clear();
        mCache.addAll(tracks);
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        Logger.d("lalalalalala");
        getTracks();
    }

    @Override
    public void getTracks() {
        if (mView != null) {
            mView.startRefresh();
        }

        repository.getTopTracks(new ITracksRepository.TracksCallback() {
            @Override
            public void onSucces(List<Track> tracks) {
                setCache(tracks);
                if ( mView != null) {
                    mView.showTracks(tracks);
                    mView.stopRefresh();
                }
            }

            @Override
            public void onFailure(String message) {
                if (mView != null) {
                    mView.showMessage(message);
                    mView.stopRefresh();
                }
            }
        });
    }

    @Override
    public void onTrackClick(int position) {
        if (mCache.size() > position && position >= 0) {
            if (mView != null) {
                mView.openTrackDetails(mCache.get(position));
            }
        }
    }

}
