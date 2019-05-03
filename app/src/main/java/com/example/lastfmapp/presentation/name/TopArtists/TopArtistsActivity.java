package com.example.lastfmapp.presentation.name.TopArtists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lastfmapp.App;
import com.example.lastfmapp.R;
import com.example.lastfmapp.model.ArtistEntity;

import java.util.List;

public class TopArtistsActivity extends AppCompatActivity{

    private ITopArtistsContract.Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TopArtistsFragment fragment = TopArtistsFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, fragment)
                .commit();

        mPresenter = new TopArtistsPresenter(App.artistsRepository);
        mPresenter.attachView(fragment);
        mPresenter.getArtist();
    }


}
