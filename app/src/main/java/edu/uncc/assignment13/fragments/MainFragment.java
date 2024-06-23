package edu.uncc.assignment13.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import edu.uncc.assignment13.R;
import edu.uncc.assignment13.databinding.FragmentMainBinding;
import edu.uncc.assignment13.models.Data;
import edu.uncc.assignment13.models.Task;

public class MainFragment extends Fragment implements MenuProvider {
    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    FragmentMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Tasks");
        getActivity().addMenuProvider(this, getViewLifecycleOwner());
        //setup the view pager and the tabs, use the adapter to show the tasks
        //the selections are in Data.tabSelections
        //the fragment loaded should be the TaskListFragment and send it the selected category

    }

    @Override
    public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.main_menu, menu);
    }

    @Override
    public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
        if(menuItem.getItemId() == R.id.action_add){
            mListener.gotoAddTask();
            return true;
        }
        return false;
    }


    MainListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainListener) {
            mListener = (MainListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement MainListener");
        }
    }

    public interface MainListener{
        void gotoAddTask();
    }
}