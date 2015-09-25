
package com.horcu.apps.balln.models.league;

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
import com.horcu.apps.balln.models.game.Venue;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import ollie.Model;
import ollie.annotation.Column;
import ollie.annotation.PrimaryKey;
import ollie.annotation.Table;

public class Team extends Model implements Parcelable
{

    public Team(){}

    public Long id;

    public String name;

    public String market;

    public Long teamColorsId;

    public String venueId;

    public String defenseId;

    public String offenseId;

    public String specialTeamsId;

    public final static Creator<Team> CREATOR = new Creator<Team>() {


        public Team createFromParcel(Parcel in) {
            Team instance = new Team();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.market = ((String) in.readValue((String.class.getClassLoader())));
            instance.teamColorsId = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.venueId = ((String) in.readValue((String.class.getClassLoader())));
           // instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Team[] newArray(int size) {
            return (new Team[size]);
        }

    }
    ;

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
     *     The name
     */

    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The market
     */

    public String getMarket() {
        return market;
    }

    /**
     * 
     * @param market
     *     The market
     */

    public void setMarket(String market) {
        this.market = market;
    }

    /**
     * 
     * @return
     *     The teamColorsId
     */

    public Long getTeamColorsId() {
        return teamColorsId;
    }

    /**
     * 
     * @param teamColorsId
     *     The team_colors
     */

    public void setTeamColorsId(Long teamColorsId) {
        this.teamColorsId = teamColorsId;
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
     *     The offenseId
     */

    public String getOffenseId() {
        return offenseId;
    }

    /**
     *
     * @param offenseId
     *     The offenseId
     */

    public void setOffenseId(String offenseId) {
        this.offenseId = offenseId;
    }

    /**
     *
     * @return
     *     The defenseId
     */

    public String getDefenseId() {
        return defenseId;
    }

    /**
     *

     *     The specialTeamsId
     */

    public void setDefenseId(String defenseId) {
        this.defenseId = defenseId;
    }

    /**
     *
     * @return
     *     The specialTeamsId
     */

    public String getSpecialTeamsId() {
        return specialTeamsId;
    }

    /**
     *
     * @param specialTeamsId
     *     The specialTeamsId
     */

    public void setSpecialTeamsId(String specialTeamsId) {
        this.specialTeamsId = specialTeamsId;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(market);
        dest.writeValue(teamColorsId);
        dest.writeValue(venueId);
       // dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
