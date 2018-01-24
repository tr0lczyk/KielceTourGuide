package com.example.android.kielcetourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView see;
    TextView eat;
    TextView sleep;
    TextView doing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        see = findViewById(R.id.see);
        eat = findViewById(R.id.eat);
        sleep = findViewById(R.id.sleep);
        doing = findViewById(R.id.doing);

        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent seeIntent = new Intent(MainActivity.this, SeeActivity.class);
                startActivity(seeIntent);
            }
        });

        eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent eatIntent = new Intent(MainActivity.this, EatActivity.class);
                startActivity(eatIntent);
            }
        });

        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sleepIntent = new Intent(MainActivity.this, SleepActivity.class);
                startActivity(sleepIntent);
            }
        });

        doing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent doingIntent = new Intent(MainActivity.this, DoingActivity.class);
                startActivity(doingIntent);
            }
        });
    }
}
