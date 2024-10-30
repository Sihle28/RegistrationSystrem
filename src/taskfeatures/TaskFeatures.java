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

public class TaskFeatures {
    String taskName;
    int taskNumber;
    String taskDescription;
    String developerFirstName;
    String developerLastName; 
    int taskDuration;
    String taskID;
    static int taskCounter = 0;
    static int totalTaskDuration = 0; // For accumulating total task duration

    Scanner input = new Scanner(System.in);

    // Method to display the welcome message
    public void displayWelcomeMessage() {
        System.out.println("Welcome to EasyKanban");
    }

    // Method to add tasks
    public void addTasks() {
        System.out.println("How many tasks would you like to enter?");
        int numberOfTasks = input.nextInt();
        input.nextLine(); // Consume newline
        for (int i = 0; i < numberOfTasks; i++) {
            System.out.println("Enter details for task " + (i + 1) + ":");
            System.out.println("Task Name:");
            String taskName = input.nextLine();
            System.out.println("Task Description:");
            String taskDescription = input.nextLine();
            System.out.println("Developer First Name:");
            String developerFirstName = input.nextLine();
            System.out.println("Developer Last Name:");
            String developerLastName = input.nextLine();
            System.out.println("Task Duration (in hours):");
            int taskDuration = input.nextInt();
            input.nextLine(); // Consume newline
            
            // Create new task
            TaskFeatures task = new TaskFeatures(taskName, taskDescription, developerFirstName, developerLastName, taskDuration);
            task.displayTaskDetails();
            totalTaskDuration += taskDuration; // Accumulate task duration
        }
        
        // Display total task duration
        JOptionPane.showMessageDialog(null, "Total Task Duration: " + totalTaskDuration + " hours");
    }

    // Method to show report
    public void showReport() {
        System.out.println("Coming Soon");
    }

    // Method to display the menu and handle user input
    public void displayMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Please choose an option:");
            System.out.println("1) Add tasks");
            System.out.println("2) Show report");
            System.out.println("3) Quit");
            int choice = input.nextInt();
            input.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addTasks();
                    break;
                case 2:
                    showReport();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Constructor to initialize TaskFeatures object
    public TaskFeatures(String taskName, String taskDescription, String developerFirstName, String developerLastName, int taskDuration) {
        this.taskName = taskName;
        this.taskNumber = ++taskCounter;
        setTaskDescription(taskDescription);
        this.developerFirstName = developerFirstName;
        this.developerLastName = developerLastName;
        this.taskDuration = taskDuration;
        this.taskID = generateTaskID(); 
    }

    // Method to set task description with validation
    public void setTaskDescription(String taskDescription) {
        if (taskDescription.length() > 50) {
            System.out.println("Please enter a task description of less than 50 characters.");
        } else {
            this.taskDescription = taskDescription;
            System.out.println("Task successfully captured.");
        }
    }

    // Method to generate a unique Task ID
    public String generateTaskID() {
        return "T" + taskNumber + developerFirstName.charAt(0) + developerLastName.charAt(0);
    }

    // Method to display task details
    public void displayTaskDetails() {
        String taskDetails = "Task Status: New\n" +
                             "Developer Details: " + developerFirstName + " " + developerLastName + "\n" +
                             "Task Number: " + taskNumber + "\n" +
                             "Task Name: " + taskName + "\n" +
                             "Task Description: " + taskDescription + "\n" +
                             "Task ID: " + taskID + "\n" +
                             "Duration: " + taskDuration + " hours";
        JOptionPane.showMessageDialog(null, taskDetails);
    }

    public static void main(String[] args) {
        TaskFeatures taskApp = new TaskFeatures("Welcome Task", "Initial Task Setup", "Admin", "User", 1);
        taskApp.displayWelcomeMessage();
        taskApp.displayMenu();
    }
}




    


