package com.okan.themoviedbapp.requests;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.okan.themoviedbapp.AppExecutors;
import com.okan.themoviedbapp.BuildConfig;
import com.okan.themoviedbapp.models.genre.Genre;
import com.okan.themoviedbapp.requests.responses.GenreListResponse;
import com.okan.themoviedbapp.utils.Constants;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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

        final Future handler = AppExecutors.getInstance().networkIO().submit(getGenreListRunnable);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            // let the user know its time out
            handler.cancel(true);

        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);


    }

    private static class GetGenreListRunnable implements Runnable {

        @Override
        public void run() {
            try {
                Response response = getGenres().execute();
                Log.d(TAG,String.valueOf(response.code()));
                if (response.code() == Constants.RESULT_OK) {
                    Log.d(TAG, response.toString());
                }

            } catch (Exception ignored) {

            }

        }

        private Call<GenreListResponse> getGenres() {
            return ServiceGenerator.getMoviesAPI().getGenreList(BuildConfig.API_KEY);
        }
    }


}
