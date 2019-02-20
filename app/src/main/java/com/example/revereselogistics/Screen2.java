package com.example.revereselogistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.revereselogistics.POJOs.HUL_Login;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Screen2 extends AppCompatActivity {
    public static final String TAG = "pikachu";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        FirebaseApp.initializeApp(this);

        final EditText etHUL_Username = findViewById(R.id.HUL_uid);
        final EditText etHUL_password = findViewById(R.id.HUL_password);
        final Button HUL_login = (Button) findViewById(R.id.HUL_login);
        HUL_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str1 = etHUL_Username.getText().toString();
                String str2 = etHUL_password.getText().toString();
                HUL_Login obj = new HUL_Login(str1, str2);

                FirebaseDatabase databaseReference = FirebaseDatabase.getInstance();
                Log.d(TAG, "onClick: "+databaseReference);



                Intent screen3 = new Intent(Screen2.this, Screen3.class);
                startActivity(screen3);
            }
        });
    }
}
