package com.example.lastfmapp.presentation.name.topTracks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.core.Logger;
import com.example.lastfmapp.App;

public class TopTracksActivity extends AppCompatActivity {

    private ITopTracksContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d("TopTracksActivity");
        TopTracksFragment fragment = TopTracksFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, fragment)
                .commit();

        mPresenter = new TopTracksPresenter(App.tracksRepository);
        mPresenter.attachView(fragment);
        mPresenter.getTracks();
    }


}
