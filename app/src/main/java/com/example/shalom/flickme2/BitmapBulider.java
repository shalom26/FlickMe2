package com.example.shalom.flickme2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Shalom on 01/10/2015.
 */
public class BitmapBulider {

    private Bitmap bitmap=null;

   public Bitmap getBitmapFromURL(String src) {



            /////////////////////////////////////////////////////////////////////////////////////////
            try {

                URL url = new URL(src);
                bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                bitmap = BitmapFactory.decodeStream((InputStream) url.getContent());
                return bitmap;

            }

            catch (MalformedURLException e) {
                e.printStackTrace();
                Log.w("FlickrImages", e.getMessage());
            }

            catch (IOException e) {
                e.printStackTrace();
                Log.w("FlickrImages", e.getMessage());
            }
                return null;

    }
}
