
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
    "id",
    "name",
    "teamDivisionId"
})
@ModelContainer
@Table(databaseName = horcuDatabase.NAME)
public class Division extends BaseModel implements Parcelable
{
    public Division(){}

    @Column
    @JsonProperty("id")
    private String id;

    @Column
    @JsonProperty("name")
    private String name;

    @Column
    @JsonProperty("teamDivisionId")
    private Long teamDivisionId ;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Division> CREATOR = new Creator<Division>() {


        public Division createFromParcel(Parcel in) {
            Division instance = new Division();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.teamDivisionId = ((Long) in.readValue((Long.class.getClassLoader())));

            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Division[] newArray(int size) {
            return (new Division[size]);
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
     *     The teamDivisionId
     */
    @JsonProperty("teamDivisionId")
    public Long getTeamDivisionId() {
        return teamDivisionId;
    }

    /**
     * 
     * @param teamDivisionId
     *     The teamDivisionId
     */
    @JsonProperty("teamDivisionId")
    public void setTeamDivisionId(Long teamDivisionId) {
        this.teamDivisionId = teamDivisionId;
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
        return new HashCodeBuilder().append(id).append(name).append(teamDivisionId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Division) == false) {
            return false;
        }
        Division rhs = ((Division) other);
        return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(teamDivisionId, rhs.teamDivisionId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeLong(teamDivisionId);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
