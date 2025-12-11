package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try (InputStream stream = getAssets().open("myPath/my_file.txt")) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
                String line = reader.readLine();
                if (!"test".equals(line)) {
                    throw new IllegalStateException("Asset wrong");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
