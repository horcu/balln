
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
import ollie.annotation.Unique;


public class Position extends Model implements Parcelable
{

    public Position(){}

    public Long id;

    public String name;


    public String desc;


    public final static Creator<Position> CREATOR = new Creator<Position>() {


        public Position createFromParcel(Parcel in) {
            Position instance = new Position();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.desc = ((String) in.readValue((String.class.getClassLoader())));
          //  instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Position[] newArray(int size) {
            return (new Position[size]);
        }

    }
    ;

    /**
     *
     * @return
     *     The positions
     */

    public Long getPositionId() {
        return id;
    }

    /**
     *
    // * @param positions
     *     The positions
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
     *     The desc
     */

    public String getDesc() {
        return desc;
    }

    /**
     * 
     * @param desc
     *     The desc
     */

    public void setDesc(String desc) {
        this.desc = desc;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(desc);
     //   dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
