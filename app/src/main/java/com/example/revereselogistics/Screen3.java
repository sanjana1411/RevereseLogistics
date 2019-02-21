package com.example.revereselogistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

public class Screen3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        //initToolBar();

        String[] reason = {"Expired","Damaged","Defective","Surplus"};
        String[] region = {"Delhi","Mumbai","Chennai","Kolkata"};

        Spinner spin = (Spinner) findViewById(R.id.reason_spin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.reason,
                R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
