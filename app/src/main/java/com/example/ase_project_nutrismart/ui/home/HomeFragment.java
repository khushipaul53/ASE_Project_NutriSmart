package com.example.ase_project_nutrismart.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ase_project_nutrismart.R;
import com.example.ase_project_nutrismart.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        return rootView;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}