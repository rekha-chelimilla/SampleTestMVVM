package com.test.sampletest.main;

import com.test.sampletest.root.AppComponent;

import dagger.Component;

@Component(modules = {ArticlesAdapterModule.class}, dependencies = AppComponent.class)
public interface MainComponent {
    ArticlesAdapter getArticlesAdapter();
    void inject(MainActivity mainActivity);
}
