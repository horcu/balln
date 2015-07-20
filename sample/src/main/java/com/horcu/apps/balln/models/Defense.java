
package com.horcu.apps.balln.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "type",
    "positions"
})
public class Defense implements Parcelable
{

    @JsonProperty("type")
    private String type;
    @JsonProperty("positions")
    private List<Position> positions = new ArrayList<Position>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Defense> CREATOR = new Creator<Defense>() {


        public Defense createFromParcel(Parcel in) {
            Defense instance = new Defense();
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.positions, (com.horcu.apps.balln.models.Position.class.getClassLoader()));
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
    @JsonProperty("positions")
    public List<Position> getPositions() {
        return positions;
    }

    /**
     * 
     * @param positions
     *     The positions
     */
    @JsonProperty("positions")
    public void setPositions(List<Position> positions) {
        this.positions = positions;
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
        return new HashCodeBuilder().append(type).append(positions).append(additionalProperties).toHashCode();
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
        return new EqualsBuilder().append(type, rhs.type).append(positions, rhs.positions).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeList(positions);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
