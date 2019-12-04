package com.elisvobs.roots;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodRecyclerViewAdapter extends RecyclerView.Adapter<FoodRecyclerViewAdapter.RecyclerAdapterViewHolder> {
    List<Food> foods;

    public FoodRecyclerViewAdapter(List<Food> foods) {
        this.foods = foods;
    }

    public static class RecyclerAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public RecyclerAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_name);
        }
    }

    @NonNull
    @Override
    public RecyclerAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new RecyclerAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterViewHolder holder, int position) {
        holder.name.setText(foods.get(position).name);
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }
}