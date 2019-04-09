package com.test.sampletest.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.test.sampletest.data.local.entity.ArticleEntity;
import com.test.sampletest.data.remote.Resource;
import com.test.sampletest.data.remote.repository.ArticleRepository;

import java.util.List;

import javax.inject.Inject;

public class ArticleListViewModel extends ViewModel {
    private final LiveData<Resource<List<ArticleEntity>>> popularArticles;

    @Inject
    public ArticleListViewModel(ArticleRepository articleRepository) {
        popularArticles = articleRepository.loadPopularArticles(7);
    }

    public LiveData<Resource<List<ArticleEntity>>> getPopularArticles() {
        return popularArticles;
    }
}
