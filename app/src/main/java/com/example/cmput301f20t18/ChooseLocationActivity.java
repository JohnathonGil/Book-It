package com.example.cmput301f20t18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Activity where the user can select a pick up location.
 */
public class ChooseLocationActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<UserLocation> locationList;

    /**
     * Initializes the list of locations and sets up adapter to display list of locations.
     *
     * @param savedInstanceState Previous saved state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_location);

        recyclerView = findViewById(R.id.location_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Setting the header title. This may be done in XML instead
        Toolbar toolbar = findViewById(R.id.mybooks_toolbar);
        toolbar.setTitle(getResources().getText(R.string.choose_location_header));

        // hardcoded some addresses to display
        Address address1 = new Address(Locale.getDefault());
        address1.setAddressLine(0, "8110 Argyll Rd NW");
        Address address2 = new Address(Locale.getDefault());
        address2.setAddressLine(0, "10305 80 Ave NW");

        locationList = new ArrayList<>();
        locationList.add(new UserLocation(address1, null));
        locationList.add(new UserLocation(address2, null));

        LocationAdapter locationAdapter = new LocationAdapter(this, locationList);
        recyclerView.setAdapter(locationAdapter);

    }
}