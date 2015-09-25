
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
import com.horcu.apps.balln.db.horcuDatabase;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import ollie.Model;
import ollie.annotation.Column;
import ollie.annotation.PrimaryKey;
import ollie.annotation.Table;

public class TeamDivision extends Model implements Parcelable
{
    public TeamDivision(){}

    public Long id;

    public String teamId;

    public String divisionId;

    public final static Creator<TeamDivision> CREATOR = new Creator<TeamDivision>() {


        public TeamDivision createFromParcel(Parcel in) {
            TeamDivision instance = new TeamDivision();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.teamId = ((String) in.readValue((String.class.getClassLoader())));
            instance.divisionId = ((String) in.readValue((String.class.getClassLoader())));
           // instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public TeamDivision[] newArray(int size) {
            return (new TeamDivision[size]);
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
     *     The teamId
     */

    public String getTeamId() {
        return teamId;
    }

    /**
     * 
     * @param teamId
     *     The teamId
     */

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    /**
     * 
     * @return
     *     The divisionId
     */

    public String getDivisionId() {
        return divisionId;
    }

    /**
     * 
     * @param divisionId
     *     The divisionId
     */

    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(teamId);
        dest.writeValue(divisionId);
       // dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
