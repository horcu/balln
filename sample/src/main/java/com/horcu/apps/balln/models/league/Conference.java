
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
    "name",
    "conferenceDivisionId"
})

@ModelContainer
@Table(databaseName = horcuDatabase.NAME)
public class Conference extends BaseModel implements Parcelable
{
    public Conference(){}

    @Column
    @PrimaryKey(autoincrement = false)
    @JsonProperty("id")
    public String id;

    @Column
    @JsonProperty("name")
    private String name;

    @Column
    @JsonProperty("conferenceDivisionId")
    private Long conferenceDivisionId ;


    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public final static Creator<Conference> CREATOR = new Creator<Conference>() {


        public Conference createFromParcel(Parcel in) {
            Conference instance = new Conference();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.conferenceDivisionId = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Conference[] newArray(int size) {
            return (new Conference[size]);
        }

    };

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
     *     The conferenceDivisionId
     */
    @JsonProperty("conferenceDivisionId")
    public Long getConferenceDivisionId() {
        return conferenceDivisionId;
    }

    /**
     * 
     * @param conferenceDivisionId
     *     The conferenceDivisionId
     */
    @JsonProperty("conferenceDivisionId")
    public void setConferenceDivisionId(Long conferenceDivisionId) {
        this.conferenceDivisionId = conferenceDivisionId;
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
        return new HashCodeBuilder().append(id).append(name).append(conferenceDivisionId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Conference) == false) {
            return false;
        }
        Conference rhs = ((Conference) other);
        return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(conferenceDivisionId, rhs.conferenceDivisionId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeLong(conferenceDivisionId);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
