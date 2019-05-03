package com.example.lastfmapp.presentation.name.topTracks;

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
import com.example.lastfmapp.model.TrackEntity;

import java.util.List;

public class TopTracksFragment extends CoreMvpFragment<ITopTracksContract.Presenter>
        implements ITopTracksContract.View{



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

    }

    @Override
    public void openTrack(TrackEntity track) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_layout;
    }

    @Override
    protected void initView(View view) {
        //TODO: Init
    }
    //endregion
}
