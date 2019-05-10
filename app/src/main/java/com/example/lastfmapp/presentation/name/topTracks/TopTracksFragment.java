package com.example.lastfmapp.presentation.name.topTracks;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.example.core.Logger;
import com.example.core.mvp.CoreMvpFragment;
import com.example.lastfmapp.R;
import com.example.lastfmapp.model.ArtistEntity;
import com.example.lastfmapp.model.TrackEntity;
import com.example.lastfmapp.model.TrackImage;
import com.example.lastfmapp.presentation.name.topTracks.recycler.TopTracksAdapter;
import com.example.lastfmapp.presentation.name.topTracks.recycler.TopTracksViewHolder;

import java.util.ArrayList;
import java.util.List;

public class TopTracksFragment extends CoreMvpFragment<ITopTracksContract.Presenter>
        implements ITopTracksContract.View{

    TopTracksAdapter adapter;
    TopTracksViewHolder viewHolder;
    ArrayList<TrackEntity> list;


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
    public void showTracks(List<TrackEntity> tracks) {
        Logger.d("showTracks");
        Logger.d(tracks.size() + "");
        for (TrackEntity track : tracks) {
            Logger.d(track.toString());
        }
        adapter.setTracks(tracks);
    }

    @Override
    public void openTrack(TrackEntity track) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_top_tracks;
    }

    @Override
    protected void initView(View view) {
        //TODO: Init
        Logger.d("initView");
        RecyclerView recyclerView = getActivity().findViewById(R.id.top_tracks_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TopTracksAdapter(new ArrayList<TrackEntity>());
        Logger.d("dfdf");
        recyclerView.setAdapter(adapter);
        Logger.d("dfdffddfdfdfdfdfdf");
    }
    //endregion
}
