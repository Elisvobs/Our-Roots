package com.elisvobs.roots.fragments;

import com.elisvobs.roots.model.Recipes;

public class IngredientsFragment  extends CheckBoxesFragment{
    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}