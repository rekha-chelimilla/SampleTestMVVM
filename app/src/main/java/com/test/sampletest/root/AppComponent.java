package com.test.sampletest.root;

import com.test.sampletest.service.APIInterfaceService;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {
    APIInterfaceService getApiInterfaceService();
}
