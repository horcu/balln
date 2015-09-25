
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


@Table("venue")
public class Venue extends Model implements Parcelable
{
    public Venue(){}

    @Column("venueId")
    @PrimaryKey()
    public Long venueId;

    @Column("country")
    public String country;

    @Column("name")
    public String name;


    @Column("city")
    public String city;

    @Column("state")
    public String state;

    @Column("capacity")
    public Integer capacity;

    @Column("surface")
    public String surface;

    @Column("type")
    public String type;

    @Column("zip")
    public String zip;

    @Column("address")
    public String address;

    public final static Creator<Venue> CREATOR = new Creator<Venue>() {


        public Venue createFromParcel(Parcel in) {
            Venue instance = new Venue();
            instance.venueId = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.country = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.city = ((String) in.readValue((String.class.getClassLoader())));
            instance.state = ((String) in.readValue((String.class.getClassLoader())));
            instance.capacity = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.surface = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.zip = ((String) in.readValue((String.class.getClassLoader())));
            instance.address = ((String) in.readValue((String.class.getClassLoader())));
          //  instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Venue[] newArray(int size) {
            return (new Venue[size]);
        }

    }
    ;

    /**
     *
     * @return
     *     The id
     */

    public Long getVenueId() {
        return venueId;
    }

    /**
     *
     * @param id
     *     The id
     */

    public void setVenueId(Long id) {
        this.venueId = id;
    }


    /**
     * 
     * @return
     *     The country
     */

    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */

    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @return
     *     The name
     */

    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The city
     */

    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return
     *     The state
     */

    public String getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */

    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @return
     *     The capacity
     */

    public Integer getCapacity() {
        return capacity;
    }

    /**
     * 
     * @param capacity
     *     The capacity
     */

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * 
     * @return
     *     The surface
     */

    public String getSurface() {
        return surface;
    }

    /**
     * 
     * @param surface
     *     The surface
     */

    public void setSurface(String surface) {
        this.surface = surface;
    }

    /**
     * 
     * @return
     *     The type
     */

    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */

    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The zip
     */

    public String getZip() {
        return zip;
    }

    /**
     * 
     * @param zip
     *     The zip
     */

    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * 
     * @return
     *     The address
     */

    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */

    public void setAddress(String address) {
        this.address = address;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(venueId);
        dest.writeValue(country);
        dest.writeValue(name);
        dest.writeValue(city);
        dest.writeValue(state);
        dest.writeValue(capacity);
        dest.writeValue(surface);
        dest.writeValue(type);
        dest.writeValue(zip);
        dest.writeValue(address);
       // dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
