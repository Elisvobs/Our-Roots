package com.elisvobs.roots.fragments;

import com.elisvobs.roots.model.Recipes;

public class DirectionsFragment extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recipes.directions[index].split("`");
    }
}
