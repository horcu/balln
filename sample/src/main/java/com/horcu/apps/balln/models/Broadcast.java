
package com.horcu.apps.balln.models;

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
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "network",
    "satellite",
    "internet"
})
public class Broadcast implements Parcelable
{

    @JsonProperty("network")
    private String network;
    @JsonProperty("satellite")
    private String satellite;
    @JsonProperty("internet")
    private String internet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Broadcast> CREATOR = new Creator<Broadcast>() {


        public Broadcast createFromParcel(Parcel in) {
            Broadcast instance = new Broadcast();
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
        return new HashCodeBuilder().append(network).append(satellite).append(internet).append(additionalProperties).toHashCode();
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
        return new EqualsBuilder().append(network, rhs.network).append(satellite, rhs.satellite).append(internet, rhs.internet).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(network);
        dest.writeValue(satellite);
        dest.writeValue(internet);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
