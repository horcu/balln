package com.horcu.apps.maura.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.horcu.apps.maura.R;
import com.horcu.apps.maura.models.Game;
import com.horcu.apps.maura.models.Player;

import com.horcu.apps.maura.ui.activities.PlayerChooserActivity;
import com.horcu.apps.maura.utilities.TeamHelmets;
import com.horcu.apps.maura.widget.floatinglabel.itemchooser.FloatingLabelItemChooser;


/**
 * A placeholder fragment containing a simple view.
 */
public class GameActivityFragment extends Fragment implements FloatingLabelItemChooser.OnItemChooserEventListener<Player>{

    public GameActivityFragment() {
    }

    public static final int REQUEST_CHOOSE_PLAYER = 0x1234;


    com.horcu.apps.maura.widget.floatinglabel.itemchooser.FloatingLabelItemChooser<Player> playerChooser;


    public static GameActivityFragment newInstance() {
        return new GameActivityFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Intent intent = getActivity().getIntent();
        final Game game = intent.getParcelableExtra("game");
        Drawable d =  getResources().getDrawable(TeamHelmets.getHelmet(game.getAwayTeam().getLogo()));
        Drawable d1 =  getResources().getDrawable(TeamHelmets.getHelmet(game.getHomeTeam().getLogo()));

        View root = inflater.inflate(R.layout.fragment_game, container, false);

        ImageView homeTeamImage = (ImageView)root.findViewById(R.id.home_image);
        homeTeamImage.setImageDrawable(d1);
        ImageView awayTeamImage = (ImageView)root.findViewById(R.id.away_image);
        awayTeamImage.setImageDrawable(d);
        // Choosers
        playerChooser = (com.horcu.apps.maura.widget.floatinglabel.itemchooser.FloatingLabelItemChooser<Player>) root.findViewById(R.id.qbChooser);
        playerChooser.setItemChooserListener(this);
        playerChooser.setWidgetListener(new FloatingLabelItemChooser.OnWidgetEventListener<Player>() {

            @Override
            public void onShowItemChooser(FloatingLabelItemChooser<Player> source) {
                Intent intent = PlayerChooserActivity.newIntent(getActivity());
                intent.putExtra("game", game);

                startActivityForResult(intent, REQUEST_CHOOSE_PLAYER);
            }
        });

        return root;
    }

    @Override
    public void onSelectionChanged(FloatingLabelItemChooser<Player> floatingLabelItemChooser, Player player) {

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CHOOSE_PLAYER) {
            if (resultCode == Activity.RESULT_OK) {
                Player selectedPlayer = data.getParcelableExtra(PlayerChooserActivity.RES_SELECTED_PLAYER);
                playerChooser.setSelectedItem(selectedPlayer);
                return;
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

}
