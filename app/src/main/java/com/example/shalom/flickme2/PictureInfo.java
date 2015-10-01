package com.example.shalom.flickme2;

/**
 * Created by Shalom on 29/09/2015.
 */
public class PictureInfo {

    private String id;
    private String owner;
    private String secret;
    private String server;
    private String farm;
    private String title;
    private String ispublic;
    private String isfriend;
    private String isfamily;
    public  String imageURL;






    public void setIspublic(String ispublic) {
        this.ispublic = ispublic;
    }



    public void setId(String id) {
        this.id = id;
    }



    public void setOwner(String owner) {
        this.owner = owner;
    }



    public void setSecret(String secret) {
        this.secret = secret;
    }


    public void setServer(String server) {
        this.server = server;
    }



    public void setFarm(String farm) {
        this.farm = farm;
    }



    public void setTitle(String title) {
        this.title = title;
    }



    public void setIsfriend(String isfriend) {
        this.isfriend = isfriend;
    }



    public void setIsfamily(String isfamily) {
        this.isfamily = isfamily; }



    public String getImageURL() {
        imageURL = ("https://farm"+farm+".staticflickr.com/"+server+"/"+id+"_"+secret+"_q.jpg");
        return imageURL; }


    }


