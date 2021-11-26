package com.example.froack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPrefLog extends AppCompatActivity {
TextView textView_name,textView_email;
Button button_logout;
Button glite;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="mapref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref_log);
        glite = findViewById(R.id.glite);
        glite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SharedPrefLog.this,StartBoard.class);
                startActivity(intent);
            }
        });
        textView_email = findViewById(R.id.text_email);
        textView_name  =  findViewById(R.id.text_fullname);
        button_logout = findViewById(R.id.button_logout);
        sharedPreferences  =  getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NAME,null);
        String email = sharedPreferences.getString(KEY_EMAIL,null);
        if (name != null || email != null){
            textView_name.setText("Full Name"  + name);
            textView_email.setText("Emaile ID"  + email);
            button_logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.clear();
                    editor.commit();
                    finish();
                    Toast.makeText(SharedPrefLog.this, "Log out successfully", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}