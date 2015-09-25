
package com.horcu.apps.balln.models.game;

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

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import ollie.Model;
import ollie.annotation.Column;
import ollie.annotation.PrimaryKey;


public class SpecialTeams extends Model implements Parcelable {
    public SpecialTeams(){}

    public Long id;

    public String playerPositionId;

    public final static Creator<SpecialTeams> CREATOR = new Creator<SpecialTeams>() {


        public SpecialTeams createFromParcel(Parcel in) {
            SpecialTeams instance = new SpecialTeams();
            in.readLong();
            in.readLong();
           // instance.additionalProperties = ((Map<String, Object>) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public SpecialTeams[] newArray(int size) {
            return (new SpecialTeams[size]);
        }

    };


    public Long getId()
    {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The positions
     */

    public String getPlayerPositionId() {
        return playerPositionId;
    }

    /**
     *

     *     The positions
     */

    public void setPlayerPositionId(String playerPositionId) {
        this.playerPositionId = playerPositionId;
    }




    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(playerPositionId);
      //  dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
