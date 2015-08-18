package com.horcu.apps.balln;

import android.app.Application;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.SimpleLineIconsModule;
import com.joanzapata.iconify.fonts.WeathericonsModule;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by hacz on 8/3/2015.
 */
public class ballnApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);

        Iconify.with(new WeathericonsModule())
        .with(new SimpleLineIconsModule());
    }
}
