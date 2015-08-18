
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
    "name",
    "jersey_number",
    "status",
    "depth"
})

@ModelContainer
@Table(databaseName = horcuDatabase.NAME)
public class Player extends BaseModel implements Parcelable
{
    public Player(){}

    @Column
    @PrimaryKey(autoincrement = false)
    @JsonProperty("id")
    public String id;

    @Column
    @JsonProperty("name")
    private String name;

    @Column
    @JsonProperty("jersey_number")
    private Integer jerseyNumber;

    @Column
    @JsonProperty("status")
    private String status;

    @Column
    @JsonProperty("depth")
    private Long depth;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Player> CREATOR = new Creator<Player>() {


        public Player createFromParcel(Parcel in) {
            Player instance = new Player();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.jerseyNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            instance.depth = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Player[] newArray(int size) {
            return (new Player[size]);
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
     *     The jerseyNumber
     */
    @JsonProperty("jersey_number")
    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    /**
     * 
     * @param jerseyNumber
     *     The jersey_number
     */
    @JsonProperty("jersey_number")
    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The depth
     */
    @JsonProperty("depth")
    public Long getDepth() {
        return depth;
    }

    /**
     * 
     * @param depth
     *     The depth
     */
    @JsonProperty("depth")
    public void setDepth(Long depth) {
        this.depth = depth;
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
        return new HashCodeBuilder().append(id).append(name).append(jerseyNumber).append(status).append(depth).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Player) == false) {
            return false;
        }
        Player rhs = ((Player) other);
        return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(jerseyNumber, rhs.jerseyNumber).append(status, rhs.status).append(depth, rhs.depth).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(jerseyNumber);
        dest.writeValue(status);
        dest.writeValue(depth);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
