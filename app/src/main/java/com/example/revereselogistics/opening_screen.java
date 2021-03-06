package com.example.revereselogistics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.revereselogistics.Fragments.HUL_Login_Fragment;
import com.example.revereselogistics.Fragments.Wholesaler_Login_Fragment;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class opening_screen extends AppCompatActivity {

    public static final String TAG = "pikachu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.opening_screen);

        Button btHUL = (Button) findViewById(R.id.HUL_id);
        Button btWholesale = (Button) findViewById(R.id.Wholesale_id);



        btHUL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: inside HUL Fragment");
                final DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                        .getReference().child("HUL");

                Log.d(TAG, "onClick: Line1"+databaseReference);

                /*databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.d(TAG, "onDataChange: ");
                        boolean isValid = false;
                        for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                            String reqID = dataSnapshot1.getKey();
                            Log.d(TAG, "onDataChange: " + reqID);
                            if(reqID == "HUL112" ) {
                                isValid = true;
                                Toast.makeText(opening_screen.this, "Succesfully Logged In!",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            }
                        }
                        if(!isValid) {
                            Toast.makeText(opening_screen.this, "Enter valid Credentials!!!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });*/


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
