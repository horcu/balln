package com.horcu.apps.balln.utilities;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.horcu.apps.balln.models.game.AwayTeam;
import com.horcu.apps.balln.models.game.Defense;
import com.horcu.apps.balln.models.game.Game;
import com.horcu.apps.balln.models.game.HomeTeam;
import com.horcu.apps.balln.models.game.Offense;
import com.horcu.apps.balln.models.game.Player;
import com.horcu.apps.balln.models.game.PlayerPosition;
import com.horcu.apps.balln.models.game.Position;
import com.horcu.apps.balln.models.game.SpecialTeams;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.structure.BaseModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by hacz on 8/15/2015.
 */
 public  class JsonHelper {

    public JsonHelper() {
    }

    public BaseModel set(BALL_SIDE ballSide, Game game, JSONObject matchup, ObjectMapper mapper, BaseModel model) throws JSONException, IOException {
        BaseModel baseModel = setBallSide(ballSide, game, matchup, mapper, model);
        return baseModel;
    }

    @NonNull
    private BaseModel setBallSide(BALL_SIDE ballSide, Game game, JSONObject matchup, ObjectMapper mapper, BaseModel team) throws JSONException, IOException {

        try {
            switch (ballSide) {
                case HOME: {
                    HomeTeam hteam =  ((HomeTeam) team);
                    JSONObject jsonModelHome = (JSONObject) matchup.get(Consts.HOME_TEAM);

                    hteam = mapper.readValue(jsonModelHome.toString(), HomeTeam.class);
                    JSONObject offense = jsonModelHome.getJSONObject(Consts.OFFENSE);

                    String pposKey = setPlayerPositionModel(mapper, offense);
                    Offense a = mapper.readValue(offense.toString(), Offense.class);
                    a.setPlayerPositionId(pposKey);

                    a.save();

                    Long id = a.getId();
                    hteam.setOffenseId(id);

                    JSONObject defense = jsonModelHome.getJSONObject(Consts.DEFENSE);

                    String pposKey2 = setPlayerPositionModel(mapper, defense);
                    Defense b = mapper.readValue(defense.toString(), Defense.class);
                    b.setPlayerPositionId(pposKey2);

                    b.save();

                    Long id2 = b.getId();
                    hteam.setDefenseId(id2);

                    JSONObject specialTeams = jsonModelHome.getJSONObject(Consts.SPECIAL_TEAMS);

                    String pposKey3 = setPlayerPositionModel(mapper, specialTeams);
                    SpecialTeams pocoSteams = mapper.readValue(specialTeams.toString(), SpecialTeams.class);
                    pocoSteams.setPlayerPositionId(pposKey3);

                    pocoSteams.save();
                     Long id3 = pocoSteams.getId();
                     hteam.setSpecialTeamsId(id3);
                     return hteam;
                }
                case AWAY: {
                    AwayTeam hteam =  ((AwayTeam) team);
                    JSONObject jsonModelHome = (JSONObject) matchup.get(Consts.AWAY_TEAM);

                    hteam = mapper.readValue(jsonModelHome.toString(), AwayTeam.class);
                    JSONObject offense = jsonModelHome.getJSONObject(Consts.OFFENSE);

                    String ppos = setPlayerPositionModel(mapper, offense);
                    Offense c = mapper.readValue(offense.toString(), Offense.class);
                    c.setPlayerPositionId(ppos);

                    c.save();
                    Long id = c.getId();
                     hteam.setOffenseId(id);

                    JSONObject defense = jsonModelHome.getJSONObject(Consts.DEFENSE);

                    String ppos2 = setPlayerPositionModel(mapper, defense);
                    Defense d = mapper.readValue(defense.toString(), Defense.class);
                    d.setPlayerPositionId(ppos2);

                    d.save();
                    Long id2 = d.getId();
                    hteam.setDefenseId(id2);

                    JSONObject specialTeams = jsonModelHome.getJSONObject(Consts.SPECIAL_TEAMS);

                    String ppos3 = setPlayerPositionModel(mapper, specialTeams);
                    SpecialTeams e = mapper.readValue(specialTeams.toString(), SpecialTeams.class);
                    e.setPlayerPositionId(ppos3);

                    e.save();
                    Long id3 = e.getId();
                    hteam.setSpecialTeamsId(id3);
                    return hteam;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return team;
    }

    @NonNull
    private String setPlayerPositionModel(ObjectMapper mapper, JSONObject jsonObject) throws JSONException, IOException {
        try {
            JSONArray positions = jsonObject.getJSONArray(Consts.POSITIONS);
            String pposKey = UUID.randomUUID().toString();

            for (int i = 0; i < positions.length(); i++) {
                Position newPosition = new Position();
                JSONObject pos = (JSONObject) positions.get(i);

                newPosition.setName(pos.getString(Consts.NAME));
                newPosition.setDesc(pos.getString(Consts.DESC));

                Position record = new Select().from(Position.class).where(Condition.column("name").eq(newPosition.getName())).querySingle();
                Boolean positionDoesNotExist = record == null;

                if(positionDoesNotExist)
                newPosition.save();

                JSONArray posPlayers = (JSONArray) pos.get(Consts.PLAYERS);
                List<Player> players = mapper.readValue(posPlayers.toString(), new TypeReference<List<Player>>() {
                });

                for (int p = 0; p < players.size(); p++) {
                    PlayerPosition ppos = new PlayerPosition();
                    ppos.setPlayerPositionId(pposKey);
                    Player pl = players.get(p);
                    pl.save();
                    ppos.setPlayerId(pl.getId());

                    Long positionId = positionDoesNotExist ? newPosition.getPositionId() : record.getPositionId();
                    ppos.setPositionId(positionId);
                    ppos.setDepth(pl.getDepth());
                    ppos.save();
                }
            }
            return pposKey;
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public enum BALL_SIDE {
        HOME,
        AWAY
    }
}

