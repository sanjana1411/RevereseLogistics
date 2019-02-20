
package com.example.revereselogistics;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class Screen6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen6);

        Button return_butt =(Button) findViewById(R.id.request_return);

        return_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screen6;
                screen6 = new Intent(Screen6.this, Screen11.class);
                startActivity(screen6);
            }
        });
    }
}







