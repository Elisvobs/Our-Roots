package com.elisvobs.roots.ui.additive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.elisvobs.roots.R;

public class AdditiveFragment extends Fragment {

    private AdditiveViewModel mAdditiveViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mAdditiveViewModel =
                ViewModelProviders.of(this).get(AdditiveViewModel.class);
        View root = inflater.inflate(R.layout.fragment_additive, container, false);
        return root;
    }
}
