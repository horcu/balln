
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

public class Defense extends Model implements Parcelable
{
    public Defense(){}

    public Long id;

   public String type;

    public String playerPositionId;

    public final static Creator<Defense> CREATOR = new Creator<Defense>() {


        public Defense createFromParcel(Parcel in) {
            Defense instance = new Defense();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.playerPositionId = ((String) in.readValue((String.class.getClassLoader())));
            //instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Defense[] newArray(int size) {
            return (new Defense[size]);
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
        dest.writeValue(id);
        dest.writeValue(type);
        dest.writeString(playerPositionId);
        //dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
