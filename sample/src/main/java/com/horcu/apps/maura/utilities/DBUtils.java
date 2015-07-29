package com.horcu.apps.maura.utilities;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by ray on 7/27/15.
 */
public class DBUtils {

    public static void backup() {
        try {
            File sdcard = Environment.getExternalStorageDirectory();
            File outputFile = new File(sdcard,
                    "mauraDB.bak");

            if (!outputFile.exists())
                outputFile.createNewFile();

            File data = Environment.getDataDirectory();
            File inputFile = new File(data, "/data/com.horcu.apps.maura/databases/mauraDb");
            InputStream input = new FileInputStream(inputFile);
            OutputStream output = new FileOutputStream(outputFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            output.flush();
            output.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
           // throw new Error("Copying Failed");
        }
    }
}
