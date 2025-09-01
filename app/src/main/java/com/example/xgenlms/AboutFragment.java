package com.example.xgenlms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.xgenlms.R; // Replace with your package name
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class AboutFragment extends Fragment {

    private static final String WEBSITE_URL = "https://xgentechnologies.com/"; // Replace with your actual website URL

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        Button visitWebsiteButton = view.findViewById(R.id.www1);
        visitWebsiteButton.setOnClickListener(v -> openWebsite());

        return view;
    }

    private void openWebsite() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(WEBSITE_URL));
        startActivity(browserIntent);
    }
}
