package com.example.revereselogistics.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.revereselogistics.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HUL_Login_Fragment extends Fragment {

public static final String TAG = "pikachu";


    public HUL_Login_Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_hul__login_, container, false);
        //FirebaseApp.initializeApp(this);

        final EditText etHUL_EmpId = fragmentView.findViewById(R.id.etHUL_empid);
        final EditText etHUL_password = fragmentView.findViewById(R.id.etHUL_password);
        final Button btHUL_login = fragmentView.findViewById(R.id.btHUL_login);



        btHUL_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String etEmpId = etHUL_EmpId.getText().toString();
                final String etPassword = etHUL_password.getText().toString();

                if(!etEmpId.equals("") && !etPassword.equals("")) {
                    Log.d(TAG, "onClick: inside HUL Fragment");
                    final DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                            .getReference().child("HUL");


                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Log.d(TAG, "onDataChange: ");
                            boolean isValid = false;
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                String reqID = dataSnapshot1.getKey();
                                if (reqID.equals(etEmpId) &&
                                        dataSnapshot1.child("Password").getValue().equals(etPassword)) {
                                    isValid = true;
                                    Toast.makeText(getActivity(), "Succesfully Logged In!",
                                            Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            }
                            if (!isValid) {
                                Toast.makeText(getActivity(), "Enter valid Credentials!!!",
                                        Toast.LENGTH_SHORT).show();
                                etHUL_EmpId.setText("");
                                etHUL_password.setText("");
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                } else {
                    Toast.makeText(getActivity(), "Enter credentials first",
                            Toast.LENGTH_SHORT).show();
                }

                //Toast.makeText(getActivity(), "Toast", Toast.LENGTH_SHORT).show();
                //Log.d(TAG, "onClick: " + databaseReference.child("HUL").child(etEmpId));
            }
        });




        return fragmentView;
    }

}
