
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
    "conferenceId",
    "divisionId"
})

@ModelContainer
@Table(databaseName = horcuDatabase.NAME)
public class ConferenceDivision extends BaseModel implements Parcelable
{
    public ConferenceDivision(){}

    @Column
    @PrimaryKey(autoincrement = true)
    @JsonProperty("id")
    public Long id;

    @Column
    @JsonProperty("conferenceId")
    private String conferenceId;

    @Column
    @JsonProperty("divisionId")
    private String divisionId;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<ConferenceDivision> CREATOR = new Creator<ConferenceDivision>() {


        public ConferenceDivision createFromParcel(Parcel in) {
            ConferenceDivision instance = new ConferenceDivision();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.conferenceId = ((String) in.readValue((String.class.getClassLoader())));
            instance.divisionId = ((String) in.readValue((String.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public ConferenceDivision[] newArray(int size) {
            return (new ConferenceDivision[size]);
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
     *     The conferenceId
     */
    @JsonProperty("conferenceId")
    public String getConferenceId() {
        return conferenceId;
    }

    /**
     * 
     * @param conferenceId
     *     The conferenceId
     */
    @JsonProperty("conferenceId")
    public void setConferenceId(String conferenceId) {
        this.conferenceId = conferenceId;
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
        return new HashCodeBuilder().append(id).append(conferenceId).append(divisionId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ConferenceDivision) == false) {
            return false;
        }
        ConferenceDivision rhs = ((ConferenceDivision) other);
        return new EqualsBuilder().append(id, rhs.id).append(conferenceId, rhs.conferenceId).append(divisionId, rhs.divisionId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(conferenceId);
        dest.writeValue(divisionId);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
