package com.mvp.ultimate.di.module;

import com.mvp.ultimate.base.IApplication;
import com.mvp.ultimate.http.HttpHelper;
import com.mvp.ultimate.http.HttpHelpers;
import com.mvp.ultimate.http.RetrofitHelper;
import com.mvp.ultimate.http.RetrofitHelpers;
import com.mvp.ultimate.model.DataManager;

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

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper) {
        return new DataManager(httpHelper);
    }
    @Provides
    @Singleton
    String provideName() {
        return "大雄";
    }
    @Provides
    @Singleton
    int provideage(RetrofitHelpers retrofitHelpers) {
        return 888;
    }

}
