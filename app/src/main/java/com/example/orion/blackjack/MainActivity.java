package com.example.orion.blackjack;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View button = findViewById(R.id.button);
        View root = button.getRootView();
        root.setBackgroundColor(Color.rgb(0,135,0));
    }

    public void onClick(View view){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
