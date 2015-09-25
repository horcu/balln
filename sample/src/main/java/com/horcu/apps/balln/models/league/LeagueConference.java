
package com.horcu.apps.balln.models.league;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import ollie.Model;
import ollie.annotation.Column;
import ollie.annotation.PrimaryKey;
import ollie.annotation.Table;

public class LeagueConference extends Model implements Parcelable
{
public LeagueConference(){}

    public Long id;

    public String leagueName;

    public String ConferenceId;

    public final static Creator<LeagueConference> CREATOR = new Creator<LeagueConference>() {


        public LeagueConference createFromParcel(Parcel in) {
            LeagueConference instance = new LeagueConference();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.leagueName = ((String) in.readValue((String.class.getClassLoader())));
            instance.ConferenceId = ((String) in.readValue((String.class.getClassLoader())));
         //   instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public LeagueConference[] newArray(int size) {
            return (new LeagueConference[size]);
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
     *     The leagueName
     */

    public String getLeagueName() {
        return leagueName;
    }

    /**
     * 
     * @param leagueName
     *     The leagueName
     */

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    /**
     * 
     * @return
     *     The ConferenceId
     */

    public String getConferenceId() {
        return ConferenceId;
    }

    /**
     * 
     * @param ConferenceId
     *     The ConferenceId
     */

    public void setConferenceId(String ConferenceId) {
        this.ConferenceId = ConferenceId;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(leagueName);
        dest.writeValue(ConferenceId);
     //   dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
