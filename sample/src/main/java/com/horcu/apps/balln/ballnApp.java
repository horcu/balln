package com.horcu.apps.balln;

import android.app.Application;

import com.horcu.apps.balln.db.horcuDatabase;
import com.horcu.apps.balln.ui.activities.MainActivity;



import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import ollie.Ollie;

/**
 * Created by hacz on 8/3/2015.
 */
public class ballnApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Ollie.with(this)
                .setName(horcuDatabase.NAME)
                .setVersion(1)
                .setLogLevel(Ollie.LogLevel.FULL)
                .setCacheSize(1024)
                .init();
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
