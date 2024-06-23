package edu.uncc.assignment13;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import edu.uncc.assignment13.fragments.AddTaskFragment;
import edu.uncc.assignment13.fragments.MainFragment;
import edu.uncc.assignment13.fragments.TaskListFragment;
import edu.uncc.assignment13.models.Task;

public class MainActivity extends AppCompatActivity implements MainFragment.MainListener, TaskListFragment.TaskListListener {
    ArrayList<Task> mTasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //example tasks to use for the assignment
        mTasks.add(new Task("Task 1", "Leisure & Social", "High"));
        mTasks.add(new Task("Task 2", "Work/Professional", "Low"));
        mTasks.add(new Task("Task 3", "Education & Learning", "Medium"));
        mTasks.add(new Task("Task 4", "Personal Errands", "Very High"));
        mTasks.add(new Task("Task 5", "Education & Learning", "Low"));
        mTasks.add(new Task("Task 6", "Leisure & Social", "Medium"));
        mTasks.add(new Task("Task 7", "Work/Professional", "Very High"));
        mTasks.add(new Task("Task 8", "Personal Errands", "High"));
        mTasks.add(new Task("Task 9", "Health & Fitness", "Medium"));
        mTasks.add(new Task("Task 10", "Education & Learning", "Very Low"));
        mTasks.add(new Task("Task 11", "Health & Fitness", "Low"));
        mTasks.add(new Task("Task 12", "Leisure & Social", "Very Low"));
        mTasks.add(new Task("Task 13", "Education & Learning", "High"));
        mTasks.add(new Task("Task 14", "Leisure & Social", "Medium"));
        mTasks.add(new Task("Task 15", "Work/Professional", "Very Low"));
        mTasks.add(new Task("Task 16", "Leisure & Social", "Very Low"));
        mTasks.add(new Task("Task 17", "Personal Errands", "High"));
        mTasks.add(new Task("Task 18", "Education & Learning", "Very High"));
        mTasks.add(new Task("Task 19", "Leisure & Social", "Low"));
        mTasks.add(new Task("Task 20", "Personal Errands", "High"));

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main, new MainFragment())
                .commit();
    }

    @Override
    public void gotoAddTask() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main, new AddTaskFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public ArrayList<Task> getTasksForCategory(String category) {
        //implement method to return the array list for a given category
        // filter the mTasks array list and return the filtered list
        return null;
    }

    @Override
    public void deleteTask(Task task) {

    }
}