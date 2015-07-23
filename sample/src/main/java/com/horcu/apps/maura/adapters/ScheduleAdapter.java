package com.horcu.apps.maura.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.horcu.apps.maura.R;
import com.horcu.apps.maura.databinding.HeaderTestBinding;
import com.horcu.apps.maura.databinding.ItemTestBinding;
import com.horcu.apps.maura.models.Game;
import com.horcu.apps.maura.ui.activities.GameActivity;
import com.horcu.apps.maura.utilities.JsonLoader;
import com.horcu.apps.maura.utilities.TeamHelmets;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ca.barrenechea.widget.recyclerview.decoration.DoubleHeaderAdapter;


public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> implements
        DoubleHeaderAdapter<ScheduleAdapter.HeaderHolder, ScheduleAdapter.SubHeaderHolder> {

    private final View empty;

    private static ArrayList<Game> games = new ArrayList<>();
    JSONObject schedule = null;
    Context context = null;


    private LayoutInflater mInflater;

    public ScheduleAdapter(final View empty, Context applicationContext) {

        this.empty = empty;
        this.context = applicationContext;
        mInflater = LayoutInflater.from(context);

        try {//TODO get from DB first then raw if necessary then sync raw with DB
            schedule  = JsonLoader.loadObject(context, R.raw.nfl_schedule_2014_week_1);
           // depthChart  = JsonLoader.loadObject(context, R.raw.nfl_depth_chart_2014_week_1);

            // Get child arrays from JSON
            String id = schedule.getString("id");
            int number = schedule.getInt("number");
            JSONArray Matchups = schedule.getJSONArray("games");
            //  JSONObject venue = JsonPathResolver.resolveObject(Matchups.getJSONObject(0), "venue");

            games = getGames(Matchups);

        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NonNull
    private ArrayList<Game> getGames(JSONArray matchups) throws JSONException {
        ArrayList<Game> parsedGames = null;
       //check db here then return raw if not present there

        try {
            parsedGames = new ArrayList<>();

            for (int i = 0; i < matchups.length(); i++) {
                JSONObject g = (JSONObject) matchups.get(i);
                ObjectMapper mapper = new ObjectMapper();
                Game game = mapper.readValue(g.toString(), new TypeReference<Game>() {
                });

                if (game != null)
                    parsedGames.add(game);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parsedGames;
    }

    @Override
    public int getItemCount() {
        return 16;
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
    }

    private void dataSetChanged() {
        this.notifyDataSetChanged();
        this.empty.setVisibility(this.getItemCount() == 0 ? View.VISIBLE : View.GONE);
    }

    @UiThread
    public void addItem(final Game game) {
        this.games.add(game);
        this.dataSetChanged();
    }

    @UiThread
    public void addItems(final ArrayList<Game> games) {
        this.games.addAll(games);
        this.dataSetChanged();
    }

    @UiThread
    public void clearItems() {
        this.games.clear();
        this.dataSetChanged();
    }

    @Override
    public long getHeaderId(int position) {
       return getHeaderByGameDate(position);
       // return this.games.get(positionLayout).getId();
    }

    private long getHeaderByGameDate(int position) {
        Game game = games.get(position);
        String date = game.getScheduled();

        String date1 = "2014-09-05T00:30:00+00:00";
        String date2 = "2014-09-07T17:00:00+00:00";
        String date3 = "2014-09-08T23:10:00+00:00";
        String date4 = "2014-09-09T02:20:00+00:00";

        if(date.equals(date1))
        {
           return 0;
        }
        else if (date.equals(date2))
        {
            return 1;
        }
        else if(date.equals(date3))
        {
            return 2;
        }
        else //String MondayNightFootballDate = "";
        {
            return 3;
        }
    }

    @Override
    public long getSubHeaderId(int position) {
        return position;
        //return this.games.get(positionLayout)();
    }


    @Override
    public HeaderHolder onCreateHeaderHolder(ViewGroup parent) {
        try {
            final View view = mInflater.inflate(R.layout.super_header_test, parent, false);
            return new HeaderHolder(view);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public SubHeaderHolder onCreateSubHeaderHolder(ViewGroup parent) {
        try
        {
            final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            HeaderTestBinding   binding = DataBindingUtil.inflate(inflater, R.layout.header_test, parent, false);
            //  binding.setSchedule(schedule);
            // Persist arrays to database
            //JsonPersister persister = new JsonPersister(mDatabaseHelper.getWritableDatabase());
            // persister.persistArray(User.class, users_json);
            // persister.persistArray(Group.class, groups_json);
            return new SubHeaderHolder(binding.matchup, binding);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ScheduleAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        try
        {
            final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            ItemTestBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_test, parent, false);

            return new ViewHolder(binding.playersMain, binding);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onBindHeaderHolder(HeaderHolder viewholder, int position) {
        try {
         String gameDatetime = games.get(position).getScheduled();
            String date = gameDatetime.substring(0, 10);
            String time = gameDatetime.substring(9, gameDatetime.length());
            Date d = new SimpleDateFormat("MM-dd").parse(date);
            Date s = new SimpleDateFormat("HH:mm").parse(time);

            viewholder.date.setText(d + ", " + s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBindSubHeaderHolder(SubHeaderHolder viewholder, int position) {

        try {
            Drawable d =  context.getResources().getDrawable(TeamHelmets.getHelmet(games.get(position).getAwayTeam().getLogo()));
            Drawable d1 =  context.getResources().getDrawable(TeamHelmets.getHelmet(games.get(position).getHomeTeam().getLogo()));
            viewholder.awayTeamImage.setImageDrawable(d);
            viewholder.homeTeamImage.setImageDrawable(d1);

            final Game game = this.games.get(position);
            viewholder.bind(game);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        try {
            final Game game = this.games.get(position);

            holder.bind(game);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemTestBinding binding;
        public RelativeLayout item;
        public ImageView refresh;
        public ImageView editMatchup;

        public ViewHolder(final View view, final ItemTestBinding binding) {
            super(view);
            this.binding = binding;

            item = (RelativeLayout) itemView;
            refresh = (ImageView) item.findViewById(R.id.refresh);
            refresh.setOnClickListener(new refreshClick());

            editMatchup = (ImageView) item.findViewById(R.id.edit_matchup);
            editMatchup.setOnClickListener(new editClick());
        }

        @UiThread
        public void bind(final Game game) {
            this.binding.setGame(game);
        }

        private class refreshClick implements View.OnClickListener {
            @Override
            public void onClick(View v) {

            }
        }

        private class editClick implements View.OnClickListener {
            @Override
            public void onClick(View v) {

                Game game = games.get(getAdapterPosition());
                Intent myIntent = new Intent(v.getContext(), GameActivity.class);
                myIntent.putExtra("game", game);
                v.getContext().startActivity(myIntent);
            }
        }
    }

    static class HeaderHolder extends RecyclerView.ViewHolder {
       public RelativeLayout dataLayout;
        public TextView date;
        public HeaderHolder(View itemView) {
            super(itemView);

            dataLayout = (RelativeLayout)itemView;
            date = (TextView)itemView.findViewById(R.id.scheduled_date);
        }

    }

    static class SubHeaderHolder extends RecyclerView.ViewHolder {
        public LinearLayout matchup;
        public ImageView awayTeamImage;
        public ImageView homeTeamImage;
        private HeaderTestBinding binding;

        public SubHeaderHolder(View itemView, final HeaderTestBinding binding) {
            super(itemView);
            try {

                this.binding = binding;

                matchup = (LinearLayout) itemView;
                homeTeamImage = (ImageView) matchup.findViewById(R.id.home_image);
                awayTeamImage = (ImageView) matchup.findViewById(R.id.away_image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        @UiThread
        public void bind(final Game game) {
            try {
                this.binding.setGame(game);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}