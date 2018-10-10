package com.example.retrofit2test;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    static final String DOMAIN_URL = "http://www.dogfriends.site/";

    @GET("/temp")
    Call<ResponseBody> getComment(@Query("temp") String temp);

}
