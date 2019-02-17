package com.example.revereselogistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Screen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        Button HUL_login = (Button) findViewById(R.id.HUL_login);
//        HUL_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent screen3 = new Intent(Screen2.this, Screen3.class);
//                startActivity(screen3);
//
//            }
//        });
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_screen2);
        HUL_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screen3;
                screen3= new Intent(Screen2.this, Screen3.class);
                startActivity(screen3);
            }
        });
    }
}
