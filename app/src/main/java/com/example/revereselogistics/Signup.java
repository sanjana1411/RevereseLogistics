package com.example.revereselogistics;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.revereselogistics.POJOs.Wholesaler_Details;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Signup extends AppCompatActivity /*implements AdapterView.OnItemSelectedListener*/ {

    //private String region = "";
    //private ArrayList<String> regionCodes = new ArrayList<>();
    public static final String TAG = "pikachu";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        final EditText e1, e2, e3, e4, e5, e6;
        final Spinner s3;
        e1 = findViewById(R.id.name);
        e2 = findViewById(R.id.contact);
        e3 = findViewById(R.id.region);
        e4 = findViewById(R.id.email);
        e5 = findViewById(R.id.pwd);
        e6 = findViewById(R.id.etuser_name);

        /*final ArrayList<String> regionsList = new ArrayList<>();

        Log.d(TAG, "onCreate: ArrayList created");*/


        /*final DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                .getReference();

        databaseReference.child("Region").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    regionsList.add((String)dataSnapshot1.getValue());
                    regionCodes.add(dataSnapshot1.getKey());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(Signup.this,
                android.R.layout.simple_spinner_item, regionsList);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(adapter);
        s3.setSelection(0);
        Log.d(TAG, "onCreate: Before listener");
        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                s3.setSelection(i);
                Log.d(TAG, "onItemSelected: selected yayee");

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Log.d(TAG, "onCreate: After Listener");*/


        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                

                Log.d(TAG, "onClick: submit clicked");
                
                final String name = e1.getText().toString();
                final String contact = e2.getText().toString();
                final String region = e3.getText().toString();
                final String email = e4.getText().toString();
                final String password = e5.getText().toString();
                final String userName = e6.getText().toString();

                final DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                        .getReference();
                Log.d(TAG, "onClick: got the reference");

                databaseReference.child("Wholesaler").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(userName)) {
                            Toast.makeText(Signup.this, "UserName already exists!", Toast.LENGTH_SHORT).show();
                        } else {
                            boolean empty = false;

                            if((name.equals("")) || (contact.equals("")) || (region.equals("")) || (email.equals("")) || (password.equals(""))) {
                                Toast.makeText(Signup.this, "One or More fields are empty", Toast.LENGTH_SHORT).show();
                                empty = true;
                            }

                                //TODO : push the details to firebase clouds;

                                Log.d(TAG, "onDataChange: "+empty);
                                if(empty==false)
                                {
                                    Wholesaler_Details wh_Details = new Wholesaler_Details(
                                            email, name, password, contact, region);
                                    databaseReference.child("Wholesaler").child(userName)
                                            .setValue(wh_Details);

                                    Intent i = new Intent(Signup.this, Screen6.class);
                                    i.putExtra("whUsername", userName);
                                    startActivity(i);
                                }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });







            }
        });


    }

    /*@Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d(TAG, "onItemSelected: Selecting Item"+adapterView.getItemAtPosition(i));
        region = regionCodes.get(i);
        Log.d(TAG, "onItemSelected: Item selected");
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }*/


}
