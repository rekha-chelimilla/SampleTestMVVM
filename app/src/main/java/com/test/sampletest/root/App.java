package com.test.sampletest.root;

import android.app.Application;
import com.test.sampletest.service.APIInterfaceService;

public class App extends Application {
    APIInterfaceService apiInterfaceService;
    AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
    }
    public AppComponent getAppComponent(){
        return appComponent;
    }
}
