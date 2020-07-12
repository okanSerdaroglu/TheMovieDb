package com.okan.themoviedbapp.requests;

import com.okan.themoviedbapp.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder().
            baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static MoviesAPI moviesAPI = retrofit.create(MoviesAPI.class);

    public static MoviesAPI getMoviesAPI() {
        return moviesAPI;
    }

}
