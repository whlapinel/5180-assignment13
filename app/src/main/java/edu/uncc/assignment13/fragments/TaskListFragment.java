package edu.uncc.assignment13.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.uncc.assignment13.R;
import edu.uncc.assignment13.databinding.FragmentTaskListBinding;
import edu.uncc.assignment13.models.Task;

public class TaskListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TaskListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TaskListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TaskListFragment newInstance(String param1, String param2) {
        TaskListFragment fragment = new TaskListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    FragmentTaskListBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTaskListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    ArrayList<Task> mTasks = new ArrayList<>();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // ArrayList<Task> mTasks = mListener.getTasksForCategory("All");
    }

    TaskListListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("demo", "onAttach: TaskListFragment");
        if (context instanceof TaskListListener) {
            mListener = (TaskListListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement TaskListListener");
        }
    }

    public interface TaskListListener{
        ArrayList<Task> getTasksForCategory(String category);
        void deleteTask(Task task);
    }
}