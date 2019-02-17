package com.example.revereselogistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Screen5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_5);
        Button wholesale_login = (Button) findViewById(R.id.wholesale_login);


        wholesale_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screen5;
                screen5 = new Intent(Screen5.this, Screen6.class);
                startActivity(screen5);
            }
        });
    }
}
