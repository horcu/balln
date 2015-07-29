package com.horcu.apps.maura.ui.activities;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.horcu.apps.maura.R;
import com.horcu.apps.maura.models.Game;
import com.horcu.apps.maura.models.Player;
import java.util.ArrayList;

public class PlayerChooserActivity extends ListActivity {

    public static final String RES_SELECTED_PLAYER = "SelectedPLayer";
    private static final String RES_SELECTED_PLAYER_ID = "SelectedPlayerId";
    public static  ArrayList<Player> AVAILABLE_PLAYERS = null;
    public Game game = null;
    protected ArrayAdapter<String> adapter;

    public static Intent newIntent(Context context) {
        Intent i = new Intent(context, PlayerChooserActivity.class);
        return i;
    }

     class playerShell{
         String name;
         Long id;

     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser);

        Intent intent = getIntent();
        game = intent.getParcelableExtra("game");
        Integer side = intent.getParcelableExtra("side");
        Integer position = intent.getIntExtra("position", 0);
        ArrayList<Player> players = null;

        if(side == 0) //offense
        {
            players = (ArrayList<Player>) game.getAwayTeam().getOffense().getPositions().get(position).getPlayers();
        }
        else if(side == 1) //defense
        {
            players = (ArrayList<Player>) game.getAwayTeam().getDefense().getPositions().get(position).getPlayers();
        }
        else //teams
        {
            players = (ArrayList<Player>) game.getAwayTeam().getSpecialTeams().getPositions().get(position).getPlayers();
        }

        ArrayList<playerShell>playerShells = new ArrayList<>();
        ArrayList<String>playerNames = new ArrayList<>();

        for(int i = 0; i < players.size(); i++)
        {
            Player p = players.get(i);
            playerShell ps = new playerShell();
            ps.id = p.getId();
            ps.name = p.getName();
            playerShells.add(ps);
            playerNames.add(p.getName());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, playerNames);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String selectedItem = adapter.getItem(position);
        Player player = null;

        ArrayList<Player> players  = (ArrayList<Player>) game.getAwayTeam().getOffense().getPositions().get(8).getPlayers();
        for(int i = 0; i < players.size(); i++)
        {
            Player p=  players.get(i);
           if(p.getName().equals(selectedItem))
           {
              player = p;
           }
        }

        Intent res = new Intent();
        res.putExtra(RES_SELECTED_PLAYER, player);
        setResult(Activity.RESULT_OK, res);
        finish();
    }
}
