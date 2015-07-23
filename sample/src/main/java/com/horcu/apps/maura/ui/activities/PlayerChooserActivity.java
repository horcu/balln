package com.horcu.apps.maura.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.ListActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.horcu.apps.maura.R;
import com.horcu.apps.maura.adapters.PlayerAdapter;
import com.horcu.apps.maura.models.Game;
import com.horcu.apps.maura.models.Player;

import java.util.ArrayList;

public class PlayerChooserActivity extends Activity {

    public static final String RES_SELECTED_PLAYER = "SelectedPLayer";
    private static final String RES_SELECTED_PLAYER_ID = "SelectedPlayerId";
    public static  ArrayList<Player> AVAILABLE_PLAYERS = null;

    protected PlayerAdapter adapter;

    public static Intent newIntent(Context context) {
        Intent i = new Intent(context, PlayerChooserActivity.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser);

        RecyclerView rView = (RecyclerView) findViewById(android.R.id.list);


        Intent intent = getIntent();
        Game game = intent.getParcelableExtra("game");
        //AVAILABLE_PLAYERS = (ArrayList<Player>)game.getAwayTeam().getOffense().getPositions().get(8).getPlayers();
       // ArrayList<String> names = new ArrayList<String>();

//        for (int i =0; i< AVAILABLE_PLAYERS.size(); i++)
//        {
//            names.add(AVAILABLE_PLAYERS.get(i).getName());
//        }
        adapter = new PlayerAdapter(this.getApplicationContext(), game);

        rView.setAdapter(adapter);
    }


}
