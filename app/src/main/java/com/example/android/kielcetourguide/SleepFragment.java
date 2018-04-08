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
public class SleepFragment extends Fragment {

    public SleepFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

//        Creates the list of objects from the accurate category

        final ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(getString(R.string.aviator),getString(R.string.aviatorD),R.drawable.hotelaviator));
        items.add(new Item(getString(R.string.grand),getString(R.string.grandD),R.drawable.hotelwestern));
        items.add(new Item(getString(R.string.ibisD),getString(R.string.ibisdescr),R.drawable.hotelibis));
        items.add(new Item(getString(R.string.srodmiejski),getString(R.string.srodmiejskiD),R.drawable.hotelmiej));
        items.add(new Item(getString(R.string.oddysey),getString(R.string.odyseyD),R.drawable.hoteloddysey));
        items.add(new Item(getString(R.string.binkowski),getString(R.string.binkowskiD),R.drawable.hotelbinkowski));
        items.add(new Item(getString(R.string.teczowy),getString(R.string.teczowyD),R.drawable.hotelteczowy));
        items.add(new Item(getString(R.string.dal),getString(R.string.dalD),R.drawable.hoteldal));
        items.add(new Item(getString(R.string.hueta),getString(R.string.huetaD),R.drawable.hotelwilla));
        items.add(new Item(getString(R.string.qubus),getString(R.string.qubusD),R.drawable.hotelonemaja));

//        creates adapter with the @param of the object's array and the background color
//        adapter transferring the information on object to the listVIew that displays them
//        ListVIew list_view is grabbed and adapter is used on it
        final ItemAdapter itemsArray = new ItemAdapter(getActivity(),items, R.color.sleep);
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
