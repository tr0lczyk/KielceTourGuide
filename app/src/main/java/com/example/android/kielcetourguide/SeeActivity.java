package com.example.android.kielcetourguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Solna 12","An intimate restaurant",R.drawable.solna12));
        items.add(new Item("Tutti Santi Kielce","Magnificent Italian cuisine",R.drawable.tutti));
        items.add(new Item("John Burg","Best Steakes and burgers",R.drawable.johnburg));
        items.add(new Item("Del Favero","A real Italy in Kielce",R.drawable.delitaliana));
        items.add(new Item("Si Senor","A place worth recommending",R.drawable.sisenor));
        items.add(new Item("Burger & Co.","Mega Tasty!",R.drawable.burgerco));
        items.add(new Item("Yellow Elephant","The best Mediterranean cuisine",R.drawable.slon));
        items.add(new Item("Cremova","Delicious cakes and tea",R.drawable.cremova));
        items.add(new Item("Craft Beer Pub","Very nice place",R.drawable.craftbeer));
        items.add(new Item("Monte-Carlo","Delicious and very efficient",R.drawable.montecarlo));


        ItemAdapter itemsArray = new ItemAdapter(this,items);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(itemsArray);
    }
}
