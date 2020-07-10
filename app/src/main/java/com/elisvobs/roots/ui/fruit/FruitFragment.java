package com.elisvobs.roots.ui.fruit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.elisvobs.roots.R;

public class FruitFragment extends Fragment {

    private FruitViewModel mFruitViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mFruitViewModel =
                ViewModelProviders.of(this).get(FruitViewModel.class);
        View root = inflater.inflate(R.layout.fragment_fruit, container, false);
        return root;
    }
}
