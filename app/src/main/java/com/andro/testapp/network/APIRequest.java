package com.andro.testapp.network;

import static com.andro.testapp.constants.AppConstants.API_KEY;

import com.andro.testapp.model.Article;
import com.andro.testapp.response.ArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIRequest {
    @GET("astronaut/")
    Call<Article> getHeadLines();

    @GET("astronaut/{astronautId}")
    Call<Article.Results> getDetails(@Path("astronautId")int astronautId);
}
