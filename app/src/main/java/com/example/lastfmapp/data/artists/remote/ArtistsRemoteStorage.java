package com.example.lastfmapp.data.artists.remote;

import com.example.core.Logger;
import com.example.lastfmapp.data.artists.IArtistsRepository;
import com.example.lastfmapp.data.artists.remote.model.ArtistsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ArtistsRemoteStorage implements IArtistsRemoteStorage {
    private final static String BASE_URL = "http://ws.audioscrobbler.com";
    private final static String API_KEY = "f4cd93850ae865628f18f6d2af27c3c4";

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ArtistsNetworkClient client = retrofit.create(ArtistsNetworkClient.class);

    @Override
    public void getArtists(final IArtistsRepository.ArtistsCallback callback) {
        Call<ArtistsResponse> call = client.getArtists(
                "chart.getTopArtists",
                API_KEY,
                "json",
                1,
                100
        );

        call.enqueue(new Callback<ArtistsResponse>() {
            @Override
            public void onResponse(Call<ArtistsResponse> call, Response<ArtistsResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Logger.d(response.body().getArtists().getData().size() + "SIZEEEEEE");
                        callback.onSucces(response.body().getArtists().getData());
                    } else {
                        callback.onFailure("Body is empty " + response.code());
                    }
                } else {
                    callback.onFailure("Request failed " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ArtistsResponse> call, Throwable t) {

            }
        });
    }


    private interface ArtistsNetworkClient {

        @GET("/2.0/")
        Call<ArtistsResponse> getArtists(
                @Query("method") String method,
                @Query("api_key") String apiKey,
                @Query("format") String format,
                @Query("page") int page,
                @Query("limit") int limit
        );
    }

}
