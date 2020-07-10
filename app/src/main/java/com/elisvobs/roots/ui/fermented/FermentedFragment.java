package com.elisvobs.roots.ui.fermented;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.elisvobs.roots.R;

public class FermentedFragment extends Fragment {

    private FermentedViewModel mFermentedViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mFermentedViewModel =
                ViewModelProviders.of(this).get(FermentedViewModel.class);
        View root = inflater.inflate(R.layout.fragment_fermented, container, false);
        return root;
    }
}
