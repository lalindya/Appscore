package com.andro.testapp.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.andro.testapp.model.Article;

public class SharedViewModel extends AndroidViewModel {
    MutableLiveData<Article.Results> selectedArticle = new MutableLiveData<>();

    public SharedViewModel(@NonNull Application application) {
        super(application);
    }

    public void setSelectedArticle(Article.Results article){
        selectedArticle.setValue(article);
    }

    public MutableLiveData<Article.Results> getSelectedArticle(){
        return selectedArticle;
    }
}
