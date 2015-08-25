
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
import com.horcu.apps.balln.models.league.Team;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "abbr",
    "name",
    "market",
    "logo",
    "team_colors",
    "offenseId",
    "defenseId",
    "special_teams"
})

@ModelContainer
@Table(databaseName = horcuDatabase.NAME)
public class AwayTeam extends BaseModel implements Parcelable
{

    public AwayTeam(){}

    @JsonProperty("id")
    @Column
    @PrimaryKey(autoincrement = true)
    public Long id;

    @Column
    @JsonProperty("abbr")
    private String abbr;

    @Column
    @JsonProperty("name")
    private String name;

    @Column
    @JsonProperty("market")
    private String market;

    @Column
    @JsonProperty("logo")
    private String logo;

    @Column(name = "team_colorsId")
    @JsonProperty("team_colorsId")
//    @ForeignKey(
//            references = {@ForeignKeyReference(columnName = "team_colors",
//                    columnType = Long.class,
//                    foreignColumnName = "id")},
//            saveForeignKeyModel = true)
    private Long teamColorsId;

   @Column
    @JsonProperty("offenseId")
//   @ForeignKey(
//           references = {@ForeignKeyReference(columnName = "offenseId",
//                   columnType = Long.class,
//                   foreignColumnName = "id")},
//           saveForeignKeyModel = true)
    private Long offenseId;

    @Column
    @JsonProperty("defenseId")
//    @ForeignKey(
//            references = {@ForeignKeyReference(columnName = "defenseId",
//                    columnType = Long.class,
//                    foreignColumnName = "id")},
//            saveForeignKeyModel = true)
    private Long defenseId;

    @Column(name ="special_teamsId")
    @JsonProperty("special_teamsId")
//    @ForeignKey(
//            references = {@ForeignKeyReference(columnName = "special_teams",
//                    columnType = Long.class,
//                    foreignColumnName = "id")},
//            saveForeignKeyModel = true)
    public Long specialTeamsId;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<AwayTeam> CREATOR = new Creator<AwayTeam>() {


        public AwayTeam createFromParcel(Parcel in) {
            AwayTeam instance = new AwayTeam();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.abbr = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.market = ((String) in.readValue((String.class.getClassLoader())));
            instance.logo = ((String) in.readValue((String.class.getClassLoader())));
            instance.teamColorsId = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.offenseId = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.defenseId = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.specialTeamsId = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public AwayTeam[] newArray(int size) {
            return (new AwayTeam[size]);
        }

    }
    ;

    /**
     *
     * @return
     *     The id
     */
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The id
     */
    @JsonProperty("abbr")
    public String getAbbr() {
        return abbr;
    }

    /**
     *
     * @param id
     *     The id
     */
    @JsonProperty("abbr")
    public void setAbbr(String abbr) {
        this.abbr = abbr;
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
    @JsonProperty("team_colorsId")
    public Long getTeamColorsId() {
        return teamColorsId;
    }

    /**
     *
     * @param team colors
     *     team colors
     */
    @JsonProperty("team_colorsId")
    public void setTeamColorsId(Long teamColorsId) {
        this.teamColorsId = teamColorsId;
    }
    /**
     * 
     * @return
     *     The offenseId
     */
    @JsonProperty("offenseId")
    public Long getOffenseId() {
        return offenseId;
    }

    /**
     * 
     * @param offenseId
     *     The offenseId
     */
    @JsonProperty("offenseId")
    public void setOffenseId(Long offenseId) {
        this.offenseId = offenseId;
    }

    /**
     * 
     * @return
     *     The defenseId
     */
    @JsonProperty("defenseId")
    public Long getDefenseId() {
        return defenseId;
    }

    /**
     * 
     * @param defenseId
     *     The defenseId
     */
    @JsonProperty("defenseId")
    public void setDefenseId(Long defenseId) {
        this.defenseId = defenseId;
    }

    /**
     * 
     * @return
     *     The specialTeamsId
     */
    @JsonProperty("special_teamsId")
    public Long getSpecialTeamsId() {
        return specialTeamsId;
    }

    /**
     * 
     * @param specialTeamsId
     *     The special_teams
     */
    @JsonProperty("special_teamsId")
    public void setSpecialTeamsId(Long specialTeamsId) {
        this.specialTeamsId = specialTeamsId;
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
        return new HashCodeBuilder().append(id).append(abbr).append(name).append(market).append(logo).append(teamColorsId).append(offenseId).append(defenseId).append(specialTeamsId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AwayTeam) == false) {
            return false;
        }
        AwayTeam rhs = ((AwayTeam) other);
        return new EqualsBuilder().append(id, rhs.id).append(abbr, rhs.abbr).append(name, rhs.name).append(market, rhs.market).append(logo, rhs.logo).append(teamColorsId, rhs.teamColorsId).append(offenseId, rhs.offenseId).append(defenseId, rhs.defenseId).append(specialTeamsId, rhs.specialTeamsId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(abbr);
        dest.writeValue(name);
        dest.writeValue(market);
        dest.writeValue(logo);
        dest.writeValue(teamColorsId);
        dest.writeValue(offenseId);
        dest.writeValue(defenseId);
        dest.writeValue(specialTeamsId);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
