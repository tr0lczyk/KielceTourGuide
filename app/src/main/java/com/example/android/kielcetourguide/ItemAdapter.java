package com.example.android.kielcetourguide;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Mateusz on 25.01.2018.
 */

/*
* Creation of the custom adapter class that extends methods from the ArrayAdapter
* */

public class ItemAdapter extends ArrayAdapter<Item> {

    private int mColorResourceId;

    /**
     * Constructor creation that will define ItemAdapter class
     * Inflating layout with the current context - currentItem
     * List of Items objects will be created on the listview.
     */


    public ItemAdapter(Activity context, ArrayList<Item> items, int colorResourceId) {
        super(context, 0, items);
        /*color is added as a additional value of adapter*/
        mColorResourceId = colorResourceId;
    }



    /*check if the view is being reused
    * if it isn't,
    * inflate the new view*/
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,
                    false);
        }

//        get the object positioned on the exact spot (that's my spot!:) on list
        Item currentItem = getItem(position);

//        setting the object's name of the place
        TextView placeName = listItemView.findViewById(R.id.place_name);
        placeName.setText(currentItem.getPlaceName());

//        setting the object's description
        TextView placeDescription = listItemView.findViewById(R.id.place_description);
        placeDescription.setText(currentItem.getPlaceDescription());

//        setting the resourseID of the list_item image
        ImageView imageResourceId = listItemView.findViewById(R.id.image_id);
        imageResourceId.setImageResource(currentItem.getImageResourceId());

//        setting the color of list_item
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);

//        returns list item layout
        return listItemView;
    }
}
