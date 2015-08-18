
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
    "network",
    "satellite",
    "internet"
})

@ModelContainer
@Table(databaseName = horcuDatabase.NAME)
public class Broadcast extends BaseModel implements Parcelable
{
    public Broadcast(){}

    @Column
    @PrimaryKey(autoincrement = true)
    @JsonProperty("id")
    public Long id;

    @Column
    @JsonProperty("network")
    private String network;

    @Column
    @JsonProperty("satellite")
    private String satellite;

    @Column
    @JsonProperty("internet")
    private String internet;


    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Broadcast> CREATOR = new Creator<Broadcast>() {


        public Broadcast createFromParcel(Parcel in) {
            Broadcast instance = new Broadcast();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.network = ((String) in.readValue((String.class.getClassLoader())));
            instance.satellite = ((String) in.readValue((String.class.getClassLoader())));
            instance.internet = ((String) in.readValue((String.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Broadcast[] newArray(int size) {
            return (new Broadcast[size]);
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
     *     The network
     */
    @JsonProperty("network")
    public String getNetwork() {
        return network;
    }

    /**
     * 
     * @param network
     *     The network
     */
    @JsonProperty("network")
    public void setNetwork(String network) {
        this.network = network;
    }

    /**
     * 
     * @return
     *     The satellite
     */
    @JsonProperty("satellite")
    public String getSatellite() {
        return satellite;
    }

    /**
     * 
     * @param satellite
     *     The satellite
     */
    @JsonProperty("satellite")
    public void setSatellite(String satellite) {
        this.satellite = satellite;
    }

    /**
     * 
     * @return
     *     The internet
     */
    @JsonProperty("internet")
    public String getInternet() {
        return internet;
    }

    /**
     * 
     * @param internet
     *     The internet
     */
    @JsonProperty("internet")
    public void setInternet(String internet) {
        this.internet = internet;
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
        return new HashCodeBuilder().append(id).append(network).append(satellite).append(internet).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Broadcast) == false) {
            return false;
        }
        Broadcast rhs = ((Broadcast) other);
        return new EqualsBuilder().append(id, rhs.id).append(network, rhs.network).append(satellite, rhs.satellite).append(internet, rhs.internet).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(network);
        dest.writeValue(satellite);
        dest.writeValue(internet);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
