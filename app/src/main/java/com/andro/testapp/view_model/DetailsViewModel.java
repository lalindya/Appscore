package com.andro.testapp.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.andro.testapp.model.Article;
import com.andro.testapp.repository.ArticleRepository;

public class DetailsViewModel extends AndroidViewModel {
    ArticleRepository articleRepository;
    LiveData<Article.Results> articleDetailsResponseLiveData;

    public DetailsViewModel(@NonNull Application application, int id) {
        super(application);
        articleRepository = new ArticleRepository();
        articleDetailsResponseLiveData = articleRepository.getDetails(64);

    }

    public LiveData<Article.Results> getArticleDetailsResponseLiveData() {
        return articleDetailsResponseLiveData;
    }
}
