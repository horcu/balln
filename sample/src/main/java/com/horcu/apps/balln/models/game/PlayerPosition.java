package com.horcu.apps.balln.models.game;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.horcu.apps.balln.db.horcuDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by hacz on 8/5/2015.
 */
@ModelContainer
@Table(databaseName = horcuDatabase.NAME)
public class PlayerPosition extends BaseModel implements Parcelable {

    public PlayerPosition(){}

    @Column

    @PrimaryKey(autoincrement = true)
    @JsonProperty("id")
    private Long id;

    @Column
    @JsonProperty("playerPositionId")
    private String playerPositionId;

    @Column
    @JsonProperty("playerId")
    private String playerId;

    @Column
    @JsonProperty("positionId")
    private Long positionId;

    @Column(name = "depth")
    @JsonProperty("depth")
    private Long depth;

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
    @JsonProperty("playerPositionId")
    public String getPlayerPositionId() {
        return playerPositionId;
    }

    /**
     *
     * @param playerPositionId
     *     The id
     */
    @JsonProperty("playerPositionId")
    public void setPlayerPositionId(String playerPositionId) {
        this.playerPositionId = playerPositionId;
    }

    /**
     *
     * @return
     *     The playerId
     */
    @JsonProperty("playerId")
    public String getPlayerId() {
        return playerId;
    }

    /**
     *
     * @param playerId
     *     The id
     */
    @JsonProperty("playerId")
    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    /**
     *
     * @return
     *     The id
     */
    @JsonProperty("positionId")
    public Long getPositionId() {
        return positionId;
    }

    /**
     *
     * @param positionId
     *     The id
     */
    @JsonProperty("positionId")
    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    /**
     *
     * @return
     *     The id
     */
    @JsonProperty("depth")
    public Long getDepth() {
        return depth;
    }

    /**
     *
     * @param depth
     *     The id
     */
    @JsonProperty("depth")
    public void setDepth(Long depth) {
        this.depth = depth;
    }

       public static final Creator<PlayerPosition> CREATOR = new Creator<PlayerPosition>() {
        @Override
        public PlayerPosition createFromParcel(Parcel in) {
            PlayerPosition instance = new PlayerPosition();
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.playerPositionId = ((String) in.readValue((String.class.getClassLoader())));
            instance.playerId = ((String) in.readValue((String.class.getClassLoader())));
            instance.positionId = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.depth = ((Long) in.readValue((Long.class.getClassLoader())));
        return instance;
        }

        @Override
        public PlayerPosition[] newArray(int size) {
            return new PlayerPosition[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(playerPositionId);
        dest.writeValue(playerId);
        dest.writeValue(positionId);
        dest.writeValue(depth);
    }
}
