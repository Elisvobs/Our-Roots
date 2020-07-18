package com.elisvobs.roots.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.elisvobs.roots.R;
import com.elisvobs.roots.model.Recipes;
import com.elisvobs.roots.utils.ViewPagerFragment;

public class DualPaneFragment extends Fragment {
    private static final String INGREDIENTS_FRAGMENT = "ingredients_fragment";
    private static final String DIRECTIONS_FRAGMENT = "directions_fragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments() != null ? getArguments().getInt(
                ViewPagerFragment.KEY_RECIPE_INDEX) : 0;
        Toast.makeText(requireActivity(), Recipes.names[index],
                Toast.LENGTH_SHORT).show();
        requireActivity().setTitle(Recipes.names[index]);

        View view = inflater.inflate(R.layout.fragment_dualpane, container,false);

        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();

        IngredientsFragment savedIngredientsFragment = (IngredientsFragment) fragmentManager.
                findFragmentByTag(INGREDIENTS_FRAGMENT);
        if (savedIngredientsFragment == null){
            IngredientsFragment ingredientsFragment = new IngredientsFragment();
            transactFragment(index, fragmentManager, ingredientsFragment);
        }

        DirectionsFragment savedDirectionsFragment = (DirectionsFragment) fragmentManager.
                findFragmentByTag(DIRECTIONS_FRAGMENT);
        if (savedDirectionsFragment == null){
            DirectionsFragment directionsFragment = new DirectionsFragment();
            transactFragment(index, fragmentManager, directionsFragment);
        }
        return view;
    }

    private void transactFragment(int index, FragmentManager fragmentManager, Fragment fragment) {
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction().add(R.id.rightPlaceholder, fragment,
                DIRECTIONS_FRAGMENT).commit();
    }

    @Override
    public void onStop() {
        super.onStop();
        requireActivity().setTitle(getResources().getString(R.string.trad));
    }

}