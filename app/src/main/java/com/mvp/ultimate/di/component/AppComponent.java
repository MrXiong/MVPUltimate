package com.mvp.ultimate.di.component;


import com.mvp.ultimate.base.IApplication;
import com.mvp.ultimate.di.module.AppModule;
import com.mvp.ultimate.di.module.HttpModule;
import com.mvp.ultimate.http.RetrofitHelper;
import com.mvp.ultimate.http.RetrofitHelpers;
import com.mvp.ultimate.model.DataManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    IApplication getContext();  // 提供App的Context

    DataManager getDataManager(); //数据中心

    RetrofitHelper retrofitHelper();  //提供http的帮助类
    String  name();
    int age();

    RetrofitHelpers retrofitHelpers();

}
