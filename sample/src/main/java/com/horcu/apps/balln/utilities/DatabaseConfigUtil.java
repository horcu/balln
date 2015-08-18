package com.horcu.apps.balln.utilities;

import android.database.SQLException;

import com.horcu.apps.balln.models.game.AwayTeam;
import com.horcu.apps.balln.models.game.Broadcast;
import com.horcu.apps.balln.models.game.Defense;
import com.horcu.apps.balln.models.game.Game;
import com.horcu.apps.balln.models.game.HomeTeam;
import com.horcu.apps.balln.models.game.NFLWeek;
import com.horcu.apps.balln.models.game.Offense;
import com.horcu.apps.balln.models.game.Player;
import com.horcu.apps.balln.models.game.PlayerPosition;
import com.horcu.apps.balln.models.game.Position;
import com.horcu.apps.balln.models.game.SpecialTeams;
import com.horcu.apps.balln.models.game.TeamColors;
import com.horcu.apps.balln.models.game.Venue;
import com.horcu.apps.balln.models.game.Weather;
import com.horcu.apps.balln.models.game.Wind;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.File;
import java.io.IOException;

/**
 * Created by ray on 7/26/15.
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil {
    private static final Class<?>[] classes = new Class[] {
            Game.class, NFLWeek.class, Broadcast.class, AwayTeam.class, HomeTeam.class, Defense.class, Offense.class,
            Player.class, Position.class, SpecialTeams.class, TeamColors.class,PlayerPosition.class,Venue.class, Weather.class, Wind.class,

    };

    public static void main(String[] args) throws SQLException, IOException {
        try {
            writeConfigFile(new File("ormlite_config.txt"), classes);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
}
