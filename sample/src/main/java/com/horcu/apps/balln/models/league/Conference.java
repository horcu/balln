
package com.horcu.apps.balln.models.league;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import org.apache.commons.lang.builder.ToStringBuilder;

import ollie.Model;
import ollie.annotation.Column;
import ollie.annotation.PrimaryKey;


public class Conference extends Model implements Parcelable
{
    public Conference(){}

    public Long id;

    public String name;

    public Long conferenceDivisionId ;


    public final static Creator<Conference> CREATOR = new Creator<Conference>() {


        public Conference createFromParcel(Parcel in) {
            Conference instance = new Conference();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.conferenceDivisionId = ((Long) in.readValue((Long.class.getClassLoader())));
           // instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Conference[] newArray(int size) {
            return (new Conference[size]);
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
     *     The conferenceDivisionId
     */

    public Long getConferenceDivisionId() {
        return conferenceDivisionId;
    }

    /**
     * 
     * @param conferenceDivisionId
     *     The conferenceDivisionId
     */

    public void setConferenceDivisionId(Long conferenceDivisionId) {
        this.conferenceDivisionId = conferenceDivisionId;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeLong(conferenceDivisionId);
     //   dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
