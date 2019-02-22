package com.example.revereselogistics;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ReturnInfoAdapter extends ArrayAdapter<ReturnInfo>{

    private static final String LOG_TAG = ReturnInfoAdapter.class.getSimpleName();

    public ReturnInfoAdapter(Activity context, ArrayList<ReturnInfo> returninfo) {
        super(context , 0,  returninfo);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        ReturnInfo currentinfo = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.wh_id);
        nameTextView.setText(currentinfo.getMwholesalerid());

        TextView numberTextView = (TextView) listItemView.findViewById(R.id.return_id);
        numberTextView.setText(currentinfo.getMreturnid());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        dateTextView.setText(currentinfo.getMreturnid());

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        timeTextView.setText(currentinfo.getMreturnid());



        return listItemView;
    }
}
