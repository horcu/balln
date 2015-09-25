
package com.horcu.apps.balln.models.league;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
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

public class ConferenceDivision extends Model implements Parcelable
{
    public ConferenceDivision(){}

    public Long id;

    public String conferenceId;

    public String divisionId;


    public final static Creator<ConferenceDivision> CREATOR = new Creator<ConferenceDivision>() {

        public ConferenceDivision createFromParcel(Parcel in) {
            ConferenceDivision instance = new ConferenceDivision();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.conferenceId = ((String) in.readValue((String.class.getClassLoader())));
            instance.divisionId = ((String) in.readValue((String.class.getClassLoader())));
          //  instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public ConferenceDivision[] newArray(int size) {
            return (new ConferenceDivision[size]);
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
     *     The conferenceId
     */

    public String getConferenceId() {
        return conferenceId;
    }

    /**
     * 
     * @param conferenceId
     *     The conferenceId
     */

    public void setConferenceId(String conferenceId) {
        this.conferenceId = conferenceId;
    }

    /**
     * 
     * @return
     *     The divisionId
     */

    public String getDivisionId() {
        return divisionId;
    }

    /**
     * 
     * @param divisionId
     *     The divisionId
     */

    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(conferenceId);
        dest.writeValue(divisionId);
       // dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
