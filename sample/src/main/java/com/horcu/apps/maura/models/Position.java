
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
    "name",
    "desc",
    "players"
})

//@DatabaseTable(tableName="Position")
public class Position extends SugarRecord<Position> implements Parcelable
{

    public Position(){}

  //  @DatabaseField(columnName = "name")
    @JsonProperty("name")
    private String name;

  //  @DatabaseField(columnName = "desc")
    @JsonProperty("desc")
    private String desc;

  //  @DatabaseField(columnName = "players", foreign = true)
    @JsonProperty("players")
    private List<Player> players = new ArrayList<Player>();

    @Ignore
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Position> CREATOR = new Creator<Position>() {


        public Position createFromParcel(Parcel in) {
            Position instance = new Position();
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.desc = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.players, (Player.class.getClassLoader()));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Position[] newArray(int size) {
            return (new Position[size]);
        }

    }
    ;

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
     *     The desc
     */
    @JsonProperty("desc")
    public String getDesc() {
        return desc;
    }

    /**
     * 
     * @param desc
     *     The desc
     */
    @JsonProperty("desc")
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 
     * @return
     *     The players
     */
    @JsonProperty("players")
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * 
     * @param players
     *     The players
     */
    @JsonProperty("players")
    public void setPlayers(List<Player> players) {
        this.players = players;
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
        return new HashCodeBuilder().append(name).append(desc).append(players).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Position) == false) {
            return false;
        }
        Position rhs = ((Position) other);
        return new EqualsBuilder().append(name, rhs.name).append(desc, rhs.desc).append(players, rhs.players).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(desc);
        dest.writeList(players);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
