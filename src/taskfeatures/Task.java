/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskfeatures;

/**
 *
 * @author RC_Student_lab
 */
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Task {
    private String taskDescription;
    private String taskID;
    private int taskDuration;
    private static int totalHours = 0;
    private static int taskCounter = 0;

    // Constructor
    public Task(String taskDescription, int taskDuration) {
        this.taskDescription = taskDescription;
        this.taskDuration = taskDuration;
        this.taskID = createTaskID();
        totalHours += taskDuration;
    }

    // Ensure the task description is not more than 50 characters
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    // Create and return the task ID
    public String createTaskID() {
        taskCounter++;
        return "T" + taskCounter + taskDescription.substring(0, 2).toUpperCase();
    }

    // Return the full task details
    public String printTaskDetails() {
        return "Task ID: " + taskID + "\n" +
               "Description: " + taskDescription + "\n" +
               "Total Hours: " + taskDuration;
    }

    // Return the total combined hours of all entered tasks
    public static int returnTotalHours() {
        return totalHours;
    }

    public static void main(String[] args) {
        // Create some task instances
        Task task1 = new Task("Complete the project documentation", 5);
        System.out.println("Is task description valid? " + task1.checkTaskDescription());
        System.out.println("Task Details: \n" + task1.printTaskDetails());
        System.out.println("Total Hours: " + Task.returnTotalHours() + "\n");

        Task task2 = new Task("Review code quality", 3);
        System.out.println("Is task description valid? " + task2.checkTaskDescription());
        System.out.println("Task Details: \n" + task2.printTaskDetails());
        System.out.println("Total Hours: " + Task.returnTotalHours() + "\n");

        Task task3 = new Task("Implement new feature", 8);
        System.out.println("Is task description valid? " + task3.checkTaskDescription());
        System.out.println("Task Details: \n" + task3.printTaskDetails());
        System.out.println("Total Hours: " + Task.returnTotalHours() + "\n");
    }
}


