package com.horcu.apps.maura.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.horcu.apps.maura.R;
import com.horcu.apps.maura.models.Game;
import com.horcu.apps.maura.models.Player;

import com.horcu.apps.maura.ui.activities.PlayerChooserActivity;
import com.horcu.apps.maura.utilities.TeamHelmets;
import com.horcu.apps.maura.widget.floatinglabel.itemchooser.FloatingLabelItemChooser;

import java.util.ArrayList;


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

        if(getActivity().getActionBar()!= null)
            getActivity().getActionBar().hide();


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

        //offense
        setUpChoosers(game, root);



        LinearLayout awayDefense = (LinearLayout)root.findViewById(R.id.players_away_defense);
        LinearLayout awayTeams = (LinearLayout)root.findViewById(R.id.players_away);

       // playerChooser = (com.horcu.apps.maura.widget.floatinglabel.itemchooser.FloatingLabelItemChooser<Player>) root.findViewById(R.id.qbChooser_offense);
       // playerChooser.setItemChooserListener(this);

        //defense

              FloatingLabelItemChooser<Player> player = (FloatingLabelItemChooser < Player >)
                root.findViewById(R.id.players_away_offense)
                .findViewById(R.id.qbChooser_offense);

             player.setWidgetListener(new FloatingLabelItemChooser.OnWidgetEventListener<Player>() {

                    @Override
                    public void onShowItemChooser(FloatingLabelItemChooser<Player> source) {
                        Intent intent = PlayerChooserActivity.newIntent(getActivity());
                        intent.putExtra("game", game);
                        intent.putExtra("side", 0);
                        intent.putExtra("position", 8);

                        startActivityForResult(intent, REQUEST_CHOOSE_PLAYER);
                    }
                });
        //teams

        return root;
    }

    private void setUpChoosers(final Game game, View root) {
      //Away

        try {
            for(int side = 0; side < 3; side ++){ // three sides of the ball

                LinearLayout[] vs = new LinearLayout[3];
                vs[0] = (LinearLayout) root.findViewById(R.id.players_away_offense);
                vs[1] = (LinearLayout) root.findViewById(R.id.players_away_defense);
                vs[2] = (LinearLayout) root.findViewById(R.id.players_away_teams);;

                Integer position;

                Integer count = vs[side].getChildCount();

                for (int i = 0; i < count; i++) {
                    position = setArrayQueryPosition(i, side);
                    FloatingLabelItemChooser<Player> v = (FloatingLabelItemChooser<Player>) vs[side].getChildAt(i);

                    v.setItemChooserListener(this);
                    final Integer finalPosition = position;
                    final int finalSide = side;
                    v.setWidgetListener(new FloatingLabelItemChooser.OnWidgetEventListener<Player>() {

                        @Override
                        public void onShowItemChooser(FloatingLabelItemChooser<Player> source) {
                            Intent intent = PlayerChooserActivity.newIntent(getActivity());
                            intent.putExtra("game", game);
                            intent.putExtra("side", finalSide);
                            intent.putExtra("position", finalPosition);

                            startActivityForResult(intent, REQUEST_CHOOSE_PLAYER);
                        }
                    });
                }
            }
            //home

            for(int side = 0; side < 3; side ++){ // three sides of the ball

                LinearLayout[] vs = new LinearLayout[3];
                vs[0] = (LinearLayout) root.findViewById(R.id.players_home_offense);;
                vs[1] = (LinearLayout) root.findViewById(R.id.players_home_defense);
                vs[2] = (LinearLayout) root.findViewById(R.id.players_home_teams);;

                Integer position;

                Integer count = vs[side].getChildCount();

                for (int i = 0; i < count; i++) {
                    position = setArrayQueryPosition(i, side);
                    FloatingLabelItemChooser<Player> v = (FloatingLabelItemChooser<Player>) vs[side].getChildAt(i);

                    v.setItemChooserListener(this);
                    final Integer finalPosition = position;
                    final int finalSide = side;
                    v.setWidgetListener(new FloatingLabelItemChooser.OnWidgetEventListener<Player>() {

                        @Override
                        public void onShowItemChooser(FloatingLabelItemChooser<Player> source) {
                            Intent intent = PlayerChooserActivity.newIntent(getActivity());
                            intent.putExtra("game", game);
                            intent.putExtra("side", finalSide);
                            intent.putExtra("position", finalPosition);

                            startActivityForResult(intent, REQUEST_CHOOSE_PLAYER);
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NonNull
    private Integer setArrayQueryPosition(int index, Integer type) {
        Integer position = 0;

        switch (type)
        {
            case 0: // offense
            {
                if(index ==0) //qb
                {
                    position = 8;
                    return position;
                }else if(index == 1) //rb
                {
                    position = 5;
                    return position;
                }
                else if (index ==2) // wr
                {
                    position = 6;
                    return position;
                }
                else // te
                {
                    position = 9;
                    return position;
                }
            }
            case 1: //defense
            {
                if(index ==0) //lb
                {
                    position = 0;
                    return position;
                }else if(index == 1) //cb
                {
                    position = 5;
                    return position;
                }
                else if (index ==2) // fs
                {
                    position = 2;
                    return position;
                }
                else // ss
                {
                    position = 1;
                    return position;
                }
            }
            case 2: //teams
            {
                if(index ==0) //pr
                {
                    position = 5;
                    return position;
                }else if(index == 1) //kr
                {
                    position = 0;
                    return position;
                }
                else if (index ==2) // p
                {
                    position = 3;
                    return position;
                }
                else // k
                {
                    position = 0;
                    return position;
                }
            }
        }

        return position;
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
