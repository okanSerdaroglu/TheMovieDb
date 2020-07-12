package com.okan.themoviedbapp.requests;


import androidx.lifecycle.MutableLiveData;

import com.okan.themoviedbapp.BuildConfig;
import com.okan.themoviedbapp.models.genre.Genre;
import com.okan.themoviedbapp.requests.responses.GenreListResponse;
import com.okan.themoviedbapp.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MoviesApiClient {

    private static MoviesApiClient instance;
    private MutableLiveData<List<Genre>> genreList;
    private GetGenreListRunnable getGenreListRunnable;
    private static final String TAG = "MoviesApiClient";

    public static MoviesApiClient getInstance() {
        if (instance == null) {
            instance = new MoviesApiClient();
        }
        return instance;
    }

    public void searchGenreList() {
        if (getGenreListRunnable != null) {
            getGenreListRunnable = null;
        }
        getGenreListRunnable = new GetGenreListRunnable();

    }

    private class GetGenreListRunnable implements Runnable {

        @Override
        public void run() {
            try {
                Response response = getGenres().execute();
                if (response.code() == Constants.RESULT_OK) {

                }

            } catch (Exception e) {

            }

        }

        private Call<GenreListResponse> getGenres() {
            return ServiceGenerator.getMoviesAPI().getGenreList(BuildConfig.API_KEY);
        }
    }


}
