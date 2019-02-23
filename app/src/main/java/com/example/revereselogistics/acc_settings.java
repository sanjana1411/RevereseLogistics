
package com.example.revereselogistics;

        import android.content.Intent;
        import android.support.annotation.NonNull;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

public class acc_settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_setting);

        Intent callerIntent = getIntent();
        final String whUsername = callerIntent.getStringExtra("whUsername");

        final TextView tvWhName = findViewById(R.id.wh_name);
        final TextView tvWhContact = findViewById(R.id.wh_number);
        final TextView tvWhMail = findViewById(R.id.wh_mail);


        final DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                .getReference().child("Wholesaler").child(whUsername);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                tvWhName.setText((String) dataSnapshot.child("Name").getValue());
                Log.d("pikachu", "onDataChange: wohooo " + dataSnapshot.child("Name").getValue());
                tvWhContact.setText(""+dataSnapshot.child("Ph_no").getValue());
                tvWhMail.setText((String) dataSnapshot.child("Email_id").getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Button return_butt =(Button) findViewById(R.id.request_return);

        return_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent screen6;
//                screen6 = new Intent(acc_settings.this, Screen11.class);
//  startActivity(screen6);
            }
        });
    }
}







