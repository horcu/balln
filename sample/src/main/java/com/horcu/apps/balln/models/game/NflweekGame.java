package com.horcu.apps.balln.models.game;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.horcu.apps.balln.db.horcuDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import javax.annotation.Generated;

/**
 * Created by hacz on 8/13/2015.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "id",
        "weekId",
        "gameId"
})

@ModelContainer
@Table(databaseName = horcuDatabase.NAME)
public class NflweekGame extends BaseModel implements Parcelable{

    @JsonProperty("id")
    @Column
    @PrimaryKey(autoincrement = true)
    public Long id;

    @Column
    @JsonProperty("weekId")
    private String weekId;

    @Column
    @JsonProperty("gameId")
    private String gameId;

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
     *     The gameId
     */
    @JsonProperty("gameId")
    public String getGameId() {
        return gameId;
    }

    /**
     *
     * @param gameId
     *     The gameId
     */
    @JsonProperty("gameId")
    public void setGameId(String id) {
        this.gameId = id;
    }

    /**
     *
     * @return
     *     The weekId
     */
    @JsonProperty("weekId")
    public String getWeekId() {
        return weekId;
    }

    /**
     *
     * @param weekId
     *     The weekId
     */
    @JsonProperty("weekId")
    public void setWeekId(String id) {
        this.weekId = id;
    }

    public final static Creator<NflweekGame> CREATOR = new Creator<NflweekGame>() {


        public NflweekGame createFromParcel(Parcel in) {
            NflweekGame instance = new NflweekGame();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.weekId = ((String) in.readValue((String.class.getClassLoader())));
            instance.gameId = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public NflweekGame[] newArray(int size) {
            return (new NflweekGame[size]);
        }

    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(weekId);
        dest.writeValue(gameId);
    }
}
