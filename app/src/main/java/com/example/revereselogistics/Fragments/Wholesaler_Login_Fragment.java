package com.example.revereselogistics.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.revereselogistics.R;

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
                String whUserId = etWhId.getText().toString();
                String whPassword = etWhPassword.getText().toString();
            }
        });

        btWhSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return fragmentView;
    }


}
