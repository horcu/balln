
package com.horcu.apps.maura.models;

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
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "positions"
})

//@DatabaseTable(tableName="Offense")
public class Offense extends SugarRecord<Offense> implements Parcelable
{

    public Offense(){}

  //  @DatabaseField(columnName = "positions", foreign = true)
    @JsonProperty("positions")
    private List<Position> positions = new ArrayList<Position>();

    @Ignore
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Offense> CREATOR = new Creator<Offense>() {


        public Offense createFromParcel(Parcel in) {
            Offense instance = new Offense();
            in.readList(instance.positions, (Position.class.getClassLoader()));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Offense[] newArray(int size) {
            return (new Offense[size]);
        }

    }
    ;

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
        return new HashCodeBuilder().append(positions).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Offense) == false) {
            return false;
        }
        Offense rhs = ((Offense) other);
        return new EqualsBuilder().append(positions, rhs.positions).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(positions);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
