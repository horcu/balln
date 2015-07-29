package com.horcu.apps.maura.utilities;

import android.database.SQLException;

import com.horcu.apps.maura.models.AwayTeam;
import com.horcu.apps.maura.models.Broadcast;
import com.horcu.apps.maura.models.Defense;
import com.horcu.apps.maura.models.Game;
import com.horcu.apps.maura.models.HomeTeam;
import com.horcu.apps.maura.models.NFLWeek;
import com.horcu.apps.maura.models.Offense;
import com.horcu.apps.maura.models.Player;
import com.horcu.apps.maura.models.Position;
import com.horcu.apps.maura.models.SpecialTeams;
import com.horcu.apps.maura.models.TeamColors;
import com.horcu.apps.maura.models.Venue;
import com.horcu.apps.maura.models.Weather;
import com.horcu.apps.maura.models.Wind;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.File;
import java.io.IOException;

/**
 * Created by ray on 7/26/15.
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil {
    private static final Class<?>[] classes = new Class[] {
            Game.class, NFLWeek.class, Broadcast.class, AwayTeam.class, HomeTeam.class, Defense.class, Offense.class,
            Player.class, Position.class, SpecialTeams.class, TeamColors.class,Venue.class, Weather.class, Wind.class,

    };

    public static void main(String[] args) throws SQLException, IOException {
        try {
            writeConfigFile(new File("ormlite_config.txt"), classes);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
}
