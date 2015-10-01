package com.example.shalom.flickme2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shalom on 29/09/2015.
 */
public class PictureJSONParser {
    public static List<PictureInfo> parseFeed(String content) {
        try {
            JSONArray ar = new JSONArray(content);
            List<PictureInfo> pictureList = new ArrayList<>();
            for (int i = 0; i < ar.length(); i++) {
                JSONObject obj = ar.getJSONObject(i);
                PictureInfo pictureInfo = new PictureInfo();
                pictureInfo.setId(obj.getString("id"));
                pictureInfo.setOwner(obj.getString("owner"));
                pictureInfo.setSecret(obj.getString("secret"));
                pictureInfo.setServer(obj.getString("server"));
                pictureInfo.setFarm(obj.getString("farm"));
                pictureInfo.setTitle(obj.getString("title"));
                pictureInfo.setIspublic(obj.getString("ispublic"));
                pictureInfo.setIsfriend(obj.getString("isfriend"));
                pictureInfo.setIsfamily(obj.getString("isfamily"));
                pictureList.add(pictureInfo);
            }
            return pictureList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}