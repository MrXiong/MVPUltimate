package com.mvp.ultimate.base;

import android.app.Activity;
import android.app.Application;

import com.mvp.ultimate.di.component.AppComponent;
import com.mvp.ultimate.di.component.DaggerAppComponent;
import com.mvp.ultimate.di.module.AppModule;
import com.mvp.ultimate.di.module.HttpModule;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ZX on 2018/5/8.
 */

public class IApplication extends Application {

    private static IApplication instance;
    private Set<Activity> allActivities;
    public static AppComponent appComponent;

    public static synchronized IApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }


    //------------------Activity Manager---------------------------
    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }




    //-----------------dagger-----------------
    public static AppComponent getAppComponent(){
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }
}
