package com.horcu.apps.maura.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.BitmapFactory;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.horcu.apps.maura.R;
import com.horcu.apps.maura.databinding.PlayerListBinding;
import com.horcu.apps.maura.models.Game;
import com.horcu.apps.maura.models.Player;
import com.horcu.apps.maura.ui.activities.PlayerChooserActivity;

import java.util.ArrayList;

/**
 * Created by ray on 7/22/15.
 */
public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder>  {

    private static final String RES_SELECTED_PLAYER = "selectedPlayer";
    private static final String RES_SELECTED_PLAYER_ID = "selectedPlayerId";
    Game _game = new Game();
    Context _context = null;

    public PlayerAdapter(Context context, Game game) {
        _game = game;
        _context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        PlayerListBinding binding = DataBindingUtil.inflate(inflater, R.layout.player_list, parent, false);
        return new ViewHolder(binding.playerCard, binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Player player = null;
        if(position ==0) {
           player =_game.getAwayTeam().getOffense().getPositions().get(8).getPlayers().get(0);

        }

        holder.bind(player);
    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final PlayerListBinding binding;
        LinearLayout playerCard;
        TextView qbName ;

        public ViewHolder(View itemView, PlayerListBinding binding) {
            super(itemView);
            this.binding = binding;
             this.playerCard = (LinearLayout)itemView;
            ((TextView)playerCard.findViewById(R.id.away_player)).setText(binding.getPlayer().getName());
            ((ImageView)playerCard.findViewById(R.id.myqb)).setImageBitmap(BitmapFactory.decodeResource(_context.getResources(), R.drawable.arogers));

            ((TextView)playerCard.findViewById(R.id.home_player)).setText("jan janeries inclunido");
            ((ImageView)playerCard.findViewById(R.id.theirqb)).setImageBitmap(BitmapFactory.decodeResource(_context.getResources(), R.drawable.rwilson));
        }

        @UiThread
        public void bind(final Player player) {
            try {
                this.binding.setPlayer(player);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onClick(View v) {
            TextView selectedPlayer = (TextView) v.findViewById(R.id.away_player);
            TextView selectedPlayerId = (TextView) v.findViewById(R.id.away_player_id);

            Intent res = new Intent();
            res.putExtra(RES_SELECTED_PLAYER, selectedPlayer.getText());
            res.putExtra(RES_SELECTED_PLAYER_ID, selectedPlayerId.getText());
            ((PlayerChooserActivity)_context).setResult(Activity.RESULT_OK, res);
            ((PlayerChooserActivity)_context).finish();

        }
    }
}