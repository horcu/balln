package com.horcu.apps.balln.models.game;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.horcu.apps.balln.db.horcuDatabase;

import ollie.Model;
import ollie.annotation.Column;
import ollie.annotation.PrimaryKey;
import ollie.annotation.Table;

/**
 * Created by hacz on 8/5/2015.
 */


public class PlayerPosition extends Model implements Parcelable {

    public PlayerPosition(){}


    public Long id;

    public String playerPositionId;

    public String playerId;

    public Long positionId;



    public Long depth;

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
    public String getPlayerPositionId() {
        return playerPositionId;
    }

    /**
     *
     * @param playerPositionId
     *     The id
     */

    public void setPlayerPositionId(String playerPositionId) {
        this.playerPositionId = playerPositionId;
    }

    /**
     *
     * @return
     *     The playerId
     */

    public String getPlayerId() {
        return playerId;
    }

    /**
     *
     * @param playerId
     *     The id
     */

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    /**
     *
     * @return
     *     The id
     */

    public Long getPositionId() {
        return positionId;
    }

    /**
     *
     * @param positionId
     *     The id
     */

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    /**
     *
     * @return
     *     The id
     */

    public Long getDepth() {
        return depth;
    }

    /**
     *
     * @param depth
     *     The id
     */

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
