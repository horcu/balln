
package com.horcu.apps.balln.models.game;

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

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "id",
    "positions"
})

@ModelContainer
@Table(databaseName = horcuDatabase.NAME)
public class SpecialTeams extends BaseModel implements Parcelable {
    public SpecialTeams(){}

    @Column
    @PrimaryKey(autoincrement = true)
    @JsonProperty("id")
    public Long id;

    @Column
    @JsonProperty("playerpositionId")
    public String playerpositionId;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public final static Creator<SpecialTeams> CREATOR = new Creator<SpecialTeams>() {


        public SpecialTeams createFromParcel(Parcel in) {
            SpecialTeams instance = new SpecialTeams();
            in.readLong();
            in.readLong();
            instance.additionalProperties = ((Map<String, Object>) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public SpecialTeams[] newArray(int size) {
            return (new SpecialTeams[size]);
        }

    };

    @JsonProperty("id")
    public Long getId()
    {
        return id;
    }


    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The positions
     */
    @JsonProperty("playerpositionId")
    public String getPlayerPositionId() {
        return playerpositionId;
    }

    /**
     *
     * @param positions
     *     The positions
     */
    @JsonProperty("playerpositionId")
    public void setPlayerPositionId(String playerPositionId) {
        this.playerpositionId = playerpositionId;
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
        return new HashCodeBuilder().append(id).append(playerpositionId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SpecialTeams) == false) {
            return false;
        }
        SpecialTeams rhs = ((SpecialTeams) other);
        return new EqualsBuilder().append(id, rhs.id).append(playerpositionId, rhs.playerpositionId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(playerpositionId);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
