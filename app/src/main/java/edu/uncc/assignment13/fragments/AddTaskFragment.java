package edu.uncc.assignment13.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import edu.uncc.assignment13.R;
import edu.uncc.assignment13.databinding.FragmentAddTaskBinding;
import edu.uncc.assignment13.models.Task;

public class AddTaskFragment extends Fragment implements MenuProvider {
    public AddTaskFragment() {
        // Required empty public constructor
    }

    FragmentAddTaskBinding binding;
    String selectedCategory;
    String selectedPriority;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddTaskBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Add Task");
        getActivity().addMenuProvider(this, getViewLifecycleOwner());

        if(selectedCategory == null){
            binding.textViewCategory.setText("N/A");
        } else {
            binding.textViewCategory.setText(selectedCategory);
        }

        if(selectedPriority == null){
            binding.textViewPriority.setText("N/A");
        } else {
            binding.textViewPriority.setText(selectedPriority);
        }

        binding.buttonSelectCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoSelectCategory();
            }
        });

        binding.buttonSelectPriority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoSelectPriority();
            }
        });

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.editTextName.getText().toString();
                if(name.isEmpty()){
                    Toast.makeText(getActivity(), "Enter valid name !!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(selectedCategory == null){
                    Toast.makeText(getActivity(), "Select a category !!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(selectedPriority == null){
                    Toast.makeText(getActivity(), "Select a priority !!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Task task = new Task(name, selectedCategory, selectedPriority);
                mListener.addTask(task);
            }
        });
    }

    @Override
    public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.add_task_menu, menu);
    }

    @Override
    public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
        if(menuItem.getItemId() == R.id.action_cancel){
            mListener.cancelAddTask();
            return true;
        }
        return false;
    }
    AddTaskListener mListener;



    public interface AddTaskListener{
        void gotoSelectCategory();
        void gotoSelectPriority();
        void cancelAddTask();
        void addTask(Task task);
    }
}