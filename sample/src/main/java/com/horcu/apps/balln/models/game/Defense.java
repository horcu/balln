
package com.horcu.apps.balln.models.game;


import java.util.HashMap;
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "type",
    "positions"
})

@ModelContainer
@Table(databaseName = horcuDatabase.NAME)
public class Defense extends BaseModel implements Parcelable
{
    public Defense(){}

    @Column
    @PrimaryKey(autoincrement = true)
    @JsonProperty("id")
    public Long id;

   @Column
    @JsonProperty("type")
    private String type;

    @Column
    @JsonProperty("playerPositionId")
    public String playerPositionId;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Defense> CREATOR = new Creator<Defense>() {


        public Defense createFromParcel(Parcel in) {
            Defense instance = new Defense();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            in.readString();
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Defense[] newArray(int size) {
            return (new Defense[size]);
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
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     *     The positions
     */
    @JsonProperty("playerPositionId")
    public String getPlayerPositionId() {
        return playerPositionId;
    }

    /**
     *
     * @param positions
     *     The positions
     */
    @JsonProperty("playerPositionId")
    public void setPlayerPositionId(String playerPositionId) {
        this.playerPositionId = playerPositionId;
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
        return new HashCodeBuilder().append(id).append(type).append(playerPositionId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Defense) == false) {
            return false;
        }
        Defense rhs = ((Defense) other);
        return new EqualsBuilder().append(id, rhs.id).append(type, rhs.type).append(playerPositionId, rhs.playerPositionId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(type);
        dest.writeString(playerPositionId);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
