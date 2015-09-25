package com.horcu.apps.balln.models.game;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.horcu.apps.balln.db.horcuDatabase;

import javax.annotation.Generated;

import ollie.Model;
import ollie.annotation.Column;
import ollie.annotation.PrimaryKey;
import ollie.annotation.Table;

/**
 * Created by hacz on 8/13/2015.
 */

public class NflweekGame extends Model implements Parcelable{

    public NflweekGame(){}

    public Long id;


    public String weekId;


    public String gameId;

    /**
     *
     * @return
     *     The id
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The gameId
     */

    public String getGameId() {
        return gameId;
    }

    /**
     *
     *     The gameId
     */

    public void setGameId(String id) {
        this.gameId = id;
    }

    /**
     *
     * @return
     *     The weekId
     */

    public String getWeekId() {
        return weekId;
    }

    /**
     *
     *     The weekId
     */

    public void setWeekId(String id) {
        this.weekId = id;
    }

    public final static Creator<NflweekGame> CREATOR = new Creator<NflweekGame>() {


        public NflweekGame createFromParcel(Parcel in) {
            NflweekGame instance = new NflweekGame();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.weekId = ((String) in.readValue((String.class.getClassLoader())));
            instance.gameId = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public NflweekGame[] newArray(int size) {
            return (new NflweekGame[size]);
        }

    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(weekId);
        dest.writeValue(gameId);
    }
}
