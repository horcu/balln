
package com.horcu.apps.balln.models.league;

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
import com.horcu.apps.balln.models.game.Venue;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "name",
    "market",
    "team_colors",
    "venueId"
})
@ModelContainer
@Table(databaseName = horcuDatabase.NAME)
public class Team extends BaseModel implements Parcelable
{

    public Team(){}

    @PrimaryKey(autoincrement = false)
    @Column
    @JsonProperty("id")
    private String id;

    @Column
    @JsonProperty("name")
    private String name;

    @Column
    @JsonProperty("market")
    private String market;

    @Column
    @JsonProperty("team_colorsId")
    private Long teamColorsId;

    @Column
    @JsonProperty("venueId")
    private String venueId;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Team> CREATOR = new Creator<Team>() {


        public Team createFromParcel(Parcel in) {
            Team instance = new Team();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.market = ((String) in.readValue((String.class.getClassLoader())));
            instance.teamColorsId = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.venueId = ((String) in.readValue((String.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Team[] newArray(int size) {
            return (new Team[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The market
     */
    @JsonProperty("market")
    public String getMarket() {
        return market;
    }

    /**
     * 
     * @param market
     *     The market
     */
    @JsonProperty("market")
    public void setMarket(String market) {
        this.market = market;
    }

    /**
     * 
     * @return
     *     The teamColorsId
     */
    @JsonProperty("team_colorsId")
    public Long getTeamColorsId() {
        return teamColorsId;
    }

    /**
     * 
     * @param teamColorsId
     *     The team_colors
     */
    @JsonProperty("team_colorsId")
    public void setTeamColorsId(Long teamColorsId) {
        this.teamColorsId = teamColorsId;
    }

    /**
     * 
     * @return
     *     The venueId
     */
    @JsonProperty("venueId")
    public String getVenueId() {
        return venueId;
    }

    /**
     * 
     * @param venueId
     *     The venueId
     */
    @JsonProperty("venueId")
    public void setVenueId(String venueId) {
        this.venueId = venueId;
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
        return new HashCodeBuilder().append(id).append(name).append(market).append(teamColorsId).append(venueId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Team) == false) {
            return false;
        }
        Team rhs = ((Team) other);
        return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(market, rhs.market).append(teamColorsId, rhs.teamColorsId).append(venueId, rhs.venueId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(market);
        dest.writeValue(teamColorsId);
        dest.writeValue(venueId);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
