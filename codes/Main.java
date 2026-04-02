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
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        // LocalTime alarmTime = null;
        TaskManager taskManager = new TaskManager();

        // ArrayList<String> tasks = new ArrayList<>();
        // ArrayList<LocalTime> alarm = new ArrayList<>();
        // String filePath = "codes\\file_example_WAV_1MG.wav";
        // String writeFilePath = "c:\\Users\\HomePC\\Desktop\\task-db.txt";

        System.out
                .println(
                        "*************** Welcome to Wisdom Personnel Task/Finance Software Application **************");
        System.out.println("This app does the following tasks:");
        System.out.println("1. Allows users to add and manage tasks (Add, Lists, update and delete their tasks");
        System.out.println("2. Users can assign date and time and set alarm as a remainder for their tasks");
        System.out.println("3. Users can mark task as completed.");
        System.out.println(
                "4. Users can Input their money and allow the app to \n   manage and allocate best way of spending their money for them.");

        System.out.println("**************************************************************************************");
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Show Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> taskManager.AddTask(scanner);
                case 2 -> taskManager.updateTask(scanner);
                case 3 -> taskManager.deleteTask(scanner);
                case 4 -> taskManager.showTask();

                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        // System.out.print("Are you ready?(Yes/No): ");
        // String start = scanner.nextLine().toLowerCase();

        // if (start.equals("yes")) {
        // System.out.print("How many tasks/activity will you do today: ");
        // int amountOfTask = scanner.nextInt();
        // scanner.nextLine();
        // for (int i = 0; i < amountOfTask; i++) {
        // System.out.print("Enter your task: " + (i + 1) + ": ");
        // String task = scanner.nextLine();
        // tasks.add(task);
        // try {
        // System.out.print("Enter an alarm time for task" + (i + 1) + " " +
        // "(HH:MM:SS): ");
        // String inputTime = scanner.nextLine();

        // alarmTime = LocalTime.parse(inputTime, formatter);
        // alarm.add(alarmTime);
        // System.out.println("Alarm set for " + alarmTime);
        // } catch (DateTimeParseException e) {
        // System.out.println("Invalid format, Please use our HH:MM");
        // }

        // try (FileWriter writer = new FileWriter(writeFilePath, true)) {
        // // for (String t : tasks) {
        // // writer.write(t + 1 + t + " " + alarm.get(tasks.indexOf(t)) + "\n");
        // // }

        // for (int j = 0; j < tasks.size(); j++) {
        // writer.write((j + 1) + ". " + tasks.get(j) + " " + alarm.get(j) + "\n");
        // }

        // System.out.println("Task has been written in file");
        // } catch (FileNotFoundException e) {
        // System.out.println("Could not locate file location");
        // } catch (IOException e) {
        // System.out.println("Could not write file");
        // }
        // }

        // String readFilePath = "c:\\\\Users\\\\HomePC\\\\Desktop\\\\task-db.txt";

        // System.out.println("\n Enter (check) to check the list of all your tasks:");
        // String check = scanner.nextLine().toLowerCase();
        // if (check.equals("check")) {
        // try (BufferedReader reader = new BufferedReader(new
        // FileReader(readFilePath))) {
        // String line;
        // while ((line = reader.readLine()) != null) {
        // System.out.println(line);
        // }

        // } catch (FileNotFoundException e) {
        // System.out.println("Could not locate file location");
        // } catch (IOException e) {
        // System.out.println("Error reading file");
        // }
        // }

        // for (LocalTime time : alarm) {
        // AlarmClock alarmClock = new AlarmClock(time, tasks.get(alarm.indexOf(time)),
        // scanner, filePath);
        // Thread alarmThread = new Thread(alarmClock);
        // alarmThread.start();
        // }

        // } else {
        // System.out.println("You ended the program!");
        // }
        // }

        // public static void actionOnTask() {
        // Scanner scanner = new Scanner(System.in);

        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        // LocalTime alarmTime = null;
        // String filePath = "codes\\file_example_WAV_1MG.wav";
        // ArrayList<String> tasks = new ArrayList<>();
        // ArrayList<LocalTime> alarm = new ArrayList<>();
        // String readFilePath = "c:\\\\Users\\\\HomePC\\\\Desktop\\\\task-db.txt";
        // System.out.println("Enter task number to update or delete a task");
        // System.out.println("Enter 1 to update task and 2 to delete task: ");
        // int action = scanner.nextInt();
        // if (action == 1) {
        // try (BufferedReader reader = new BufferedReader(new
        // FileReader(readFilePath))) {
        // String line;
        // while ((line = reader.readLine()) != null) {
        // tasks.add(line);
        // System.out.println(line);

        // }
        // System.out.print("Enter task number to update:");
        // int taskNumber = scanner.nextInt();
        // System.out.print("Update new task for task" + taskNumber + ": ");
        // String newTask = scanner.nextLine();

        // try {
        // System.out.print("Enter new alarm time for task" + (taskNumber) + " " +
        // "(HH:MM:SS): ");
        // String inputTime = scanner.nextLine();

        // alarmTime = LocalTime.parse(inputTime, formatter);
        // alarm.add(alarmTime);
        // System.out.println("new Alarm set for " + alarmTime);
        // } catch (DateTimeParseException e) {
        // System.out.println("Invalid format, Please use our HH:MM");
        // }
        // tasks.set(taskNumber - 1, newTask + " " + alarm.get(taskNumber - 1));

        // for (LocalTime time : alarm) {
        // AlarmClock alarmClock = new AlarmClock(time, tasks.get(alarm.indexOf(time)),
        // scanner, filePath);
        // Thread alarmThread = new Thread(alarmClock);
        // alarmThread.start();
        // }

        // } catch (FileNotFoundException e) {
        // System.out.println("Could not locate file location");
        // } catch (IOException e) {
        // System.out.println("Error reading file");
        // }
        // } else if (action == 2) {
        // try (BufferedReader reader = new BufferedReader(new
        // FileReader(readFilePath))) {
        // String line;
        // while ((line = reader.readLine()) != null) {
        // System.out.println(line);
        // }
        // System.out.print("Enter task number to delete: ");
        // int taskNumber = scanner.nextInt();
        // tasks.remove(taskNumber - 1);
        // System.out.println("Task " + taskNumber + " has been deleted");
        // } catch (FileNotFoundException e) {
        // System.out.println("Could not locate file location");

        // } catch (IOException e) {
        // System.out.println("Error reading file");
        // }
        // } else {
        // System.out.println("Invalid input, Please enter 1 to update task and 2 to
        // delete task");
        // }

        // scanner.close();

    }
}
