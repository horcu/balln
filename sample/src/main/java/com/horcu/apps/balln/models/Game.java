
package com.horcu.apps.balln.models;

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
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import rx.Observable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "scheduled",
    "home_rotation",
    "away_rotation",
    "home_team",
    "away_team",
    "venue",
    "broadcast",
    "weather"
})
public class Game   implements Parcelable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("scheduled")
    private String scheduled;
    @JsonProperty("home_rotation")
    private String homeRotation;
    @JsonProperty("away_rotation")
    private String awayRotation;
    @JsonProperty("home_team")
    private HomeTeam homeTeam;
    @JsonProperty("away_team")
    private AwayTeam awayTeam;
    @JsonProperty("venue")
    private Venue venue;
    @JsonProperty("broadcast")
    private Broadcast broadcast;
    @JsonProperty("weather")
    private Weather weather;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Game> CREATOR = new Creator<Game>() {


        public Game createFromParcel(Parcel in) {
            Game instance = new Game();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.scheduled = ((String) in.readValue((String.class.getClassLoader())));
            instance.homeRotation = ((String) in.readValue((String.class.getClassLoader())));
            instance.awayRotation = ((String) in.readValue((String.class.getClassLoader())));
            instance.homeTeam = ((HomeTeam) in.readValue((HomeTeam.class.getClassLoader())));
            instance.awayTeam = ((AwayTeam) in.readValue((AwayTeam.class.getClassLoader())));
            instance.venue = ((Venue) in.readValue((Venue.class.getClassLoader())));
            instance.broadcast = ((Broadcast) in.readValue((Broadcast.class.getClassLoader())));
            instance.weather = ((Weather) in.readValue((Weather.class.getClassLoader())));
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
     *     The homeTeam
     */
    @JsonProperty("home_team")
    public HomeTeam getHomeTeam() {
        return homeTeam;
    }

    /**
     * 
     * @param homeTeam
     *     The home_team
     */
    @JsonProperty("home_team")
    public void setHomeTeam(HomeTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    /**
     * 
     * @return
     *     The awayTeam
     */
    @JsonProperty("away_team")
    public AwayTeam getAwayTeam() {
        return awayTeam;
    }

    /**
     * 
     * @param awayTeam
     *     The away_team
     */
    @JsonProperty("away_team")
    public void setAwayTeam(AwayTeam awayTeam) {
        this.awayTeam = awayTeam;
    }

    /**
     * 
     * @return
     *     The venue
     */
    @JsonProperty("venue")
    public Venue getVenue() {
        return venue;
    }

    /**
     * 
     * @param venue
     *     The venue
     */
    @JsonProperty("venue")
    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    /**
     * 
     * @return
     *     The broadcast
     */
    @JsonProperty("broadcast")
    public Broadcast getBroadcast() {
        return broadcast;
    }

    /**
     * 
     * @param broadcast
     *     The broadcast
     */
    @JsonProperty("broadcast")
    public void setBroadcast(Broadcast broadcast) {
        this.broadcast = broadcast;
    }

    /**
     * 
     * @return
     *     The weather
     */
    @JsonProperty("weather")
    public Weather getWeather() {
        return weather;
    }

    /**
     * 
     * @param weather
     *     The weather
     */
    @JsonProperty("weather")
    public void setWeather(Weather weather) {
        this.weather = weather;
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
        return new HashCodeBuilder().append(id).append(scheduled).append(homeRotation).append(awayRotation).append(homeTeam).append(awayTeam).append(venue).append(broadcast).append(weather).append(additionalProperties).toHashCode();
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
        return new EqualsBuilder().append(id, rhs.id).append(scheduled, rhs.scheduled).append(homeRotation, rhs.homeRotation).append(awayRotation, rhs.awayRotation).append(homeTeam, rhs.homeTeam).append(awayTeam, rhs.awayTeam).append(venue, rhs.venue).append(broadcast, rhs.broadcast).append(weather, rhs.weather).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(scheduled);
        dest.writeValue(homeRotation);
        dest.writeValue(awayRotation);
        dest.writeValue(homeTeam);
        dest.writeValue(awayTeam);
        dest.writeValue(venue);
        dest.writeValue(broadcast);
        dest.writeValue(weather);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
