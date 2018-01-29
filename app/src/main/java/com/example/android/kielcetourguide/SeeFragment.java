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


public class SeeFragment extends Fragment {


    public SeeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        final ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Solna 12 Restaurant","An intimate restaurant",R.drawable.solna12));
        items.add(new Item("Tutti Santi Kielce","Magnificent Italian cuisine",R.drawable.tutti));
        items.add(new Item("John Burg","Best Steakes and burgers",R.drawable.johnburg));
        items.add(new Item("Del Favero","A real Italy in Kielce",R.drawable.delitaliana));
        items.add(new Item("Si Senor","A place worth recommending",R.drawable.sisenor));
        items.add(new Item("Burger & Co.","Mega Tasty!",R.drawable.burgerco));
        items.add(new Item("Yellow Elephant","The best Mediterranean cuisine",R.drawable.slon));
        items.add(new Item("Cremova","Delicious cakes and tea",R.drawable.cremova));
        items.add(new Item("Craft Beer Pub","Very nice place",R.drawable.craftbeer));
        items.add(new Item("Monte-Carlo","Delicious and very efficient",R.drawable.montecarlo));

        final ItemAdapter itemsArray = new ItemAdapter(getActivity(),items, R.color.see);
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);
        listView.setAdapter(itemsArray);

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
