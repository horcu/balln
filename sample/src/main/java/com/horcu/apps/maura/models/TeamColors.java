
package com.horcu.apps.maura.models;

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
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "primary_color",
    "secondary_color",
    "tertiary_color"
})

//@DatabaseTable(tableName="TeamColors")
public class TeamColors extends SugarRecord<TeamColors> implements Parcelable
{

    public TeamColors(){}

   // @DatabaseField(columnName = "primary_color")
    @JsonProperty("primary_color")
    private String primaryColor;

    //@DatabaseField(columnName = "secondary_color")
    @JsonProperty("secondary_color")
    private String secondaryColor;

  //  @DatabaseField(columnName = "tertiary_color")
    @JsonProperty("tertiary_color")
    private String tertiaryColor;

    @Ignore
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<TeamColors> CREATOR = new Creator<TeamColors>() {


        public TeamColors createFromParcel(Parcel in) {
            TeamColors instance = new TeamColors();
            instance.primaryColor = ((String) in.readValue((String.class.getClassLoader())));
            instance.secondaryColor = ((String) in.readValue((String.class.getClassLoader())));
            instance.tertiaryColor = ((String) in.readValue((String.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public TeamColors[] newArray(int size) {
            return (new TeamColors[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The primaryColor
     */
    @JsonProperty("primary_color")
    public String getPrimaryColor() {
        return primaryColor;
    }

    /**
     * 
     * @param primaryColor
     *     The primary_color
     */
    @JsonProperty("primary_color")
    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    /**
     * 
     * @return
     *     The secondaryColor
     */
    @JsonProperty("secondary_color")
    public String getSecondaryColor() {
        return secondaryColor;
    }

    /**
     * 
     * @param secondaryColor
     *     The secondary_color
     */
    @JsonProperty("secondary_color")
    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    /**
     * 
     * @return
     *     The tertiaryColor
     */
    @JsonProperty("tertiary_color")
    public String getTertiaryColor() {
        return tertiaryColor;
    }

    /**
     * 
     * @param tertiaryColor
     *     The tertiary_color
     */
    @JsonProperty("tertiary_color")
    public void setTertiaryColor(String tertiaryColor) {
        this.tertiaryColor = tertiaryColor;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(primaryColor).append(secondaryColor).append(tertiaryColor).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TeamColors) == false) {
            return false;
        }
        TeamColors rhs = ((TeamColors) other);
        return new EqualsBuilder().append(primaryColor, rhs.primaryColor).append(secondaryColor, rhs.secondaryColor).append(tertiaryColor, rhs.tertiaryColor).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(primaryColor);
        dest.writeValue(secondaryColor);
        dest.writeValue(tertiaryColor);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
