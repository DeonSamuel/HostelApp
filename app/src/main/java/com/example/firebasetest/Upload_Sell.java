package com.example.firebasetest;

import com.google.firebase.database.Exclude;

public class Upload_Sell {

    private String mCat;
    private String mProduct;
    private String mPrice;
    private String mContact;
    private String mImageUrl;

    private String mKey;

    public Upload_Sell() {
        //empty
    }

    public Upload_Sell(String cat,String pro,String price,String contact, String imageUrl) {
        if (cat.trim().equals("")) {
            cat = "No Name";
        }
        mCat = cat;
        mProduct = pro;
        mPrice= price;
        mContact = contact;
        mImageUrl = imageUrl;
    }

    public String getCat() {return mCat;}
    public String getPro() {return mProduct;}
    public String getPrice() {return mPrice;}
    public String getContact() {return mContact;}

    public void setCat(String name){mCat = name;}
    public void setPro(String age){mProduct = age;}
    public void setPrice(String gender){mPrice = gender;}
    public void setContact(String Hostel){mContact= Hostel;}

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
