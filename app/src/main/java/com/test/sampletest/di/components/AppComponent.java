package com.test.sampletest.di.components;

import android.app.Application;

import com.test.sampletest.NYTimesApp;
import com.test.sampletest.di.builder.ActivityBuilderModule;
import com.test.sampletest.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AppModule.class,
        AndroidInjectionModule.class,
        ActivityBuilderModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(NYTimesApp nyTimesApp);
}