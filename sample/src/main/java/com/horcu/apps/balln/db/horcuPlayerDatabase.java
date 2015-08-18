package com.horcu.apps.balln.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by hacz on 8/10/2015.
 */
@Database(name = horcuDatabase.NAME, version = horcuDatabase.VERSION, foreignKeysSupported = true, backupEnabled = true, consistencyCheckEnabled = true)
public class horcuPlayerDatabase {
    public static final String NAME = "nflPlayersDb";

    public static final int VERSION = 1;
}
