package com.example.android.popularmovie;


import android.graphics.Movie;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment extends Fragment {


//    Button mBtnCoba;
    RecyclerView recycler;
    List<MovieModel> listMovie = new ArrayList<>();

    public PopularFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_popular, container, false);

        recycler = fragmentView.findViewById(R.id.recycler_view);

        // 0 Buat Layout Item
        // 1. Dataset
//        for (int i = 0; i < 20; i++) {
//            //* Pakai Constructor
//            MovieModel movie1 = new MovieModel("https://cdns.klimg.com/resized/644x/p/dilan1990-poster.JPG", "Dilan");
//            listMovie.add(movie1);
//
//
//            //* Pakai Setter
//            MovieModel movie2 = new MovieModel();
//            movie2.setPosterMovie("https://cdns.klimg.com/resized/644x/p/dilan1990-poster.JPG");
//            movie2.setJudulMovie("Dilan 2");
//            listMovie.add(movie2);
//        }

        ambilDataOnline();

        // 2. Adapter
        recycler.setAdapter(new MovieAdapter(getActivity(), listMovie));
        // 3. Layout Manager
        recycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
//        mBtnCoba = fragmentView.findViewById(R.id.btn_coba);
//
//        mBtnCoba.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "Hore", Toast.LENGTH_SHORT).show();
//            }
//        });
        return fragmentView;

        //1. harus buat variabel viewnya dulu
        //2. Context kalau di fragment pakai getActivity()

    }

    private void ambilDataOnline() {
        Call<ResponseModel> requestData = RetrofitConfig.getApiService().ambilDataPopularMovie();
        requestData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if(response.isSuccessful()){
                    listMovie = response.body().getResults();
                    recycler.setAdapter(new MovieAdapter(getActivity(), listMovie));
                } else {
                    Toast.makeText(getActivity(), "Response is not succesfull", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(getActivity(), "Response Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
