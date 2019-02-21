package com.example.revereselogistics.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.revereselogistics.POJOs.HUL_Login;
import com.example.revereselogistics.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HUL_Login_Fragment extends Fragment {




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

        final EditText etHUL_Username = fragmentView.findViewById(R.id.HUL_uid);
        final EditText etHUL_password = fragmentView.findViewById(R.id.HUL_password);
        final Button btHUL_login = fragmentView.findViewById(R.id.HUL_login);

        String str1 = etHUL_Username.getText().toString();
        String str2 = etHUL_password.getText().toString();
        HUL_Login obj = new HUL_Login(str1, str2);



        return fragmentView;
    }

}
