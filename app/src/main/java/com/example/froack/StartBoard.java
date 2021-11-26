package com.example.froack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartBoard extends AppCompatActivity {
Button btnLoad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_board);
       btnLoad = findViewById(R.id.btn_Loadpaise);
       btnLoad.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(StartBoard.this,ViewPager.class);
               startActivity(intent);
           }
       });

    }
}