
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
   // "id",
    "name",
    "market",
    "logo",
    "team_colors",
    "offense",
    "defense",
    "special_teams"
})

//@DatabaseTable(tableName="HomeTeam")
public class HomeTeam extends SugarRecord<HomeTeam> implements Parcelable
{
public HomeTeam(){}
//
//    @DatabaseField(columnName = "id")
//    @JsonProperty("id")
//    private String id;

   // @DatabaseField(columnName = "name")
    @JsonProperty("name")
    private String name;

   // @DatabaseField(columnName = "market")
    @JsonProperty("market")
    private String market;

   // @DatabaseField(columnName = "logo")
    @JsonProperty("logo")
    private String logo;

  //  @DatabaseField(columnName = "team_colors", foreign = true)
    @JsonProperty("team_colors")
    private TeamColors teamColors;

  //  @DatabaseField(columnName = "offense", foreign = true)
    @JsonProperty("offense")
    private Offense offense;

 //   @DatabaseField(columnName = "defense", foreign = true)
    @JsonProperty("defense")
    private Defense defense;

  //  @DatabaseField(columnName = "special_teams", foreign = true)
    @JsonProperty("special_teams")
    private SpecialTeams specialTeams;

    @Ignore
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<HomeTeam> CREATOR = new Creator<HomeTeam>() {


        public HomeTeam createFromParcel(Parcel in) {
            HomeTeam instance = new HomeTeam();
//            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.market = ((String) in.readValue((String.class.getClassLoader())));
            instance.logo = ((String) in.readValue((String.class.getClassLoader())));
            instance.teamColors = ((TeamColors) in.readValue((TeamColors.class.getClassLoader())));
            instance.offense = ((Offense) in.readValue((Offense.class.getClassLoader())));
            instance.defense = ((Defense) in.readValue((Defense.class.getClassLoader())));
            instance.specialTeams = ((SpecialTeams) in.readValue((SpecialTeams.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public HomeTeam[] newArray(int size) {
            return (new HomeTeam[size]);
        }

    }
    ;

//    /**
//     *
//     * @return
//     *     The id
//     */
//    @JsonProperty("id")
//    public String getId() {
//        return id;
//    }

//    /**
//     *
//     * @param id
//     *     The id
//     */
//    @JsonProperty("id")
//    public void setId(String id) {
//        this.id = id;
//    }

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
     *     The logo
     */
    @JsonProperty("logo")
    public String getLogo() {
        return logo;
    }

    /**
     * 
     * @param logo
     *     The logo
     */
    @JsonProperty("logo")
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     *
     * @param team colors
     *     team colors
     */
    @JsonProperty("team_colors")
    public TeamColors getTeamColors() {
        return teamColors;
    }

    /**
     *
     * @param team colors
     *     team colors
     */
    @JsonProperty("team_colors")
    public void setTeamColors(TeamColors teamColors) {
        this.teamColors = teamColors;
    }

    /**
     * 
     * @return
     *     The offense
     */
    @JsonProperty("offense")
    public Offense getOffense() {
        return offense;
    }

    /**
     * 
     * @param offense
     *     The offense
     */
    @JsonProperty("offense")
    public void setOffense(Offense offense) {
        this.offense = offense;
    }

    /**
     * 
     * @return
     *     The defense
     */
    @JsonProperty("defense")
    public Defense getDefense() {
        return defense;
    }

    /**
     * 
     * @param defense
     *     The defense
     */
    @JsonProperty("defense")
    public void setDefense(Defense defense) {
        this.defense = defense;
    }

    /**
     * 
     * @return
     *     The specialTeams
     */
    @JsonProperty("special_teams")
    public SpecialTeams getSpecialTeams() {
        return specialTeams;
    }

    /**
     * 
     * @param specialTeams
     *     The special_teams
     */
    @JsonProperty("special_teams")
    public void setSpecialTeams(SpecialTeams specialTeams) {
        this.specialTeams = specialTeams;
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
        return new HashCodeBuilder().append(id).append(name).append(market).append(logo).append(teamColors).append(offense).append(defense).append(specialTeams).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HomeTeam) == false) {
            return false;
        }
        HomeTeam rhs = ((HomeTeam) other);
        return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(market, rhs.market).append(logo, rhs.logo).append(teamColors, rhs.teamColors).append(offense, rhs.offense).append(defense, rhs.defense).append(specialTeams, rhs.specialTeams).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
       // dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(market);
        dest.writeValue(logo);
        dest.writeValue(teamColors);
        dest.writeValue(offense);
        dest.writeValue(defense);
        dest.writeValue(specialTeams);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
