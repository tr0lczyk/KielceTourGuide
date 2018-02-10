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
public class DoingFragment extends Fragment {


    public DoingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        View rootView = inflater.inflate(R.layout.item_list, container, false);

//        Creates the list of objects from the accurate category

        final ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(getString(R.string.rope),getString(R.string.ropeD),R.drawable.doinparklinowy));
        items.add(new Item(getString(R.string.door),getString(R.string.doorD),R.drawable.doinunlockdoor));
        items.add(new Item(getString(R.string.bishop),getString(R.string.bishopD),R.drawable.doinpalacbiskupow));
        items.add(new Item(getString(R.string.vrdisco),getString(R.string.vrdiscoD),R.drawable.doindiscovr));
        items.add(new Item(getString(R.string.kielcevr),getString(R.string.kielcevrD),R.drawable.doinexperiencevr));
        items.add(new Item(getString(R.string.museum),getString(R.string.museumD),R.drawable.doinmuzeumzabawek));
        items.add(new Item(getString(R.string.gallery),getString(R.string.galeryD),R.drawable.doinechogaleria));
        items.add(new Item(getString(R.string.krajno),getString(R.string.krajnoD),R.drawable.doinamusementpark));
        items.add(new Item(getString(R.string.natmuseum),getString(R.string.natmuseumD),R.drawable.doinmuzeumkielce));
        items.add(new Item(getString(R.string.filharmon),getString(R.string.filharmonD),R.drawable.doingfilharmoniasw));

//        creates adapter with the @param of the object's array and the background color
//        adapter transferring the information on object to the listVIew that displays them
//        ListVIew list_view is grabbed and adapter is used on it
        final ItemAdapter itemsArray = new ItemAdapter(getActivity(),items, R.color.doing);
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
