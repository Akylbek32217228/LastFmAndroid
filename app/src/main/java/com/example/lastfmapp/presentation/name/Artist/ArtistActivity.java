package com.example.lastfmapp.presentation.name.Artist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.core.mvp.CoreMvpActivity;
import com.example.lastfmapp.App;
import com.example.lastfmapp.R;


public class ArtistActivity extends CoreMvpActivity<IArtistContract.Presenter> implements IArtistContract.View {

    private IArtistContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        mPresenter = new ArtistPresenter(App.artistsRepository);
        mPresenter.attachView(this);
    }





}
