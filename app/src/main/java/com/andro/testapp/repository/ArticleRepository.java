package com.andro.testapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.andro.testapp.model.Article;
import com.andro.testapp.network.APIRequest;
import com.andro.testapp.network.RetrofitRequest;
import com.andro.testapp.response.ArticleResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {
    public static final String TAG = ArticleRepository.class.getSimpleName();
    private final APIRequest apiRequest;

    public ArticleRepository() {
        this.apiRequest = RetrofitRequest.getRetrofit().create(APIRequest.class);
    }

    public LiveData<Article> getHeaderDetails(){
        final MutableLiveData<Article> data = new MutableLiveData<>();
        apiRequest.getHeadLines().enqueue(new Callback<Article>() {
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {
                if(response != null){
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public LiveData<Article.Results> getDetails(int astronautId){
        final MutableLiveData<Article.Results> data = new MutableLiveData<>();
        apiRequest.getDetails(astronautId).enqueue(new Callback<Article.Results>() {
            @Override
            public void onResponse(Call<Article.Results> call, Response<Article.Results> response) {
                if(response != null){
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Article.Results> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
