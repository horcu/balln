
package com.horcu.apps.balln.models.game;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonProperty;
import ollie.Model;
import ollie.annotation.Column;
import ollie.annotation.PrimaryKey;
import ollie.annotation.Table;

public class AwayTeam extends Model implements Parcelable
{

    public AwayTeam(){}



    public Long id;


    public  String abbr;


    public String name;


    public String market;


    public String logo;


    public Long teamColorsId;


   public Long offenseId;


    public Long defenseId;


    public Long specialTeamsId;


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
     *     The id
     */

    public String getAbbr() {
        return abbr;
    }

    /**
     *
     *     The id
     */

    public void setAbbr(String abbr) {
        this.abbr = abbr;
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
     *     The market
     */

    public String getMarket() {
        return market;
    }

    /**
     * 
     * @param market
     *     The market
     */

    public void setMarket(String market) {
        this.market = market;
    }

    /**
     * 
     * @return
     *     The logo
     */

    public String getLogo() {
        return logo;
    }

    /**
     * 
     * @param logo
     *     The logo
     */

    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     *
     *     team colors
     */

    public Long getTeamColorsId() {
        return teamColorsId;
    }

    /**
     *
     *     team colors
     */

    public void setTeamColorsId(Long teamColorsId) {
        this.teamColorsId = teamColorsId;
    }
    /**
     * 
     * @return
     *     The offenseId
     */

    public Long getOffenseId() {
        return offenseId;
    }

    /**
     * 
     * @param offenseId
     *     The offenseId
     */

    public void setOffenseId(Long offenseId) {
        this.offenseId = offenseId;
    }

    /**
     * 
     * @return
     *     The defenseId
     */

    public Long getDefenseId() {
        return defenseId;
    }

    /**
     * 
     * @param defenseId
     *     The defenseId
     */

    public void setDefenseId(Long defenseId) {
        this.defenseId = defenseId;
    }

    /**
     * 
     * @return
     *     The specialTeamsId
     */

    public Long getSpecialTeamsId() {
        return specialTeamsId;
    }

    /**
     * 
     * @param specialTeamsId
     *     The special_teams
     */

    public void setSpecialTeamsId(Long specialTeamsId) {
        this.specialTeamsId = specialTeamsId;
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
    }

    public int describeContents() {
        return  0;
    }

}
