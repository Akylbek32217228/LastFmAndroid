package com.example.lastfmapp.presentation.name.Track;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.core.mvp.CoreMvpActivity;
import com.example.core.mvp.CoreMvpPresenter;
import com.example.core.mvp.ICoreMvpContract;
import com.example.lastfmapp.App;
import com.example.lastfmapp.R;

public class TrackActivity extends CoreMvpActivity<ITrackContract.Presenter> implements ITrackContract.View{

    private ITrackContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        presenter = new TrackPresenter(App.tracksRepository);
        presenter.attachView(this);
    }
}
