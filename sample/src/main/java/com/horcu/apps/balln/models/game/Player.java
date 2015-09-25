
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

public class Player extends Model implements Parcelable
{
    public Player(){}

    public Long id;


    public String name;

    public Integer jerseyNumber;

    public String status;


    public Long depth;


    public final static Creator<Player> CREATOR = new Creator<Player>() {


        public Player createFromParcel(Parcel in) {
            Player instance = new Player();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.jerseyNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            instance.depth = ((Long) in.readValue((Long.class.getClassLoader())));
           // instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
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
     *     The jerseyNumber
     */

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    /**
     * 
     * @param jerseyNumber
     *     The jersey_number
     */

    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    /**
     * 
     * @return
     *     The status
     */

    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The depth
     */

    public Long getDepth() {
        return depth;
    }

    /**
     * 
     * @param depth
     *     The depth
     */

    public void setDepth(Long depth) {
        this.depth = depth;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(jerseyNumber);
        dest.writeValue(status);
        dest.writeValue(depth);
       // dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
