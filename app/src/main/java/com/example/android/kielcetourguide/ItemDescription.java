package com.example.android.kielcetourguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mateusz on 26.01.2018.
 */

public class ItemDescription extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView name = findViewById(R.id.place_description_name);
        ImageView image = findViewById(R.id.place_description_image_id);
        TextView placeDescription = findViewById(R.id.place_description_description);

        Bundle extras=getIntent().getExtras();

        name.setText(extras.getString("name"));
        image.setImageResource(extras.getInt("image"));
        placeDescription.setText(extras.getString("placeDescription"));
    }
}
