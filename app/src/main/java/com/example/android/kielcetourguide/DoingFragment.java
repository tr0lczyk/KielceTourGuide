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
        items.add(new Item("Unlock the door","A great escape room",R.drawable.doinunlockdoor));
        items.add(new Item("Cracow Bishops' Palace Kielce","Splendor of the medival priests",R.drawable.doinpalacbiskupow));
        items.add(new Item("VR disco centre Kielce","Virtual dance!",R.drawable.doindiscovr));
        items.add(new Item("VR Kielce","Get your virtual fun!",R.drawable.doinexperiencevr));
        items.add(new Item("Museum of Toys and Play Kielce.","Unleash your inner child",R.drawable.doinmuzeumzabawek));
        items.add(new Item("Echo Gallery","Really big shopping mall",R.drawable.doinechogaleria));
        items.add(new Item("Amusement Park Krajno","Meet the history of Swietokrzyskie",R.drawable.doinamusementpark));
        items.add(new Item("Kielce's National Museum","Very nice place",R.drawable.doinmuzeumkielce));
        items.add(new Item("Świętokrzyska Philharmonic","Great classic concerts",R.drawable.doingfilharmoniasw));

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
