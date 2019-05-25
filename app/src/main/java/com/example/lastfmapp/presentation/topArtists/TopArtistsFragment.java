package com.example.lastfmapp.presentation.topArtists;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.core.Logger;
import com.example.core.mvp.CoreMvpFragment;
import com.example.lastfmapp.R;
import com.example.lastfmapp.model.Artist;
import com.example.lastfmapp.presentation.topArtists.recycler.TopArtistsAdapter;

import java.util.ArrayList;
import java.util.List;

public class TopArtistsFragment extends CoreMvpFragment<ITopArtistsContract.Presenter>
        implements ITopArtistsContract.View{

    TextView textView;
    ArrayList<Artist> listArtist;
    TopArtistsAdapter adapter;


    public static TopArtistsFragment newInstance() {

        TopArtistsFragment fragment = new TopArtistsFragment();

        return fragment;
    }

    @Override
    protected void initView(View view) {
        //TODO: init
        RecyclerView recyclerView = getActivity().findViewById(R.id.top_artists_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TopArtistsAdapter(new ArrayList<Artist>());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void showArtists(List<Artist> artists) {
        Logger.d(artists.size() + "SIZEEARTIST");
        adapter.setArtists(artists);
    }

    @Override
    public void openArtist(Artist artist) {

    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_top_artists;
    }
}
