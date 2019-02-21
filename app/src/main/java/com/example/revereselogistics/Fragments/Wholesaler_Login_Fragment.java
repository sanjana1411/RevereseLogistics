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

        View fragmentView = inflater.inflate(R.layout.fragment_wholesaler__login_, container, false);
        Log.d("pikachu", "onCreateView: Inflated");
        Button btInfo = fragmentView.findViewById(R.id.info);
        TextView tvWhName = fragmentView.findViewById(R.id.wh_name);
        TextView tvWhNumber = fragmentView.findViewById(R.id.wh_name);
        TextView tvWhMail = fragmentView.findViewById(R.id.wh_mail);
        TextView tvAdd1 = fragmentView.findViewById(R.id.add1);
        TextView tvAdd2 = fragmentView.findViewById(R.id.add2);
        TextView tvAdd3 = fragmentView.findViewById(R.id.add3);
        TextView tvReturn1 = fragmentView.findViewById(R.id.return_1);
        TextView tvDate1  = fragmentView.findViewById(R.id.date_1);
        TextView tvTime1 = fragmentView.findViewById(R.id.time_1);
        TextView tvReturn2 = fragmentView.findViewById(R.id.return_2);
        TextView tvDate2  = fragmentView.findViewById(R.id.date_2);
        TextView tvTime2 = fragmentView.findViewById(R.id.time_2);
        TextView tvReturn3 = fragmentView.findViewById(R.id.return_3);
        TextView tvDate3  = fragmentView.findViewById(R.id.date_3);
        TextView tvTime3 = fragmentView.findViewById(R.id.time_3);
        Button btRequestReturn = fragmentView.findViewById(R.id.request_return);


        return fragmentView;
    }


}
