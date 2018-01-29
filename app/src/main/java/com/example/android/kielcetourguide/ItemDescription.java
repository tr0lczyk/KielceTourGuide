package com.example.android.kielcetourguide;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mateusz on 26.01.2018.
 */

public class ItemDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_description);

        /**
         * Constructor for each item detailed description
         *
         * List of object's states - name, image and description
         * plus the place location
         *
         */

        TextView name = (TextView) findViewById(R.id.place_description_name);
        ImageView image = (ImageView) findViewById(R.id.place_description_image_id);
        TextView placeDescription = (TextView) findViewById(R.id.place_description_description);
        ImageView placeDescriptionLocation = (ImageView) findViewById(R.id.place_description_location);

        /**
         * setting the bundle for the values of
         * name, image and place description
         */
        final Bundle extras = getIntent().getExtras();

        name.setText(extras.getString("name"));
        image.setImageResource(extras.getInt("image"));
        placeDescription.setText(extras.getString("placeDescription"));

        /**
         * creating the onClick-functionality of the method that's sending intent to gm apk and
         * searching for the place's name.
         */

        placeDescriptionLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address = extras.getString("name");
                Uri mapUri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
