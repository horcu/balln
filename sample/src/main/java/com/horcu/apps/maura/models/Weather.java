
package com.horcu.apps.maura.models;

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
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "temperature",
    "condition",
    "humidity",
    "wind"
})
public class Weather implements Parcelable
{

    @JsonProperty("temperature")
    private Integer temperature;
    @JsonProperty("condition")
    private String condition;
    @JsonProperty("humidity")
    private Integer humidity;
    @JsonProperty("wind")
    private Wind wind;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Weather> CREATOR = new Creator<Weather>() {


        public Weather createFromParcel(Parcel in) {
            Weather instance = new Weather();
            instance.temperature = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.condition = ((String) in.readValue((String.class.getClassLoader())));
            instance.humidity = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.wind = ((Wind) in.readValue((Wind.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Weather[] newArray(int size) {
            return (new Weather[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The temperature
     */
    @JsonProperty("temperature")
    public Integer getTemperature() {
        return temperature;
    }

    /**
     * 
     * @param temperature
     *     The temperature
     */
    @JsonProperty("temperature")
    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    /**
     * 
     * @return
     *     The condition
     */
    @JsonProperty("condition")
    public String getCondition() {
        return condition;
    }

    /**
     * 
     * @param condition
     *     The condition
     */
    @JsonProperty("condition")
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * 
     * @return
     *     The humidity
     */
    @JsonProperty("humidity")
    public Integer getHumidity() {
        return humidity;
    }

    /**
     * 
     * @param humidity
     *     The humidity
     */
    @JsonProperty("humidity")
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    /**
     * 
     * @return
     *     The wind
     */
    @JsonProperty("wind")
    public Wind getWind() {
        return wind;
    }

    /**
     * 
     * @param wind
     *     The wind
     */
    @JsonProperty("wind")
    public void setWind(Wind wind) {
        this.wind = wind;
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
        return new HashCodeBuilder().append(temperature).append(condition).append(humidity).append(wind).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Weather) == false) {
            return false;
        }
        Weather rhs = ((Weather) other);
        return new EqualsBuilder().append(temperature, rhs.temperature).append(condition, rhs.condition).append(humidity, rhs.humidity).append(wind, rhs.wind).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(temperature);
        dest.writeValue(condition);
        dest.writeValue(humidity);
        dest.writeValue(wind);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
