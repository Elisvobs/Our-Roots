package com.elisvobs.roots.utils;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.elisvobs.roots.R;
import com.elisvobs.roots.fragments.DirectionsFragment;
import com.elisvobs.roots.fragments.IngredientsFragment;
import com.elisvobs.roots.model.Recipes;
import com.google.android.material.tabs.TabLayout;

public class ViewPagerFragment extends Fragment {
    public static final String KEY_RECIPE_INDEX = "recipe_index";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments() != null
                ? getArguments().getInt(KEY_RECIPE_INDEX) : 0;
        Toast.makeText(requireActivity(), Recipes.names[index],
                Toast.LENGTH_SHORT).show();
        requireActivity().setTitle(Recipes.names[index]);

        View view = inflater.inflate(R.layout.fragment_viewpager,
                container,false);

        final IngredientsFragment ingredientsFragment = new IngredientsFragment();
        addIndex(index, ingredientsFragment);

        final DirectionsFragment directionsFragment = new DirectionsFragment();
        addIndex(index, directionsFragment);

        ViewPager viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(requireActivity().getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return position == 0 ? ingredientsFragment : directionsFragment;
            }

            @NonNull
            @Override
            public CharSequence getPageTitle(int position) {
                return position == 0 ? "Ingredients" : "Directions";
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private void addIndex(int index, Fragment fragment) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX, index);
        fragment.setArguments(bundle);
    }

    @Override
    public void onStop() {
        super.onStop();
        requireActivity().setTitle(getResources().getString(R.string.trad));
    }

}