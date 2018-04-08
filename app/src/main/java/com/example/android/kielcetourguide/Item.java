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
    private String myPlaceName;

    private String myPlaceDescription;

    private int myImageResourceId;

    /*
    *
    * Creation of the Item object
    *
    * */
    public Item(String placeName, String placeDescription, int imageResourceId){
        myPlaceName = placeName;
        myPlaceDescription = placeDescription;
        myImageResourceId = imageResourceId;
    }

    /*
    *
    * @Methods of the Item object
    *
    * */
    public String getPlaceName(){
        return myPlaceName;
    }

    public String getPlaceDescription(){
        return myPlaceDescription;
    }

    public int getImageResourceId(){
        return myImageResourceId;
    }
}
