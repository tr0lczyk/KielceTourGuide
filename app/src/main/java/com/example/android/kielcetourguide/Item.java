package com.example.android.kielcetourguide;

/**
 * Created by Mateusz on 25.01.2018.
 */

public class Item {


    /*
    *
    * States of the Item object
    *
    * */
    private String mPlaceName;

    private String mPlaceDescription;

    private int mImageResourceId;

    /*
    *
    * Creation of the Item object
    *
    * */
    public Item(String placeName, String placeDescription, int imageResourceId){
        mPlaceName = placeName;
        mPlaceDescription = placeDescription;
        mImageResourceId = imageResourceId;
    }

    /*
    *
    * @Methods of the Item object
    *
    * */
    public String getPlaceName(){
        return mPlaceName;
    }

    public String getPlaceDescription(){
        return mPlaceDescription;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }
}
