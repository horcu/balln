
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
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "scheduled",
    "home_rotation",
    "away_rotation",
    "home_team",
    "away_team",
    "venueId",
    "broadcastId",
    "weatherId"
})

@ModelContainer
@Table(databaseName = horcuDatabase.NAME)
public class Game extends BaseModel implements Parcelable
{

    public Game(){}

    @Column
    @PrimaryKey(autoincrement = false)
    @JsonProperty("id")
    public String id;

    @Column
    @JsonProperty("scheduled")
    private String scheduled;

    @Column
    @JsonProperty("home_rotation")
    private String homeRotation;

    @Column
    @JsonProperty("away_rotation")
    private String awayRotation;

    @Column
    @JsonProperty("home_teamId")
//    @ForeignKey(
//            references = {@ForeignKeyReference(columnName = "home_team",
//                    columnType = Long.class,
//                    foreignColumnName = "id")},
//            saveForeignKeyModel = true)
    private Long homeTeamId;

    @Column(name = "away_teamId")
    @JsonProperty("away_teamId")
//    @ForeignKey(
//            references = {@ForeignKeyReference(columnName = "away_team",
//                    columnType = Long.class,
//                    foreignColumnName = "id")},
//            saveForeignKeyModel = true)
    private Long awayTeamId;

    @Column
    @JsonProperty("venueId")
//    @ForeignKey(
//            references = {@ForeignKeyReference(columnName = "venueId",
//                    columnType = Long.class,
//                    foreignColumnName = "id")},
//            saveForeignKeyModel = true)
    private String venueId;

    @Column
    @JsonProperty("broadcastId")
//    @ForeignKey(
//            references = {@ForeignKeyReference(columnName = "broadcastId",
//                    columnType = Long.class,
//                    foreignColumnName = "id")},
//            saveForeignKeyModel = true)
    private Long broadcastId;

    @Column
    @JsonProperty("weatherId")
//    @ForeignKey(
//            references = {@ForeignKeyReference(columnName = "weatherId",
//                    columnType = Long.class,
//                    foreignColumnName = "id")},
//            saveForeignKeyModel = true)
    private Long weatherId;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Game> CREATOR = new Creator<Game>() {


        public Game createFromParcel(Parcel in) {
            Game instance = new Game();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.scheduled = ((String) in.readValue((String.class.getClassLoader())));
            instance.homeRotation = ((String) in.readValue((String.class.getClassLoader())));
            instance.awayRotation = ((String) in.readValue((String.class.getClassLoader())));
            instance.homeTeamId = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.awayTeamId = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.venueId = ((String) in.readValue((String.class.getClassLoader())));
            instance.broadcastId = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.weatherId = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Game[] newArray(int size) {
            return (new Game[size]);
        }
    };

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
     *     The scheduled
     */
    @JsonProperty("scheduled")
    public String getScheduled() {
        return scheduled;
    }

    /**
     * 
     * @param scheduled
     *     The scheduled
     */
    @JsonProperty("scheduled")
    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    /**
     * 
     * @return
     *     The homeRotation
     */
    @JsonProperty("home_rotation")
    public String getHomeRotation() {
        return homeRotation;
    }

    /**
     * 
     * @param homeRotation
     *     The home_rotation
     */
    @JsonProperty("home_rotation")
    public void setHomeRotation(String homeRotation) {
        this.homeRotation = homeRotation;
    }

    /**
     * 
     * @return
     *     The awayRotation
     */
    @JsonProperty("away_rotation")
    public String getAwayRotation() {
        return awayRotation;
    }

    /**
     * 
     * @param awayRotation
     *     The away_rotation
     */
    @JsonProperty("away_rotation")
    public void setAwayRotation(String awayRotation) {
        this.awayRotation = awayRotation;
    }

    /**
     * 
     * @return
     *     The homeTeamId
     */
    @JsonProperty("home_teamId")
    public Long getHomeTeamId() {
        return homeTeamId;
    }

    /**
     * 
     * @param homeTeamId
     *     The home_team
     */
    @JsonProperty("home_teamId")
    public void setHomeTeamId(Long homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    /**
     * 
     * @return
     *     The awayTeamId
     */
    @JsonProperty("away_teamId")
    public Long getAwayTeamId() {
        return awayTeamId;
    }

    /**
     * 
     * @param awayTeamId
     *     The away_team
     */
    @JsonProperty("away_teamId")
    public void setAwayTeamId(Long awayTeamId) {
        this.awayTeamId = awayTeamId;
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

    /**
     * 
     * @return
     *     The broadcastId
     */
    @JsonProperty("broadcastId")
    public Long getBroadcastId() {
        return broadcastId;
    }

    /**
     * 
     * @param broadcastId
     *     The broadcastId
     */
    @JsonProperty("broadcastId")
    public void setBroadcastId(Long broadcastId) {
        this.broadcastId = broadcastId;
    }

    /**
     * 
     * @return
     *     The weatherId
     */
    @JsonProperty("weatherId")
    public Long getWeatherId() {
        return weatherId;
    }

    /**
     * 
     * @param weatherId
     *     The weatherId
     */
    @JsonProperty("weatherId")
    public void setWeatherId(Long weatherId) {
        this.weatherId = weatherId;
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
        return new HashCodeBuilder().append(id).append(scheduled).append(homeRotation).append(awayRotation).append(homeTeamId).append(awayTeamId).append(venueId).append(broadcastId).append(weatherId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Game) == false) {
            return false;
        }
        Game rhs = ((Game) other);
        return new EqualsBuilder().append(id, rhs.id).append(scheduled, rhs.scheduled).append(homeRotation, rhs.homeRotation).append(awayRotation, rhs.awayRotation).append(homeTeamId, rhs.homeTeamId).append(awayTeamId, rhs.awayTeamId).append(venueId, rhs.venueId).append(broadcastId, rhs.broadcastId).append(weatherId, rhs.weatherId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(scheduled);
        dest.writeValue(homeRotation);
        dest.writeValue(awayRotation);
        dest.writeValue(homeTeamId);
        dest.writeValue(awayTeamId);
        dest.writeValue(venueId);
        dest.writeValue(broadcastId);
        dest.writeValue(weatherId);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }
}
