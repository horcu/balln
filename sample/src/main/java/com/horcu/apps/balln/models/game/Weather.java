
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


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ollie.Model;
import ollie.annotation.Column;
import ollie.annotation.PrimaryKey;
import ollie.annotation.Table;


public class Weather extends Model implements Parcelable
{

    public Weather(){}

    public Long id;

    public Integer temperature;

    public String condition;

    public Integer humidity;

    public Long windId;

    public final static Creator<Weather> CREATOR = new Creator<Weather>() {


        public Weather createFromParcel(Parcel in) {
            Weather instance = new Weather();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.temperature = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.condition = ((String) in.readValue((String.class.getClassLoader())));
            instance.humidity = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.windId = ((Long) in.readValue((Long.class.getClassLoader())));
          //  instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Weather[] newArray(int size) {
            return (new Weather[size]);
        }

    }
    ;

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The temperature
     */

    public Integer getTemperature() {
        return temperature;
    }

    /**
     * 
     * @param temperature
     *     The temperature
     */

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    /**
     * 
     * @return
     *     The condition
     */

    public String getCondition() {
        return condition;
    }

    /**
     * 
     * @param condition
     *     The condition
     */

    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * 
     * @return
     *     The humidity
     */

    public Integer getHumidity() {
        return humidity;
    }

    /**
     * 
     * @param humidity
     *     The humidity
     */

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    /**
     * 
     * @return
     *     The windId
     */

    public Long getWindId() {
        return windId;
    }

    /**
     * 
     * @param windId
     *     The windId
     */

    public void setWindId(Long windId) {
        this.windId = windId;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(temperature);
        dest.writeValue(condition);
        dest.writeValue(humidity);
        dest.writeValue(windId);
        //dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
