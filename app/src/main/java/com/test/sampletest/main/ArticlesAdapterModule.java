package com.test.sampletest.main;

import android.content.Context;

import com.test.sampletest.model.Result;
import java.util.List;
import dagger.Module;
import dagger.Provides;

@Module
public class ArticlesAdapterModule {
    List<Result> popularArticles;
    Context context;
    public ArticlesAdapterModule(List<Result> popularArticles, Context context) {
        this.popularArticles = popularArticles;
        this.context = context;
    }
    @Provides
    ArticlesAdapter getArticlesAdapter(){
    return new ArticlesAdapter(popularArticles, context);
    }

}
