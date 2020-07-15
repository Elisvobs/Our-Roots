package com.elisvobs.roots.adapters;

import com.elisvobs.roots.R;
import com.elisvobs.roots.fragments.GridFragment;

public class GridAdapter extends RecyclerAdapter {

    private final GridFragment.OnRecipeSelectedInterface mListener;

    public GridAdapter(GridFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.grid_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListener.onGridRecipeSelected(index);
    }

}