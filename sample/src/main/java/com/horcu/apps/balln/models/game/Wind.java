
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
    "speed",
    "direction"
})

@ModelContainer
@Table(databaseName = horcuDatabase.NAME)
public class Wind extends BaseModel implements Parcelable
{
    public Wind(){}
    @Column
    @JsonProperty("id")
    @PrimaryKey(autoincrement = true)
    public Long id;

     @Column
    @JsonProperty("speed")
    private Integer speed;

    @Column
    @JsonProperty("direction")
    private String direction;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Wind> CREATOR = new Creator<Wind>() {

        public Wind createFromParcel(Parcel in) {
            Wind instance = new Wind();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.speed = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.direction = ((String) in.readValue((String.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Wind[] newArray(int size) {
            return (new Wind[size]);
        }

    }
    ;

    @JsonProperty("id")
    public Long getId() {
        return id;
    }


    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The speed
     */
    @JsonProperty("speed")
    public Integer getSpeed() {
        return speed;
    }

    /**
     * 
     * @param speed
     *     The speed
     */
    @JsonProperty("speed")
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    /**
     * 
     * @return
     *     The direction
     */
    @JsonProperty("direction")
    public String getDirection() {
        return direction;
    }

    /**
     * 
     * @param direction
     *     The direction
     */
    @JsonProperty("direction")
    public void setDirection(String direction) {
        this.direction = direction;
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
        return new HashCodeBuilder().append(id).append(speed).append(direction).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Wind) == false) {
            return false;
        }
        Wind rhs = ((Wind) other);
        return new EqualsBuilder().append(id, rhs.id).append(speed, rhs.speed).append(direction, rhs.direction).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(speed);
        dest.writeValue(direction);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
