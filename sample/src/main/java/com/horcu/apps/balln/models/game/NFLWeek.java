
package com.horcu.apps.balln.models.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "number",
    "games"
})

@ModelContainer
@Table(databaseName = horcuDatabase.NAME)
public class NFLWeek extends BaseModel implements Parcelable
{

    public NFLWeek(){}

    @Column
    @PrimaryKey(autoincrement = false)
    @JsonProperty("id")
    public String id;

    @Column
    @JsonProperty("number")
    private Integer number;

    @JsonProperty("games")
    public List<Game> games = new ArrayList<Game>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<NFLWeek> CREATOR = new Creator<NFLWeek>() {


        public NFLWeek createFromParcel(Parcel in) {
            NFLWeek instance = new NFLWeek();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.number = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.games, (Game.class.getClassLoader()));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public NFLWeek[] newArray(int size) {
            return (new NFLWeek[size]);
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
     *     The number
     */
    @JsonProperty("number")
    public Integer getNumber() {
        return number;
    }

    /**
     * 
     * @param number
     *     The number
     */
    @JsonProperty("number")
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     *
     * @return
     *     The games
     */
    @JsonProperty("games")
    @OneToMany(methods = {OneToMany.Method.SAVE, OneToMany.Method.DELETE}, variableName = "games")
    public List<Game> getGames() {
        if(games == null)
        {
         games = new Select().from (Game.class).queryList();
        }
        return games;
    }

    /**
     * 
     * @param games
     *     The games
     */
    @JsonProperty("games")
    public void setGames(List<Game> games) {
        this.games = games;
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
        return new HashCodeBuilder().append(id).append(number).append(games).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NFLWeek) == false) {
            return false;
        }
        NFLWeek rhs = ((NFLWeek) other);
        return new EqualsBuilder().append(id, rhs.id).append(number, rhs.number).append(games, rhs.games).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(number);
        dest.writeList(games);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}