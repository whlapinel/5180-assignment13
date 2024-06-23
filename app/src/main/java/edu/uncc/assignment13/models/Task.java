package edu.uncc.assignment13.models;

import java.io.Serializable;

public class Task implements Serializable {
    String name, category, priority;

    public Task(String name, String category, String priority) {
        this.name = name;
        this.category = category;
        this.priority = priority;
    }

    public Task() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}