package com.example.lastfmapp.presentation.name.TopArtists;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.core.mvp.CoreMvpFragment;
import com.example.lastfmapp.R;
import com.example.lastfmapp.model.ArtistEntity;

import java.util.List;

public class TopArtistsFragment extends CoreMvpFragment<ITopArtistsContract.Presenter>
        implements ITopArtistsContract.View{



    public static TopArtistsFragment newInstance() {

        TopArtistsFragment fragment = new TopArtistsFragment();

        return fragment;
    }

    @Override
    protected void initView(View view) {
        //TODO: init
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
    public void finisView() {
        getActivity().finish();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_layout;
    }
}
