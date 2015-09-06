package com.horcu.apps.balln.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.horcu.apps.balln.R;
import com.horcu.apps.balln.databinding.HeaderTestBinding;
import com.horcu.apps.balln.databinding.ItemTestBinding;
import com.horcu.apps.balln.models.game.AwayTeam;
import com.horcu.apps.balln.models.game.Broadcast;
import com.horcu.apps.balln.models.game.Game;
import com.horcu.apps.balln.models.game.HomeTeam;
import com.horcu.apps.balln.models.game.NFLWeek;
import com.horcu.apps.balln.models.game.NflweekGame;
import com.horcu.apps.balln.models.game.TeamColors;
import com.horcu.apps.balln.models.game.Venue;
import com.horcu.apps.balln.models.game.Weather;
import com.horcu.apps.balln.models.game.Wind;
import com.horcu.apps.balln.models.league.Conference;
import com.horcu.apps.balln.models.league.ConferenceDivision;
import com.horcu.apps.balln.models.league.Division;
import com.horcu.apps.balln.models.league.League;
import com.horcu.apps.balln.models.league.LeagueConference;
import com.horcu.apps.balln.models.league.Team;
import com.horcu.apps.balln.models.league.TeamDivision;
import com.horcu.apps.balln.ui.activities.GameActivity;
import com.horcu.apps.balln.utilities.AsyncTaskResult;
import com.horcu.apps.balln.utilities.DBUtils;
import com.horcu.apps.balln.utilities.JsonHelper;
import com.horcu.apps.balln.utilities.JsonLoader;
import com.horcu.apps.balln.utilities.TeamHelmets;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ca.barrenechea.widget.recyclerview.decoration.DoubleHeaderAdapter;


