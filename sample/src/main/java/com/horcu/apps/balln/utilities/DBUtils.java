package com.horcu.apps.balln.utilities;

import android.content.Context;
import android.os.Environment;

import com.horcu.apps.balln.db.horcuDatabase;
import com.horcu.apps.balln.db.horcuPlayerDatabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by ray on 7/27/15.
 */
public class DBUtils {

    public static void backup(Context context) {
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            String[] dbNames = context.databaseList();

            if (sd.canWrite()) {
                String currentDBPath = context.getDatabasePath(horcuDatabase.NAME+".db").toString();
                String backupDBPath = String.format("%s.db", horcuDatabase.NAME);
                File currentDB = new File(currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(currentDB).getChannel();
                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                }

                String currentPlayerDBPath = context.getDatabasePath(horcuPlayerDatabase.NAME+".db").toString();
                String backupPlayerDBPath = "horcuPlayerdBase.db";
                File currentPlayerDB = new File(currentPlayerDBPath);
                File backupPlayerDB = new File(sd, backupPlayerDBPath);

                if (currentPlayerDB.exists()) {
                    FileChannel src1 = new FileInputStream(currentPlayerDB).getChannel();
                    FileChannel dst1 = new FileOutputStream(backupPlayerDB).getChannel();
                    dst1.transferFrom(src1, 0, src1.size());
                    src1.close();
                    dst1.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static Object getPlayers(String playerPositionId, )
}
