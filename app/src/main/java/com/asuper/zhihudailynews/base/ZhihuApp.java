package com.asuper.zhihudailynews.base;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Super on 2016/8/4.
 */
public class ZhihuApp extends MultiDexApplication {
    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        //65536 methods
        MultiDex.install(this);

        sContext = this;

        //fresco config
        FLog.setMinimumLoggingLevel(FLog.WARN);
        Fresco.initialize(this, ImagePipelineConfigFactory.getOkHttpImagePipelineConfig(this));

        //catch exception
        Thread.setDefaultUncaughtExceptionHandler(new SimpleUncaughtExceptionHandler());

    }

    public static Context getContext() {
        return sContext;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        android.os.Process.killProcess(android.os.Process.myPid());
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }


}
