package com.elisvobs.roots.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elisvobs.roots.R;
import com.elisvobs.roots.model.Additive;
import com.elisvobs.roots.viewholder.AdditiveViewHolder;

import java.util.List;

public class AdditiveAdapter extends RecyclerView.Adapter<AdditiveViewHolder> {
    private List<Additive> additives;

    public AdditiveAdapter(List<Additive> additives) {
        this.additives = additives;
    }

    @NonNull
    @Override
    public AdditiveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_add, parent,false);
        return new AdditiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdditiveViewHolder holder, int position) {
        holder.additive.setText(additives.get(position).name);
    }

    @Override
    public int getItemCount() {
        return additives.size();
    }
}
