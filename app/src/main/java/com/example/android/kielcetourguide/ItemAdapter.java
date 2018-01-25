package com.example.android.kielcetourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

public class ItemAdapter extends ArrayAdapter<Item> {


    public ItemAdapter(Activity context, ArrayList<Item> items) {
        super(context, 0, items);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,
                    false);
        }

        Item currentItem = getItem(position);


        TextView placeName = listItemView.findViewById(R.id.place_name);
        placeName.setText(currentItem.getPlaceName());

        TextView placeDescription = listItemView.findViewById(R.id.place_description);
        placeDescription.setText(currentItem.getPlaceDescription());

        ImageView imageResourceId = listItemView.findViewById(R.id.image_id);
        imageResourceId.setImageResource(currentItem.getImageResourceId());

        return listItemView;
    }
}
