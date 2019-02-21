package com.example.revereselogistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.revereselogistics.Fragments.HUL_Login_Fragment;
import com.example.revereselogistics.Fragments.Wholesaler_Login_Fragment;
import com.google.firebase.database.FirebaseDatabase;

public class Screen1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);

        Button btHUL = (Button) findViewById(R.id.HUL_id);
        Button btWholesale = (Button) findViewById(R.id.Wholesale_id);



        btHUL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.screen1FragContainer,
                        new HUL_Login_Fragment()).commit();
            }
        });

        btWholesale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("pikachu", "onClick: Wholesale");
                getSupportFragmentManager().beginTransaction().replace(R.id.screen1FragContainer,
                        new Wholesaler_Login_Fragment()).commit();
            }
        });
    }

}
