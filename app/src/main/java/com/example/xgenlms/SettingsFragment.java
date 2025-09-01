package com.example.xgenlms;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    public SettingsFragment() {
        // Required empty public constructor
    }

    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Handle any fragment arguments here if needed
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the XML layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // Find the Change Password button by its ID
        Button changePasswordButton = view.findViewById(R.id.btn_change_password);

        // Set an OnClickListener to handle the button click
        changePasswordButton.setOnClickListener(v -> {
            // Intent to navigate to ChangePasswordActivity when button is clicked
            Intent intent = new Intent(getActivity(), ChangePasswordActivity.class);
            startActivity(intent);
        });

        return view;
    }
}
