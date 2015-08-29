package com.horcu.apps.balln.ui.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.horcu.apps.balln.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class CrashActivityActivityFragment extends Fragment {

    public CrashActivityActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_crash, container, false);
    }
}
