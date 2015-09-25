
package com.horcu.apps.balln.models.game;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import com.horcu.apps.balln.db.horcuDatabase;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ollie.Model;
import ollie.annotation.Column;
import ollie.annotation.PrimaryKey;
import ollie.annotation.Table;

public class Game extends Model implements Parcelable
{
    public Game(){}

    public Long id;

    public String scheduled;

    public String homeRotation;

    public String awayRotation;

    public Long homeTeamId;

    public Long awayTeamId;

    public String venueId;

    public Long broadcastId;

    public Long weatherId;

    public final static Creator<Game> CREATOR = new Creator<Game>() {


        public Game createFromParcel(Parcel in) {
            Game instance = new Game();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.scheduled = ((String) in.readValue((String.class.getClassLoader())));
            instance.homeRotation = ((String) in.readValue((String.class.getClassLoader())));
            instance.awayRotation = ((String) in.readValue((String.class.getClassLoader())));
            instance.homeTeamId = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.awayTeamId = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.venueId = ((String) in.readValue((String.class.getClassLoader())));
            instance.broadcastId = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.weatherId = ((Long) in.readValue((Long.class.getClassLoader())));
           // instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Game[] newArray(int size) {
            return (new Game[size]);
        }
    };

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
     *     The scheduled
     */

    public String getScheduled() {
        return scheduled;
    }

    /**
     * 
     * @param scheduled
     *     The scheduled
     */

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    /**
     * 
     * @return
     *     The homeRotation
     */

    public String getHomeRotation() {
        return homeRotation;
    }

    /**
     * 
     * @param homeRotation
     *     The home_rotation
     */

    public void setHomeRotation(String homeRotation) {
        this.homeRotation = homeRotation;
    }

    /**
     * 
     * @return
     *     The awayRotation
     */
    public String getAwayRotation() {
        return awayRotation;
    }

    /**
     * 
     * @param awayRotation
     *     The away_rotation
     */

    public void setAwayRotation(String awayRotation) {
        this.awayRotation = awayRotation;
    }

    /**
     * 
     * @return
     *     The homeTeamId
     */

    public Long getHomeTeamId() {
        return homeTeamId;
    }

    /**
     * 
     * @param homeTeamId
     *     The home_team
     */

    public void setHomeTeamId(Long homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    /**
     * 
     * @return
     *     The awayTeamId
     */

    public Long getAwayTeamId() {
        return awayTeamId;
    }

    /**
     * 
     * @param awayTeamId
     *     The away_team
     */

    public void setAwayTeamId(Long awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    /**
     * 
     * @return
     *     The venueId
     */

    public String getVenueId() {
        return venueId;
    }

    /**
     * 
     * @param venueId
     *     The venueId
     */

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    /**
     * 
     * @return
     *     The broadcastId
     */

    public Long getBroadcastId() {
        return broadcastId;
    }

    /**
     * 
     * @param broadcastId
     *     The broadcastId
     */

    public void setBroadcastId(Long broadcastId) {
        this.broadcastId = broadcastId;
    }

    /**
     * 
     * @return
     *     The weatherId
     */

    public Long getWeatherId() {
        return weatherId;
    }

    /**
     * 
     * @param weatherId
     *     The weatherId
     */

    public void setWeatherId(Long weatherId) {
        this.weatherId = weatherId;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(scheduled);
        dest.writeValue(homeRotation);
        dest.writeValue(awayRotation);
        dest.writeValue(homeTeamId);
        dest.writeValue(awayTeamId);
        dest.writeValue(venueId);
        dest.writeValue(broadcastId);
        dest.writeValue(weatherId);
      //  dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }
}
