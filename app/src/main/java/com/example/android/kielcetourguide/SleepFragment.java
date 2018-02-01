package com.example.android.kielcetourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Fragment that  displays a list of objects
 */
public class SleepFragment extends Fragment {


    public SleepFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        View rootView = inflater.inflate(R.layout.item_list, container, false);

//        Creates the list of objects from the accurate category

        final ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Hotel Aviator","from 171 zł for a room",R.drawable.hotelaviator));
        items.add(new Item("Best Western Grand Hotel","from 162 zł for a room",R.drawable.hotelwestern));
        items.add(new Item("Ibis Kielce Centrum","from 111 zł for a room",R.drawable.hotelibis));
        items.add(new Item("Hotel Śródmiejski","from 180 zł for a room",R.drawable.hotelmiej));
        items.add(new Item("Odyssey ClubHotel Wellness & SPA","from 420 zł for a room",R.drawable.hoteloddysey));
        items.add(new Item("Hotel Binkowski","from 240 zł for a room",R.drawable.hotelbinkowski));
        items.add(new Item("Hotel Teczowy Mlyn","from 130 zł for a room",R.drawable.hotelteczowy));
        items.add(new Item("Hotel Dal","from 134 zł for a room",R.drawable.hoteldal));
        items.add(new Item("Willa Hueta","from 144 zł for a room",R.drawable.hotelwilla));
        items.add(new Item("Qubus Hotel Kielce","from 209 zł for a room",R.drawable.hotelonemaja));

//        creates adapter with the @param of the object's array and the background color
//        adapter transferring the information on object to the listVIew that displays them
//        ListVIew list_view is grabbed and adapter is used on it
        final ItemAdapter itemsArray = new ItemAdapter(getActivity(),items, R.color.sleep);
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);
        listView.setAdapter(itemsArray);

        /*  setOnItemClickListener for the List items
        *   currentItem being clicked intent from this context to ItemDescription.class
        *   putExtra for getting the name, placeDescription and image of the currentItem
        *   to ptransfer them to ItemDescription.class */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Item currentItem = items.get(position);
                Intent intent = new Intent(getActivity(),ItemDescription.class);
                intent.putExtra("name",currentItem.getPlaceName());
                intent.putExtra("placeDescription",currentItem.getPlaceDescription());
                intent.putExtra("image", currentItem.getImageResourceId());
                startActivity(intent);
            }
        });
        return rootView;
    }
}
