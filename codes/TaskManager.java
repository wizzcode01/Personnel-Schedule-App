package codes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    String filePath = "codes\\file_example_WAV_1MG.wav";
    String writeFilePath = "c:\\Users\\HomePC\\Desktop\\task-db.txt";

    public void showTask() {
        String readFilePath = "c:\\Users\\HomePC\\Desktop\\task-db.txt";
        tasks.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(readFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                // tasks.add(new Task(line, null));
                // System.out.println(line);
                String[] parts = line.split("\\|");
                if (parts.length >= 2) {
                    String name = parts[0].trim();
                    String time = parts[1].trim();
                    // String status = parts[2].trim();

                    Task task = new Task(name, LocalTime.parse(time));
                    tasks.add(task);
                }
            }

            if (tasks.isEmpty()) {
                System.out.println("No task added yet");
                return;
            } else {
                for (int i = 0; i < tasks.size(); i++) {
                    Task task = tasks.get(i);
                    task.updateStatus();
                    System.out.println((i + 1) + ". " + task.getTask() + " " +
                            task.getAlarmTime() + " " + task.getStatus());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }

    }

    public void AddTask(Scanner scanner) {
        int amountOfTask = 0;
        while (true) {
            try {
                System.out.print("How many tasks/activity will you do today: ");
                amountOfTask = scanner.nextInt();
                scanner.nextLine();
                if (amountOfTask <= 0 || amountOfTask > 20) {
                    System.out.println("Invalid input, please enter a number between 1 and 20");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number!");
                scanner.nextLine();
            }
        }
        for (int i = 0; i < amountOfTask; i++) {
            System.out.print("Enter your task: " + (i + 1) + ": ");
            String userTask = scanner.nextLine();
            LocalTime alarmTime = null;
            while (true) {
                try {
                    System.out.print("Enter an alarm time for task " + (i + 1) + " " + "(HH:MM:SS): ");
                    String inputTime = scanner.nextLine();

                    alarmTime = LocalTime.parse(inputTime, formatter);

                    Task task = new Task(userTask, alarmTime);
                    tasks.add(task);

                    System.out.println("Alarm set for " + alarmTime);

                    try (FileWriter writer = new FileWriter(writeFilePath, true)) {
                        writer.write(task.getTask() + "|" + task.getAlarmTime() + "\n");

                        System.out.println("Task(s) have been written in file");
                    } catch (FileNotFoundException e) {
                        System.out.println("Could not locate file location");
                    } catch (IOException e) {
                        System.out.println("Could not write file");
                    }

                    AlarmClock alarmClock = new AlarmClock(task, scanner, filePath);
                    // Thread alarmThread =
                    new Thread(alarmClock).start();
                    break;
                    // alarmThread.start();
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid format, Please use our HH:MM:SS");
                }
            }
        }
    }

    public void markAsCompleted(Scanner scanner) {
        showTask();
        System.out.print("Enter task number to mark as completed: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();
        try (FileWriter writer = new FileWriter(writeFilePath, true)) {
            writer.write(taskNumber + ". " + tasks.get(taskNumber - 1).getTask() + " "
                    + tasks.get(taskNumber - 1).getAlarmTime() + " completed");
            System.out.println("Task " + taskNumber + " has been marked as completed");

        } catch (IOException e) {
            System.out.println("Could not write into file");
        }
    }

    public void updateTask(Scanner scanner) {
        System.out.println("***************************************************");
        showTask();
        System.out.println("***************************************************");
        System.out.print("Enter task number to update: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();
        // if (taskNumber < 1 || taskNumber > tasks.size()) {
        // System.out.println("Invalid task number");
        // return;
        // }
        System.out.print("Update new task for task" + taskNumber + ": ");
        String newTask = scanner.nextLine();
        try (FileWriter writer = new FileWriter(writeFilePath, true)) {
            System.out.print("Enter an alarm time for task" + taskNumber + " " + "(HH:MM:SS): ");
            String inputTime = scanner.nextLine();

            LocalTime alarmTime = LocalTime.parse(inputTime, formatter);
            tasks.get(taskNumber - 1).setTask(newTask);
            tasks.get(taskNumber - 1).setAlarmTime(alarmTime);
            for (Task task : tasks) {
                writer.write((tasks.indexOf(task) + 1) + ". " + task.getTask() + " " + task.getAlarmTime() + "\n");
            }
            System.out.println("Task updated successfully");
            for (Task task : tasks) {
                AlarmClock alarmClock = new AlarmClock(task, scanner, filePath);
                Thread alarmThread = new Thread(alarmClock);
                alarmThread.start();
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid format, Please use our HH:MM");
        } catch (IOException e) {
            System.out.println("Could not write file");
        }
    }

    public void deleteTask(Scanner scanner) {
        showTask();
        System.out.println("Enter task number to delete: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();
        try (FileWriter writer = new FileWriter(writeFilePath, true)) {
            // if (taskNumber < 1 || taskNumber > tasks.size()) {
            // System.out.println("Invalid task number");
            // return;
            // }
            tasks.remove(taskNumber - 1);
            for (Task task : tasks) {
                writer.write((tasks.indexOf(task) + 1) + ". " + task.getTask() + " " + task.getAlarmTime() + "\n");
            }
            System.out.println("Task " + taskNumber + " has been deleted");
        } catch (IOException e) {
            System.out.println("Could not write file");
        }
    }

    public void clearAllTasks() {
        tasks.clear();
        try (FileWriter writer = new FileWriter(writeFilePath, false)) {
            writer.write("");
            System.out.println("All task has been cleared. You can start adding new task");
        } catch (IOException e) {
            System.out.println("Could not clear tasks");
        }
    }

}
