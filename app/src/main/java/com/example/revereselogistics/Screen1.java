package com.example.revereselogistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Screen1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button HUL = (Button) findViewById(R.id.HUL_id);
        Button Wholesale = (Button) findViewById(R.id.Wholesale_id);



        HUL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screen2 = new Intent(Screen1.this, Screen2.class);
                startActivity(screen2);
            }
        });
        Wholesale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screen5 = new Intent(Screen1.this, Screen5.class);
                startActivity(screen5);

            }
        });
    }

}
