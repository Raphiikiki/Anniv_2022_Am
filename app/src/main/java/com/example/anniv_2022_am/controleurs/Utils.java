package com.example.anniv_2022_am.controleurs;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;

public class Utils {

    public static Bitmap getBitmapFromAssets(Context context, String file) {
        try {
            return BitmapFactory.decodeStream(context.getAssets().open(file));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
