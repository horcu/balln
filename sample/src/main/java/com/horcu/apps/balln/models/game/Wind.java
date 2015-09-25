
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

public class Wind extends Model implements Parcelable
{
    public Wind(){}

    public Long id;

    public Integer speed;

    public String direction;

    public final static Creator<Wind> CREATOR = new Creator<Wind>() {

        public Wind createFromParcel(Parcel in) {
            Wind instance = new Wind();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.speed = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.direction = ((String) in.readValue((String.class.getClassLoader())));
          //  instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Wind[] newArray(int size) {
            return (new Wind[size]);
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
     *     The speed
     */

    public Integer getSpeed() {
        return speed;
    }

    /**
     * 
     * @param speed
     *     The speed
     */

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    /**
     * 
     * @return
     *     The direction
     */

    public String getDirection() {
        return direction;
    }

    /**
     * 
     * @param direction
     *     The direction
     */

    public void setDirection(String direction) {
        this.direction = direction;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(speed);
        dest.writeValue(direction);
       // dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
