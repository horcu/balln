
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
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "leagueName",
    "ConferenceId"
})

@ModelContainer
@Table(databaseName = horcuDatabase.NAME)
public class LeagueConference extends BaseModel implements Parcelable
{
public LeagueConference(){}

    @Column
    @PrimaryKey(autoincrement = true)
    @JsonProperty("id")
    private Long id;

    @Column
    @JsonProperty("leagueName")
    private String leagueName;

    @Column
    @JsonProperty("ConferenceId")
    private String ConferenceId;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<LeagueConference> CREATOR = new Creator<LeagueConference>() {


        public LeagueConference createFromParcel(Parcel in) {
            LeagueConference instance = new LeagueConference();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.leagueName = ((String) in.readValue((String.class.getClassLoader())));
            instance.ConferenceId = ((String) in.readValue((String.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
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
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The leagueName
     */
    @JsonProperty("leagueName")
    public String getLeagueName() {
        return leagueName;
    }

    /**
     * 
     * @param leagueName
     *     The leagueName
     */
    @JsonProperty("leagueName")
    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    /**
     * 
     * @return
     *     The ConferenceId
     */
    @JsonProperty("ConferenceId")
    public String getConferenceId() {
        return ConferenceId;
    }

    /**
     * 
     * @param ConferenceId
     *     The ConferenceId
     */
    @JsonProperty("ConferenceId")
    public void setConferenceId(String ConferenceId) {
        this.ConferenceId = ConferenceId;
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
        return new HashCodeBuilder().append(id).append(leagueName).append(ConferenceId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LeagueConference) == false) {
            return false;
        }
        LeagueConference rhs = ((LeagueConference) other);
        return new EqualsBuilder().append(id, rhs.id).append(leagueName, rhs.leagueName).append(ConferenceId, rhs.ConferenceId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(leagueName);
        dest.writeValue(ConferenceId);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
