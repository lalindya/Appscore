package com.andro.testapp.response;

import com.andro.testapp.model.Article;

import java.util.List;

public class ArticleResponse {
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "ArticleResponse{" +
                "articles=" + articles +
                '}';
    }
}
