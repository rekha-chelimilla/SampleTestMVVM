package com.test.sampletest.di.builder;

import com.test.sampletest.view.fragment.ArticleDetailFragment;
import com.test.sampletest.view.fragment.ArticleListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract ArticleListFragment contributeArticleListFragment();

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract ArticleDetailFragment contributeArticleDetailFragment();

}
