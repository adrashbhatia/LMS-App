package com.example.xgenlms;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MaterialAdapter extends RecyclerView.Adapter<MaterialAdapter.MaterialViewHolder> {

    private final List<Material> materialList;

    public MaterialAdapter(List<Material> materialList) {
        this.materialList = materialList;
    }

    @NonNull
    @Override
    public MaterialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.material_item, parent, false);
        return new MaterialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MaterialViewHolder holder, int position) {
        Material material = materialList.get(position);
        holder.descriptionTextView.setText(material.getDescription());
        holder.descriptionTextView.setOnClickListener(v -> {
            // Open the URL in a web browser
            String url = material.getUrl();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return materialList.size();
    }

    static class MaterialViewHolder extends RecyclerView.ViewHolder {
        final TextView descriptionTextView;

        MaterialViewHolder(View itemView) {
            super(itemView);
            descriptionTextView = itemView.findViewById(R.id.materialDescription);
        }
    }
}
