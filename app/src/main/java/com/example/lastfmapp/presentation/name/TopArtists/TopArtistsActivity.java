package com.example.lastfmapp.presentation.name.TopArtists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lastfmapp.R;
import com.example.lastfmapp.model.ArtistEntity;
import com.example.lastfmapp.presentation.name.BaseInterface.BaseInterface;

import java.util.List;

public class TopArtistsActivity extends AppCompatActivity implements TopArtistsContract.View {

    private TopArtistsContract.Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_artists);

        mPresenter = new TopArtistsPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void showArtists(List<ArtistEntity> artists) {

    }

    @Override
    public void openArtist(ArtistEntity artist) {

    }

    @Override
    public void showMessage(String Message) {

    }


    @Override
    public void finishView() {

    }

    @Override
    public void attachPresenter(BaseInterface.Presenter presenter) {

    }
}
