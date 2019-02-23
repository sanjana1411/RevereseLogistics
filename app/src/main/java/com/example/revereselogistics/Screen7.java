package com.example.revereselogistics;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class Screen7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen7);

        Button settings = (Button) findViewById(R.id.settings);
        Button track = (Button) findViewById(R.id.track);
        Button policy = (Button) findViewById(R.id.policy);


        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screen2 = new Intent(Screen7.this, Screen8.class);
                startActivity(screen2);
            }
        });
        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screen2 = new Intent(Screen7.this, order_track.class);
                startActivity(screen2);

            }
        });
        policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screen2 = new Intent(Screen7.this, e_wasteMgtPolicy.class);
                startActivity(screen2);

            }
        });
    }

}
