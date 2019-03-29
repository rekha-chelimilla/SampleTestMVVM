package com.test.sampletest.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.sampletest.main.ArticlesAdapterModule;
import com.test.sampletest.main.DaggerMainComponent;
import com.test.sampletest.main.MainActivity;
import com.test.sampletest.model.PopularArticles;
import com.test.sampletest.root.App;
import com.test.sampletest.service.APIInterface;
import com.test.sampletest.service.APIInterfaceService;
import com.test.sampletest.util.Const;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArticlesRepository {
    static Gson gsson;
    static Retrofit retrofit;

    private static Gson providesGson(){
        gsson = new GsonBuilder()
                .setLenient()
                .create();
        return gsson;
    }

    private static Retrofit providesRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gsson))
                .build();
        return retrofit;
    }
    private static APIInterface getApiInterface(){
        gsson = ArticlesRepository.providesGson();
        retrofit = ArticlesRepository.providesRetrofit();
        APIInterface apiInterface = retrofit.create(APIInterface.class);
        return apiInterface;
    }

    public MutableLiveData<PopularArticles> getPopularArticles(){
        final MutableLiveData<PopularArticles> popularArticlesMutableLiveData = new MutableLiveData<>();
         ArticlesRepository.getApiInterface()
                .getMostPopularArticles(Const.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PopularArticles>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PopularArticles popularArticles) {
                     popularArticlesMutableLiveData.setValue(popularArticles);
                        Log.e("TAG: ",popularArticles.getResults().get(0).getTitle());
                    }

                    @Override
                    public void onError(Throwable e) {
                      Log.e("TAG E", ""+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("on completed", "on completed");
                    }
                });


        return popularArticlesMutableLiveData;
    }





}
