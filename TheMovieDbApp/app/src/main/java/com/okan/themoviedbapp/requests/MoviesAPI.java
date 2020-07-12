package com.okan.themoviedbapp.requests;

import com.okan.themoviedbapp.models.genre.Genre;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesAPI {

    // get genre list
    @GET("/genre/movie/list")
    Call<List<Genre>> getGenreList(
            @Query("apiKey") String apiKey
    );


}
