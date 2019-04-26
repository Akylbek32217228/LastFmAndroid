package com.example.lastfmapp.presentation.name.topTracks;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.lastfmapp.R;
import com.example.lastfmapp.model.TrackEntity;

import java.util.List;

public class TopTracksFragment extends Fragment implements ITopTracksContract.View{

    private ITopTracksContract.Presenter mPresenter;

    private static final String ARG_CATEGORY_ID = "category_id";

    public static TopTracksFragment newInstance() {

        TopTracksFragment fragment = new TopTracksFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_CATEGORY_ID, 1231);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getArguments().getInt(ARG_CATEGORY_ID);
        View v = inflater.inflate(R.layout.fragment_layout, container, false);
        TextView textView = v.findViewById(R.id.text_name);

        textView.setText("Top Tracks");
        return v;
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
    public void finisView() {
        getActivity().finish();
    }

    @Override
    public void attachPresenter(ITopTracksContract.Presenter presenter) {
        mPresenter = presenter;
    }
    //endregion
}
