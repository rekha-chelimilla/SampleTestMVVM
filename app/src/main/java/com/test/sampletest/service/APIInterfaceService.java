package com.test.sampletest.service;

import com.google.gson.Gson;
import com.test.sampletest.model.PopularArticles;
import com.test.sampletest.util.Const;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.Retrofit;

public class APIInterfaceService {
    Gson gson;
    Retrofit retrofit;

    public APIInterfaceService(Gson gson, Retrofit retrofit) {
        this.gson = gson;
        this.retrofit = retrofit;
    }

    public Observable<PopularArticles> getPopularArticles(){
        APIInterface apiInterface = retrofit.create(APIInterface.class);
        Observable<PopularArticles> popularArticlesObserver = apiInterface.getMostPopularArticles(Const.API_KEY);
        return popularArticlesObserver;
    }
}
