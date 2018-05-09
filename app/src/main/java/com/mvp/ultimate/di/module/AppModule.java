package com.mvp.ultimate.di.module;

import com.mvp.ultimate.base.IApplication;
import com.mvp.ultimate.http.HttpHelper;
import com.mvp.ultimate.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by codeest on 16/8/7.
 */

@Module
public class AppModule {
    private final IApplication application;

    public AppModule(IApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    IApplication provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

}
