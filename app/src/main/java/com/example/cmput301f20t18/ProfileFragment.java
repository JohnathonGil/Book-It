package com.example.cmput301f20t18;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This is a class that creates options for the use of the ISBN
 * The class is still under development so the elements that appear on screen are mostly visual
 * with the exception of cancel
 * @author Johnathon Gil
 * @author
 */

public class ProfileFragment extends Fragment {

    TextView username, phoneNum, email, editAccount;
    Button signOut;
    ImageView profilePic;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyBooksAvailableFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        username = (TextView) view.findViewById(R.id.my_user_name);
        phoneNum = (TextView) view.findViewById(R.id.phone_num);
        email = (TextView) view.findViewById(R.id.email);
        editAccount = (TextView) view.findViewById(R.id.edit_profile);

        profilePic = (ImageView) view.findViewById(R.id.profile_pic);

        String text = "Edit Account";

        SpannableString  editProf = new SpannableString(text);

        ClickableSpan redirect = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {

                Intent editIntent = new Intent(getContext(),EditProfile.class);
                startActivity(editIntent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(getResources().getColor(R.color.doveGray));
            }
        };

        editProf.setSpan(redirect,0,12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        editAccount.setText(editProf);
        editAccount.setMovementMethod(LinkMovementMethod.getInstance());

        username.setText("MysticWolf");
        phoneNum.setText("780 933 8641");
        email.setText("jggil@ualberta.ca");

        return view;
    }
}
