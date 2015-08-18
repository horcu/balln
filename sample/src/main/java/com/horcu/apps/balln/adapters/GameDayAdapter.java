package com.horcu.apps.balln.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.Typeface;
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

import com.amulyakhare.textdrawable.TextDrawable;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.horcu.apps.balln.R;

import com.horcu.apps.balln.databinding.HeaderTestBinding;
import com.horcu.apps.balln.databinding.ItemTestBinding;
import com.horcu.apps.balln.db.horcuDatabase;
import com.horcu.apps.balln.models.game.AwayTeam;
import com.horcu.apps.balln.models.game.Broadcast;
import com.horcu.apps.balln.models.game.Game;
import com.horcu.apps.balln.models.game.HomeTeam;
import com.horcu.apps.balln.models.game.NFLWeek;
import com.horcu.apps.balln.models.game.NflweekGame;
import com.horcu.apps.balln.models.game.Venue;
import com.horcu.apps.balln.models.game.Weather;
import com.horcu.apps.balln.models.game.Wind;
import com.horcu.apps.balln.ui.activities.GameActivity;
import com.horcu.apps.balln.utilities.DBUtils;
import com.horcu.apps.balln.utilities.JsonHelper;
import com.horcu.apps.balln.utilities.JsonLoader;
import com.horcu.apps.balln.utilities.TeamHelmets;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import ca.barrenechea.widget.recyclerview.decoration.DoubleHeaderAdapter;

