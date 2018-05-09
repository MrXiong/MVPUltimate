package com.mvp.ultimate.di.component;

import android.app.Activity;


import com.mvp.ultimate.GirlsActivity;
import com.mvp.ultimate.MainActivity;
import com.mvp.ultimate.di.module.ActivityModule;
import com.mvp.ultimate.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(GirlsActivity girlsActivity);

    void inject(MainActivity mainActivity);

}
