package com.me.nav.ssclicker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton but;
    TextView schet;
    int count;
    String sch;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but = (ImageButton) findViewById(R.id.imageButton);
        schet = (TextView) findViewById(R.id.textView);
        prefs = getSharedPreferences("com.me.nav.ssclicker", MODE_PRIVATE);
        count = prefs.getInt("Schet", count);

        sch="Очков: " + count;
        schet.setText(sch);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 85834){
                    Toast toast = Toast.makeText(getApplicationContext(), "Поздравляем! Вы прошли игру!", Toast.LENGTH_LONG);
                    toast.show();
                    count=0;
                }
                count=count+1;
                sch="Очков: " + count;
                schet.setText(sch);
                prefs.edit().putInt("Schet", count).commit();
            }
        });

    }
}
