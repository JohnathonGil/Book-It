package com.example.cmput301f20t18;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

/**
 * This is a splash screen activity
 * @author Chase/ Sean
 * UI contrabutions
 * @author Johnathon Gil
 */

public class SearchFragment extends Fragment {

    /**
     * Creates the instance of the fragment, adds all the elements of the xml, then returns the view object
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return view
     */

    private Long isbn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        EditText searchEditText = null;
        Button searchButton;
        ListView searchResultList;

        String isbn = getArguments().getString("ISBN");
        if (isbn != null) {
            searchEditText.setText(isbn);
        }

        TabLayout tabLayout = view.findViewById(R.id.search_tab_layout);
        ViewPager viewPager = view.findViewById(R.id.search_viewPager);

        SearchPageAdapter pageAdapter = new SearchPageAdapter(getChildFragmentManager(), tabLayout.getTabCount(), getContext());

        viewPager.setAdapter(pageAdapter);

        //Set up spinner
        SpinnerOnClickListener spinnerListener = new SpinnerOnClickListener();

        Spinner searchSpinner = view.findViewById(R.id.search_spinner);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.search_spinner_array, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        searchSpinner.setAdapter(spinnerAdapter);
        searchSpinner.setOnItemSelectedListener(spinnerListener);

        //Set up search bar edit text
        searchEditText = view.findViewById(R.id.search_edit_text);

        //Set up search button
        searchButton = view.findViewById(R.id.search_button);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String selectedOption = spinnerListener.getSelected();
                //Currently debug text. Will in the future instantiate the proper object
                //In order to conduct a search
                if (selectedOption.equals("Books")){
                    Library lib = new Library();                    //May replace with User's static lib to avoid instantiating twice
                    Log.d("Search", "Books are neat");
                }
                else{
                    Log.d("Search", "Users are cool");
                }
            }
        });

        return view;
    }

    /**
     * An OnClickListener with the ability to return data to the fragment
     */
    private class SpinnerOnClickListener implements AdapterView.OnItemSelectedListener{
        String searchOption = "Books";

        /**
         * Called when an item is selected. Sets searchOption to
         * the current selection of spinner
         */
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             searchOption = parent.getItemAtPosition(position).toString();
        }

        /**
         * Called when nothing is selected and currently does nothing
         */
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            //Do Nothing
        }

        /**
         * Grabs data from the listener
         * @return The current selected item in listener
         */
        public String getSelected(){
            return searchOption;
        }
    }
}
