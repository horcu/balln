package com.horcu.apps.maura.ui.activities;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;

import com.horcu.apps.maura.R;
import com.horcu.apps.maura.utilities.DBUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
