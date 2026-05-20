package com.example.lab14.cache;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public final class CacheStore {

    private CacheStore() {}

    public static void write(Context context, String fileName, String content) throws Exception {
        File file = new File(context.getCacheDir(), fileName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(content.getBytes(StandardCharsets.UTF_8));
        }
    }

    public static String read(Context context, String fileName) throws Exception {
        File file = new File(context.getCacheDir(), fileName);
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

    public static int purge(Context context) {
        File[] files = context.getCacheDir().listFiles();
        if (files == null) return 0;
        int deleted = 0;
        for (File f : files) {
            if (f.delete()) deleted++;
        }
        return deleted;
    }
}
