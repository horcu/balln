
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


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ollie.Model;
import ollie.annotation.Column;
import ollie.annotation.PrimaryKey;
import ollie.annotation.Table;

public class Broadcast extends Model implements Parcelable
{
    public Broadcast(){}

    public Long id;

    public String network;

    public String satellite;


    public String internet;

    public final static Creator<Broadcast> CREATOR = new Creator<Broadcast>() {

        public Broadcast createFromParcel(Parcel in) {
            Broadcast instance = new Broadcast();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.network = ((String) in.readValue((String.class.getClassLoader())));
            instance.satellite = ((String) in.readValue((String.class.getClassLoader())));
            instance.internet = ((String) in.readValue((String.class.getClassLoader())));
           // instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
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

    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */

    public void setId(Long id) {
        this.id = id;
    }


    /**
     * 
     * @return
     *     The network
     */

    public String getNetwork() {
        return network;
    }

    /**
     * 
     * @param network
     *     The network
     */
    public void setNetwork(String network) {
        this.network = network;
    }

    /**
     * 
     * @return
     *     The satellite
     */
    public String getSatellite() {
        return satellite;
    }

    /**
     * 
     * @param satellite
     *     The satellite
     */

    public void setSatellite(String satellite) {
        this.satellite = satellite;
    }

    /**
     * 
     * @return
     *     The internet
     */
    public String getInternet() {
        return internet;
    }

    /**
     * 
     * @param internet
     *     The internet
     */

    public void setInternet(String internet) {
        this.internet = internet;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(network);
        dest.writeValue(satellite);
        dest.writeValue(internet);
     //   dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
