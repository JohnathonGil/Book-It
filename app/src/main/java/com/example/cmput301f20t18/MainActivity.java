package com.example.cmput301f20t18;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent loginIntent = new Intent(MainActivity.this, Login.class);
        //startActivity(loginIntent);

        /* Testing bottom navigation menu */

        Intent homeScreenIntent = new Intent(MainActivity.this, HomeScreen.class);
        startActivity(homeScreenIntent);

        //Intent intent = new Intent(MainActivity.this, SelectLocationActivity.class);
        //startActivity(intent);
    }
}