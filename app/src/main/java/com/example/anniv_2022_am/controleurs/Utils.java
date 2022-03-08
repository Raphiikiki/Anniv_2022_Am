package com.example.anniv_2022_am.controleurs;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

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

    public static Bitmap getBitmapFromAssets(Context context, String file, Rect hitbox) {
        Bitmap og_picture = Utils.getBitmapFromAssets(context, file);
        return Bitmap.createScaledBitmap(og_picture, hitbox.width(), hitbox.height(), false);
    }
}