public class GameDayAdapter extends RecyclerView.Adapter<GameDayAdapter.ViewHolder> implements
        DoubleHeaderAdapter<GameDayAdapter.HeaderHolder, GameDayAdapter.SubHeaderHolder> {

    private final View empty;
    private static List<Game> games = new ArrayList<>();
    JSONObject nflWeek = null;
    Context context = null;
    List<Game> parsedGames = new ArrayList<Game>();

    private LayoutInflater mInflater;



    public GameDayAdapter(final View empty, Context applicationContext) {

        this.empty = empty;
        this.context = applicationContext;
        mInflater = LayoutInflater.from(context);

        try {
            games = getGames();

            File dbFile = context.getDatabasePath(horcuDatabase.NAME);
//            FlowManager.getDatabaseForTable(Game.class).backupDatabase();
//            String dbFIleName = FlowManager.getDatabase("horcuDb").getDatabaseFileName();
//            BaseDatabaseDefinition db =  FlowManager.getDatabase("horcuDb");
//
//            db.reset(context);

            DBUtils.backup(context);
      }
         catch (JSONException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NonNull
    private List<Game> getGames() throws JSONException {
    try {

//      //  nflWeek = JsonLoader.loadObject(context, R.raw.nfl_schedule_2014_week_1);
       if(parsedGames != null && parsedGames.size() <=0)
        {
            parsedGames = new Select().from(Game.class).queryList();

            if(parsedGames.size() <=0)
            LoadGamesFromJson(parsedGames);
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
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return parsedGames;
    }

    private void LoadGamesFromJson(List<Game> parsedGames) throws JSONException, IOException {
        try {

            JsonHelper jh = new JsonHelper();
            nflWeek = new JSONObject(JsonLoader.loadJSONFromAsset(context, "nfl_sched_2014_week_1.json"));
            ObjectMapper mapper = new ObjectMapper();

            NFLWeek week = mapper.readValue(nflWeek.toString(), NFLWeek.class);
            week.setNumber(1);

            JSONArray matchups = nflWeek.getJSONArray("games");

            for (int i = 0; i < matchups.length(); i++) {
                JSONObject matchup = (JSONObject) matchups.get(i);
                NflweekGame weekGame = new NflweekGame();

                Game game = mapper.readValue(matchup.toString(), Game.class);
                HomeTeam homeTeam = new HomeTeam();
                AwayTeam awayTeam = new AwayTeam();

               HomeTeam hteam = (HomeTeam) jh.set(JsonHelper.BALL_SIDE.HOME, game, matchup, mapper, homeTeam);
               hteam.save();
                game.setHomeTeamId(hteam.getId());

                AwayTeam ateam = (AwayTeam)jh.set(JsonHelper.BALL_SIDE.AWAY, game, matchup, mapper, awayTeam);
                ateam.save();
                game.setAwayTeamId(ateam.getId());

                JSONObject jVenue = matchup.getJSONObject("venue");
                Venue venue = mapper.readValue(jVenue.toString(), Venue.class);
                game.setVenueId(venue.getVenueId());
                venue.save();

                JSONObject jBroadcast = matchup.getJSONObject("broadcast");
                Broadcast broadcast = mapper.readValue(jBroadcast.toString(), Broadcast.class);

                broadcast.save();
                game.setBroadcastId(broadcast.getId());

                JSONObject jWeather = matchup.getJSONObject("weather");
                Weather weather = mapper.readValue(jWeather.toString(), Weather.class);

                JSONObject jWind = jWeather.getJSONObject("wind");
                Wind wind = mapper.readValue(jWind.toString(), Wind.class);
                weather.setWindId(wind.getId());
                weather.save();
                wind.save();

                game.setWeatherId(weather.getId());
                parsedGames.add(game);
                game.save();
                weekGame.setGameId(game.getId());
                weekGame.setWeekId(week.getId());
                weekGame.save();
            }

            week.setGames(parsedGames);
            week.save();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    @Override
    public long getHeaderId(int position) {
       return getHeaderByGameDate(position);
       // return this.games.get(positionLayout).getId();
    }

    private long getHeaderByGameDate(int position) {
        if(games.size() != 16)
            return 0;

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
            HeaderTestBinding binding = DataBindingUtil.inflate(inflater, R.layout.header_test, parent, false);

            return new SubHeaderHolder(binding.matchup, binding);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GameDayAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

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
        if(games.size() < 1)
            return;

        try {
            Game game = games.get(position);
            Map<String, Object> appPropMap = game.getAdditionalProperties();
            Object ateam = appPropMap.get(0);

            Long ateamId = game.getAwayTeamId();
            String awayLogo = new Select().from(AwayTeam.class).where(Condition.column("id").eq(ateamId)).querySingle().getLogo();
            String homeLogo = new Select().from(HomeTeam.class).where(Condition.column("id").eq(ateamId)).querySingle().getLogo();
            Drawable d =  context.getResources().getDrawable(TeamHelmets.getHelmet(awayLogo));
            Drawable d1 =  context.getResources().getDrawable(TeamHelmets.getHelmet(homeLogo));
            viewholder.awayTeamImage.setImageDrawable(d);
            viewholder.homeTeamImage.setImageDrawable(d1);

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
        public com.joanzapata.iconify.widget.IconTextView refresh;
        public com.joanzapata.iconify.widget.IconTextView editMatchup;
        public ImageView qb;
        public ImageView wr;

        public ViewHolder(final View view, final ItemTestBinding binding) {
            super(view);
            this.binding = binding;

            item = (RelativeLayout) itemView;
            qb = (ImageView)item.findViewById(R.id.testImage);
            wr = (ImageView)item.findViewById(R.id.testImage2);
            TextDrawable drawable = TextDrawable.builder()
                    .beginConfig()
                    .textColor(Color.WHITE)
                    .useFont(Typeface.DEFAULT)
                    .fontSize(25) /* size in px */
                    .bold()
                    .toUpperCase()
                    .withBorder(1)
                    .endConfig()
                    .buildRoundRect("Qb", Color.parseColor("#DCDCDC"), 5);

            qb.setImageDrawable(drawable);

            TextDrawable drawable1 = TextDrawable.builder()
                    .beginConfig()
                    .textColor(Color.WHITE)
                    .useFont(Typeface.DEFAULT)
                    .fontSize(25) /* size in px */
                    .bold()
                    .toUpperCase()
                    .withBorder(1)
                    .endConfig()
                    .buildRoundRect("Qb", Color.parseColor("#DCDCDC"), 5);


            wr.setImageDrawable(drawable1);

            refresh = (com.joanzapata.iconify.widget.IconTextView) item.findViewById(R.id.refresh);
            refresh.setOnClickListener(new refreshClick());

            editMatchup = (com.joanzapata.iconify.widget.IconTextView) item.findViewById(R.id.edit_matchup);
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
            if(games.size() < 1)
                return;

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