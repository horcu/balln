package com.horcu.apps.balln.ui.activities;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toolbar;

import com.horcu.apps.balln.R;

public abstract class BaseActivity extends AppCompatActivity
    {


        @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//            try {
//                this.setContentView(R.layout.activity_main);
//                Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
//                setActionBar(toolbar);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
       }
    }
