package com.example.android.popularmovie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sani on 03/02/18.
 */

public class MovieModel {
    @SerializedName("poster_path")
    @Expose
    String posterMovie;

    @SerializedName("title")
    @Expose
    String judulMovie;

    // 1. Constructor
    // 2. Setter & Getter


    public MovieModel(String posterMovie, String judulMovie) {
        this.posterMovie = posterMovie;
        this.judulMovie = judulMovie;
    }

    public MovieModel() {

    }

    public String getPosterMovie() {
        return posterMovie;
    }

    public void setPosterMovie(String posterMovie) {
        this.posterMovie = posterMovie;
    }

    public String getJudulMovie() {
        return judulMovie;
    }

    public void setJudulMovie(String judulMovie) {
        this.judulMovie = judulMovie;
    }
}
