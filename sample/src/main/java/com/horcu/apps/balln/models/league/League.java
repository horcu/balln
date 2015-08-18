
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
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "name",
    "leagueConferenceId"
})

@ModelContainer
@Table(databaseName = horcuDatabase.NAME)
public class League extends BaseModel implements Parcelable
{
    public League(){}

    @Column
    @JsonProperty("name")
    private String name;

    @Column
    @JsonProperty("leagueConferenceId")
    private Long leagueConferenceId ;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<League> CREATOR = new Creator<League>() {


        public League createFromParcel(Parcel in) {
            League instance = new League();
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.leagueConferenceId = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
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
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The leagueConferenceId
     */
    @JsonProperty("leagueConferenceId")
    public Long getLeagueConferenceId() {
        return leagueConferenceId;
    }

    /**
     * 
     * @param leagueConferenceId
     *     The leagueConferenceId
     */
    @JsonProperty("leagueConferenceId")
    public void setLeagueConferenceId(Long leagueConferenceId) {
        this.leagueConferenceId = leagueConferenceId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(leagueConferenceId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof League) == false) {
            return false;
        }
        League rhs = ((League) other);
        return new EqualsBuilder().append(name, rhs.name).append(leagueConferenceId, rhs.leagueConferenceId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeLong(leagueConferenceId);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
