package codes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
    private String filePath = "c:\\Users\\HomePC\\Desktop\\task-db.txt";

    public void saveTasks(ArrayList<Task> tasks) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            // for (String t : tasks) {
            // writer.write(t + 1 + t + " " + alarm.get(tasks.indexOf(t)) + "\n");
            // }

            for (int j = 0; j < tasks.size(); j++) {
                writer.write((j + 1) + ". " + tasks.get(j).getTask() + " " + tasks.get(j).getAlarmTime() + "\n");
            }

            System.out.println("Task has been written in file");
        } catch (IOException e) {
            System.out.println("Error saving tasks");
        }

    }

}
