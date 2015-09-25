
package com.horcu.apps.balln.models.league;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;


import ollie.Model;
import ollie.annotation.Column;
import ollie.annotation.PrimaryKey;
import ollie.annotation.Table;

public class Division extends Model implements Parcelable
{
    public Division(){}


    public Long id;

    public String name;

    public String teamDivisionId ;

    public final static Creator<Division> CREATOR = new Creator<Division>() {


        public Division createFromParcel(Parcel in) {
            Division instance = new Division();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.teamDivisionId = ((String) in.readValue((String.class.getClassLoader())));
           // instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Division[] newArray(int size) {
            return (new Division[size]);
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
     *     The teamDivisionId
     */

    public String getTeamDivisionId() {
        return teamDivisionId;
    }

    /**
     * 
     * @param teamDivisionId
     *     The teamDivisionId
     */

    public void setTeamDivisionId(String teamDivisionId) {
        this.teamDivisionId = teamDivisionId;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeString(teamDivisionId);
      //  dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
