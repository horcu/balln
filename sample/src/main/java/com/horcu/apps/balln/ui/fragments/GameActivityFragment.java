package com.horcu.apps.balln.ui.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.horcu.apps.balln.R;
import com.horcu.apps.balln.models.Game;

/**
 * A placeholder fragment containing a simple view.
 */
public class GameActivityFragment extends Fragment {

    public GameActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Intent intent = getActivity().getIntent();
        Game game = intent.getParcelableExtra("game");


        return inflater.inflate(R.layout.fragment_game, container, false);
    }
}
