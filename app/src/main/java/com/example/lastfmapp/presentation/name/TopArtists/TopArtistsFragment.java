package com.example.lastfmapp.presentation.name.TopArtists;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lastfmapp.R;
import com.example.lastfmapp.model.ArtistEntity;

import java.util.List;

public class TopArtistsFragment extends Fragment implements ITopArtistsContract.View{



    public static TopArtistsFragment newInstance() {

        TopArtistsFragment fragment = new TopArtistsFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_layout, container, false);
        TextView textView = v.findViewById(R.id.text_name);
        textView.setText("Top Artists");

        return v;
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
    public void attachPresenter(ITopArtistsContract.Presenter presenter) {

    }
}
