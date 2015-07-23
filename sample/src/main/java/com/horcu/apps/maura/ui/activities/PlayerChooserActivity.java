package com.horcu.apps.maura.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.ListActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.horcu.apps.maura.R;
import com.horcu.apps.maura.models.Game;
import com.horcu.apps.maura.models.Player;

import java.util.ArrayList;

public class PlayerChooserActivity extends ListActivity {

    public static final String RES_SELECTED_PLAYER = "SelectedPLayer";
    public static  ArrayList<Player> AVAILABLE_PLAYERS = null;

    protected ArrayAdapter<Player> adapter;

    public static Intent newIntent(Context context) {
        Intent i = new Intent(context, PlayerChooserActivity.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser);

        Intent intent = getIntent();
        Game game = intent.getParcelableExtra("game");
        AVAILABLE_PLAYERS = (ArrayList<Player>)game.getAwayTeam().getOffense().getPositions().get(8).getPlayers();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, AVAILABLE_PLAYERS);
        //adapter
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Player selectedItem = adapter.getItem(position);

        Intent res = new Intent();
        res.putExtra(RES_SELECTED_PLAYER, selectedItem);
        setResult(Activity.RESULT_OK, res);
        finish();
    }
}
