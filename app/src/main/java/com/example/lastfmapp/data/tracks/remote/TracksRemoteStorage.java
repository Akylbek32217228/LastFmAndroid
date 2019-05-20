package com.example.lastfmapp.data.tracks.remote;

import android.util.Log;

import com.example.core.Logger;
import com.example.lastfmapp.BuildConfig;
import com.example.lastfmapp.data.tracks.ITracksRepository;
import com.example.lastfmapp.data.tracks.remote.model.TracksResponse;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class TracksRemoteStorage implements ITracksRemoteStorage {
    private final static String BASE_URL = BuildConfig.BASE_URL;
    private final static String API_KEY = BuildConfig.API_KEY;

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static TracksNetworkClient client = retrofit.create(TracksNetworkClient.class);

    @Override
    public void getTracks(final ITracksRepository.TracksCallback callback) {
        Logger.d("getTracksTrackRemoteStorage");
        Call<TracksResponse> call = client.getTracks(
                "chart.getTopTracks",
                API_KEY,
                "json",
                1,
                100
        );

        call.enqueue(new Callback<TracksResponse>() {
            @Override
            public void onResponse(Call<TracksResponse> call, Response<TracksResponse> response) {
                Logger.d("1234");
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSucces(response.body().getTracks().getData());
                    } else {
                        callback.onFailure("Body is empty " + response.code());
                    }
                } else {
                    callback.onFailure("Request failed " + response.code());
                }
            }

            @Override
            public void onFailure(Call<TracksResponse> call, Throwable t) {
                Logger.d("987");
                callback.onFailure("Top tracks failure: " + t.getMessage());
            }
        });
    }


    private interface TracksNetworkClient {

        @GET("/2.0/")
        Call<TracksResponse> getTracks(
                @Query("method") String method,
                @Query("api_key") String apiKey,
                @Query("format") String format,
                @Query("page") int page,
                @Query("limit") int limit
        );
    }
}
