package com.elisvobs.roots.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.elisvobs.roots.MushroomActivity;
import com.elisvobs.roots.R;
import com.elisvobs.roots.adapters.ListAdapter;
import com.google.android.material.card.MaterialCardView;

public class ListFragment extends Fragment implements View.OnClickListener {

    public interface OnRecipeSelectedInterface {
        void onListRecipeSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        OnRecipeSelectedInterface listener = (OnRecipeSelectedInterface) getActivity();
//        OnRecipeSelectedInterface listener = (OnRecipeSelectedInterface) getParentFragment();
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        MaterialCardView additive, fermented;
        additive = view.findViewById(R.id.additive);
        fermented = view.findViewById(R.id.fermented);

        additive.setOnClickListener(this);
        fermented.setOnClickListener(this);

        ListAdapter listAdapter = new ListAdapter(listener);
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(
                getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.additive:
                startActivity(new Intent(getContext(), MushroomActivity.class));
                break;
            case R.id.fermented:
                break;
        }
    }
}
