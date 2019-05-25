package com.example.lastfmapp.data.lyrics.remote;

import com.example.lastfmapp.data.lyrics.ILyricsRepository;
import com.example.lastfmapp.data.lyrics.remote.model.LyricsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class LyricsRemoteStorage implements ILyricsRemoteStorage {

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.lyrics.ovh")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static LyricsNetworkClient client = retrofit.create(LyricsNetworkClient.class);

    @Override
    public void getLyrics( String artist, String track, final ILyricsRepository.LyricsCallback callback) {
        Call<LyricsResponse> call = client.getLyric(artist, track);

        call.enqueue(new Callback<LyricsResponse>() {
            @Override
            public void onResponse(Call<LyricsResponse> call, Response<LyricsResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSucces(response.body().getLyrics());
                    } else {
                        callback.onFailure("Body is empty " + response.code());
                    }
                } else {
                    callback.onFailure("Request failed " + response.code());
                }
            }

            @Override
            public void onFailure(Call<LyricsResponse> call, Throwable t) {
                callback.onFailure("Lyrics failure: " + t.getMessage());
            }
        });
    }


    private interface LyricsNetworkClient {

        @GET("/v1/{artist}/{track}")
        Call<LyricsResponse> getLyric(@Path("artist") String artist, @Path("track") String track);

    }

}
