package com.test.sampletest.main;

import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.test.sampletest.R;
import com.test.sampletest.model.PopularArticles;
import com.test.sampletest.model.Result;
import com.test.sampletest.root.App;
import com.test.sampletest.viewmodel.ArticlesViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvArticles;
    @Inject
    ArticlesAdapter adapter;
    MainComponent mainComponent;
    List<Result> articlesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvArticles = (RecyclerView) findViewById(R.id.rcv_articles);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rvArticles.setHasFixedSize(true);
        rvArticles.setLayoutManager(linearLayoutManager);

        ArticlesViewModel articlesViewModel = ViewModelProviders.of(this).get(ArticlesViewModel.class);
        articlesViewModel.init();
        articlesViewModel.getPopularArticlesData().observe(this, new android.arch.lifecycle.Observer<PopularArticles>() {
            @Override
            public void onChanged(@Nullable PopularArticles popularArticles) {
                articlesList.addAll(popularArticles.getResults());
                adapter.notifyDataSetChanged();
            }
        });

        mainComponent = DaggerMainComponent.builder()
                .articlesAdapterModule(new ArticlesAdapterModule(articlesList,MainActivity.this))
                .appComponent(((App)getApplication()).getAppComponent())
                .build();
        adapter =  mainComponent.getArticlesAdapter();
        mainComponent.inject(MainActivity.this);

        if(articlesList != null) {
            rvArticles.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }
}
