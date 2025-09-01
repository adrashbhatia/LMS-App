package com.example.xgenlms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<ListData> {

    public ListAdapter(@NonNull Context context, ArrayList<ListData> dataArrayList) {
        super(context, R.layout.list_view, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ListData listData = getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }

        TextView courseName = view.findViewById(R.id.course_name);
        ImageView courseImage = view.findViewById(R.id.listimage);

        courseName.setText(listData.getName());
        courseImage.setImageResource(listData.getImage());

        return view;
    }
}
