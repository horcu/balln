
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
    "venueId",
    "country",
    "name",
    "city",
    "state",
    "capacity",
    "surface",
    "type",
    "zip",
    "address"
})

@ModelContainer
@Table(databaseName = horcuDatabase.NAME)
public class Venue extends BaseModel implements Parcelable
{
    public Venue(){}

    @Column
    @PrimaryKey(autoincrement = false)
    @JsonProperty("venueId")
    private String venueId;

    @Column
    @JsonProperty("country")
    private String country;

    @Column
    @JsonProperty("name")
    private String name;


    @Column
    @JsonProperty("city")
    private String city;

    @Column
    @JsonProperty("state")
    private String state;

    @Column
    @JsonProperty("capacity")
    private Integer capacity;

    @Column
    @JsonProperty("surface")
    private String surface;

    @Column
    @JsonProperty("type")
    private String type;

    @Column
    @JsonProperty("zip")
    private String zip;

    @Column
    @JsonProperty("address")
    private String address;


    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Venue> CREATOR = new Creator<Venue>() {


        public Venue createFromParcel(Parcel in) {
            Venue instance = new Venue();
            instance.venueId = ((String) in.readValue((String.class.getClassLoader())));
            instance.country = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.city = ((String) in.readValue((String.class.getClassLoader())));
            instance.state = ((String) in.readValue((String.class.getClassLoader())));
            instance.capacity = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.surface = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.zip = ((String) in.readValue((String.class.getClassLoader())));
            instance.address = ((String) in.readValue((String.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
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
    @JsonProperty("venueId")
    public String getVenueId() {
        return venueId;
    }

    /**
     *
     * @param id
     *     The id
     */
    @JsonProperty("venueId")
    public void setVenueId(String id) {
        this.venueId = id;
    }


    /**
     * 
     * @return
     *     The country
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
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
     *     The city
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return
     *     The state
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @return
     *     The capacity
     */
    @JsonProperty("capacity")
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * 
     * @param capacity
     *     The capacity
     */
    @JsonProperty("capacity")
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * 
     * @return
     *     The surface
     */
    @JsonProperty("surface")
    public String getSurface() {
        return surface;
    }

    /**
     * 
     * @param surface
     *     The surface
     */
    @JsonProperty("surface")
    public void setSurface(String surface) {
        this.surface = surface;
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
     *     The zip
     */
    @JsonProperty("zip")
    public String getZip() {
        return zip;
    }

    /**
     * 
     * @param zip
     *     The zip
     */
    @JsonProperty("zip")
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * 
     * @return
     *     The address
     */
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
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
        return new HashCodeBuilder().append(venueId).append(country).append(name).append(city).append(state).append(capacity).append(surface).append(type).append(zip).append(address).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Venue) == false) {
            return false;
        }
        Venue rhs = ((Venue) other);
        return new EqualsBuilder().append(venueId, rhs.venueId).append(country, rhs.country).append(name, rhs.name).append(city, rhs.city).append(state, rhs.state).append(capacity, rhs.capacity).append(surface, rhs.surface).append(type, rhs.type).append(zip, rhs.zip).append(address, rhs.address).append(additionalProperties, rhs.additionalProperties).isEquals();
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
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
