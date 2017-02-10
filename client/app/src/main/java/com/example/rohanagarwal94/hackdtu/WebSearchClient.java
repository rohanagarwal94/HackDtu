package com.example.rohanagarwal94.hackdtu;


import com.example.rohanagarwal94.hackdtu.model.WebSearch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mayank on 12-12-2016.
 */

public interface WebSearchClient {

    @GET("/?&format=json&pretty=1")
    Call<WebSearch> getresult(@Query("q") String query);

}
