package com.example.xgenlms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.app.Activity.RESULT_OK;

public class QueryFragment extends Fragment {

    private static final int PICK_FILE_REQUEST = 1;

    private EditText editTextQuery;
    private Button buttonSubmitQuery;
    private ImageView attachmentIcon;
    private TextView attachedFileName;
    private Uri attachedFileUri;

    public QueryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_query, container, false);

        // Initialize UI components
        editTextQuery = view.findViewById(R.id.editTextQuery);
        buttonSubmitQuery = view.findViewById(R.id.buttonSubmitQuery);
        attachmentIcon = view.findViewById(R.id.attachmentIcon);
        attachedFileName = view.findViewById(R.id.attachedFileName);

        // Set click listener for the attachment icon
        attachmentIcon.setOnClickListener(v -> openFileChooser());

        // Set click listener for the submit button
        buttonSubmitQuery.setOnClickListener(v -> {
            String query = editTextQuery.getText().toString().trim();

            if (TextUtils.isEmpty(query)) {
                Toast.makeText(getActivity(), "Please enter a query", Toast.LENGTH_SHORT).show();
            } else {
                submitQueryToAdmin(query);
            }
        });

        return view;
    }

    // Method to open the file chooser
    private void openFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*"); // You can restrict to specific types like "application/pdf" or "image/*"
        startActivityForResult(Intent.createChooser(intent, "Select File"), PICK_FILE_REQUEST);
    }

    // Handle file selection
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_FILE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            attachedFileUri = data.getData(); // Get the URI of the selected file

            // Extract the file name from the URI and display it
            String fileName = attachedFileUri.getLastPathSegment();
            attachedFileName.setText(fileName != null ? fileName : "File selected");
        }
    }

    // Method to submit query along with the attachment to the admin
    private void submitQueryToAdmin(String query) {
        // TODO: Implement logic to send the query and the attachment to the admin

        if (attachedFileUri != null) {
            Toast.makeText(getActivity(), "Query submitted with attachment: " + query, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Query submitted without attachment: " + query, Toast.LENGTH_SHORT).show();
        }

        // Clear the input fields after submission
        editTextQuery.setText("");
        attachedFileName.setText("No file selected");
        attachedFileUri = null;
    }
}
