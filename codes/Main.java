package codes;

// import java.io.BufferedReader;
// import java.io.FileNotFoundException;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.time.LocalDateTime;
// import java.time.LocalTime;
// import java.time.format.DateTimeFormatter;
// import java.time.format.DateTimeParseException;
// import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Wisdom Program for task and finance management.
        /*
         * Steps
         * 1. To input tasks and their time and dates, if time, alarm sound
         * 2. To store those tasks in a file so you can read and get, update and delete
         * the tasks
         * 3. Mark a task as completed.
         * 4. To input finance e.g 10,000 then the system tells you how to use that
         * money based on how the algorithm.
         */
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        FInanceManager financeManager = new FInanceManager();

        System.out
                .println(
                        "*************** Welcome to Wisdom Personnel Task/Finance Software Application **************");
        System.out.println("This app does the following tasks:");
        System.out.println("1. Allows users to add and manage tasks (Add, Lists, update and delete their tasks");
        System.out.println("2. Users can assign date and time and set alarm as a remainder for their tasks");
        System.out.println("3. Users can mark task as completed.");
        System.out.println(
                "4. Users can Input their money and allow the app to manage \n and allocate best way of spending their money for them.");

        System.out.println("**************************************************************************************");
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Show Tasks");
            System.out.println("5. Manage finance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> taskManager.AddTask(scanner);
                case 2 -> taskManager.updateTask(scanner);
                case 3 -> taskManager.deleteTask(scanner);
                case 4 -> taskManager.showTask();
                case 5 -> financeManager.manageFinance(scanner);

                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}
