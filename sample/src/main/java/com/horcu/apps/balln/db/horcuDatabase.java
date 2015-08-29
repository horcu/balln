package com.horcu.apps.balln.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by hacz on 8/3/2015.
 */
@Database(name = horcuDatabase.NAME, version = horcuDatabase.VERSION, foreignKeysSupported = true, backupEnabled = true, consistencyCheckEnabled = true)
public class horcuDatabase {

    public static final String NAME = "Ballndb_staging_15";

    public static final int VERSION = 1;
}

