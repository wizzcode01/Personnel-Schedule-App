package codes;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;

        ArrayList<String> tasks = new ArrayList<>();
        ArrayList<LocalTime> alarm = new ArrayList<>();
        String filePath = "codes\\file_example_WAV_1MG.wav";

        System.out
                .println("***************Welcome to Wisdom Personnel Task/Finance Software Application**************");
        System.out.println("This app does the following tasks:");
        System.out.println("1. Allows users to add and manage tasks (Add, Lists, update and delete their tasks");
        System.out.println("2. Users can assign date and time and set alarm as a remainder for their tasks");
        System.out.println("3. Users can mark task as completed.");
        System.out.println(
                "4. Users can Input their money and allow the app to \n   manage and allocate best way of spending their money for them.");

        System.out.println("***********************************");
        System.out.print("Are you ready?(Yes/No): ");
        String start = scanner.nextLine().toLowerCase();

        if (start.equals("yes")) {
            System.out.print("How many tasks/activity will you do today: ");
            int amountOfTask = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < amountOfTask; i++) {
                System.out.print("Enter your task: " + (i + 1) + ": ");
                String task = scanner.nextLine();
                tasks.add(task);
                try {
                    System.out.print("Enter an alarm time for task" + (i + 1) + " " + "(HH:MM:SS): ");
                    String inputTime = scanner.nextLine();

                    alarmTime = LocalTime.parse(inputTime, formatter);
                    alarm.add(alarmTime);
                    System.out.println("Alarm set for " + alarmTime);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid format, Please use our HH:MM");
                }
            }
            System.out.println("\n your tasks for today are: ");

            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("- " + tasks.get(i) + " " + "time is" + " " + alarm.get(i));
            }

            for (LocalTime time : alarm) {
                AlarmClock alarmClock = new AlarmClock(time, tasks.get(alarm.indexOf(time)), scanner, filePath);
                Thread alarmThread = new Thread(alarmClock);
                alarmThread.start();
            }

            // AlarmClock alarmClock = new AlarmClock(filePath);
            // Thread alarmThread = new Thread(alarmClock);
            // alarmThread.start();

        } else {
            System.out.println("You ended the program!");
        }
    }
}
