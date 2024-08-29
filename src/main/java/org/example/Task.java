package org.example;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private int taskId;
    private String title;
    private String description;
    private Person assignee;
    private String status;

    public Task(int taskId, String title, String description, Person assignee, String status) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.assignee = assignee;
        this.status = status;
    }

    // Getters and Setters
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }
    public enum TaskStatus {
        TO_DO, IN_PROGRESS, DONE
    }

    public class TaskManager {
        private List<Task> tasks = new ArrayList<>();

        public void addTask(Task task) {
            tasks.add(task);
        }

        public List<Task> getTasks() {
            return tasks;
        }

        public void updateTaskStatus(int taskId, TaskStatus newStatus) {
            for (Task task : tasks) {
                if (task.getId() == taskId) {
                    task.setStatus(String.valueOf(newStatus));
                    break;
                }
            }
        }
    }

    private int getId() {
        return 0;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}