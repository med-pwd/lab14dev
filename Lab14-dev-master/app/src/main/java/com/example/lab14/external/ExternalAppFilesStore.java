package com.example.lab14.external;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public final class ExternalAppFilesStore {

    private ExternalAppFilesStore() {}

    public static String write(Context context, String fileName, String content) throws Exception {
        File dir = context.getExternalFilesDir(null);
        if (dir == null) return null;

        File file = new File(dir, fileName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(content.getBytes(StandardCharsets.UTF_8));
        }
        return file.getAbsolutePath();
    }

    public static String read(Context context, String fileName) throws Exception {
        File dir = context.getExternalFilesDir(null);
        if (dir == null) return null;

        File file = new File(dir, fileName);
        if (!file.exists()) return null;

        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(isr)) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString().trim();
        }
    }

    public static boolean delete(Context context, String fileName) {
        File dir = context.getExternalFilesDir(null);
        if (dir == null) return false;

        File file = new File(dir, fileName);
        return file.delete();
    }
}
