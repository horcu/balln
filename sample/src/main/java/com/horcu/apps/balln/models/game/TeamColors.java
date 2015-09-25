
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
import org.apache.commons.lang.builder.ToStringBuilder;

import ollie.Model;
import ollie.annotation.Column;
import ollie.annotation.PrimaryKey;
import ollie.annotation.Table;


public class TeamColors extends Model implements Parcelable
{
public TeamColors(){}


    public Long id;

    public String primaryColor;

    public String secondaryColor;

    public String tertiaryColor;

    public final static Creator<TeamColors> CREATOR = new Creator<TeamColors>() {


        public TeamColors createFromParcel(Parcel in) {
            TeamColors instance = new TeamColors();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.primaryColor = ((String) in.readValue((String.class.getClassLoader())));
            instance.secondaryColor = ((String) in.readValue((String.class.getClassLoader())));
            instance.tertiaryColor = ((String) in.readValue((String.class.getClassLoader())));

            //instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public TeamColors[] newArray(int size) {
            return (new TeamColors[size]);
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
     *     The primaryColor
     */

    public String getPrimaryColor() {
        return primaryColor;
    }

    /**
     * 
     * @param primaryColor
     *     The primary_color
     */

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    /**
     * 
     * @return
     *     The secondaryColor
     */

    public String getSecondaryColor() {
        return secondaryColor;
    }

    /**
     * 
     * @param secondaryColor
     *     The secondary_color
     */

    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    /**
     * 
     * @return
     *     The tertiaryColor
     */

    public String getTertiaryColor() {
        return tertiaryColor;
    }

    /**
     * 
     * @param tertiaryColor
     *     The tertiary_color
     */

    public void setTertiaryColor(String tertiaryColor) {
        this.tertiaryColor = tertiaryColor;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(primaryColor);
        dest.writeValue(secondaryColor);
        dest.writeValue(tertiaryColor);
       // dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
