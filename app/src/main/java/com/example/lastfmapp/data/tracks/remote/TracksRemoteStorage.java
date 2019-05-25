package com.example.lastfmapp.data.tracks.remote;


import com.example.lastfmapp.BuildConfig;
import com.example.lastfmapp.data.tracks.ITracksRepository;
import com.example.lastfmapp.data.tracks.remote.model.TopTracksResponse;
import com.example.lastfmapp.data.tracks.remote.model.TrackResponseData;
import com.example.lastfmapp.data.tracks.remote.model.TracksResponse;
import com.example.lastfmapp.data.tracks.remote.model.TracksResponseData;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class  TracksRemoteStorage implements ITracksRemoteStorage {
    private final static String BASE_URL = BuildConfig.BASE_URL;
    private final static String API_KEY = BuildConfig.API_KEY;

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static TracksNetworkClient client = retrofit.create(TracksNetworkClient.class);

    @Override
    public void getTracks(final ITracksRepository.TracksCallback callback) {
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
                callback.onFailure("Tracks failure: " + t.getMessage());
            }
        });
    }

    @Override
    public void getArtistTopTracks(String artistName, final ITracksRepository.TracksCallback callback) {
        Call<TopTracksResponse> call = client.getTopTracks(
                "artist.gettoptracks",
                artistName,
                API_KEY,
                "json"
        );

        call.enqueue(new Callback<TopTracksResponse>() {
            @Override
            public void onResponse(Call<TopTracksResponse> call, Response<TopTracksResponse> response) {
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
            public void onFailure(Call<TopTracksResponse> call, Throwable t) {
                callback.onFailure("Top Tracks failure: " + t.getMessage());
            }
        });
    }

    @Override
    public void getTrack(String artistName, String trackName, final ITracksRepository.TrackCallback callback) {
        Call<TrackResponseData> call = client.getTrack(
                "track.getInfo",
                API_KEY,
                artistName,
                trackName,
                "json"
        );

        call.enqueue(new Callback<TrackResponseData>() {
            @Override
            public void onResponse(Call<TrackResponseData> call, Response<TrackResponseData> response) {
                if ( response.isSuccessful()) {
                    if ( response.body() != null) {
                        callback.onSucces(response.body().getTrack());
                    } else {
                        callback.onFailure("Body is empty " + response.code());
                    }
                } else {
                    callback.onFailure("Request failed " + response.code());
                }

            }

            @Override
            public void onFailure(Call<TrackResponseData> call, Throwable t) {
                callback.onFailure("Track failure: " + t.getMessage());
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
        @GET("/2.0/")
        Call<TopTracksResponse> getTopTracks(
                @Query("method") String method,
                @Query("artist") String artist,
                @Query("api_key") String apiKey,
                @Query("format") String format
        );
        @GET("/2.0/")
        Call<TrackResponseData> getTrack(
                @Query("method") String method,
                @Query("api_key") String apiKey,
                @Query("artist") String artist,
                @Query("track") String track,
                @Query("format") String format
                );
    }
}
