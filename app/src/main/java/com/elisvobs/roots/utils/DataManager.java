package com.elisvobs.roots.utils;

import com.elisvobs.roots.R;
import com.elisvobs.roots.model.Additive;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<Additive> mAdditives = new ArrayList<>();
    private int [] ADDITIVES = {};

    public static DataManager getInstance() {
        DataManager ourInstance = new DataManager();

        ourInstance.initializeAdditives();

        return ourInstance;
    }

    public List<Additive> getAdditiveNames() {
        return mAdditives;
    }

    public int[] getAdditiveImages() {
        return ADDITIVES;
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