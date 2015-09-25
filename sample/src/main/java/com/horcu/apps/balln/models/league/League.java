
package com.horcu.apps.balln.models.league;

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
import org.apache.commons.lang.builder.ToStringBuilder;

import ollie.Model;
import ollie.annotation.Column;
import ollie.annotation.PrimaryKey;
import ollie.annotation.Table;

public class League extends Model implements Parcelable
{
    public League(){}


    public Long id;

    public String name;

    public Long leagueConferenceId ;

    public final static Creator<League> CREATOR = new Creator<League>() {


        public League createFromParcel(Parcel in) {
            League instance = new League();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.leagueConferenceId = ((Long) in.readValue((Long.class.getClassLoader())));
          //  instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public League[] newArray(int size) {
            return (new League[size]);
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
     *     The leagueConferenceId
     */

    public Long getLeagueConferenceId() {
        return leagueConferenceId;
    }

    /**
     * 
     * @param leagueConferenceId
     *     The leagueConferenceId
     */

    public void setLeagueConferenceId(Long leagueConferenceId) {
        this.leagueConferenceId = leagueConferenceId;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeLong(leagueConferenceId);
      //  dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
