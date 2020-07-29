package com.elisvobs.roots.viewholder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elisvobs.roots.About;
import com.elisvobs.roots.R;

public class AdditiveViewHolder extends RecyclerView.ViewHolder {
    public TextView additive;
    private Context context;

    public AdditiveViewHolder(@NonNull View view) {
        super(view);
        additive = view.findViewById(R.id.add_name);
        context = view.getContext();
        view.setClickable(true);
//        view.setOnClickListener(this::onClick);
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (getAdapterPosition()) {
            case 0:
                break;
            case 1:
                intent = new Intent(context, About.class);
                break;
        }
        context.startActivity(intent);
    }

}