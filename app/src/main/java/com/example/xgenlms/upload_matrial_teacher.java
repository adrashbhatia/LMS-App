package com.example.xgenlms;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class upload_matrial_teacher extends Fragment {

    private EditText materialDescriptionInput;
    private EditText materialLinkInput;
    private Button saveMaterialButton;
    private RecyclerView materialsRecyclerView;
    private uploadMaterialAdapter materialAdapter;
    private List<MaterialItem> materialsList;

    public upload_matrial_teacher() {
        // Required empty public constructor
    }

    public static upload_matrial_teacher newInstance(String param1, String param2) {
        upload_matrial_teacher fragment = new upload_matrial_teacher();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Retrieve arguments if needed
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upload_matrial_teacher, container, false);

        materialDescriptionInput = view.findViewById(R.id.material_description_input);
        materialLinkInput = view.findViewById(R.id.material_link_input);
        saveMaterialButton = view.findViewById(R.id.save_material_button);
        materialsRecyclerView = view.findViewById(R.id.materialsRecyclerView);

        // Initialize RecyclerView
        materialsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        materialsList = new ArrayList<>();
        materialAdapter = new uploadMaterialAdapter(materialsList);
        materialsRecyclerView.setAdapter(materialAdapter);

        materialAdapter.setOnItemClickListener(new uploadMaterialAdapter.OnItemClickListener() {
            @Override
            public void onEditClick(int position) {
                // Handle edit action here
                MaterialItem item = materialsList.get(position);
                showEditDialog(position, item);
            }

            @Override
            public void onDeleteClick(int position) {
                // Handle delete action here
                showDeleteConfirmationDialog(position);
            }
        });

        saveMaterialButton.setOnClickListener(v -> saveMaterial());

        return view;
    }

    private void saveMaterial() {
        String description = materialDescriptionInput.getText().toString().trim();
        String link = materialLinkInput.getText().toString().trim();

        if (description.isEmpty() || link.isEmpty()) {
            Toast.makeText(getContext(), "Please enter both description and link", Toast.LENGTH_SHORT).show();
            return;
        }

        new AlertDialog.Builder(getContext())
                .setTitle("Confirm Upload")
                .setMessage("Are you sure you want to upload this material?")
                .setPositiveButton("Confirm", (dialog, which) -> {
                    // Add new material to the list
                    materialsList.add(new MaterialItem(description, link));
                    materialAdapter.notifyDataSetChanged();
                    materialDescriptionInput.setText("");
                    materialLinkInput.setText("");
                    Toast.makeText(getContext(), "Material saved", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    private void showEditDialog(int position, MaterialItem item) {
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_edit_material, null);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText editDescription = dialogView.findViewById(R.id.edit_description);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText editLink = dialogView.findViewById(R.id.edit_link);

        editDescription.setText(item.getDescription());
        editLink.setText(item.getLink());

        new AlertDialog.Builder(getContext())
                .setTitle("Edit Material")
                .setView(dialogView)
                .setPositiveButton("Save", (dialog, which) -> {
                    String newDescription = editDescription.getText().toString().trim();
                    String newLink = editLink.getText().toString().trim();

                    if (newDescription.isEmpty() || newLink.isEmpty()) {
                        Toast.makeText(getContext(), "Please enter both description and link", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    materialsList.set(position, new MaterialItem(newDescription, newLink));
                    materialAdapter.notifyItemChanged(position);
                    Toast.makeText(getContext(), "Material updated", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    private void showDeleteConfirmationDialog(int position) {
        new AlertDialog.Builder(getContext())
                .setTitle("Delete Confirmation")
                .setMessage("Are you sure you want to delete this material?")
                .setPositiveButton("Delete", (dialog, which) -> {
                    materialsList.remove(position);
                    materialAdapter.notifyItemRemoved(position);
                    Toast.makeText(getContext(), "Material deleted", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}
