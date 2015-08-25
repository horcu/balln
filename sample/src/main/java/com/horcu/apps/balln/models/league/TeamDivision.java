
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
    "teamId",
    "divisionId"
})

@ModelContainer
@Table(databaseName = horcuDatabase.NAME)
public class TeamDivision extends BaseModel implements Parcelable
{
    public TeamDivision(){}

    @Column
    @PrimaryKey(autoincrement = false)
    @JsonProperty("id")
    public String id;

    @Column
    @JsonProperty("teamId")
    private String teamId;

    @Column
    @JsonProperty("divisionId")
    private String divisionId;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<TeamDivision> CREATOR = new Creator<TeamDivision>() {


        public TeamDivision createFromParcel(Parcel in) {
            TeamDivision instance = new TeamDivision();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.teamId = ((String) in.readValue((String.class.getClassLoader())));
            instance.divisionId = ((String) in.readValue((String.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
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
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The teamId
     */
    @JsonProperty("teamId")
    public String getTeamId() {
        return teamId;
    }

    /**
     * 
     * @param teamId
     *     The teamId
     */
    @JsonProperty("teamId")
    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    /**
     * 
     * @return
     *     The divisionId
     */
    @JsonProperty("divisionId")
    public String getDivisionId() {
        return divisionId;
    }

    /**
     * 
     * @param divisionId
     *     The divisionId
     */
    @JsonProperty("divisionId")
    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
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
        return new HashCodeBuilder().append(id).append(teamId).append(divisionId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TeamDivision) == false) {
            return false;
        }
        TeamDivision rhs = ((TeamDivision) other);
        return new EqualsBuilder().append(id, rhs.id).append(teamId, rhs.teamId).append(divisionId, rhs.divisionId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(teamId);
        dest.writeValue(divisionId);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
