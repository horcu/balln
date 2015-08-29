package com.horcu.apps.balln;

import android.app.Application;

import com.horcu.apps.balln.ui.activities.MainActivity;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.SimpleLineIconsModule;
import com.joanzapata.iconify.fonts.WeathericonsModule;
import com.raizlabs.android.dbflow.config.FlowManager;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;

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


        CustomActivityOnCrash.setShowErrorDetails(true);
        CustomActivityOnCrash.setRestartActivityClass(MainActivity.class);

      //  CustomActivityOnCrash.setErrorActivityClass(Class<? extends Activity>);
        //Install CustomActivityOnCrash
        CustomActivityOnCrash.install(this);

        //Now initialize your error handlers as normal
        //i.e., ACRA.init(this);
        //or Crashlytics.start(this);
    }
}
