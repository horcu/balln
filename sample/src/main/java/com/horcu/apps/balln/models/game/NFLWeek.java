
package com.horcu.apps.balln.models.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

public class NFLWeek extends Model implements Parcelable
{

    public NFLWeek(){}

    public Long id;

    public Integer number;


    public List<Game> games = new ArrayList<Game>();


    public final static Creator<NFLWeek> CREATOR = new Creator<NFLWeek>() {


        public NFLWeek createFromParcel(Parcel in) {
            NFLWeek instance = new NFLWeek();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.number = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.games, (Game.class.getClassLoader()));
          //  instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public NFLWeek[] newArray(int size) {
            return (new NFLWeek[size]);
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
     *     The number
     */

    public Integer getNumber() {
        return number;
    }

    /**
     * 
     * @param number
     *     The number
     */

    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     *
     * @return
     *     The games
     */

    public List<Game> getGames() {
        return games;
    }

    /**
     * 
     * @param games
     *     The games
     */

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(number);
        dest.writeList(games);
       // dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
