package com.example.revereselogistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.Objects;

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

     //   Objects.requireNonNull(getSupportActionBar()).setTitle("Home");

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.menu_screen3, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       /* int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                Intent settingsIntent = new Intent(this, Screen4.class);
                startActivity(settingsIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }*/
        return super.onOptionsItemSelected(item);
    }
}
