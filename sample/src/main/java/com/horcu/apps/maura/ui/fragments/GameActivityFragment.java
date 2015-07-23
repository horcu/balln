package com.horcu.apps.maura.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.horcu.apps.maura.R;
import com.horcu.apps.maura.models.Game;
import com.horcu.apps.maura.models.Player;
import com.horcu.apps.maura.ui.activities.PlayerChooserActivity;
import com.marvinlabs.widget.floatinglabel.itemchooser.FloatingLabelItemChooser;

/**
 * A placeholder fragment containing a simple view.
 */
public class GameActivityFragment extends Fragment implements FloatingLabelItemChooser.OnItemChooserEventListener<Player>{

    public GameActivityFragment() {
    }

    public static final int REQUEST_CHOOSE_PRODUCT = 0x1234;


    FloatingLabelItemChooser<Player> playerChooser;


    public static GameActivityFragment newInstance() {
        return new GameActivityFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Intent intent = getActivity().getIntent();
        final Game game = intent.getParcelableExtra("game");

        View root = inflater.inflate(R.layout.fragment_game, container, false);
        // Choosers
        playerChooser = (FloatingLabelItemChooser<Player>) root.findViewById(R.id.chooser1);
        playerChooser.setItemChooserListener(this);
        playerChooser.setWidgetListener(new FloatingLabelItemChooser.OnWidgetEventListener<Player>() {

            @Override
            public void onShowItemChooser(FloatingLabelItemChooser<Player> source) {
                Intent intent = PlayerChooserActivity.newIntent(getActivity());
                intent.putExtra("game", game);

                startActivityForResult(intent, REQUEST_CHOOSE_PRODUCT);
            }
        });

        return root;
    }

    @Override
    public void onSelectionChanged(FloatingLabelItemChooser<Player> floatingLabelItemChooser, Player player) {

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CHOOSE_PRODUCT) {
            if (resultCode == Activity.RESULT_OK) {
                Player selectedProduct = data.getParcelableExtra(PlayerChooserActivity.RES_SELECTED_PLAYER);
                playerChooser.setSelectedItem(selectedProduct);
                return;
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

}
