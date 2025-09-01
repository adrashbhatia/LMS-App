package com.example.xgenlms;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class uploadMaterialAdapter extends RecyclerView.Adapter<uploadMaterialAdapter.MaterialViewHolder> {

    private List<MaterialItem> materialsList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onEditClick(int position);
        void onDeleteClick(int position);
    }

    public uploadMaterialAdapter(List<MaterialItem> materialsList) {
        this.materialsList = materialsList;
    }

    @NonNull
    @Override
    public MaterialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_uploadmaterial, parent, false);
        return new MaterialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MaterialViewHolder holder, int position) {
        MaterialItem material = materialsList.get(position);
        holder.descriptionTextView.setText(material.getDescription());
        holder.linkTextView.setText(material.getLink());

        // Handle link clicks
        holder.linkTextView.setOnClickListener(v -> {
            Uri uri = Uri.parse(material.getLink());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            if (intent.resolveActivity(holder.itemView.getContext().getPackageManager()) != null) {
                holder.itemView.getContext().startActivity(intent);
            } else {
                Toast.makeText(holder.itemView.getContext(), "No application can handle this request.", Toast.LENGTH_SHORT).show();
            }
        });

        // Set up edit and delete button listeners
        holder.editButton.setOnClickListener(v -> {
            if (listener != null) {
                listener.onEditClick(position);
            }
        });

        holder.deleteButton.setOnClickListener(v -> {
            if (listener != null) {
                listener.onDeleteClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return materialsList.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    static class MaterialViewHolder extends RecyclerView.ViewHolder {
        TextView descriptionTextView;
        TextView linkTextView;
        Button editButton;
        Button deleteButton;

        MaterialViewHolder(View itemView) {
            super(itemView);
            descriptionTextView = itemView.findViewById(R.id.material_description);
            linkTextView = itemView.findViewById(R.id.material_link);
            editButton = itemView.findViewById(R.id.edit_button);
            deleteButton = itemView.findViewById(R.id.delete_button);
        }
    }
}
