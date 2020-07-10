package com.elisvobs.roots.ui.preps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.elisvobs.roots.R;

public class PrepsFragment extends Fragment {

    private PrepsViewModel mPrepsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mPrepsViewModel =
                ViewModelProviders.of(this).get(PrepsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_preps, container, false);

        return root;
    }
}
