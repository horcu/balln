package com.horcu.apps.maura.ui.activities;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Toolbar;

import com.horcu.apps.maura.R;

public abstract class BaseActivity extends FragmentActivity
    {


        @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


            try {
                this.setContentView(R.layout.activity_main);
            } catch (Exception e) {
                e.printStackTrace();
            }



    }

}