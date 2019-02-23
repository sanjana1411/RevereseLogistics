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

public class Signup extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //private String region = "";
    //private ArrayList<String> region= new ArrayList<>();
    public static final String TAG = "pikachu";
   //String[] region = {"Delhi", "Mumbai", "Chennai", "Kolkata"};
    private String regionCodeFinal = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        final EditText e1, e2, e4, e5, e6;
       // final Spinner s3;
        e1 = findViewById(R.id.name);
        e2 = findViewById(R.id.contact);
       // e3 = findViewById(R.id.region_spin);
        e4 = findViewById(R.id.email);
        e5 = findViewById(R.id.pwd);
        e6 = findViewById(R.id.etuser_name);

        final DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                .getReference();



        Spinner spin = findViewById(R.id.region_spin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.region,
                R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);




        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                

                Log.d(TAG, "onClick: submit clicked");
                
                final String name = e1.getText().toString();
                final String contact = e2.getText().toString();
                //final String region = e3.getText().toString();
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

                            if((name.equals("")) || (contact.equals("")) || (regionCodeFinal.equals("")) || (email.equals("")) || (password.equals(""))) {
                                Toast.makeText(Signup.this, "One or More fields are empty", Toast.LENGTH_SHORT).show();
                                empty = true;
                            }

                                //TODO : push the details to firebase clouds;

                                Log.d(TAG, "onDataChange: "+empty);
                                if(empty==false)
                                {
                                    Wholesaler_Details wh_Details = new Wholesaler_Details(
                                            email, name, password, contact, regionCodeFinal);
                                    databaseReference.child("Wholesaler").child(userName)
                                            .setValue(wh_Details);

                                    Intent screen2 = new Intent(Signup.this, acc_settings.class);
                                    startActivity(screen2);
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String[] regionCodesArray = getResources().getStringArray(R.array.regionCodes);
        switch (i){
            case 0:
                 regionCodeFinal = regionCodesArray[i];
                 break;
            case 1:
                regionCodeFinal = regionCodesArray[i];
                break;
            case 2:
                regionCodeFinal = regionCodesArray[i];
                break;
            case 3:
                regionCodeFinal = regionCodesArray[i];
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {


    }


}
