package com.okan.themoviedbapp.requests;

import com.okan.themoviedbapp.requests.responses.GenreListResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesAPI {

    // get genre list
    @GET("/genre/movie/list")
    Call<GenreListResponse> getGenreList(
            @Query("apiKey") String apiKey
    );


}
