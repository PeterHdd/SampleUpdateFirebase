package com.example.peterhaddad.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
private DatabaseReference ref,taskd;
private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button2);
        ref= FirebaseDatabase.getInstance().getReference().child("users").child("123456789").child("Tasks").push();
        ref.child("done").setValue("false");
        ref.child("name").setValue("Task 1");
        ref.child("priority").setValue(5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               final DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("users").child("123456789").child("Tasks");
                ref.orderByChild("name").equalTo("Task 1").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            for(DataSnapshot datas: dataSnapshot.getChildren()){
                                String key=datas.getKey();
                                String name=datas.child("name").getValue().toString();
                                String priorities=datas.child("priority").getValue().toString();
                                ref.child(key).child("done").setValue("true");
                                ref.child(key).child("name").setValue(name);
                                ref.child(key).child("priority").setValue(priorities);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });
    }
}
