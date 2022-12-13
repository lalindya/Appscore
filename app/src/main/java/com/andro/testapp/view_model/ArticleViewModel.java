package com.andro.testapp.view_model;

import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.andro.testapp.model.Article;
import com.andro.testapp.repository.ArticleRepository;
import com.andro.testapp.response.ArticleResponse;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArticleViewModel extends AndroidViewModel {
    ArticleRepository articleRepository;
    LiveData<Article> articleResponseLiveData;


    public ArticleViewModel(@NonNull Application application) {
        super(application);
        articleRepository = new ArticleRepository();
        articleResponseLiveData = articleRepository.getHeaderDetails();

    }

    public LiveData<Article> getArticleResponseLiveData() {
        return articleResponseLiveData;
    }

    public void sortByName(List<Article.Results> list){
        Collections.sort(list, new Comparator<Article.Results>() {
            public int compare(Article.Results v1, Article.Results v2) {
                return v1.getName().compareTo(v2.getName());
            }
        });

    }


}
