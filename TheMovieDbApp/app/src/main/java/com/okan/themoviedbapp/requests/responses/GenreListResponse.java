package com.okan.themoviedbapp.requests.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.okan.themoviedbapp.models.genre.Genre;

import java.util.List;

public class GenreListResponse {

    @SerializedName("genres")
    @Expose
    private List<Genre> genreList;

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    @Override
    public String toString() {
        return "GenreListResponse{" +
                "genreList=" + genreList +
                '}';
    }
}
