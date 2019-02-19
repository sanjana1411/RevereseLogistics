package com.example.revereselogistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

public class Screen3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        //initToolBar();
        Button graphview = (Button) findViewById(R.id.GView);


        graphview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screen3;
                screen3 = new Intent(Screen3.this, Screen4.class);
                startActivity(screen3);
            }
        });

//    public void initToolBar() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
//        // toolbar.setTitle(HOME);
//
//        setActionBar(toolbar);
//
//       // toolbar.setNavigationIcon(R.drawable.dot);
//        toolbar.setNavigationOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(Screen3.this, "clicking the toolbar!", Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );
//    }

    }
}
