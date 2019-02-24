package com.example.revereselogistics.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.revereselogistics.R;
import com.example.revereselogistics.Screen6;
import com.example.revereselogistics.Signup;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;


public class Wholesaler_Login_Fragment extends Fragment {



    public Wholesaler_Login_Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View fragmentView = inflater.inflate(R.layout.fragment_wholesaler__login_, container, false);
        Log.d("pikachu", "onCreateView: Inflated");
        final EditText etWhId = fragmentView.findViewById(R.id.et_whuid);
        final EditText etWhPassword = fragmentView.findViewById(R.id.et_whpassword);
        Button btWholesale_Login = fragmentView.findViewById(R.id.bt_wholesale_login);
        Button btWhSignUp = fragmentView.findViewById(R.id.bt_whsignup);


        btWholesale_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String whUserId = etWhId.getText().toString();
                final String whPassword = etWhPassword.getText().toString();

                Log.d("pikachu", "onClick: Login wholesaler clicked");

                if(!whUserId.equals("") && !whPassword.equals("")) {
                    final DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                            .getReference().child("Wholesaler");

                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            boolean isValid = false;
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                String available_uid = dataSnapshot1.getKey();
                                if (available_uid.equals(whUserId) &&
                                        dataSnapshot1.child("Password").getValue().equals(whPassword)) {
                                    isValid = true;
                                    Toast.makeText(getActivity(),
                                            "Successfully Logged In!",
                                            Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(getActivity(), Screen6.class);
                                    i.putExtra("whUsername", whUserId);
                                    startActivity(i);
                                    break;
                                }
                            }
                            if (!isValid) {
                                Toast.makeText(getActivity(),
                                        "Enter valid credentias!",
                                        Toast.LENGTH_SHORT).show();
                                etWhId.setText("");
                                etWhPassword.setText("");
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                } else {
                    Toast.makeText(getActivity(), "Enter credentials first!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btWhSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Signup.class);
                startActivity(i);
            }
        });


        return fragmentView;
    }


}
