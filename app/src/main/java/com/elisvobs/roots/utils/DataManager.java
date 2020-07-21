package com.elisvobs.roots.utils;

import com.elisvobs.roots.R;
import com.elisvobs.roots.model.Additive;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<Additive> mAdditives = new ArrayList<>();
    int[] ADDITIVES = {
            R.drawable.soda,
            R.drawable.hacha,
            R.drawable.pumpkin,
            R.drawable.tsunga_seed,
            R.drawable.peanut,
            R.drawable.baobab,
            R.drawable.legume_flour
    };
    int[] ADDITIVE_NAMES = {
            R.string.soda,
            R.string.hacha,
            R.string.pumpkin,
            R.string.tsunga_seeds,
            R.string.peanut,
            R.string.baobab,
            R.string.legume_flour
    };

    public static DataManager getInstance() {
        DataManager ourInstance = new DataManager();

        ourInstance.initializeAdditives();

        return ourInstance;
    }

//    public List<Additive> getAdditives() {
//        return mAdditives;
//    }

    public int[] getAdditiveImages() {
        return ADDITIVES;
    }

    public int[] getAdditiveNames() {
        return ADDITIVE_NAMES;
    }

    private void initImages() {}

    private void initializeAdditives() {

        mAdditives.add(new Additive(R.string.soda));
        mAdditives.add(new Additive(R.string.hacha));
        mAdditives.add(new Additive(R.string.pumpkin));
        mAdditives.add(new Additive(R.string.tsunga_seeds));
        mAdditives.add(new Additive(R.string.peanut));
        mAdditives.add(new Additive(R.string.baobab));
        mAdditives.add(new Additive(R.string.legume_flour));
    }

}