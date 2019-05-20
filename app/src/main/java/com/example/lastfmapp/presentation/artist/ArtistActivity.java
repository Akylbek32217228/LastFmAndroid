package com.example.lastfmapp.presentation.artist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.core.mvp.CoreMvpActivity;
import com.example.lastfmapp.App;
import com.example.lastfmapp.R;
import com.example.lastfmapp.model.Track;
import com.example.lastfmapp.presentation.artist.recycler.ArtistAdapter;
import com.example.lastfmapp.presentation.artist.recycler.ArtistViewHolder;

import java.util.ArrayList;
import java.util.List;


public class ArtistActivity extends CoreMvpActivity<IArtistContract.Presenter> implements IArtistContract.View,
ArtistViewHolder.ArtistListener{

    private static final String EXTRA_ACTIVTY_UNIQUE_ID = "unique_id";
    private TextView artistName;
    ArtistAdapter adapter;

    @Override
    protected IArtistContract.Presenter providePresenter() {
        return new ArtistPresenter(App.tracksRepository, getArtistName(getIntent()));
    }

    public static void start(Activity activity, String name) {
        Intent intent = new Intent(activity, ArtistActivity.class);
        intent.putExtra(EXTRA_ACTIVTY_UNIQUE_ID, name);
        activity.startActivity(intent);
    }

    private static String getArtistName(Intent intent) {
        return intent.getStringExtra(EXTRA_ACTIVTY_UNIQUE_ID);
    }

    @Override
    protected void initView() {
        RecyclerView recyclerView = findViewById(R.id.activity_artist_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        adapter = new ArtistAdapter(new ArrayList<Track>(), this);
        recyclerView.setAdapter(adapter);
        artistName = findViewById(R.id.activity_artist_name);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_artist;
    }


    @Override
    public void showArtist(List<Track> tracks) {
        artistName.setText(tracks.get(0).getArtist().getName());
        adapter.setArtistTracks(tracks);
    }

    @Override
    public void onTrackClick(int pos) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
