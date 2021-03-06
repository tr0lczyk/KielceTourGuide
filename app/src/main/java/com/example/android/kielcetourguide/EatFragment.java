package com.example.android.kielcetourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Fragment that  displays a list of objects
 */
public class EatFragment extends Fragment {

    public EatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

//        Creates the list of objects from the accurate category

        final ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(getString(R.string.solna),getString(R.string.solnaD),R.drawable.solna12));
        items.add(new Item(getString(R.string.tutti),getString(R.string.tuttiD),R.drawable.tutti));
        items.add(new Item(getString(R.string.burg),getString(R.string.burgD),R.drawable.johnburg));
        items.add(new Item(getString(R.string.favero),getString(R.string.faveroD),R.drawable.delitaliana));
        items.add(new Item(getString(R.string.senor),getString(R.string.senorD),R.drawable.sisenor));
        items.add(new Item(getString(R.string.burger),getString(R.string.burgerD),R.drawable.burgerco));
        items.add(new Item(getString(R.string.elephant),getString(R.string.elephantD),R.drawable.slon));
        items.add(new Item(getString(R.string.cremova),getString(R.string.cremovaD),R.drawable.cremova));
        items.add(new Item(getString(R.string.craftbeerD),getString(R.string.creaftbeer),R.drawable.craftbeer));
        items.add(new Item(getString(R.string.montecarlo),getString(R.string.montecarloD),R.drawable.montecarlo));

//        creates adapter with the @param of the object's array and the background color
//        adapter transferring the information on object to the listVIew that displays them
//        ListVIew list_view is grabbed and adapter is used on it
        final ItemAdapter itemsArray = new ItemAdapter(getActivity(),items, R.color.eat);
        ListView listView = rootView.findViewById(R.id.list_view);
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
