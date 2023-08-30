package com.example.chuadangadev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // single node data
       DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("copyWrite");
       databaseReference.setValue("Marufur. All right reserved.");


       // multiple node data
       DatabaseReference contactRef = FirebaseDatabase.getInstance().getReference("contactList");
       String contactId = contactRef.push().getKey();

       ContactModel contactModel = new ContactModel("Sadik","01757474700");

       contactRef.child(contactId).setValue(contactModel);




       // receive data
//        contactRef.child(contactId).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//               ContactModel model = snapshot.getValue(ContactModel.class);
//                Log.d("Data", "onDataChange: " + model.getName()+",  "+ model.getNumber());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Log.e("Error Database",  error.toString() );
//            }
//        });
    }
}