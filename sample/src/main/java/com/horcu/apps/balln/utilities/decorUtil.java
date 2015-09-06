package com.horcu.apps.balln.utilities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by hacz on 9/1/2015.
 */
public class decorUtil {


    public static void changeStatusBarColor(Activity ctx, int color) {
        Window window = ctx.getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // finally change the color
        window.setStatusBarColor(color);
    }
}
