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
 * Fragment  that  displays a list of objects
 */
public class SeeFragment extends Fragment {


    public SeeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        View rootView = inflater.inflate(R.layout.item_list, container, false);

//        Creates the list of objects from the accurate category

        final ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Sienkiewicza Street","Main street - promenade",R.drawable.seesienkiwicza));
        items.add(new Item("Geocentre Kadzielnia","Stones with the concert hall",R.drawable.seekadzielnia));
        items.add(new Item("Karczówka Monastery","Monks' place of peace",R.drawable.seekarczowka));
        items.add(new Item("Kielce St. Mary Basilic ","Most beautiful church in Kielce",R.drawable.seebazylika));
        items.add(new Item("Artists' square","Place of events and festivalsg",R.drawable.seeartystow));
        items.add(new Item("Kielce St. Joseph church","Tallest church in city",R.drawable.seejozef));
        items.add(new Item("Kielce St. Wojciech church","Oldest church in Kielce",R.drawable.seewojciech));
        items.add(new Item("Kielce Main square","Market with restaurants ",R.drawable.seemarket));
        items.add(new Item("Tomasz Zieliński Mansion","Culture centre for youg people",R.drawable.seezielinski));
        items.add(new Item("Stanislaw Staszic Park","A place to catch a breath",R.drawable.seepark));

//        creates adapter with the @param of the object's array and the background color
//        adapter transferring the information on object to the listVIew that displays them
//        ListVIew list_view is grabbed and adapter is used on it
        final ItemAdapter itemsArray = new ItemAdapter(getActivity(),items, R.color.see);
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
