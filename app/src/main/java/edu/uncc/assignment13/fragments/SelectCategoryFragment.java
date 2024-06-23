package edu.uncc.assignment13.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import edu.uncc.assignment13.R;
import edu.uncc.assignment13.databinding.FragmentSelectCategoryBinding;
import edu.uncc.assignment13.models.Data;

public class SelectCategoryFragment extends Fragment {
    public SelectCategoryFragment() {
        // Required empty public constructor
    }

    FragmentSelectCategoryBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSelectCategoryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Select Category");
        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.listView.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, Data.categories));
    }

    public interface SelectCategoryListener {
    }
}