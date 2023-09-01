package com.example.firebasetest;

import com.google.firebase.database.Exclude;

public class Upload {
    private String mDescription;
    private String mImageUrl;

    private String mKey;

    public Upload() {
        //empty
    }

    public Upload(String desc, String imageUrl) {
        if (desc.trim().equals("")) {
            desc = "No caption";
        }
        mDescription = desc;
        mImageUrl = imageUrl;
    }

    public String getDes() {
        return mDescription;
    }

    public void setDes(String des){
        mDescription = des;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String image){
        mImageUrl = image;
    }

    @Exclude
    public String getKey(){
        return mKey;
    }

    @Exclude
    public void setKey(String Key){
        mKey = Key;
    }
}
