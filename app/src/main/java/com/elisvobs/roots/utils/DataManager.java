package com.elisvobs.roots.utils;

import com.elisvobs.roots.model.Additive;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<Additive> mAdditives = new ArrayList<>();

    public static DataManager getInstance() {
        DataManager ourInstance = new DataManager();

        ourInstance.initializeAdditives();

        return ourInstance;
    }

    public List<Additive> getAdditives() {
        return mAdditives;
    }

    private void initializeAdditives() {
        mAdditives.add(new Additive("Traditional soda/Utyora"));
        mAdditives.add(new Additive("Hacha fruit syrup"));
        mAdditives.add(new Additive("Pumpkin seed oil"));
        mAdditives.add(new Additive("Tsunga seeds oil"));
        mAdditives.add(new Additive("Peanut butter"));
        mAdditives.add(new Additive("Baobab seeds"));
        mAdditives.add(new Additive("Legume flour"));
        mAdditives.add(new Additive("Mabumbe"));
    }

}