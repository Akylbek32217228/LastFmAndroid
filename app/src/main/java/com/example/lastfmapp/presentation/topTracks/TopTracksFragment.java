package com.example.lastfmapp.presentation.topTracks;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.example.core.Logger;
import com.example.core.mvp.CoreMvpFragment;
import com.example.lastfmapp.R;
import com.example.lastfmapp.model.Artist;
import com.example.lastfmapp.model.Track;
import com.example.lastfmapp.presentation.artist.ArtistActivity;
import com.example.lastfmapp.presentation.topTracks.recycler.TopTracksAdapter;
import com.example.lastfmapp.presentation.topTracks.recycler.TopTracksViewHolder;
import com.example.lastfmapp.presentation.track.TrackActivity;

import java.util.ArrayList;
import java.util.List;

public class TopTracksFragment extends CoreMvpFragment<ITopTracksContract.Presenter>
        implements ITopTracksContract.View, TopTracksViewHolder.TopTrackListener {

    TopTracksAdapter adapter;
    SwipeRefreshLayout mRefresh;

    private static final String ARG_CATEGORY_ID = "category_id";

    public static TopTracksFragment newInstance() {

        TopTracksFragment fragment = new TopTracksFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_CATEGORY_ID, 1231);
        fragment.setArguments(bundle);

        return fragment;
    }


    //region Contract
    @Override
    public void showTracks(List<Track> tracks) {
        for (Track track : tracks) {
            Logger.d(track.toString());
        }
        adapter.setTracks(tracks);
    }

    @Override
    public void openTrackDetails(Track track) {
        if ( getActivity() != null) {
            TrackActivity.start(getActivity(), track.getUniqueId(), track.getArtist().getName(),
                    track.getName());
        }
    }

    @Override
    public void openArtistDetails(Artist artist) {
        if ( getActivity() != null) {
            ArtistActivity.start(getActivity(), artist.getName());
        }
    }

    @Override
    public void startRefresh() {
        if ( mRefresh != null) {
            mRefresh.setRefreshing(true);
        }
    }

    @Override
    public void stopRefresh() {
        if ( mRefresh != null) {
            mRefresh.setRefreshing(false);
        }
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_top_tracks;
    }

    @Override
    protected void initView(View view) {
        RecyclerView recyclerView = getActivity().findViewById(R.id.top_tracks_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TopTracksAdapter(this, new ArrayList<Track>());
        recyclerView.setAdapter(adapter);
        mRefresh = view.findViewById(R.id.fragment_refresh);
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshTracks();
            }
        });
    }

    private void refreshTracks() {
        if ( presenter != null) {
            presenter.getTracks();
        }
    }


    @Override
    public void onTrackClick(int pos) {
        if ( presenter != null) {
            presenter.onTrackClick(pos);
        }
    }

    @Override
    public void onArtistClick(int pos) {
        if ( presenter != null) {
            presenter.onArtistClick(pos);
        }
    }
    //endregion
}
