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
        View rootView = inflater.inflate(R.layout.item_list, container, false);

//        Creates the list of objects from the accurate category

        final ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(getString(R.string.sienkiewicza),getString(R.string.sienkiewiczaD),R.drawable.seesienkiwicza));
        items.add(new Item(getString(R.string.kadzielnia),getString(R.string.kadzielniaD),R.drawable.seekadzielnia));
        items.add(new Item(getString(R.string.karczówka),getString(R.string.karczókaD),R.drawable.seekarczowka));
        items.add(new Item(getString(R.string.basillic),getString(R.string.basillicD),R.drawable.seebazylika));
        items.add(new Item(getString(R.string.placartystow),getString(R.string.placartystowD),R.drawable.seeartystow));
        items.add(new Item(getString(R.string.joseph),getString(R.string.josephD),R.drawable.seejozef));
        items.add(new Item(getString(R.string.wojciech),getString(R.string.ojciechD),R.drawable.seewojciech));
        items.add(new Item(getString(R.string.mainsquare),getString(R.string.mainsquareD),R.drawable.seemarket));
        items.add(new Item(getString(R.string.zielinski),getString(R.string.zielinskiD),R.drawable.seezielinski));
        items.add(new Item(getString(R.string.staszica),getString(R.string.staszicaD),R.drawable.seepark));

//        creates adapter with the @param of the object's array and the background color
//        adapter transferring the information on object to the listVIew that displays them
//        ListVIew list_view is grabbed and adapter is used on it
        final ItemAdapter itemsArray = new ItemAdapter(getActivity(),items, R.color.see);
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
