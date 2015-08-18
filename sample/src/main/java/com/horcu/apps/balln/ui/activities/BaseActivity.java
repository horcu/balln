package com.horcu.apps.balln.ui.activities;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.horcu.apps.balln.R;

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
