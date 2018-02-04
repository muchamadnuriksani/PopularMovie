package com.example.android.popularmovie;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sani on 03/02/18.
 */

public interface ApiService {
    @GET("3/movie/popular?api_key=ff7c3ceb7089096b81cfd9bafae0d3b6&language=id-US&page=1")
    Call<ResponseModel> ambilDataPopularMovie();

//    @GET('3/movie/popular?api_key=ff7c3ceb7089096b81cfd9bafae0d3b6&language=en-US&page=1')
//    Call<ResponseModel> ambilDataTopRated();
//
//    @GET('3/movie/popular?api_key=ff7c3ceb7089096b81cfd9bafae0d3b6&language=en-US&page=1')
//    Call<ResponseModel> ambilDataFavorite();
}