public class GameDayAdapter extends  RecyclerView.Adapter<GameDayAdapter.ViewHolder> implements
        DoubleHeaderAdapter<GameDayAdapter.HeaderHolder, GameDayAdapter.SubHeaderHolder> {

    private final View empty;
    private static List<Game> games = new ArrayList<>();
    JSONObject nflSeason = null;
    JSONObject nflWeek = null;
    Context context = null;
    List<Game> parsedGames = new ArrayList<Game>();

    private LayoutInflater mInflater;

    public GameDayAdapter(final View empty, Context applicationContext) {

        this.empty = empty;
        this.context = applicationContext;
        mInflater = LayoutInflater.from(context);

        try {
           new GetGameFromDbsAsync(context).execute();
      }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadLeagueInfoAsync() {
        new LoadLeagueFromJsonAsync(context).execute();
    }

    private int getCurrentWeek() {
        return 1;
        //logic here to use the current date to determine the week
//        Date today = new Date();
//        switch (today.getDate())
//        {
//            case today.getDate() > Consts.WEEK1_DATE.getDate()
//            {
//
//            }
//        }
    }

    @NonNull
    private void getGamesAsync(int weekNumber) throws JSONException {
                new LoadGamesFromJsonAsync(context, weekNumber).execute();
    }

    @Override
    public int getItemCount() {
        return games.size();
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
        try {
            if(games.size() == 0)
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
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
            if(games == null)
                return;

         String gameDatetime = games.get(position).getScheduled();

            if(gameDatetime == null)
                return;

            DateTimeFormatter fmt = DateTimeFormat.forPattern("d MMM, mm:ss a z");
            Game game = games.get(position);
            String date = game.getScheduled();

            String str = new LocalDateTime(date.substring(0,18)).toString(fmt);

            viewholder.date.setText(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBindSubHeaderHolder(SubHeaderHolder viewholder, int position) {
        if(games.size() < 1)
            return;

        try {
           final  Game game = games.get(position);

            AwayTeam ateam = new Select().from(AwayTeam.class).where(Condition.column("id").eq(game.getAwayTeamId())).querySingle();
            HomeTeam hteam = new Select().from(HomeTeam.class).where(Condition.column("id").eq(game.getHomeTeamId())).querySingle();

            if(ateam == null || hteam == null)
                return;

            String awayLogo = String.format("%s_away", ateam.getName().toLowerCase());
            String homeLogo = String.format("%s_home", hteam.getName().toLowerCase());
            Drawable d =  context.getResources().getDrawable(TeamHelmets.getHelmet(awayLogo));
            Drawable d1 =  context.getResources().getDrawable(TeamHelmets.getHelmet(homeLogo));
            viewholder.awayTeamImage.setImageDrawable(d);
            viewholder.homeTeamImage.setImageDrawable(d1);

//            viewholder.triggerEdit.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(games.size() < 1)
//                        return;
//
//                    Intent myIntent = new Intent(v.getContext(), GameActivity.class);
//                    myIntent.putExtra("game", game);
//                    v.getContext().startActivity(myIntent);
//                }
//            });

            viewholder.bind(game);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        try {
           if(games.size() < 1)
               return;

            final Game game = games.get(position);
            AwayTeam ateam = new Select().from(AwayTeam.class).where(Condition.column("id").eq(game.getAwayTeamId())).querySingle();
             holder.binding.setAwayTeam(ateam);

            HomeTeam hteam = new Select().from(HomeTeam.class).where(Condition.column("id").eq(game.getHomeTeamId())).querySingle();
            holder.binding.setHomeTeam(hteam);

            holder.bind(game);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemTestBinding binding;
        public LinearLayout item;
        public com.joanzapata.iconify.widget.IconTextView refresh;
        public com.joanzapata.iconify.widget.IconTextView editMatchup;

        public ViewHolder(final View view, final ItemTestBinding binding) {
            super(view);
            this.binding = binding;

            item = (LinearLayout)view;

           // refresh = (com.joanzapata.iconify.widget.IconTextView) item.findViewById(R.id.refresh);
           // refresh.setOnClickListener(new refreshClick());

            editMatchup = (com.joanzapata.iconify.widget.IconTextView) item.findViewById(R.id.edit_matchup);
            editMatchup.setOnClickListener(new editClick() );
        }

        @UiThread
        public void bind(final Game game) {
            this.binding.setGame(game);
        }

        private class editClick implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                if (games.size() < 1)
                    return;

                Game game = games.get(getAdapterPosition());
                Intent myIntent = new Intent(v.getContext(), GameActivity.class);
                myIntent.putExtra("game", game);
                v.getContext().startActivity(myIntent);
            }
        }
    }

    private static TextDrawable makeDrawableForIcons(String txt, String col) {
        return TextDrawable.builder()
                        .beginConfig()
                        .textColor(Color.WHITE)
                        .useFont(Typeface.DEFAULT)
                        .fontSize(25) /* size in px */
                        .bold()
                        .toUpperCase()
                        .withBorder(1)
                        .endConfig()
                        .buildRoundRect(txt, Color.parseColor(col), 5);
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
        public TextView triggerEdit;
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

    private class GetGameFromDbsAsync extends AsyncTask<Void, Integer, AsyncTaskResult<JSONObject>>{
        Context context = null;
        public GetGameFromDbsAsync(Context ctx){
            this.context = ctx;
        }

        @Override
        protected void onPostExecute(AsyncTaskResult<JSONObject> result) {
            if(result == null)
                return;

            if ( result.getError() != null ) {
                // error handling here
            }  else if ( isCancelled()) {
                // cancel handling here
            } else {

                if(games.size() < 16) {
                    try {
                        getGamesAsync(getCurrentWeek());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    loadLeagueInfoAsync();
                }
                else
                {
                    dataSetChanged();
                }
                DBUtils.backup(context);
            }
        }

        @Override
        protected AsyncTaskResult<JSONObject> doInBackground(Void... params) {

            try {
                games = new Select().from(Game.class).queryList();

            } catch (Exception e) {
                e.printStackTrace();
                return new AsyncTaskResult<JSONObject>(e);
            }
            return new AsyncTaskResult<JSONObject>("");
        }
    }

    private class SyncTeamsAndGamesAsync extends AsyncTask<Void, Integer, AsyncTaskResult<JSONObject>>{
        Context context = null;
        public SyncTeamsAndGamesAsync(Context ctx){
            this.context = ctx;
        }

        @Override
        protected void onPostExecute(AsyncTaskResult<JSONObject> result) {
            if(result == null)
                return;

            if ( result.getError() != null ) {
                // error handling here
            }  else if ( isCancelled()) {
                // cancel handling here
            } else {
                DBUtils.backup(context);
            }
        }

        @Override
        protected AsyncTaskResult<JSONObject> doInBackground(Void... params) {

            try {

                List<Team> teams = new Select().from(Team.class).queryList();
                List<AwayTeam> awayTeams  = new Select().from(AwayTeam.class).queryList();
                List<HomeTeam> homeTeams  = new Select().from(HomeTeam.class).queryList();
                List<BaseModel> teamsCombo = new ArrayList<>();
                teamsCombo.addAll(awayTeams);
                teamsCombo.addAll(homeTeams);


               for (int i =0; i< teams.size(); i++)
               {
                   Team team = teams.get(i);

                   for (int at= 0; at < teamsCombo.size(); at ++)
                   {
                       BaseModel xteam = teamsCombo.get(at);

                       if(xteam instanceof AwayTeam ) {
                           String name = ((AwayTeam) xteam).getName();
                           if (team.getName().equals(name)) {
                               ((AwayTeam) xteam).setTeamColorsId(team.getTeamColorsId());
                               xteam.save();
                           }
                       }
                       else
                       {
                           String name = ((HomeTeam) xteam).getName();
                           if (team.getName().equals(name)) {
                               ((HomeTeam) xteam).setTeamColorsId(team.getTeamColorsId());
                               xteam.save();
                           }
                       }
                   }
               }

            } catch (Exception e) {
                e.printStackTrace();
                return new AsyncTaskResult<JSONObject>(e);
            }
            return new AsyncTaskResult<JSONObject>("");
        }
    }

    private class LoadLeagueFromJsonAsync extends AsyncTask<Void, Integer, AsyncTaskResult<JSONObject>>{
       Context context = null;
        public LoadLeagueFromJsonAsync(Context ctx){
            this.context = ctx;
        }

        @Override
        protected void onPostExecute(AsyncTaskResult<JSONObject> result) {
            if(result == null)
                return;

            if ( result.getError() != null ) {
                // error handling here
            }  else if ( isCancelled()) {
                // cancel handling here
            } else {
               new SyncTeamsAndGamesAsync(context).execute();
            }
        }

        @Override
        protected AsyncTaskResult<JSONObject> doInBackground(Void... params) {
            JSONObject jsonLeague = null;
            try {
                ObjectMapper mapper = new ObjectMapper();
                jsonLeague = new JSONObject(JsonLoader.loadJSONFromAsset(context, "nfl_teams.json"));
                 League league = new League();
                league.setName(jsonLeague.getString("leagueName"));
                mapper.readValue(jsonLeague.toString(), League.class);

                JSONArray jsonconferences = jsonLeague.getJSONArray("conferences");
                List<Conference> conferences = mapper.readValue(jsonconferences.toString(), new TypeReference<List<Conference>>() {
                });

                for (int i = 0; i < conferences.size(); i ++)
                {
                    LeagueConference lconf = new LeagueConference();
                    lconf.setLeagueName(league.getName());
                    JSONObject jsonConference = jsonconferences.getJSONObject(i);
                    Conference conference = mapper.readValue(jsonConference.toString(), Conference.class);

                    JSONArray jsonDivisions = jsonConference.getJSONArray("divisions");
                    ConferenceDivision cDiv = new ConferenceDivision();

                    for(int d = 0; d < jsonDivisions.length(); d ++)
                    {
                       String tdKey = UUID.randomUUID().toString();
                        JSONObject div = jsonDivisions.getJSONObject(d);
                        Division Division = mapper.readValue(div.toString(), Division.class);

                        JSONArray jsonTeams = div.getJSONArray("teams");

                        for(int t = 0; t < jsonTeams.length(); t++)
                        {
                            TeamDivision tdiv = new TeamDivision();
                            tdiv.setId(tdKey);
                            tdiv.setDivisionId(Division.getId());

                            JSONObject jsonTeam = jsonTeams.getJSONObject(t);
                            Team team = mapper.readValue(jsonTeam.toString(), Team.class);

                            tdiv.setTeamId(team.getId());
                            tdiv.save();

                            TeamColors teamColors = mapper.readValue(jsonTeam.get("team_colors").toString(), TeamColors.class);

                            if(!teamColors.exists())
                            teamColors.save();

                            JSONObject jsonVenue = jsonTeam.getJSONObject("venue");
                            Venue venue = mapper.readValue(jsonVenue.toString(), Venue.class);
                            String venueId = jsonVenue.getString("id");
                            venue.setVenueId(venueId);
                            venue.save();

                            team.setVenueId(venueId);
                            team.setTeamColorsId(teamColors.getId());
                            team.save();
                        }

                        Division.setTeamDivisionId(tdKey);
                        Division.save();

                        cDiv.setDivisionId(Division.getId());
                        cDiv.setConferenceId(conference.getId());
                        cDiv.save();
                        conference.setConferenceDivisionId(cDiv.getId());
                        conference.save();
                    }

                    lconf.setConferenceId(conference.getId());
                    lconf.save();
                }

               // league.setLeagueConferenceId();

            } catch (Exception e) {
                e.printStackTrace();
                return new AsyncTaskResult<JSONObject>(e);
            }
            return new AsyncTaskResult<JSONObject>(jsonLeague);
        }
    };

   private class LoadGamesFromJsonAsync extends AsyncTask<Void, Integer, AsyncTaskResult<List<Game>>> {

        Context context = null;
        Integer week = 1;

        public LoadGamesFromJsonAsync(Context ctx, Integer weekNumber){
            this.context = ctx;
            week = weekNumber;
        }

       @Override
       protected void onPostExecute(AsyncTaskResult<List<Game>> result) {
            if(result == null)
                return;

           if ( result.getError() != null ) {
               // error handling here
           }  else if ( isCancelled()) {
               // cancel handling here
           } else {
               games = result.getResult();
              dataSetChanged();
           }
       }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected AsyncTaskResult<List<Game>> doInBackground(Void... params) {

            try {
               // nflSeason = new JSONObject(JsonLoader.loadJSONFromAsset(context, "nfl_sched_2014_season.json"));
               //nfkWeek = get from nfl season filtering by week number
               //for now we only need to work with one week

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
                   // venue.save(); // this is saved when the teams are saved

                    JSONObject jBroadcast = matchup.getJSONObject("broadcast");
                    Broadcast broadcast = mapper.readValue(jBroadcast.toString(), Broadcast.class);

                    broadcast.save();
                    game.setBroadcastId(broadcast.getId());

                    JSONObject jWeather = matchup.getJSONObject("weather");
                    Weather weather = mapper.readValue(jWeather.toString(), Weather.class);

                    JSONObject jWind = jWeather.getJSONObject("wind");
                    Wind wind = mapper.readValue(jWind.toString(), Wind.class);
                    wind.save();
                    weather.setWindId(wind.getId());
                    weather.save();

                    game.setWeatherId(weather.getId());
                    parsedGames.add(game);
                    game.save();
                    weekGame.setGameId(game.getId());
                    weekGame.setWeekId(week.getId());
                    weekGame.save();
                }
                week.setGames(parsedGames);
                week.save();

            } catch (Exception e) {
                e.printStackTrace();
                return new AsyncTaskResult<>(e);
            }
            return new AsyncTaskResult<>(parsedGames);
        }
    }
}