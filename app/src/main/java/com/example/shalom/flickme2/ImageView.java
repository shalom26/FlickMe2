package com.example.shalom.flickme2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class ImageView extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    String imageTag;
    private PictureInfo mPictureInfo=new PictureInfo();
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        context = getBaseContext();

        Bundle selTag = getIntent().getExtras();
        imageTag = selTag.getString("selectedTag");


        String apiKey = "7cac09213fb9d08d6efbc2aeb8a3f223";
        String secret = "a5f141a334b64a27";
        String baseUrl = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key="+apiKey+"&tags="+imageTag+"&format=json&nojsoncallback=1";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(baseUrl).build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                try {
                    if (response.isSuccessful()) {
                        String jsonData = response.body().string();
                        Log.v(TAG, jsonData);
                        try {
                            mPictureInfo = getPictureInfo(jsonData);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }

            }
        });
    }

    private PictureInfo getPictureInfo(String jsonData) throws JSONException {
        JSONObject picInfo = new JSONObject(jsonData);
        JSONObject picInfo2 = new JSONObject(picInfo.get("photos").toString());
        JSONArray picArray = new JSONArray(picInfo2.getJSONArray("photo").toString());


        for (int i = 0; i < picArray.length(); i++) {
            JSONObject pic = picArray.getJSONObject(i);


            PictureInfo pictureInfo = new PictureInfo();
            pictureInfo.setId(pic.getString("id"));
            pictureInfo.setOwner(pic.getString("owner"));
            pictureInfo.setSecret(pic.getString("secret"));
            pictureInfo.setServer(pic.getString("server"));
            pictureInfo.setFarm(pic.getString("farm"));
            pictureInfo.setTitle(pic.getString("title"));
            pictureInfo.setIspublic(pic.getString("ispublic"));
            pictureInfo.setIsfriend(pic.getString("isfriend"));
            pictureInfo.setIsfamily(pic.getString("isfamily"));

            String picUrl =pictureInfo.getImageURL();

            BitmapBulider bitmapBulider=new BitmapBulider();
            Bitmap bitmap;
            bitmap=(bitmapBulider.getBitmapFromURL(picUrl));
            int temp =0;





        }

        return null;

    }

}

